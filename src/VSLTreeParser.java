// $ANTLR 3.5.2 ./src/VSLTreeParser.g 2016-11-22 09:57:51

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


			      code = p; symTab.print();
			    
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
	// ./src/VSLTreeParser.g:17:1: program[SymbolTable symTab] returns [Code3a code] : ^( PROG (u= unit[symTab] )+ ) ;
	public final Code3a program(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a u =null;

		try {
			// ./src/VSLTreeParser.g:18:5: ( ^( PROG (u= unit[symTab] )+ ) )
			// ./src/VSLTreeParser.g:18:7: ^( PROG (u= unit[symTab] )+ )
			{
			code = new Code3a();
			match(input,PROG,FOLLOW_PROG_in_program101); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:19:15: (u= unit[symTab] )+
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
					// ./src/VSLTreeParser.g:19:16: u= unit[symTab]
					{
					pushFollow(FOLLOW_unit_in_program107);
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
	// ./src/VSLTreeParser.g:23:1: unit[SymbolTable symTab] returns [Code3a code] : (f= function[symTab] | proto[symTab] );
	public final Code3a unit(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a f =null;

		try {
			// ./src/VSLTreeParser.g:24:3: (f= function[symTab] | proto[symTab] )
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
					// ./src/VSLTreeParser.g:24:5: f= function[symTab]
					{
					pushFollow(FOLLOW_function_in_unit140);
					f=function(symTab);
					state._fsp--;

					code = f;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:25:5: proto[symTab]
					{
					pushFollow(FOLLOW_proto_in_unit149);
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
	// ./src/VSLTreeParser.g:28:1: function[SymbolTable symTab] returns [Code3a code] : ^( FUNC_KW typeFonction= type IDENT listeParam= param_list ^( BODY stat= statement[symTab] ) ) ;
	public final Code3a function(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		Type typeFonction =null;
		List<Type> listeParam =null;
		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:29:3: ( ^( FUNC_KW typeFonction= type IDENT listeParam= param_list ^( BODY stat= statement[symTab] ) ) )
			// ./src/VSLTreeParser.g:29:5: ^( FUNC_KW typeFonction= type IDENT listeParam= param_list ^( BODY stat= statement[symTab] ) )
			{
			match(input,FUNC_KW,FOLLOW_FUNC_KW_in_function172); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_function176);
			typeFonction=type();
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function178); 
			pushFollow(FOLLOW_param_list_in_function182);
			listeParam=param_list();
			state._fsp--;

			match(input,BODY,FOLLOW_BODY_in_function186); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_statement_in_function190);
			stat=statement(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 


			    // verif que ident est pas déja déclaré (sauf si c'est un proto)
			    // si proto existe verif si le type et argument est le même
			    if (symTab.lookup((IDENT1!=null?IDENT1.getText():null)) != null
			      && !(TypeCheck.isPrototype(symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type ))) {
			        System.out.println("Erreur function -> l'ident " +(IDENT1!=null?IDENT1.getText():null)+ " à déja été déclarée et n'est pas un prototype");
			        System.exit(0);
			    }

			    
			    FunctionType typeFunc = new FunctionType(typeFonction,false);
			    for (int i=0; i<listeParam.size(); i++) {
			      typeFunc.extend(listeParam.get(i));
			    }

			    if (!symTab.lookup((IDENT1!=null?IDENT1.getText():null)).type.isCompatible(typeFunc)) {
			        System.out.println("Erreur function -> l'ident " +(IDENT1!=null?IDENT1.getText():null)+ " la fonction est différente du prototype déclaré");
			        System.exit(0);
			    }

			    

			    if (symTab.lookup((IDENT1!=null?IDENT1.getText():null)) == null) {
			      LabelSymbol lb = new LabelSymbol((IDENT1!=null?IDENT1.getText():null));
			      FunctionSymbol fonction = new FunctionSymbol(lb,typeFunc);
			      symTab.insert((IDENT1!=null?IDENT1.getText():null),fonction);
			    }

			    code = new Code3a();

			    LabelSymbol lbFunction = ((FunctionSymbol) symTab.lookup((IDENT1!=null?IDENT1.getText():null))).label;
			  
			    code.append(Code3aGenerator.genCodeLabel(lbFunction));/* code labelNomFonction */
			    code.append(new Inst3a(Inst3a.TAC.BEGINFUNC, null, null, null));/* code beginFunction */
			    
			    code.append()
			    /* code init var param */

			    code.append(stat);

			    /* code return (si type != void) */
			    
			    code.append(new Inst3a(Inst3a.TAC.ENDFUNC, null, null, null));
			    /* code endFunction */
			  
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
	// ./src/VSLTreeParser.g:77:1: proto[SymbolTable symTab] : ^( PROTO_KW typeProto= type IDENT listeParam= param_list ) ;
	public final void proto(SymbolTable symTab) throws RecognitionException {
		CommonTree IDENT2=null;
		Type typeProto =null;
		List<Type> listeParam =null;

		try {
			// ./src/VSLTreeParser.g:78:5: ( ^( PROTO_KW typeProto= type IDENT listeParam= param_list ) )
			// ./src/VSLTreeParser.g:78:7: ^( PROTO_KW typeProto= type IDENT listeParam= param_list )
			{
			match(input,PROTO_KW,FOLLOW_PROTO_KW_in_proto215); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_type_in_proto219);
			typeProto=type();
			state._fsp--;

			IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_proto221); 
			pushFollow(FOLLOW_param_list_in_proto225);
			listeParam=param_list();
			state._fsp--;

			match(input, Token.UP, null); 


			      
			      //verif que le proto n'existe pas déjà
			      if (symTab.lookup((IDENT2!=null?IDENT2.getText():null)) != null) {
			        System.out.println("Erreur proto -> l'ident " +(IDENT2!=null?IDENT2.getText():null)+ " à déja été déclarée");
			        System.exit(0);
			      }

			      LabelSymbol lb = new LabelSymbol((IDENT2!=null?IDENT2.getText():null));

			      FunctionType typeFunc = new FunctionType(typeProto,true);
			      
			      for (int i=0; i<listeParam.size(); i++) {
			        typeFunc.extend(listeParam.get(i));
			      }
			      FunctionSymbol protoFonction = new FunctionSymbol(lb,typeFunc);
			      symTab.insert((IDENT2!=null?IDENT2.getText():null),protoFonction);
			    
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
	// ./src/VSLTreeParser.g:99:1: type returns [Type type] : ( INT_KW | VOID_KW );
	public final Type type() throws RecognitionException {
		Type type = null;


		try {
			// ./src/VSLTreeParser.g:100:5: ( INT_KW | VOID_KW )
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
					// ./src/VSLTreeParser.g:100:7: INT_KW
					{
					match(input,INT_KW,FOLLOW_INT_KW_in_type253); 
					type = Type.INT;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:101:7: VOID_KW
					{
					match(input,VOID_KW,FOLLOW_VOID_KW_in_type263); 
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



	// $ANTLR start "param_list"
	// ./src/VSLTreeParser.g:104:1: param_list returns [List<Type> liste] : ( ^( PARAM (pa= param )* ) | PARAM );
	public final List<Type> param_list() throws RecognitionException {
		List<Type> liste = null;


		Type pa =null;

		try {
			// ./src/VSLTreeParser.g:105:5: ( ^( PARAM (pa= param )* ) | PARAM )
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
					// ./src/VSLTreeParser.g:105:7: ^( PARAM (pa= param )* )
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list287); 
					liste = new ArrayList<>();
					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						// ./src/VSLTreeParser.g:105:44: (pa= param )*
						loop4:
						while (true) {
							int alt4=2;
							int LA4_0 = input.LA(1);
							if ( (LA4_0==IDENT||LA4_0==ARRAY) ) {
								alt4=1;
							}

							switch (alt4) {
							case 1 :
								// ./src/VSLTreeParser.g:105:45: pa= param
								{
								pushFollow(FOLLOW_param_in_param_list294);
								pa=param();
								state._fsp--;

								liste.add(pa);
								}
								break;

							default :
								break loop4;
							}
						}

						match(input, Token.UP, null); 
					}

					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:106:7: PARAM
					{
					match(input,PARAM,FOLLOW_PARAM_in_param_list307); 
					liste = new ArrayList<>();
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
		return liste;
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// ./src/VSLTreeParser.g:109:1: param returns [Type type] : ( IDENT | ^( ARRAY IDENT ) );
	public final Type param() throws RecognitionException {
		Type type = null;


		try {
			// ./src/VSLTreeParser.g:110:5: ( IDENT | ^( ARRAY IDENT ) )
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
					// ./src/VSLTreeParser.g:110:7: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_param330); 
					type =Type.INT;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:111:7: ^( ARRAY IDENT )
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_param341); 
					match(input, Token.DOWN, null); 
					match(input,IDENT,FOLLOW_IDENT_in_param343); 
					type =Type.POINTER;
					match(input, Token.UP, null); 

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
	// $ANTLR end "param"



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:114:1: statement[SymbolTable symTab] returns [Code3a code] : (aff= affectation[symTab] |b= block[symTab] |i= ifStatement[symTab] |w= whileStatement[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a aff =null;
		Code3a b =null;
		Code3a i =null;
		Code3a w =null;

		try {
			// ./src/VSLTreeParser.g:115:3: (aff= affectation[symTab] |b= block[symTab] |i= ifStatement[symTab] |w= whileStatement[symTab] )
			int alt7=4;
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
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:116:5: aff= affectation[symTab]
					{
					pushFollow(FOLLOW_affectation_in_statement372);
					aff=affectation(symTab);
					state._fsp--;

					 code = aff; 
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:117:5: b= block[symTab]
					{
					symTab.enterScope();
					pushFollow(FOLLOW_block_in_statement385);
					b=block(symTab);
					state._fsp--;

					symTab.leaveScope();
					 code = b; 
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:118:5: i= ifStatement[symTab]
					{
					pushFollow(FOLLOW_ifStatement_in_statement400);
					i=ifStatement(symTab);
					state._fsp--;

					code = i;
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:119:5: w= whileStatement[symTab]
					{
					pushFollow(FOLLOW_whileStatement_in_statement413);
					w=whileStatement(symTab);
					state._fsp--;

					code = w;
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



	// $ANTLR start "whileStatement"
	// ./src/VSLTreeParser.g:122:1: whileStatement[SymbolTable symTab] returns [Code3a code] : ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) ;
	public final Code3a whileStatement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a s1 =null;

		try {
			// ./src/VSLTreeParser.g:123:3: ( ^( WHILE_KW e= expression[symTab] s1= statement[symTab] ) )
			// ./src/VSLTreeParser.g:124:5: ^( WHILE_KW e= expression[symTab] s1= statement[symTab] )
			{
			match(input,WHILE_KW,FOLLOW_WHILE_KW_in_whileStatement439); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_whileStatement443);
			e=expression(symTab);
			state._fsp--;

			pushFollow(FOLLOW_statement_in_whileStatement448);
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
	// ./src/VSLTreeParser.g:139:1: ifStatement[SymbolTable symTab] returns [Code3a code] : ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) ;
	public final Code3a ifStatement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		ExpAttribute e =null;
		Code3a s1 =null;
		Code3a s2 =null;

		try {
			// ./src/VSLTreeParser.g:140:3: ( ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? ) )
			// ./src/VSLTreeParser.g:140:5: ^( IF_KW e= expression[symTab] s1= statement[symTab] (s2= statement[symTab] )? )
			{
			match(input,IF_KW,FOLLOW_IF_KW_in_ifStatement475); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_ifStatement479);
			e=expression(symTab);
			state._fsp--;

			pushFollow(FOLLOW_statement_in_ifStatement485);
			s1=statement(symTab);
			state._fsp--;

			s2=null;
			// ./src/VSLTreeParser.g:140:67: (s2= statement[symTab] )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ASSIGN_KW||LA8_0==IF_KW||LA8_0==WHILE_KW||LA8_0==BLOCK) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:140:68: s2= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_ifStatement493);
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
	// ./src/VSLTreeParser.g:161:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dec =null;
		Code3a l =null;

		try {
			// ./src/VSLTreeParser.g:162:3: ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==BLOCK) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==DOWN) ) {
					int LA9_2 = input.LA(3);
					if ( (LA9_2==DECL) ) {
						alt9=1;
					}
					else if ( (LA9_2==INST) ) {
						alt9=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 9, 2, input);
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
							new NoViableAltException("", 9, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ./src/VSLTreeParser.g:163:5: ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block526); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block530);
					dec=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block535);
					l=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					dec.append(l);code = dec;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:164:5: ^( BLOCK l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block546); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block550);
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
	// ./src/VSLTreeParser.g:167:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (stat= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:168:5: ( ^( INST (stat= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:168:8: ^( INST (stat= statement[symTab] )+ )
			{
			code = new Code3a();
			match(input,INST,FOLLOW_INST_in_inst_list578); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:168:38: (stat= statement[symTab] )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==ASSIGN_KW||LA10_0==IF_KW||LA10_0==WHILE_KW||LA10_0==BLOCK) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ./src/VSLTreeParser.g:168:39: stat= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list583);
					stat=statement(symTab);
					state._fsp--;

					code.append(stat);
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
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
	// ./src/VSLTreeParser.g:171:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_item[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// ./src/VSLTreeParser.g:172:3: ( ^( DECL (dl= decl_item[symTab] )+ ) )
			// ./src/VSLTreeParser.g:172:5: ^( DECL (dl= decl_item[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration612); 
			code=new Code3a();
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:172:33: (dl= decl_item[symTab] )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==IDENT||LA11_0==ARDECL) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// ./src/VSLTreeParser.g:172:34: dl= decl_item[symTab]
					{
					pushFollow(FOLLOW_decl_item_in_declaration619);
					dl=decl_item(symTab);
					state._fsp--;

					code.append(dl);
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
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
	// ./src/VSLTreeParser.g:178:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT3=null;
		CommonTree IDENT4=null;
		CommonTree INTEGER5=null;

		try {
			// ./src/VSLTreeParser.g:179:3: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENT) ) {
				alt12=1;
			}
			else if ( (LA12_0==ARDECL) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// ./src/VSLTreeParser.g:179:5: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item646); 

					      if(symTab.lookup((IDENT3!=null?IDENT3.getText():null))==null
					      || symTab.lookup((IDENT3!=null?IDENT3.getText():null)).getScope() != symTab.getScope()){
					        VarSymbol op = new VarSymbol(Type.INT, (IDENT3!=null?IDENT3.getText():null), symTab.getScope());
					        symTab.insert((IDENT3!=null?IDENT3.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        System.out.println("Erreur déclaration -> la variable " +(IDENT3!=null?IDENT3.getText():null)+ " à déja été déclarée");
					        System.exit(0);
					      }

					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:193:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item660); 
					match(input, Token.DOWN, null); 
					IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item662); 
					INTEGER5=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item664); 
					match(input, Token.UP, null); 


					      if(symTab.lookup((IDENT4!=null?IDENT4.getText():null))==null
					      || symTab.lookup((IDENT4!=null?IDENT4.getText():null)).getScope() != symTab.getScope()){
					        int sizeArray = Integer.parseInt((INTEGER5!=null?INTEGER5.getText():null));
					        ArrayType tableau = new ArrayType(Type.INT, sizeArray);
					        VarSymbol op = new VarSymbol(tableau, (IDENT4!=null?IDENT4.getText():null), symTab.getScope());
					        symTab.insert((IDENT4!=null?IDENT4.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        System.out.println("Erreur déclaration -> la variable " +(IDENT4!=null?IDENT4.getText():null)+ " à déja été déclarée");
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
	// ./src/VSLTreeParser.g:210:1: affectation[SymbolTable symTab] returns [Code3a code] : ^( ASSIGN_KW e= expression[symTab] IDENT ) ;
	public final Code3a affectation(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT6=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:211:3: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) )
			// ./src/VSLTreeParser.g:211:3: ^( ASSIGN_KW e= expression[symTab] IDENT )
			{
			match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_affectation690); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_affectation694);
			e=expression(symTab);
			state._fsp--;

			IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_affectation697); 
			match(input, Token.UP, null); 

			code = Code3aGenerator.genAff((IDENT6!=null?IDENT6.getText():null),e,symTab);
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
	// ./src/VSLTreeParser.g:215:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree PLUS7=null;
		CommonTree MINUS8=null;
		CommonTree MUL9=null;
		CommonTree DIV10=null;
		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:216:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] )
			int alt13=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt13=1;
				}
				break;
			case MINUS:
				{
				alt13=2;
				}
				break;
			case MUL:
				{
				alt13=3;
				}
				break;
			case DIV:
				{
				alt13=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case NEGAT:
				{
				alt13=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// ./src/VSLTreeParser.g:216:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					PLUS7=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expression721); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression725);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression730);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(PLUS7, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:226:4: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					MINUS8=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression745); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression749);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression754);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 

					      if (TypeCheck.checkBinOpError(MINUS8, e1.type, e2.type)) {
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp); 
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:237:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					MUL9=(CommonTree)match(input,MUL,FOLLOW_MUL_in_expression769); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression773);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression778);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					;
					      if(TypeCheck.checkBinOpError(MUL9, e1.type, e2.type)){
					          VarSymbol temp = SymbDistrib.newTemp();
					          Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					          expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:248:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					DIV10=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expression794); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression798);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression803);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(DIV10, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }

					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:259:5: pe= primary[symTab]
					{
					pushFollow(FOLLOW_primary_in_expression820);
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
	// ./src/VSLTreeParser.g:264:1: primary[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) );
	public final ExpAttribute primary(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER11=null;
		CommonTree IDENT12=null;
		CommonTree NEGAT13=null;
		ExpAttribute e2 =null;

		try {
			// ./src/VSLTreeParser.g:265:3: ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) )
			int alt14=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt14=1;
				}
				break;
			case IDENT:
				{
				alt14=2;
				}
				break;
			case NEGAT:
				{
				alt14=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// ./src/VSLTreeParser.g:265:5: INTEGER
					{
					INTEGER11=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary848); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER11!=null?INTEGER11.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:270:5: IDENT
					{
					IDENT12=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary860); 

					      Operand3a id = symTab.lookup((IDENT12!=null?IDENT12.getText():null));
					      if (id == null) {
					        System.out.println("Erreur primary -> la variable "+(IDENT12!=null?IDENT12.getText():null)+ " n'existe pas");
					      }else{
					        expAtt = new ExpAttribute(id.type, new Code3a(), id);
					      }
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:279:5: ^( NEGAT e2= primary[symTab] )
					{
					NEGAT13=(CommonTree)match(input,NEGAT,FOLLOW_NEGAT_in_primary873); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_primary_in_primary877);
					e2=primary(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      ConstSymbol cs = new ConstSymbol(0);
					      ExpAttribute expZero = new ExpAttribute(Type.INT, new Code3a(), cs);

					      if (TypeCheck.checkBinOpError(NEGAT13, expZero.type, e2.type)) {
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, expZero, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
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
		return expAtt;
	}
	// $ANTLR end "primary"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_s64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROG_in_program101 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_unit_in_program107 = new BitSet(new long[]{0x0000000008002008L});
	public static final BitSet FOLLOW_function_in_unit140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_proto_in_unit149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNC_KW_in_function172 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_function176 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_function178 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_function182 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_BODY_in_function186 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_function190 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROTO_KW_in_proto215 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_proto219 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_proto221 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_param_list_in_proto225 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_KW_in_type253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KW_in_type263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAM_in_param_list287 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_param_list294 = new BitSet(new long[]{0x0000010000004008L});
	public static final BitSet FOLLOW_PARAM_in_param_list307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_param330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_param341 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_param343 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_affectation_in_statement372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_statement385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifStatement_in_statement400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileStatement_in_statement413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KW_in_whileStatement439 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_whileStatement443 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_whileStatement448 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IF_KW_in_ifStatement475 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ifStatement479 = new BitSet(new long[]{0x0000021000008020L});
	public static final BitSet FOLLOW_statement_in_ifStatement485 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_statement_in_ifStatement493 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block526 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block530 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block535 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block546 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block550 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list578 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list583 = new BitSet(new long[]{0x0000021000008028L});
	public static final BitSet FOLLOW_DECL_in_declaration612 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_item_in_declaration619 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_IDENT_in_decl_item646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item660 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item662 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item664 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_affectation690 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_affectation694 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_affectation697 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression721 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression725 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression730 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression745 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression749 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression754 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression769 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression773 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression778 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression794 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression798 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression803 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_in_expression820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEGAT_in_primary873 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_primary_in_primary877 = new BitSet(new long[]{0x0000000000000008L});
}
