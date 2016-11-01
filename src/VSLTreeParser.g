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


statement [SymbolTable symTab] returns [Code3a code]
  :
    aff=affectation[symTab] { code = aff; }
  | {symTab.enterScope();} b=block[symTab] {symTab.leaveScope();} { code = b; }
  ;

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
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  |^(MINUS e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  |^(MUL e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | ^(DIV e1=expression[symTab] e2=expression[symTab]) 
    { 
      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
      VarSymbol temp = SymbDistrib.newTemp();
      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
      expAtt = new ExpAttribute(ty, cod, temp);
    }
  | pe=primary_exp[symTab] 
    { expAtt = pe; }
  ;


primary_exp [SymbolTable symTab] returns [ExpAttribute expAtt]
  : INTEGER
    {
      ConstSymbol cs = new ConstSymbol(Integer.parseInt($INTEGER.text));
      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
    }
  | IDENT
    {
      Operand3a id = symTab.lookup($IDENT.text);
      if (id == null) {
        System.out.println("Erreur primary_exp -> la variable "+$IDENT.text+ " n'existe pas");
      }else{
        expAtt = new ExpAttribute(id.type, new Code3a(), id);
      }
    }
  ;
