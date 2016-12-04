tree grammar VSLTreeParser;

options {
  language     = Java;
  tokenVocab   = VSLParser;
  ASTLabelType = CommonTree;
}

s [SymbolTable symTab] returns [Code3a code]
  :
    p=program[symTab] 
    {
      code = p; symTab.print();
      //verif que tout les proto sont définit ?
      //que la fonction main existe ?
    }


  ;

program[SymbolTable symTab] returns [Code3a code]
    : {code = new Code3a();}
      ^(PROG  (u=unit[symTab] {code.append(u);} )+)

    ;

unit [SymbolTable symTab] returns [Code3a code]
  : f = function[symTab] {code = f;}
  | proto[symTab] {code = new Code3a();}
  ;

function [SymbolTable symTab] returns [Code3a code]
  : ^(FUNC_KW typeFonction=type IDENT param_list[symTab]  ^(BODY stat=statement[symTab]))
  {

    boolean prototypeExist = symTab.lookup($IDENT.text) != null;
    // verif que ident est pas déja déclaré (sauf si c'est un proto)
    // si proto existe verif si le type et argument est le même
   if (prototypeExist
      && !(TypeCheck.isPrototype(symTab.lookup($IDENT.text).type))) {
      //System.out.println("Erreur function -> l'ident " +$IDENT.text+ " à déja été déclarée et n'est pas un prototype");
      Errors.redefinedIdentifier($FUNC_KW,$IDENT.text,
        "Erreur function -> l'ident " +$IDENT.text+ " à déja été déclarée et n'est pas un prototype");
      System.exit(0);
    }
    
    

    FunctionType typeFunc = new FunctionType(typeFonction,false);
    for (int i=0; i<$param_list.listType.size(); i++) {
      typeFunc.extend($param_list.listType.get(i));
    }





    if(prototypeExist && !symTab.lookup($IDENT.text).type.isCompatible(typeFunc)){
      //System.out.println("Erreur function -> " +$IDENT.text+ ", la fonction est différente du prototype déclaré");
      Errors.incompatibleTypes($FUNC_KW,symTab.lookup($IDENT.text).type, typeFunc, 
        "Erreur function -> " +$IDENT.text+ ", la fonction est différente du prototype déclaré");
      System.exit(0);
    }


    code = new Code3a();

    LabelSymbol lbFunction;
    if (!prototypeExist) {
      lbFunction = new LabelSymbol($IDENT.text);
    }else{
      lbFunction = ((FunctionSymbol) symTab.lookup($IDENT.text)).label;
    }

  
    code.append(Code3aGenerator.genCodeLabel(lbFunction));/* code labelNomFonction */
    code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));/* code beginFunction */



    code.append($param_list.code);

    code.append(stat);

    code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
    /* code endFunction */

    symTab.leaveScope(); 


    if (!prototypeExist) {//si il n'y à pas de proto
      FunctionSymbol fonction = new FunctionSymbol(lbFunction,typeFunc);
      symTab.insert($IDENT.text,fonction);
    }else{// sinon changer proto en fonction
      ((FunctionType) symTab.lookup($IDENT.text).type).prototype = false;
    }

  } 
  ;

proto [SymbolTable symTab]
    : ^(PROTO_KW typeProto=type IDENT param_list[symTab])
    {
      symTab.leaveScope();

      //verif que le proto n'existe pas déjà
      if (symTab.lookup($IDENT.text) != null) {
        //System.out.println("Erreur proto -> l'ident " +$IDENT.text+ " à déja été déclarée");
        Errors.redefinedIdentifier($PROTO_KW, $IDENT.text, 
          "Erreur proto -> l'ident " +$IDENT.text+ " à déja été déclarée");
        System.exit(0);
      }

      LabelSymbol lb = new LabelSymbol($IDENT.text);

      FunctionType typeFunc = new FunctionType(typeProto,true);
      
      for (int i=0; i<$param_list.listType.size(); i++) {
        typeFunc.extend($param_list.listType.get(i));
      }
      FunctionSymbol protoFonction = new FunctionSymbol(lb,typeFunc);
      symTab.insert($IDENT.text,protoFonction);       
    }
    ;

type returns [Type type]
    : INT_KW {type = Type.INT;}
    | VOID_KW {type = Type.VOID;}
    ;

param_list[SymbolTable symTab] returns [Code3a code, List<Type> listType]
    : ^(PARAM 
      {
        List<Type> listType = new ArrayList<>();
        symTab.enterScope();
        Code3a code = new Code3a();
        $code = code;
      } 
      (param[symTab]
        {
          code.append($param.code);
          listType.add($param.type);

        })
      *)

     { $code=code;
           $listType=listType;}
    | PARAM 
    {
      symTab.enterScope();
      Code3a code = new Code3a();
      List<Type> listType = new ArrayList<>();
      $code=code;
      $listType=listType;
    }
    ;

param[SymbolTable symTab] returns [Code3a code, Type type]
    : IDENT 
    { 

      Type type = Type.INT;
      if(symTab.lookup($IDENT.text)==null){
        VarSymbol op = new VarSymbol(Type.INT, $IDENT.text, symTab.getScope());
        op.setParam();
        symTab.insert($IDENT.text,op);

        Code3a code = Code3aGenerator.genVar(op);
        $code=code;
        $type=type;
      }else{
        //System.out.println("Erreur param -> l'ident "+$IDENT.text+"à dejà été déclaré");
        Errors.redefinedIdentifier($IDENT, $IDENT.text, null);
        System.exit(0);
      }
    }
    | ^(ARRAY IDENT) 
    { 
      Type type = Type.POINTER;
      if(symTab.lookup($IDENT.text)==null){
        VarSymbol op = new VarSymbol(Type.POINTER, $IDENT.text, symTab.getScope());
        op.setParam();
        symTab.insert($IDENT.text,op);

        Code3a code = Code3aGenerator.genVar(op);
        $code=code;
        $type=type;
      }else{
        //System.out.println("Erreur param -> l'ident "+$IDENT.text+"à dejà été déclaré");
        Errors.redefinedIdentifier($ARRAY, $IDENT.text, null);
        System.exit(0);
      }
    }

    ;

statement[SymbolTable symTab] returns [Code3a code]
  :
    aff=affectation[symTab] { code = aff; }
  | {symTab.enterScope();} b=block[symTab] {symTab.leaveScope();} { code = b; }
  | i = ifStatement[symTab] {code = i;}
  | w = whileStatement[symTab] {code = w;}
  | ^(RETURN_KW e=expression[symTab])
      {
        if (!TypeCheck.isInt(e.type)) {
          //System.out.println("Erreur return -> l'expression donnée n'est pas de type int");
          Errors.incompatibleTypes($RETURN_KW,Type.INT,e.type,null);
          System.exit(0);
        }
        code = Code3aGenerator.genReturn(e);
      } 
  | aF = appelFunction[symTab] {code = aF.code;}
  | f = funcPrint[symTab] {code = f;}
  | f = funcRead[symTab] {code = f;}
  ;

funcRead[SymbolTable symTab] returns [Code3a code]
  : ^(PRINT_KW p=print_list[symTab]) {code = p;}

  ;
funcPrint[SymbolTable symTab] returns [Code3a code]
  : ^(READ_KW r=read_list[symTab]) {code=r;}

  ;

print_list[SymbolTable symTab] returns [Code3a code]
    : p1 = print_item[symTab] {code = p1;} (p2 = print_item[symTab] {code.append(p2);})*
    ;

print_item[SymbolTable symTab] returns [Code3a code]
    : TEXT 
    {
      code = new Code3a();
      Data3a dataStr = new Data3a($TEXT.text);
      code.appendData(dataStr);

      code.append(new Inst3a(Inst3a.TAC.ARG,  dataStr.getLabel(), null, null));
      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null)));
    }
    | e=expression[symTab]
    {

      if (!TypeCheck.isInt(e.type)) {
        //System.out.println("Erreur print_item -> l'expression n'est pas un entier");
        Errors.incompatibleTypes(null,Type.INT,e.type, // changer null !!!!!
        "Erreur print_item -> l'expression n'est pas un entier");
        System.exit(0);
      }
      code = new Code3a();
      code.append(e.code);
      code.append(new Inst3a(Inst3a.TAC.ARG,  e.place, null, null));
      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintN, null)));
    }
    ;

read_list[SymbolTable symTab] returns [Code3a code]
    : r = read_item[symTab] {code = r;}(r2 = read_item[symTab] {code.append(r2);})*
    ;

read_item[SymbolTable symTab] returns [Code3a code]
    : IDENT
    {
      code = new Code3a();
      if (symTab.lookup($IDENT.text) == null) {
        //System.out.println("Erreur read_item -> la variable "+$IDENT.text+ " n'existe pas");
        Errors.unknownIdentifier($IDENT,$IDENT.text, 
          "Erreur read_item -> la variable "+$IDENT.text+ " n'existe pas");
        System.exit(0);
      }
      Operand3a result = symTab.lookup($IDENT.text);
      
      if (!TypeCheck.isInt(result.type)) {
        //System.out.println("Erreur read_item -> "+$IDENT.text+ " n'est pas une variable de type int");
        Errors.incompatibleTypes($IDENT,Type.INT,result.type,
          "Erreur read_item -> "+$IDENT.text+ " n'est pas une variable de type int");
        System.exit(0);
      }

      if(!(result instanceof VarSymbol)){
        //System.out.println("Erreur read_item -> "+$IDENT.text+ " n'est pas une variable");
        Errors.miscError($IDENT,"Erreur read_item -> "+$IDENT.text+ " n'est pas une variable");
        System.exit(0);
      }


      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, result, SymbDistrib.builtinRead, null)));


      //SymbDistrib.builtinRead
    }
    | ^(ARELEM  IDENT exp=expression[symTab]) 
    {
      Operand3a result = symTab.lookup($IDENT.text);
      if (!TypeCheck.isArrayInt($ARELEM,exp, result, $IDENT.text)) {
        System.exit(0);
      }
      code = exp.code;
      VarSymbol temp = SymbDistrib.newTemp();
      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, temp, SymbDistrib.builtinRead, null)));

      code.append(new Code3a(new Inst3a(Inst3a.TAC.VARTAB, result, exp.place, temp)));

    }
    ;


appelFunction[SymbolTable symTab] returns [ExpAttribute expAtt]
  : ^((tok=FCALL_S|tok=FCALL) IDENT {arguments = null;} (arguments = argument_list[symTab])?)
  {
    CommonTree token = tok;
    Operand3a identTab = symTab.lookup($IDENT.text); 
    if (identTab == null) {
        //System.out.println("Erreur appelFunction -> la fonction "+$IDENT.text+" n'existe pas");
        Errors.unknownIdentifier(token,$IDENT.text, 
          "Erreur appelFunction -> la fonction "+$IDENT.text+" n'existe pas");
        System.exit(0);
    }
    if (!TypeCheck.isFunction(identTab.type)) {
        //System.out.println("Erreur appelFunction -> l'ident "+$IDENT.text+" n'est pas une fonction ou un prototype");
        Errors.incompatibleTypes(token, "FUNC or PROTO",identTab.type,
          "Erreur appelFunction -> l'ident "+$IDENT.text+" n'est pas une fonction ou un prototype");
        System.exit(0); 
    }

    FunctionSymbol functionSymb = (FunctionSymbol) identTab;
    FunctionType operandFunction = (FunctionType) identTab.type;
    
    if (arguments == null && operandFunction.getArguments().size() != 0) {
        //System.out.println("Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+$IDENT.text+" est incorrecte");
        Errors.miscError(token, 
          "Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+$IDENT.text+" est incorrecte");
        System.exit(0);
    }else if(arguments != null && arguments.size() != operandFunction.getArguments().size()){
        //System.out.println("Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+$IDENT.text+" est incorrecte");
        Errors.miscError(token, 
          "Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+$IDENT.text+" est incorrecte");
        System.exit(0);  
    }

    Code3a code = new Code3a();
    if (arguments != null) {
      for (int i = 0; i < arguments.size() ; i++) {
        if (!arguments.get(i).type.isCompatible(operandFunction.getArguments().get(i))) {
          if (!((arguments.get(i).type instanceof  ArrayType) && (operandFunction.getArguments().get(i).isCompatible(Type.POINTER)))) {
            //System.out.println("Erreur appelFunction -> le type d'argument est incorrecte lors de l'appel à "+$IDENT.text);
            Errors.incompatibleTypes(token, operandFunction.getArguments().get(i), arguments.get(i).type, 
              "Erreur appelFunction -> le type d'argument est incorrecte lors de l'appel à "+$IDENT.text);
            System.exit(0);
          }
        }
        code.append(Code3aGenerator.genArgs(arguments.get(i)));
      }
    }

    VarSymbol temp = SymbDistrib.newTemp();
    code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, temp, functionSymb.label, null)));
    expAtt = new ExpAttribute(operandFunction.getReturnType(),code,temp);
  }
  ;

argument_list[SymbolTable symTab] returns [List<ExpAttribute> listExp]
  : {listExp = new ArrayList<ExpAttribute>();}
    e1=expression[symTab] {listExp.add(e1);} (e=expression[symTab] {listExp.add(e);})*
  ;

whileStatement[SymbolTable symTab] returns [Code3a code]
  :
    ^(WHILE_KW e=expression[symTab] s1=statement[symTab])
    {
      LabelSymbol lDebut = SymbDistrib.newLabel();      
      LabelSymbol lFin = SymbDistrib.newLabel();

      code = Code3aGenerator.genCodeLabel(lDebut);/* lDebut */
      code.append(e.code); /* exp */
      code.append(Code3aGenerator.genIfz(e.place, lFin));/* ifz lFin*/

      code.append(s1);/* code s1 */
      code.append(Code3aGenerator.genGoto(lDebut));/* goto LabelDebut */
      code.append(Code3aGenerator.genCodeLabel(lFin));/* LabelFin */
    }
  ;

ifStatement[SymbolTable symTab] returns [Code3a code]
  : ^(IF_KW e=expression[symTab]  s1=statement[symTab] {s2=null;} (s2=statement[symTab])?)
    {
      LabelSymbol l0 = SymbDistrib.newLabel();

      code = e.code; /*exp*/
      code.append(Code3aGenerator.genIfz(e.place, l0)); /* ifz goto l0*/
      code.append(s1);  /* code s1 */

      if (s2 == null) {
        code.append(Code3aGenerator.genCodeLabel(l0));/*label l0*/
      }else{// si il y à un else
        LabelSymbol l1 = SymbDistrib.newLabel();  
        
        code.append(Code3aGenerator.genGoto(l1));/*goto l1*/
        code.append(Code3aGenerator.genCodeLabel(l0));/*label l0*/
        code.append(s2); /* code s2*/
        code.append(Code3aGenerator.genCodeLabel(l1));/*label l1*/
      }
    }
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
  : ^(DECL {code=new Code3a();} (dl=decl_item[symTab] {code.append(dl);} )+ )
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
        //System.out.println("Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");
        Errors.redefinedIdentifier($IDENT, $IDENT.text, 
          "Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");
        System.exit(0);
      }

    }
  | ^(ARDECL IDENT INTEGER)// tableau
    {
      if(symTab.lookup($IDENT.text)==null
      || symTab.lookup($IDENT.text).getScope() != symTab.getScope()){
        int sizeArray = Integer.parseInt($INTEGER.text);
        if (sizeArray <= 0) {
          //System.out.println("Erreur déclaration -> La taille donnée au tableau est inférieur ou égale à 0");
          Errors.miscError($ARDECL, "Erreur déclaration -> La taille donnée au tableau est inférieur ou égale à 0");
          System.exit(0);
        }
        ArrayType tableau = new ArrayType(Type.INT, sizeArray);
        VarSymbol op = new VarSymbol(tableau, $IDENT.text, symTab.getScope());
        symTab.insert($IDENT.text,op);

        code = Code3aGenerator.genVar(op);
      }else{
        //System.out.println("Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");
        Errors.redefinedIdentifier($ARDECL, $IDENT.text, 
          "Erreur déclaration -> la variable " +$IDENT.text+ " à déja été déclarée");        
        System.exit(0);
      }
    }
  ;


affectation [SymbolTable symTab] returns [Code3a code]
: ^(ASSIGN_KW e=expression[symTab] (
      (i1=IDENT {code = Code3aGenerator.genAff($ASSIGN_KW,$i1.text,e,symTab);})
      |(^(ARELEM  i2=IDENT exp=expression[symTab]))// affect tableau
        {
          Operand3a result = symTab.lookup($i2.text);
          if (!TypeCheck.isArrayInt($ASSIGN_KW, exp, result, $i2.text)) {
            System.exit(0);
          }
          code = exp.code;
          code.append(new Code3a(new Inst3a(Inst3a.TAC.VARTAB, result, exp.place, e.place)));
        })
  )
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
        //System.out.println("Erreur primary -> la variable "+$IDENT.text+ " n'existe pas");
        Errors.unknownIdentifier($IDENT,$IDENT.text, 
          "Erreur primary -> la variable "+$IDENT.text+ " n'existe pas");
        System.exit(0);
      }

      if (!(id instanceof VarSymbol)) {
        //System.out.println("Erreur primary -> "+$IDENT.text+ " n'est pas une variable");
        Errors.miscError($IDENT, "Erreur primary -> "+$IDENT.text+ " n'est pas une variable");
        System.exit(0);
      }

      expAtt = new ExpAttribute(id.type, new Code3a(), id);
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
  |  e=appelFunction[symTab] {expAtt = e;}
  | ^(ARELEM  IDENT exp=expression[symTab])
    {
      Operand3a result = symTab.lookup($IDENT.text);
      if (!TypeCheck.isArrayInt($ARELEM, exp, result, $IDENT.text)) {
        System.exit(0);
      }

      Code3a code = exp.code;

      VarSymbol tmp = SymbDistrib.newTemp();

      code.append(new Code3a(new Inst3a(Inst3a.TAC.TABVAR, tmp, result, exp.place))); 

      expAtt = new ExpAttribute(Type.INT, code, tmp);
    }
  ;