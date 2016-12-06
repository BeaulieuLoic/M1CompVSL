// $ANTLR 3.5.2 ./src/VSLTreeParser.g 2016-12-06 09:02:32

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class VSLTreeParser extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASCII", "ASSIGN_KW", "COM", "COMMENT", 
		"DIGIT", "DIV", "DO_KW", "ELSE_KW", "FI_KW", "FUNC_KW", "IDENT", "IF_KW", 
		"INTEGER", "INT_KW", "LB", "LC", "LETTER", "LP", "MINUS", "MUL", "OD_KW", 
		"PLUS", "PRINT_KW", "PROTO_KW", "RB", "RC", "READ_KW", "RETURN_KW", "RP", 
		"TEXT", "THEN_KW", "VOID_KW", "WHILE_KW", "WS", "ARDECL", "ARELEM", "ARRAY", 
		"BLOCK", "BODY", "DECL", "FCALL", "FCALL_S", "INST", "NEGAT", "PARAM", 
		"PROG"
	};
	public static final int EOF=-1;
	public static final int ASCII=4;
	public static final int ASSIGN_KW=5;
	public static final int COM=6;
	public static final int COMMENT=7;
	public static final int DIGIT=8;
	public static final int DIV=9;
	public static final int DO_KW=10;
	public static final int ELSE_KW=11;
	public static final int FI_KW=12;
	public static final int FUNC_KW=13;
	public static final int IDENT=14;
	public static final int IF_KW=15;
	public static final int INTEGER=16;
	public static final int INT_KW=17;
	public static final int LB=18;
	public static final int LC=19;
	public static final int LETTER=20;
	public static final int LP=21;
	public static final int MINUS=22;
	public static final int MUL=23;
	public static final int OD_KW=24;
	public static final int PLUS=25;
	public static final int PRINT_KW=26;
	public static final int PROTO_KW=27;
	public static final int RB=28;
	public static final int RC=29;
	public static final int READ_KW=30;
	public static final int RETURN_KW=31;
	public static final int RP=32;
	public static final int TEXT=33;
	public static final int THEN_KW=34;
	public static final int VOID_KW=35;
	public static final int WHILE_KW=36;
	public static final int WS=37;
	public static final int ARDECL=38;
	public static final int ARELEM=39;
	public static final int ARRAY=40;
	public static final int BLOCK=41;
	public static final int BODY=42;
	public static final int DECL=43;
	public static final int FCALL=44;
	public static final int FCALL_S=45;
	public static final int INST=46;
	public static final int NEGAT=47;
	public static final int PARAM=48;
	public static final int PROG=49;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public VSLTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public VSLTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return VSLTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "./src/VSLTreeParser.g"; }



	// $ANTLR start "s"
	// ./src/VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : p= program[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:10:3: (p= program[symTab] )
			// ./src/VSLTreeParser.g:11:5: p= program[symTab]
			{
			pushFollow(FOLLOW_program_in_s64);
			p=program(symTab);
			state._fsp--;


			      code = p; //symTab.print();
			      //verif que tout les proto sont définit ?
			      //que la fonction main existe (et n'est pas qu'un proto)?
			      // paramètre sont l modifiable ?
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "s"



	// $ANTLR start "program"
	// ./src/VSLTreeParser.g:22:1: program[SymbolTable symTab] returns [Code3a code] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a u =null;

		try {
			// ./src/VSLTreeParser.g:23:5: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:23:7: ^( PROG (u= unit[symTab] )+ )
			{
			code = new Code3a();
			match(input,PROG,FOLLOW_PROG_in_program103); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:24:15: (u= unit[symTab] )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FUNC_KW||LA1_0==PROTO_KW) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:24:16: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program109);
					u=unit(symTab);
					state._fsp--;

					code.append(u);
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "program"



	// $ANTLR start "unit"
	// ./src/VSLTreeParser.g:28:1: unit[SymbolTable symTab] returns [Code3a code] : (f= function[symTab] | proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a f =null;

		try {
			// ./src/VSLTreeParser.g:29:3: (f= function[symTab] | proto[symTab] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNC_KW) ) {
				alt2=1;
			}
			else if ( (LA2_0==PROTO_KW) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:29:5: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit142);
					f=function(symTab);
					state._fsp--;

					code = f;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:30:5: proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit151);
					proto(symTab);
					state._fsp--;

					code = new Code3a();
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "unit"



	// $ANTLR start "function"
	// ./src/VSLTreeParser.g:33:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW typeFonction= type IDENT param_list[symTab] ^( BODY stat= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		CommonTree FUNC_KW2=null;
		Type typeFonction =null;
		Code3a stat =null;
		TreeRuleReturnScope param_list3 =null;

		try {
			// ./src/VSLTreeParser.g:34:3: ( ^( FUNC_KW typeFonction= type IDENT param_list[symTab] ^( BODY stat= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:34:5: ^( FUNC_KW typeFonction= type IDENT param_list[symTab] ^( BODY stat= statement[symTab] ) )
			{
			FUNC_KW2=(CommonTree)match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function174); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function178);
			typeFonction=type();
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function180); 
			pushFollow(FOLLOW_param_list_in_function182);
			param_list3=param_list(symTab);
			state._fsp--;

			match(input,BODY,FOLLOW_BODY_in_function187); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function191);
			stat=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 



			    boolean prototypeExist = symTab.lookup((IDENT1!=null?IDENT1.getText():null)) != null;
			    // verif que ident est pas déja déclaré (sauf si c'est un proto)
			    // si proto existe verif si le type et argument est le même
			   if (prototypeExist
			      && !(TypeCheck.isPrototype(symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type))) {
			      //System.out.println("Erreur function -> l'ident " +(IDENT1!=null?IDENT1.getText():null)+ " à déja été déclarée et n'est pas un prototype");
			      Errors.redefinedIdentifier(FUNC_KW2,(IDENT1!=null?IDENT1.getText():null),
			        "Erreur function -> l'ident " +(IDENT1!=null?IDENT1.getText():null)+ " à déja été déclarée et n'est pas un prototype");
			      System.exit(0);
			    }
			    
			    

			    FunctionType typeFunc = new FunctionType(typeFonction,false);
			    for (int i=0; i<(param_list3!=null?((VSLTreeParser.param_list_return)param_list3).listType:null).size(); i++) {
			      typeFunc.extend((param_list3!=null?((VSLTreeParser.param_list_return)param_list3).listType:null).get(i));
			    }

			    if(prototypeExist && !symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type.isCompatible(typeFunc)){
			      //System.out.println("Erreur function -> " +(IDENT1!=null?IDENT1.getText():null)+ ", la fonction est différente du prototype déclaré");
			      Errors.incompatibleTypes(FUNC_KW2,symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type, typeFunc, 
			        "Erreur function -> " +(IDENT1!=null?IDENT1.getText():null)+ ", la fonction est différente du prototype déclaré");
			      System.exit(0);
			    }


			    code = new Code3a();

			    LabelSymbol lbFunction;
			    // création d'un label si pas de proto, sinon on récupère celui du proto
			    if (!prototypeExist) {
			      lbFunction = new LabelSymbol((IDENT1!=null?IDENT1.getText():null));
			    }else{
			      lbFunction = ((FunctionSymbol) symTab.lookup((IDENT1!=null?IDENT1.getText():null))).label;
			    }

			  
			    code.append(Code3aGenerator.genCodeLabel(lbFunction));/* code labelNomFonction */
			    code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));/* code beginFunction */


			    // empilement des arguments
			    code.append((param_list3!=null?((VSLTreeParser.param_list_return)param_list3).code:null));

			    /* code statement */
			    code.append(stat);

			    /* code endFunction */
			    code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));

			    //remonte d'un niveau pour se retrouvé au même niveau d'ou la fonction à été déclaré
			    symTab.leaveScope(); 


			    if (!prototypeExist) {//si il n'y à pas de proto, insertion de la fonction dans la table des symboles, sinon modif le proto en type fonction
			      FunctionSymbol fonction = new FunctionSymbol(lbFunction,typeFunc);
			      symTab.insert((IDENT1!=null?IDENT1.getText():null),fonction);
			    }else{// sinon changer proto en fonction
			      ((FunctionType) symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type).prototype = false;
			    }

			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "function"



	// $ANTLR start "proto"
	// ./src/VSLTreeParser.g:101:1: proto[SymbolTable symTab] : ^( PROTO_KW typeProto= type IDENT param_list[symTab] ) ;
	public final void proto(SymbolTable symTab) throws RecognitionException {
		CommonTree IDENT4=null;
		CommonTree PROTO_KW5=null;
		Type typeProto =null;
		TreeRuleReturnScope param_list6 =null;

		try {
			// ./src/VSLTreeParser.g:102:5: ( ^( PROTO_KW typeProto= type IDENT param_list[symTab] ) )
			// ./src/VSLTreeParser.g:102:7: ^( PROTO_KW typeProto= type IDENT param_list[symTab] )
			{
			PROTO_KW5=(CommonTree)match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto217); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto221);
			typeProto=type();
			state._fsp--;

			IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto223); 
			pushFollow(FOLLOW_param_list_in_proto225);
			param_list6=param_list(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			      symTab.leaveScope();

			      //verif que le proto n'existe pas déjà
			      if (symTab.lookup((IDENT4!=null?IDENT4.getText():null)) != null) {
			        //System.out.println("Erreur proto -> l'ident " +(IDENT4!=null?IDENT4.getText():null)+ " à déja été déclarée");
			        Errors.redefinedIdentifier(PROTO_KW5, (IDENT4!=null?IDENT4.getText():null), 
			          "Erreur proto -> l'ident " +(IDENT4!=null?IDENT4.getText():null)+ " à déja été déclarée");
			        System.exit(0);
			      }

			      // création du label de la fonction avec le même nom que la fonction
			      LabelSymbol lb = new LabelSymbol((IDENT4!=null?IDENT4.getText():null));

			      FunctionType typeFunc = new FunctionType(typeProto,true);
			      
			      // ajout des paramètres
			      for (int i=0; i<(param_list6!=null?((VSLTreeParser.param_list_return)param_list6).listType:null).size(); i++) {
			        typeFunc.extend((param_list6!=null?((VSLTreeParser.param_list_return)param_list6).listType:null).get(i));
			      }
			      FunctionSymbol protoFonction = new FunctionSymbol(lb,typeFunc);
			      symTab.insert((IDENT4!=null?IDENT4.getText():null),protoFonction);       
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "proto"



	// $ANTLR start "type"
	// ./src/VSLTreeParser.g:128:1: type returns [Type type] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type type = null;


		try {
			// ./src/VSLTreeParser.g:129:5: ( INT_KW | VOID_KW )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==INT_KW) ) {
				alt3=1;
			}
			else if ( (LA3_0==VOID_KW) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:129:7: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type254); 
					type = Type.INT;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:130:7: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type264); 
					type = Type.VOID;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "type"


	public static class param_list_return extends TreeRuleReturnScope {
		public Code3a code;
		public List<Type> listType;
	};


	// $ANTLR start "param_list"
	// ./src/VSLTreeParser.g:133:1: param_list[SymbolTable symTab] returns [Code3a code, List<Type> listType] : ( ^( PARAM ( param[symTab] )* ) | PARAM );
	public final VSLTreeParser.param_list_return param_list(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.param_list_return retval = new VSLTreeParser.param_list_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope param7 =null;

		try {
			// ./src/VSLTreeParser.g:134:5: ( ^( PARAM ( param[symTab] )* ) | PARAM )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==PARAM) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==DOWN) ) {
					alt5=1;
				}
				else if ( (LA5_1==UP||LA5_1==BODY) ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:134:7: ^( PARAM ( param[symTab] )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list289); 

					        List<Type> listType = new ArrayList<>();
					        // descent en profondeur pour ce retrouvé juste en dessous de la fonction
					        symTab.enterScope();
					        Code3a code = new Code3a();
					        retval.code = code;
					      
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:142:7: ( param[symTab] )*
						loop4:
						while (true) {
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==IDENT||LA4_0==ARRAY) ) {
								alt4=1;
							}

							switch (alt4) {
							case 1 :
								// ./src/VSLTreeParser.g:142:8: param[symTab]
								{
								pushFollow(FOLLOW_param_in_param_list307);
								param7=param(symTab);
								state._fsp--;


								          code.append((param7!=null?((VSLTreeParser.param_return)param7).code:null));
								          listType.add((param7!=null?((VSLTreeParser.param_return)param7).type:null));
								        
								}
								break;

							default :
								break loop4;
							}
						}

						match(input, Token.UP, null); 
					}

					 retval.code =code;
					           retval.listType =listType;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:151:7: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list344); 

					      // descent en profondeur pour ce retrouvé juste en dessous de la fonction
					      symTab.enterScope();
					      Code3a code = new Code3a();
					      List<Type> listType = new ArrayList<>();
					      retval.code =code;
					      retval.listType =listType;
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends TreeRuleReturnScope {
		public Code3a code;
		public Type type;
	};


	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:162:1: param[SymbolTable symTab] returns [Code3a code, Type type] : ( IDENT | ^( ARRAY IDENT ) );
	public final VSLTreeParser.param_return param(SymbolTable symTab) throws RecognitionException {
		VSLTreeParser.param_return retval = new VSLTreeParser.param_return();
		retval.start = input.LT(1);

		CommonTree IDENT8=null;
		CommonTree IDENT9=null;
		CommonTree ARRAY10=null;

		try {
			// ./src/VSLTreeParser.g:163:5: ( IDENT | ^( ARRAY IDENT ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IDENT) ) {
				alt6=1;
			}
			else if ( (LA6_0==ARRAY) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:163:7: IDENT
					{
					IDENT8=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param373); 
					 
					      // le type est forcément un int si on rencontre ident
					      Type type = Type.INT;

					      // on vérifie que l'ident n'existe pas déjà parmis les paramètre déjà fait
					      if(symTab.lookup((IDENT8!=null?IDENT8.getText():null))==null){
					        VarSymbol op = new VarSymbol(Type.INT, (IDENT8!=null?IDENT8.getText():null), symTab.getScope());
					        op.setParam();
					        symTab.insert((IDENT8!=null?IDENT8.getText():null),op);

					        Code3a code = Code3aGenerator.genVar(op);
					        retval.code =code;
					        retval.type =type;
					      }else{
					        //System.out.println("Erreur param -> l'ident "+(IDENT8!=null?IDENT8.getText():null)+"à dejà été déclaré");
					        Errors.redefinedIdentifier(IDENT8, (IDENT8!=null?IDENT8.getText():null), null);
					        System.exit(0);
					      }
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:183:7: ^( ARRAY IDENT )
					{
					ARRAY10=(CommonTree)match(input,ARRAY,FOLLOW_ARRAY_in_param389); 
					match(input, Token.DOWN, null); 
					IDENT9=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_param391); 
					match(input, Token.UP, null); 

					 
					      // le type est forcément un pointeur si on rencontre un tableau
					      Type type = Type.POINTER;
					      // on vérifie que l'ident n'existe pas déjà parmis les paramètre déjà fait
					      if(symTab.lookup((IDENT9!=null?IDENT9.getText():null))==null){
					        VarSymbol op = new VarSymbol(Type.POINTER, (IDENT9!=null?IDENT9.getText():null), symTab.getScope());
					        op.setParam();
					        symTab.insert((IDENT9!=null?IDENT9.getText():null),op);

					        Code3a code = Code3aGenerator.genVar(op);
					        retval.code =code;
					        retval.type =type;
					      }else{
					        //System.out.println("Erreur param -> l'ident "+(IDENT9!=null?IDENT9.getText():null)+"à dejà été déclaré");
					        Errors.redefinedIdentifier(ARRAY10, (IDENT9!=null?IDENT9.getText():null), null);
					        System.exit(0);
					      }
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:205:1: statement[SymbolTable symTab] returns [Code3a code] : (aff= affectation[symTab] |b= block[symTab] |i= ifStatement[symTab] |w= whileStatement[symTab] | ^( RETURN_KW e= expression[symTab] ) |aF= appelFunction[symTab] |f= funcPrint[symTab] |f= funcRead[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree RETURN_KW11=null;
		Code3a aff =null;
		Code3a b =null;
		Code3a i =null;
		Code3a w =null;
		ExpAttribute e =null;
		ExpAttribute aF =null;
		Code3a f =null;

		try {
			// ./src/VSLTreeParser.g:206:3: (aff= affectation[symTab] |b= block[symTab] |i= ifStatement[symTab] |w= whileStatement[symTab] | ^( RETURN_KW e= expression[symTab] ) |aF= appelFunction[symTab] |f= funcPrint[symTab] |f= funcRead[symTab] )
			int alt7=8;
			switch ( input.LA(1) ) {
			case ASSIGN_KW:
				{
				alt7=1;
				}
				break;
			case BLOCK:
				{
				alt7=2;
				}
				break;
			case IF_KW:
				{
				alt7=3;
				}
				break;
			case WHILE_KW:
				{
				alt7=4;
				}
				break;
			case RETURN_KW:
				{
				alt7=5;
				}
				break;
			case FCALL:
			case FCALL_S:
				{
				alt7=6;
				}
				break;
			case READ_KW:
				{
				alt7=7;
				}
				break;
			case PRINT_KW:
				{
				alt7=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:207:5: aff= affectation[symTab]
					{
					pushFollow(FOLLOW_affectation_in_statement426);
					aff=affectation(symTab);
					state._fsp--;

					 code = aff; 
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:208:5: b= block[symTab]
					{
					symTab.enterScope();
					pushFollow(FOLLOW_block_in_statement439);
					b=block(symTab);
					state._fsp--;

					symTab.leaveScope();
					 code = b; 
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:209:5: i= ifStatement[symTab]
					{
					pushFollow(FOLLOW_ifStatement_in_statement454);
					i=ifStatement(symTab);
					state._fsp--;

					code = i;
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:210:5: w= whileStatement[symTab]
					{
					pushFollow(FOLLOW_whileStatement_in_statement467);
					w=whileStatement(symTab);
					state._fsp--;

					code = w;
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:211:5: ^( RETURN_KW e= expression[symTab] )
					{
					RETURN_KW11=(CommonTree)match(input,RETURN_KW,FOLLOW_RETURN_KW_in_statement477); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_statement481);
					e=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					        // on vérifie que le type retourné est bien un entier car seul type possible de retour
					        if (!TypeCheck.isInt(e.type)) {
					          //System.out.println("Erreur return -> l'expression donnée n'est pas de type int");
					          Errors.incompatibleTypes(RETURN_KW11,Type.INT,e.type,null);
					          System.exit(0);
					        }
					        code = Code3aGenerator.genReturn(e);
					      
					}
					break;
				case 6 :
					// ./src/VSLTreeParser.g:221:5: aF= appelFunction[symTab]
					{
					pushFollow(FOLLOW_appelFunction_in_statement502);
					aF=appelFunction(symTab);
					state._fsp--;

					code = aF.code;
					}
					break;
				case 7 :
					// ./src/VSLTreeParser.g:222:5: f= funcPrint[symTab]
					{
					pushFollow(FOLLOW_funcPrint_in_statement515);
					f=funcPrint(symTab);
					state._fsp--;

					code = f;
					}
					break;
				case 8 :
					// ./src/VSLTreeParser.g:223:5: f= funcRead[symTab]
					{
					pushFollow(FOLLOW_funcRead_in_statement528);
					f=funcRead(symTab);
					state._fsp--;

					code = f;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "statement"



	// $ANTLR start "funcRead"
	// ./src/VSLTreeParser.g:226:1: funcRead[SymbolTable symTab] returns [Code3a code] : ^( PRINT_KW p= print_list[symTab] ) ;
	public final Code3a funcRead(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a p =null;

		try {
			// ./src/VSLTreeParser.g:227:3: ( ^( PRINT_KW p= print_list[symTab] ) )
			// ./src/VSLTreeParser.g:227:5: ^( PRINT_KW p= print_list[symTab] )
			{
			match(input,PRINT_KW,FOLLOW_PRINT_KW_in_funcRead550); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_print_list_in_funcRead554);
			p=print_list(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			code = p;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "funcRead"



	// $ANTLR start "funcPrint"
	// ./src/VSLTreeParser.g:230:1: funcPrint[SymbolTable symTab] returns [Code3a code] : ^( READ_KW r= read_list[symTab] ) ;
	public final Code3a funcPrint(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a r =null;

		try {
			// ./src/VSLTreeParser.g:231:3: ( ^( READ_KW r= read_list[symTab] ) )
			// ./src/VSLTreeParser.g:231:5: ^( READ_KW r= read_list[symTab] )
			{
			match(input,READ_KW,FOLLOW_READ_KW_in_funcPrint577); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_read_list_in_funcPrint581);
			r=read_list(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			code=r;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "funcPrint"



	// $ANTLR start "print_list"
	// ./src/VSLTreeParser.g:235:1: print_list[SymbolTable symTab] returns [Code3a code] : p1= print_item[symTab] (p2= print_item[symTab] )* ;
	public final Code3a print_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a p1 =null;
		Code3a p2 =null;

		try {
			// ./src/VSLTreeParser.g:236:5: (p1= print_item[symTab] (p2= print_item[symTab] )* )
			// ./src/VSLTreeParser.g:236:7: p1= print_item[symTab] (p2= print_item[symTab] )*
			{
			pushFollow(FOLLOW_print_item_in_print_list610);
			p1=print_item(symTab);
			state._fsp--;

			code = p1;
			// ./src/VSLTreeParser.g:236:44: (p2= print_item[symTab] )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DIV||LA8_0==IDENT||LA8_0==INTEGER||(LA8_0 >= MINUS && LA8_0 <= MUL)||LA8_0==PLUS||LA8_0==TEXT||LA8_0==ARELEM||(LA8_0 >= FCALL && LA8_0 <= FCALL_S)||LA8_0==NEGAT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:236:45: p2= print_item[symTab]
					{
					pushFollow(FOLLOW_print_item_in_print_list620);
					p2=print_item(symTab);
					state._fsp--;

					code.append(p2);
					}
					break;

				default :
					break loop8;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "print_list"



	// $ANTLR start "print_item"
	// ./src/VSLTreeParser.g:239:1: print_item[SymbolTable symTab] returns [Code3a code] : ( TEXT |e= expression[symTab] );
	public final Code3a print_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree TEXT12=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:240:5: ( TEXT |e= expression[symTab] )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==TEXT) ) {
				alt9=1;
			}
			else if ( (LA9_0==DIV||LA9_0==IDENT||LA9_0==INTEGER||(LA9_0 >= MINUS && LA9_0 <= MUL)||LA9_0==PLUS||LA9_0==ARELEM||(LA9_0 >= FCALL && LA9_0 <= FCALL_S)||LA9_0==NEGAT) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:240:7: TEXT
					{
					TEXT12=(CommonTree)match(input,TEXT,FOLLOW_TEXT_in_print_item647); 

					      code = new Code3a();
					      Data3a dataStr = new Data3a((TEXT12!=null?TEXT12.getText():null).substring(1,(TEXT12!=null?TEXT12.getText():null).length()-1));
					      code.appendData(dataStr);

					      code.append(new Inst3a(Inst3a.TAC.ARG,  dataStr.getLabel(), null, null));
					      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, null, SymbDistrib.builtinPrintS, null)));
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:249:7: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_print_item664);
					e=expression(symTab);
					state._fsp--;


					      // on vérifie que la valeurs est bien de type int car on affiche uniquement les entiers
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
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "print_item"



	// $ANTLR start "read_list"
	// ./src/VSLTreeParser.g:265:1: read_list[SymbolTable symTab] returns [Code3a code] : r= read_item[symTab] (r2= read_item[symTab] )* ;
	public final Code3a read_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a r =null;
		Code3a r2 =null;

		try {
			// ./src/VSLTreeParser.g:266:5: (r= read_item[symTab] (r2= read_item[symTab] )* )
			// ./src/VSLTreeParser.g:266:7: r= read_item[symTab] (r2= read_item[symTab] )*
			{
			pushFollow(FOLLOW_read_item_in_read_list697);
			r=read_item(symTab);
			state._fsp--;

			code = r;
			// ./src/VSLTreeParser.g:266:40: (r2= read_item[symTab] )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==IDENT||LA10_0==ARELEM) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:266:41: r2= read_item[symTab]
					{
					pushFollow(FOLLOW_read_item_in_read_list706);
					r2=read_item(symTab);
					state._fsp--;

					code.append(r2);
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "read_list"



	// $ANTLR start "read_item"
	// ./src/VSLTreeParser.g:269:1: read_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARELEM IDENT exp= expression[symTab] ) );
	public final Code3a read_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT13=null;
		CommonTree IDENT14=null;
		CommonTree ARELEM15=null;
		ExpAttribute exp =null;

		try {
			// ./src/VSLTreeParser.g:270:5: ( IDENT | ^( ARELEM IDENT exp= expression[symTab] ) )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==IDENT) ) {
				alt11=1;
			}
			else if ( (LA11_0==ARELEM) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:270:7: IDENT
					{
					IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item733); 

					      code = new Code3a();

					      // on vérifie que l'ident à été déclaré
					      if (symTab.lookup((IDENT13!=null?IDENT13.getText():null)) == null) {
					        //System.out.println("Erreur read_item -> la variable "+(IDENT13!=null?IDENT13.getText():null)+ " n'existe pas");
					        Errors.unknownIdentifier(IDENT13,(IDENT13!=null?IDENT13.getText():null), 
					          "Erreur read_item -> la variable "+(IDENT13!=null?IDENT13.getText():null)+ " n'existe pas");
					        System.exit(0);
					      }
					      Operand3a result = symTab.lookup((IDENT13!=null?IDENT13.getText():null));
					      
					      // seul les entiers peuvent être écris 
					      if (!TypeCheck.isInt(result.type)) {
					        //System.out.println("Erreur read_item -> "+(IDENT13!=null?IDENT13.getText():null)+ " n'est pas une variable de type int");
					        Errors.incompatibleTypes(IDENT13,Type.INT,result.type,
					          "Erreur read_item -> "+(IDENT13!=null?IDENT13.getText():null)+ " n'est pas une variable de type int");
					        System.exit(0);
					      }
					      // on vérifie bien que le symbol est bien une variable
					      if(!(result instanceof VarSymbol)){
					        //System.out.println("Erreur read_item -> "+(IDENT13!=null?IDENT13.getText():null)+ " n'est pas une variable");
					        Errors.miscError(IDENT13,"Erreur read_item -> "+(IDENT13!=null?IDENT13.getText():null)+ " n'est pas une variable");
					        System.exit(0);
					      }


					      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, result, SymbDistrib.builtinRead, null)));


					      //SymbDistrib.builtinRead
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:303:7: ^( ARELEM IDENT exp= expression[symTab] )
					{
					ARELEM15=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_read_item748); 
					match(input, Token.DOWN, null); 
					IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_read_item751); 
					pushFollow(FOLLOW_expression_in_read_item755);
					exp=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Operand3a result = symTab.lookup((IDENT14!=null?IDENT14.getText():null));
					      if (!TypeCheck.isArrayInt(ARELEM15,exp, result, (IDENT14!=null?IDENT14.getText():null))) {
					        System.exit(0);
					      }
					      code = exp.code;
					      VarSymbol temp = SymbDistrib.newTemp();
					      code.append(Code3aGenerator.genVar(temp));
					      code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, temp, SymbDistrib.builtinRead, null)));

					      code.append(new Code3a(new Inst3a(Inst3a.TAC.VARTAB, result, exp.place, temp)));

					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "read_item"



	// $ANTLR start "appelFunction"
	// ./src/VSLTreeParser.g:320:1: appelFunction[SymbolTable symTab] returns [ExpAttribute expAtt] : ^( (tok= FCALL_S |tok= FCALL ) IDENT (arguments= argument_list[symTab] )? ) ;
	public final ExpAttribute appelFunction(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree tok=null;
		CommonTree IDENT16=null;
		List<ExpAttribute> arguments =null;

		try {
			// ./src/VSLTreeParser.g:321:3: ( ^( (tok= FCALL_S |tok= FCALL ) IDENT (arguments= argument_list[symTab] )? ) )
			// ./src/VSLTreeParser.g:321:5: ^( (tok= FCALL_S |tok= FCALL ) IDENT (arguments= argument_list[symTab] )? )
			{
			// ./src/VSLTreeParser.g:321:7: (tok= FCALL_S |tok= FCALL )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==FCALL_S) ) {
				alt12=1;
			}
			else if ( (LA12_0==FCALL) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:321:8: tok= FCALL_S
					{
					tok=(CommonTree)match(input,FCALL_S,FOLLOW_FCALL_S_in_appelFunction789); 
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:321:20: tok= FCALL
					{
					tok=(CommonTree)match(input,FCALL,FOLLOW_FCALL_in_appelFunction793); 
					}
					break;

			}

			match(input, Token.DOWN, null); 
			IDENT16=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_appelFunction796); 
			arguments = null;
			// ./src/VSLTreeParser.g:321:57: (arguments= argument_list[symTab] )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==DIV||LA13_0==IDENT||LA13_0==INTEGER||(LA13_0 >= MINUS && LA13_0 <= MUL)||LA13_0==PLUS||LA13_0==ARELEM||(LA13_0 >= FCALL && LA13_0 <= FCALL_S)||LA13_0==NEGAT) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:321:58: arguments= argument_list[symTab]
					{
					pushFollow(FOLLOW_argument_list_in_appelFunction805);
					arguments=argument_list(symTab);
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


			    CommonTree token = tok;
			    Operand3a identTab = symTab.lookup((IDENT16!=null?IDENT16.getText():null)); 
			    if (identTab == null) {
			        //System.out.println("Erreur appelFunction -> la fonction "+(IDENT16!=null?IDENT16.getText():null)+" n'existe pas");
			        Errors.unknownIdentifier(token,(IDENT16!=null?IDENT16.getText():null), 
			          "Erreur appelFunction -> la fonction "+(IDENT16!=null?IDENT16.getText():null)+" n'existe pas");
			        System.exit(0);
			    }
			    if (!TypeCheck.isFunction(identTab.type)) {
			        //System.out.println("Erreur appelFunction -> l'ident "+(IDENT16!=null?IDENT16.getText():null)+" n'est pas une fonction ou un prototype");
			        Errors.incompatibleTypes(token, "FUNC or PROTO",identTab.type,
			          "Erreur appelFunction -> l'ident "+(IDENT16!=null?IDENT16.getText():null)+" n'est pas une fonction ou un prototype");
			        System.exit(0); 
			    }

			    FunctionSymbol functionSymb = (FunctionSymbol) identTab;
			    FunctionType operandFunction = (FunctionType) identTab.type;
			    
			    if (arguments == null && operandFunction.getArguments().size() != 0) {
			        //System.out.println("Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+(IDENT16!=null?IDENT16.getText():null)+" est incorrecte");
			        Errors.miscError(token, 
			          "Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+(IDENT16!=null?IDENT16.getText():null)+" est incorrecte");
			        System.exit(0);
			    }else if(arguments != null && arguments.size() != operandFunction.getArguments().size()){
			        //System.out.println("Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+(IDENT16!=null?IDENT16.getText():null)+" est incorrecte");
			        Errors.miscError(token, 
			          "Erreur appelFunction -> le nombre de paramètre fournis pour la fonction "+(IDENT16!=null?IDENT16.getText():null)+" est incorrecte");
			        System.exit(0);  
			    }

			    Code3a code = new Code3a();
			    VarSymbol temp = SymbDistrib.newTemp();
			    code.append(Code3aGenerator.genVar(temp));
			    if (arguments != null) {
			      for (int i = 0; i < arguments.size() ; i++) {
			        if (!arguments.get(i).type.isCompatible(operandFunction.getArguments().get(i))) {
			          if (!((arguments.get(i).type instanceof  ArrayType) && (operandFunction.getArguments().get(i).isCompatible(Type.POINTER)))) {
			            //System.out.println("Erreur appelFunction -> le type d'argument est incorrecte lors de l'appel à "+(IDENT16!=null?IDENT16.getText():null));
			            Errors.incompatibleTypes(token, operandFunction.getArguments().get(i), arguments.get(i).type, 
			              "Erreur appelFunction -> le type d'argument est incorrecte lors de l'appel à "+(IDENT16!=null?IDENT16.getText():null));
			            System.exit(0);
			          }
			        }
			        code.append(Code3aGenerator.genArgs(arguments.get(i)));
			      }
			    }

			    code.append(new Code3a(new Inst3a(Inst3a.TAC.CALL, temp, functionSymb.label, null)));
			    expAtt = new ExpAttribute(operandFunction.getReturnType(),code,temp);
			  
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "appelFunction"



	// $ANTLR start "argument_list"
	// ./src/VSLTreeParser.g:375:1: argument_list[SymbolTable symTab] returns [List<ExpAttribute> listExp] :e1= expression[symTab] (e= expression[symTab] )* ;
	public final List<ExpAttribute> argument_list(SymbolTable symTab) throws RecognitionException {
		List<ExpAttribute> listExp = null;


		ExpAttribute e1 =null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:376:3: (e1= expression[symTab] (e= expression[symTab] )* )
			// ./src/VSLTreeParser.g:376:5: e1= expression[symTab] (e= expression[symTab] )*
			{
			listExp = new ArrayList<ExpAttribute>();
			pushFollow(FOLLOW_expression_in_argument_list839);
			e1=expression(symTab);
			state._fsp--;

			listExp.add(e1);
			// ./src/VSLTreeParser.g:377:46: (e= expression[symTab] )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==DIV||LA14_0==IDENT||LA14_0==INTEGER||(LA14_0 >= MINUS && LA14_0 <= MUL)||LA14_0==PLUS||LA14_0==ARELEM||(LA14_0 >= FCALL && LA14_0 <= FCALL_S)||LA14_0==NEGAT) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// ./src/VSLTreeParser.g:377:47: e= expression[symTab]
					{
					pushFollow(FOLLOW_expression_in_argument_list847);
					e=expression(symTab);
					state._fsp--;

					listExp.add(e);
					}
					break;

				default :
					break loop14;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return listExp;
	}
	// $ANTLR end "argument_list"



	// $ANTLR start "whileStatement"
	// ./src/VSLTreeParser.g:380:1: whileStatement[SymbolTable symTab] returns [Code3a code] : ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) ;
	public final Code3a whileStatement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a s1 =null;

		try {
			// ./src/VSLTreeParser.g:381:3: ( ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) )
			// ./src/VSLTreeParser.g:382:5: ^( WHILE_KW e= expression[symTab] s1= statement[symTab] )
			{
			match(input,WHILE_KW,FOLLOW_WHILE_KW_in_whileStatement875); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_whileStatement879);
			e=expression(symTab);
			state._fsp--;

			pushFollow(FOLLOW_statement_in_whileStatement884);
			s1=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 


			      LabelSymbol lDebut = SymbDistrib.newLabel();      
			      LabelSymbol lFin = SymbDistrib.newLabel();

			      code = Code3aGenerator.genCodeLabel(lDebut);/* lDebut */
			      code.append(e.code); /* exp */
			      code.append(Code3aGenerator.genIfz(e.place, lFin));/* ifz lFin*/

			      code.append(s1);/* code s1 */
			      code.append(Code3aGenerator.genGoto(lDebut));/* goto LabelDebut */
			      code.append(Code3aGenerator.genCodeLabel(lFin));/* LabelFin */
			    
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "whileStatement"



	// $ANTLR start "ifStatement"
	// ./src/VSLTreeParser.g:397:1: ifStatement[SymbolTable symTab] returns [Code3a code] : ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) ;
	public final Code3a ifStatement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;

		try {
			// ./src/VSLTreeParser.g:398:3: ( ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) )
			// ./src/VSLTreeParser.g:398:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
			{
			match(input,IF_KW,FOLLOW_IF_KW_in_ifStatement911); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifStatement915);
			e=expression(symTab);
			state._fsp--;

			pushFollow(FOLLOW_statement_in_ifStatement921);
			s1=statement(symTab);
			state._fsp--;

			s2=null;
			// ./src/VSLTreeParser.g:398:67: (s2= statement[symTab] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==ASSIGN_KW||LA15_0==IF_KW||LA15_0==PRINT_KW||(LA15_0 >= READ_KW && LA15_0 <= RETURN_KW)||LA15_0==WHILE_KW||LA15_0==BLOCK||(LA15_0 >= FCALL && LA15_0 <= FCALL_S)) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// ./src/VSLTreeParser.g:398:68: s2= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_ifStatement929);
					s2=statement(symTab);
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 


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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "ifStatement"



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:419:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dec =null;
		Code3a l =null;

		try {
			// ./src/VSLTreeParser.g:420:3: ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BLOCK) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==DOWN) ) {
					int LA16_2 = input.LA(3);
					if ( (LA16_2==DECL) ) {
						alt16=1;
					}
					else if ( (LA16_2==INST) ) {
						alt16=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 16, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// ./src/VSLTreeParser.g:421:5: ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block962); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block966);
					dec=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block971);
					l=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					dec.append(l);code = dec;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:422:5: ^( BLOCK l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block982); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block986);
					l=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					code = l;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "block"



	// $ANTLR start "inst_list"
	// ./src/VSLTreeParser.g:425:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (stat= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:426:5: ( ^( INST (stat= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:426:8: ^( INST (stat= statement[symTab] )+ )
			{
			code = new Code3a();
			match(input,INST,FOLLOW_INST_in_inst_list1014); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:426:38: (stat= statement[symTab] )+
			int cnt17=0;
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==ASSIGN_KW||LA17_0==IF_KW||LA17_0==PRINT_KW||(LA17_0 >= READ_KW && LA17_0 <= RETURN_KW)||LA17_0==WHILE_KW||LA17_0==BLOCK||(LA17_0 >= FCALL && LA17_0 <= FCALL_S)) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ./src/VSLTreeParser.g:426:39: stat= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list1019);
					stat=statement(symTab);
					state._fsp--;

					code.append(stat);
					}
					break;

				default :
					if ( cnt17 >= 1 ) break loop17;
					EarlyExitException eee = new EarlyExitException(17, input);
					throw eee;
				}
				cnt17++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "inst_list"



	// $ANTLR start "declaration"
	// ./src/VSLTreeParser.g:429:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// ./src/VSLTreeParser.g:430:3: ( ^( DECL (dl= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:430:5: ^( DECL (dl= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration1048); 
			code=new Code3a();
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:430:33: (dl= decl_item[symTab] )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==IDENT||LA18_0==ARDECL) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// ./src/VSLTreeParser.g:430:34: dl= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration1055);
					dl=decl_item(symTab);
					state._fsp--;

					code.append(dl);
					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "declaration"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:433:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT17=null;
		CommonTree IDENT18=null;
		CommonTree INTEGER19=null;
		CommonTree ARDECL20=null;

		try {
			// ./src/VSLTreeParser.g:434:3: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==IDENT) ) {
				alt19=1;
			}
			else if ( (LA19_0==ARDECL) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// ./src/VSLTreeParser.g:434:5: IDENT
					{
					IDENT17=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1081); 

					      if(symTab.lookup((IDENT17!=null?IDENT17.getText():null))==null // on vérifié que l'ident n'existe pas déja ou si il existe, il ce situe à un autre niveau, sinon erreur
					      || symTab.lookup((IDENT17!=null?IDENT17.getText():null)).getScope() != symTab.getScope()){
					        VarSymbol op = new VarSymbol(Type.INT, (IDENT17!=null?IDENT17.getText():null), symTab.getScope());
					        symTab.insert((IDENT17!=null?IDENT17.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        //System.out.println("Erreur déclaration -> la variable " +(IDENT17!=null?IDENT17.getText():null)+ " à déja été déclarée");
					        Errors.redefinedIdentifier(IDENT17, (IDENT17!=null?IDENT17.getText():null), 
					          "Erreur déclaration -> la variable " +(IDENT17!=null?IDENT17.getText():null)+ " à déja été déclarée");
					        System.exit(0);
					      }

					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:450:5: ^( ARDECL IDENT INTEGER )
					{
					ARDECL20=(CommonTree)match(input,ARDECL,FOLLOW_ARDECL_in_decl_item1095); 
					match(input, Token.DOWN, null); 
					IDENT18=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item1097); 
					INTEGER19=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item1099); 
					match(input, Token.UP, null); 


					      if(symTab.lookup((IDENT18!=null?IDENT18.getText():null))==null// on vérifié que l'ident n'existe pas déja ou si il existe, il ce situe à un autre niveau,
					      || symTab.lookup((IDENT18!=null?IDENT18.getText():null)).getScope() != symTab.getScope()){
					        int sizeArray = Integer.parseInt((INTEGER19!=null?INTEGER19.getText():null));
					        if (sizeArray <= 0) {// interdit les tableau de taille <= 0
					          //System.out.println("Erreur déclaration -> La taille donnée au tableau est inférieur ou égale à 0");
					          Errors.miscError(ARDECL20, "Erreur déclaration -> La taille donnée au tableau est inférieur ou égale à 0");
					          System.exit(0);
					        }
					        ArrayType tableau = new ArrayType(Type.INT, sizeArray);
					        VarSymbol op = new VarSymbol(tableau, (IDENT18!=null?IDENT18.getText():null), symTab.getScope());
					        symTab.insert((IDENT18!=null?IDENT18.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        //System.out.println("Erreur déclaration -> la variable " +(IDENT18!=null?IDENT18.getText():null)+ " à déja été déclarée");
					        Errors.redefinedIdentifier(ARDECL20, (IDENT18!=null?IDENT18.getText():null), 
					          "Erreur déclaration -> la variable " +(IDENT18!=null?IDENT18.getText():null)+ " à déja été déclarée");        
					        System.exit(0);
					      }
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "decl_item"



	// $ANTLR start "affectation"
	// ./src/VSLTreeParser.g:475:1: affectation[SymbolTable symTab] returns [Code3a code] : ^( ASSIGN_KW e= expression[symTab] ( (i1= IDENT ) | ( ^( ARELEM i2= IDENT exp= expression[symTab] ) ) ) ) ;
	public final Code3a affectation(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree i1=null;
		CommonTree i2=null;
		CommonTree ASSIGN_KW21=null;
		ExpAttribute e =null;
		ExpAttribute exp =null;

		try {
			// ./src/VSLTreeParser.g:476:3: ( ^( ASSIGN_KW e= expression[symTab] ( (i1= IDENT ) | ( ^( ARELEM i2= IDENT exp= expression[symTab] ) ) ) ) )
			// ./src/VSLTreeParser.g:476:3: ^( ASSIGN_KW e= expression[symTab] ( (i1= IDENT ) | ( ^( ARELEM i2= IDENT exp= expression[symTab] ) ) ) )
			{
			ASSIGN_KW21=(CommonTree)match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_affectation1125); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_affectation1129);
			e=expression(symTab);
			state._fsp--;

			// ./src/VSLTreeParser.g:476:36: ( (i1= IDENT ) | ( ^( ARELEM i2= IDENT exp= expression[symTab] ) ) )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==IDENT) ) {
				alt20=1;
			}
			else if ( (LA20_0==ARELEM) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// ./src/VSLTreeParser.g:477:7: (i1= IDENT )
					{
					// ./src/VSLTreeParser.g:477:7: (i1= IDENT )
					// ./src/VSLTreeParser.g:477:8: i1= IDENT
					{
					i1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_affectation1143); 
					code = Code3aGenerator.genAff(ASSIGN_KW21,(i1!=null?i1.getText():null),e,symTab);
					}

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:478:8: ( ^( ARELEM i2= IDENT exp= expression[symTab] ) )
					{
					// ./src/VSLTreeParser.g:478:8: ( ^( ARELEM i2= IDENT exp= expression[symTab] ) )
					// ./src/VSLTreeParser.g:478:9: ^( ARELEM i2= IDENT exp= expression[symTab] )
					{
					match(input,ARELEM,FOLLOW_ARELEM_in_affectation1157); 
					match(input, Token.DOWN, null); 
					i2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_affectation1162); 
					pushFollow(FOLLOW_expression_in_affectation1166);
					exp=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					}


					          Operand3a result = symTab.lookup((i2!=null?i2.getText():null));
					          if (!TypeCheck.isArrayInt(ASSIGN_KW21, exp, result, (i2!=null?i2.getText():null))) {
					            System.exit(0);
					          }
					          e.code.append(exp.code);
					          code = e.code;
					          code.append(new Code3a(new Inst3a(Inst3a.TAC.VARTAB, result, exp.place, e.place)));
					        
					}
					break;

			}

			match(input, Token.UP, null); 

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return code;
	}
	// $ANTLR end "affectation"



	// $ANTLR start "expression"
	// ./src/VSLTreeParser.g:491:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree PLUS22=null;
		CommonTree MINUS23=null;
		CommonTree MUL24=null;
		CommonTree DIV25=null;
		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:492:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] )
			int alt21=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt21=1;
				}
				break;
			case MINUS:
				{
				alt21=2;
				}
				break;
			case MUL:
				{
				alt21=3;
				}
				break;
			case DIV:
				{
				alt21=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case ARELEM:
			case FCALL:
			case FCALL_S:
			case NEGAT:
				{
				alt21=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// ./src/VSLTreeParser.g:492:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					PLUS22=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expression1202); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1206);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1211);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(PLUS22, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:502:4: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					MINUS23=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression1226); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1230);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1235);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 

					      if (TypeCheck.checkBinOpError(MINUS23, e1.type, e2.type)) {
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp); 
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:513:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					MUL24=(CommonTree)match(input,MUL,FOLLOW_MUL_in_expression1250); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1254);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1259);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					;
					      if(TypeCheck.checkBinOpError(MUL24, e1.type, e2.type)){
					          VarSymbol temp = SymbDistrib.newTemp();
					          Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					          expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:524:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					DIV25=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expression1275); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression1279);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression1284);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(DIV25, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }

					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:535:5: pe= primary[symTab]
					{
					pushFollow(FOLLOW_primary_in_expression1301);
					pe=primary(symTab);
					state._fsp--;

					 expAtt = pe;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "expression"



	// $ANTLR start "primary"
	// ./src/VSLTreeParser.g:540:1: primary[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) |e= appelFunction[symTab] | ^( ARELEM IDENT exp= expression[symTab] ) );
	public final ExpAttribute primary(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER26=null;
		CommonTree IDENT27=null;
		CommonTree NEGAT28=null;
		CommonTree IDENT29=null;
		CommonTree ARELEM30=null;
		ExpAttribute e2 =null;
		ExpAttribute e =null;
		ExpAttribute exp =null;

		try {
			// ./src/VSLTreeParser.g:541:3: ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) |e= appelFunction[symTab] | ^( ARELEM IDENT exp= expression[symTab] ) )
			int alt22=5;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt22=1;
				}
				break;
			case IDENT:
				{
				alt22=2;
				}
				break;
			case NEGAT:
				{
				alt22=3;
				}
				break;
			case FCALL:
			case FCALL_S:
				{
				alt22=4;
				}
				break;
			case ARELEM:
				{
				alt22=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// ./src/VSLTreeParser.g:541:5: INTEGER
					{
					INTEGER26=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary1329); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER26!=null?INTEGER26.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:546:5: IDENT
					{
					IDENT27=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary1341); 

					      Operand3a id = symTab.lookup((IDENT27!=null?IDENT27.getText():null));
					      if (id == null) {
					        //System.out.println("Erreur primary -> la variable "+(IDENT27!=null?IDENT27.getText():null)+ " n'existe pas");
					        Errors.unknownIdentifier(IDENT27,(IDENT27!=null?IDENT27.getText():null), 
					          "Erreur primary -> la variable "+(IDENT27!=null?IDENT27.getText():null)+ " n'existe pas");
					        System.exit(0);
					      }

					      if (!(id instanceof VarSymbol)) {
					        //System.out.println("Erreur primary -> "+(IDENT27!=null?IDENT27.getText():null)+ " n'est pas une variable");
					        Errors.miscError(IDENT27, "Erreur primary -> "+(IDENT27!=null?IDENT27.getText():null)+ " n'est pas une variable");
					        System.exit(0);
					      }

					      expAtt = new ExpAttribute(id.type, new Code3a(), id);
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:564:5: ^( NEGAT e2= primary[symTab] )
					{
					NEGAT28=(CommonTree)match(input,NEGAT,FOLLOW_NEGAT_in_primary1354); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_primary_in_primary1358);
					e2=primary(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      ConstSymbol cs = new ConstSymbol(0);
					      ExpAttribute expZero = new ExpAttribute(Type.INT, new Code3a(), cs);

					      if (TypeCheck.checkBinOpError(NEGAT28, expZero.type, e2.type)) {
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, expZero, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:577:6: e= appelFunction[symTab]
					{
					pushFollow(FOLLOW_appelFunction_in_primary1375);
					e=appelFunction(symTab);
					state._fsp--;

					expAtt = e;
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:578:5: ^( ARELEM IDENT exp= expression[symTab] )
					{
					ARELEM30=(CommonTree)match(input,ARELEM,FOLLOW_ARELEM_in_primary1385); 
					match(input, Token.DOWN, null); 
					IDENT29=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary1388); 
					pushFollow(FOLLOW_expression_in_primary1392);
					exp=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      Operand3a result = symTab.lookup((IDENT29!=null?IDENT29.getText():null));
					      if (!TypeCheck.isArrayInt(ARELEM30, exp, result, (IDENT29!=null?IDENT29.getText():null))) {
					        System.exit(0);
					      }

					      Code3a code = exp.code;

					      VarSymbol tmp = SymbDistrib.newTemp();

					      code.append(Code3aGenerator.genVar(tmp));
					      code.append(new Code3a(new Inst3a(Inst3a.TAC.TABVAR, tmp, result, exp.place))); 

					      expAtt = new ExpAttribute(Type.INT, code, tmp);
					    
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return expAtt;
	}
	// $ANTLR end "primary"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program109 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_KW_in_function174 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function178 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function180 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function182 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function187 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function191 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto217 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto221 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto223 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_proto225 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list289 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list307 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param389 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param391 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_affectation_in_statement426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_statement439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_statement467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KW_in_statement477 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_statement481 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_appelFunction_in_statement502 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcPrint_in_statement515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funcRead_in_statement528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_KW_in_funcRead550 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_print_list_in_funcRead554 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_READ_KW_in_funcPrint577 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_read_list_in_funcPrint581 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_print_item_in_print_list610 = new BitSet(new long[]{0x0000B08202C14202L});
	public static final BitSet FOLLOW_print_item_in_print_list620 = new BitSet(new long[]{0x0000B08202C14202L});
	public static final BitSet FOLLOW_TEXT_in_print_item647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_print_item664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_item_in_read_list697 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_read_item_in_read_list706 = new BitSet(new long[]{0x0000008000004002L});
	public static final BitSet FOLLOW_IDENT_in_read_item733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_read_item748 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_read_item751 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_read_item755 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FCALL_S_in_appelFunction789 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_FCALL_in_appelFunction793 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_appelFunction796 = new BitSet(new long[]{0x0000B08002C14208L});
	public static final BitSet FOLLOW_argument_list_in_appelFunction805 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_expression_in_argument_list839 = new BitSet(new long[]{0x0000B08002C14202L});
	public static final BitSet FOLLOW_expression_in_argument_list847 = new BitSet(new long[]{0x0000B08002C14202L});
	public static final BitSet FOLLOW_WHILE_KW_in_whileStatement875 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_whileStatement879 = new BitSet(new long[]{0x00003210C4008020L});
	public static final BitSet FOLLOW_statement_in_whileStatement884 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_ifStatement911 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifStatement915 = new BitSet(new long[]{0x00003210C4008020L});
	public static final BitSet FOLLOW_statement_in_ifStatement921 = new BitSet(new long[]{0x00003210C4008028L});
	public static final BitSet FOLLOW_statement_in_ifStatement929 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block962 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block966 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block971 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block982 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block986 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list1014 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list1019 = new BitSet(new long[]{0x00003210C4008028L});
	public static final BitSet FOLLOW_DECL_in_declaration1048 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration1055 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1081 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item1095 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item1097 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item1099 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_affectation1125 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_affectation1129 = new BitSet(new long[]{0x0000008000004000L});
	public static final BitSet FOLLOW_IDENT_in_affectation1143 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ARELEM_in_affectation1157 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_affectation1162 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_affectation1166 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression1202 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1206 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1211 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1226 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1230 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1235 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression1250 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1254 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1259 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression1275 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1279 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_expression1284 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_in_expression1301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary1329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary1341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEGAT_in_primary1354 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_primary_in_primary1358 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_appelFunction_in_primary1375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARELEM_in_primary1385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_primary1388 = new BitSet(new long[]{0x0000B08002C14200L});
	public static final BitSet FOLLOW_expression_in_primary1392 = new BitSet(new long[]{0x0000000000000008L});
}
