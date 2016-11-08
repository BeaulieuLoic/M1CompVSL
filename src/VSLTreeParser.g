tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  : {code = new Code3a();}
  stat=statement[symTab] { code.append(stat); symTab.print();}
  ;


statement[SymbolTable symTab] returns [Code3a code]
  :
    aff=affectation[symTab] { code = aff; }
  | {symTab.enterScope();} b=block[symTab] {symTab.leaveScope();} { code = b; }
  //| ifStatement
  ;


// ifStatement[SymbolTable symTab] returns [Code3a code]
//   : ^(IF_KW e=expression[symTab]  s1=statement[symTab] {s2=null} (s2=statement[symTab])?)
//     {
//       code.append(e.code); code.append(new Inst3a(Inst3a.TAC.IFZ,/*l0*/ , e.place, null));
//       code.append(s1); /*goto l1*/ /*label l0*/ code.append(s2) /*label l1*/ 
//     }
//   ;

block[SymbolTable symTab] returns [Code3a code]
  :
    ^(BLOCK dec=declaration[symTab] l=inst_list[symTab]) {dec.append(l);code = dec;}
  | ^(BLOCK l=inst_list[symTab]) {code = l;}
  ;

inst_list[SymbolTable symTab] returns [Code3a code]
    :  {code = new Code3a();} ^(INST (stat=statement[symTab] {code.append(stat);})+  )
    ;

declaration[SymbolTable symTab] returns [Code3a code]
  : ^(DECL {code=new Code3a();} (dl=decl_list[symTab] {code.append(dl);} )+ )
  ;

decl_list[SymbolTable symTab] returns [Code3a code]
  : di=decl_item[symTab] {code=di;} (COM di=decl_item[symTab] {code.append(di);})*
  ;
decl_item[SymbolTable symTab] returns [Code3a code]
  : IDENT 
    {
      if(symTab.lookup($IDENT.text)==null
      || symTab.lookup($IDENT.text).getScope() != symTab.getScope()){
        VarSymbol op = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
        symTab.insert($IDENT.text,op);

        code = Code3aGenerator.genVar(op);
      }else{
        System.out.println("Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");
      }

    }
  | ^(ARDECL IDENT INTEGER)// tableau
    {
      if(symTab.lookup($IDENT.text)==null
      || symTab.lookup($IDENT.text).getScope() != symTab.getScope()){
        int sizeArray = Integer.parseInt($INTEGER.text);
    
        VarSymbol op = new VarSymbol(new Type("ARRAY",4*sizeArray), $IDENT.text, symTab.getScope());
        symTab.insert($IDENT.text,op);

        code = Code3aGenerator.genVar(op);
      }else{
        System.out.println("Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");
      }
    }
  ;


affectation [SymbolTable symTab] returns [Code3a code]
: ^(ASSIGN_KW e=expression[symTab] IDENT) {code = Code3aGenerator.genAff($IDENT.text,e,symTab);}
;

expression [SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^(PLUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      if(TypeCheck.checkBinOpError($PLUS, e1.type, e2.type)){
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
        expAtt = new ExpAttribute(Type.INT, cod, temp);
      }else{
        System.exit(0);
      }
    }
  |^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 

      if (TypeCheck.checkBinOpError($MINUS, e1.type, e2.type)) {
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
        expAtt = new ExpAttribute(Type.INT, cod, temp); 
      }else{
        System.exit(0);
      }
    }
  |^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
;
      if(TypeCheck.checkBinOpError($MUL, e1.type, e2.type)){
          VarSymbol temp = SymbDistrib.newTemp();
          Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
          expAtt = new ExpAttribute(Type.INT, cod, temp);
      }else{
        System.exit(0);
      }
    }
  | ^(DIV e1=expression[symTab] e2=expression[symTab]) 
    { 
      if(TypeCheck.checkBinOpError($DIV, e1.type, e2.type)){
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
        expAtt = new ExpAttribute(Type.INT, cod, temp);
      }else{
        System.exit(0);
      }

    }
  | pe=primary[symTab] 
    { expAtt = pe; }
  ;


primary [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      if (id == null) {
        System.out.println("Erreur primary -> la variable "+$IDENT.text+ " n'existe pas");
      }else{
        expAtt = new ExpAttribute(id.type, new Code3a(), id);
      }
    }
  | ^(NEGAT e2=primary[symTab])
    {
      ConstSymbol cs = new ConstSymbol(0);
      ExpAttribute expZero = new ExpAttribute(Type.INT, new Code3a(), cs);

      if (TypeCheck.checkBinOpError($NEGAT, expZero.type, e2.type)) {
        VarSymbol temp = SymbDistrib.newTemp();
        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, expZero, e2);
        expAtt = new ExpAttribute(Type.INT, cod, temp);
      }else{
        System.exit(0);
      }
    }

  ;
