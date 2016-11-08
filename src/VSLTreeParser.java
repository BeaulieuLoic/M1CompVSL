// $ANTLR 3.5.2 ./src/VSLTreeParser.g 2016-11-08 10:07:25

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
	// ./src/VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] :stat= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:10:3: (stat= statement[symTab] )
			// ./src/VSLTreeParser.g:10:5: stat= statement[symTab]
			{
			code = new Code3a();
			pushFollow(FOLLOW_statement_in_s64);
			stat=statement(symTab);
			state._fsp--;

			 code.append(stat); symTab.print();
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



	// $ANTLR start "statement"
	// ./src/VSLTreeParser.g:15:1: statement[SymbolTable symTab] returns [Code3a code] : (aff= affectation[symTab] |b= block[symTab] );
	public final Code3a statement(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a aff =null;
		Code3a b =null;

		try {
			// ./src/VSLTreeParser.g:16:3: (aff= affectation[symTab] |b= block[symTab] )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==ASSIGN_KW) ) {
				alt1=1;
			}
			else if ( (LA1_0==BLOCK) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ./src/VSLTreeParser.g:17:5: aff= affectation[symTab]
					{
					pushFollow(FOLLOW_affectation_in_statement92);
					aff=affectation(symTab);
					state._fsp--;

					 code = aff; 
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:18:5: b= block[symTab]
					{
					symTab.enterScope();
					pushFollow(FOLLOW_block_in_statement105);
					b=block(symTab);
					state._fsp--;

					symTab.leaveScope();
					 code = b; 
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



	// $ANTLR start "block"
	// ./src/VSLTreeParser.g:31:1: block[SymbolTable symTab] returns [Code3a code] : ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) );
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dec =null;
		Code3a l =null;

		try {
			// ./src/VSLTreeParser.g:32:3: ( ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] ) | ^( BLOCK l= inst_list[symTab] ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==BLOCK) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					int LA2_2 = input.LA(3);
					if ( (LA2_2==DECL) ) {
						alt2=1;
					}
					else if ( (LA2_2==INST) ) {
						alt2=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 2, 2, input);
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
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:33:5: ^( BLOCK dec= declaration[symTab] l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block145); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_declaration_in_block149);
					dec=declaration(symTab);
					state._fsp--;

					pushFollow(FOLLOW_inst_list_in_block154);
					l=inst_list(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					dec.append(l);code = dec;
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:34:5: ^( BLOCK l= inst_list[symTab] )
					{
					match(input,BLOCK,FOLLOW_BLOCK_in_block165); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_inst_list_in_block169);
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
	// ./src/VSLTreeParser.g:37:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (stat= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:38:5: ( ^( INST (stat= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:38:8: ^( INST (stat= statement[symTab] )+ )
			{
			code = new Code3a();
			match(input,INST,FOLLOW_INST_in_inst_list197); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:38:38: (stat= statement[symTab] )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==ASSIGN_KW||LA3_0==BLOCK) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:38:39: stat= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list202);
					stat=statement(symTab);
					state._fsp--;

					code.append(stat);
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
	// ./src/VSLTreeParser.g:41:1: declaration[SymbolTable symTab] returns [Code3a code] : ^( DECL (dl= decl_list[symTab] )+ ) ;
	public final Code3a declaration(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a dl =null;

		try {
			// ./src/VSLTreeParser.g:42:3: ( ^( DECL (dl= decl_list[symTab] )+ ) )
			// ./src/VSLTreeParser.g:42:5: ^( DECL (dl= decl_list[symTab] )+ )
			{
			match(input,DECL,FOLLOW_DECL_in_declaration231); 
			code=new Code3a();
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:42:33: (dl= decl_list[symTab] )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==IDENT||LA4_0==ARDECL) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:42:34: dl= decl_list[symTab]
					{
					pushFollow(FOLLOW_decl_list_in_declaration238);
					dl=decl_list(symTab);
					state._fsp--;

					code.append(dl);
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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



	// $ANTLR start "decl_list"
	// ./src/VSLTreeParser.g:45:1: decl_list[SymbolTable symTab] returns [Code3a code] : di= decl_item[symTab] ( COM di= decl_item[symTab] )* ;
	public final Code3a decl_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a di =null;

		try {
			// ./src/VSLTreeParser.g:46:3: (di= decl_item[symTab] ( COM di= decl_item[symTab] )* )
			// ./src/VSLTreeParser.g:46:5: di= decl_item[symTab] ( COM di= decl_item[symTab] )*
			{
			pushFollow(FOLLOW_decl_item_in_decl_list266);
			di=decl_item(symTab);
			state._fsp--;

			code=di;
			// ./src/VSLTreeParser.g:46:37: ( COM di= decl_item[symTab] )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COM) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// ./src/VSLTreeParser.g:46:38: COM di= decl_item[symTab]
					{
					match(input,COM,FOLLOW_COM_in_decl_list272); 
					pushFollow(FOLLOW_decl_item_in_decl_list276);
					di=decl_item(symTab);
					state._fsp--;

					code.append(di);
					}
					break;

				default :
					break loop5;
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
	// $ANTLR end "decl_list"



	// $ANTLR start "decl_item"
	// ./src/VSLTreeParser.g:48:1: decl_item[SymbolTable symTab] returns [Code3a code] : ( IDENT | ^( ARDECL IDENT INTEGER ) );
	public final Code3a decl_item(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		CommonTree IDENT2=null;
		CommonTree INTEGER3=null;

		try {
			// ./src/VSLTreeParser.g:49:3: ( IDENT | ^( ARDECL IDENT INTEGER ) )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==IDENT) ) {
				alt6=1;
			}
			else if ( (LA6_0==ARDECL) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ./src/VSLTreeParser.g:49:5: IDENT
					{
					IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item298); 

					      if(symTab.lookup((IDENT1!=null?IDENT1.getText():null))==null
					      || symTab.lookup((IDENT1!=null?IDENT1.getText():null)).getScope() != symTab.getScope()){
					        VarSymbol op = new VarSymbol(Type.INT, (IDENT1!=null?IDENT1.getText():null), symTab.getScope());
					        symTab.insert((IDENT1!=null?IDENT1.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        System.out.println("Erreur déclaration -> la variable " +(IDENT1!=null?IDENT1.getText():null)+ " à déja été déclarée");
					      }

					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:62:5: ^( ARDECL IDENT INTEGER )
					{
					match(input,ARDECL,FOLLOW_ARDECL_in_decl_item312); 
					match(input, Token.DOWN, null); 
					IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_decl_item314); 
					INTEGER3=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_decl_item316); 
					match(input, Token.UP, null); 


					      if(symTab.lookup((IDENT2!=null?IDENT2.getText():null))==null
					      || symTab.lookup((IDENT2!=null?IDENT2.getText():null)).getScope() != symTab.getScope()){
					        int sizeArray = Integer.parseInt((INTEGER3!=null?INTEGER3.getText():null));
					    
					        VarSymbol op = new VarSymbol(new Type("ARRAY",4*sizeArray), (IDENT2!=null?IDENT2.getText():null), symTab.getScope());
					        symTab.insert((IDENT2!=null?IDENT2.getText():null),op);

					        code = Code3aGenerator.genVar(op);
					      }else{
					        System.out.println("Erreur déclaration -> la variable " +(IDENT2!=null?IDENT2.getText():null)+ " à déja été déclarée");
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
	// ./src/VSLTreeParser.g:79:1: affectation[SymbolTable symTab] returns [Code3a code] : ^( ASSIGN_KW e= expression[symTab] IDENT ) ;
	public final Code3a affectation(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT4=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:80:3: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) )
			// ./src/VSLTreeParser.g:80:3: ^( ASSIGN_KW e= expression[symTab] IDENT )
			{
			match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_affectation342); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_affectation346);
			e=expression(symTab);
			state._fsp--;

			IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_affectation349); 
			match(input, Token.UP, null); 

			code = Code3aGenerator.genAff((IDENT4!=null?IDENT4.getText():null),e,symTab);
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
	// ./src/VSLTreeParser.g:83:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree PLUS5=null;
		CommonTree MINUS6=null;
		CommonTree MUL7=null;
		CommonTree DIV8=null;
		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:84:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary[symTab] )
			int alt7=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt7=1;
				}
				break;
			case MINUS:
				{
				alt7=2;
				}
				break;
			case MUL:
				{
				alt7=3;
				}
				break;
			case DIV:
				{
				alt7=4;
				}
				break;
			case IDENT:
			case INTEGER:
			case NEGAT:
				{
				alt7=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ./src/VSLTreeParser.g:84:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					PLUS5=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expression370); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression374);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression379);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(PLUS5, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:94:4: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					MINUS6=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression394); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression398);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression403);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 

					      if (TypeCheck.checkBinOpError(MINUS6, e1.type, e2.type)) {
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp); 
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:105:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					MUL7=(CommonTree)match(input,MUL,FOLLOW_MUL_in_expression418); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression422);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression427);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					;
					      if(TypeCheck.checkBinOpError(MUL7, e1.type, e2.type)){
					          VarSymbol temp = SymbDistrib.newTemp();
					          Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					          expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:116:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					DIV8=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expression443); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression447);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression452);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      if(TypeCheck.checkBinOpError(DIV8, e1.type, e2.type)){
					        VarSymbol temp = SymbDistrib.newTemp();
					        Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					        expAtt = new ExpAttribute(Type.INT, cod, temp);
					      }else{
					        System.exit(0);
					      }

					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:127:5: pe= primary[symTab]
					{
					pushFollow(FOLLOW_primary_in_expression469);
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
	// ./src/VSLTreeParser.g:132:1: primary[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) );
	public final ExpAttribute primary(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER9=null;
		CommonTree IDENT10=null;
		CommonTree NEGAT11=null;
		ExpAttribute e2 =null;

		try {
			// ./src/VSLTreeParser.g:133:3: ( INTEGER | IDENT | ^( NEGAT e2= primary[symTab] ) )
			int alt8=3;
			switch ( input.LA(1) ) {
			case INTEGER:
				{
				alt8=1;
				}
				break;
			case IDENT:
				{
				alt8=2;
				}
				break;
			case NEGAT:
				{
				alt8=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// ./src/VSLTreeParser.g:133:5: INTEGER
					{
					INTEGER9=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary497); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER9!=null?INTEGER9.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:138:5: IDENT
					{
					IDENT10=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary509); 

					      Operand3a id = symTab.lookup((IDENT10!=null?IDENT10.getText():null));
					      if (id == null) {
					        System.out.println("Erreur primary -> la variable "+(IDENT10!=null?IDENT10.getText():null)+ " n'existe pas");
					      }else{
					        expAtt = new ExpAttribute(id.type, new Code3a(), id);
					      }
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:147:5: ^( NEGAT e2= primary[symTab] )
					{
					NEGAT11=(CommonTree)match(input,NEGAT,FOLLOW_NEGAT_in_primary522); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_primary_in_primary526);
					e2=primary(symTab);
					state._fsp--;

					match(input, Token.UP, null); 


					      ConstSymbol cs = new ConstSymbol(0);
					      ExpAttribute expZero = new ExpAttribute(Type.INT, new Code3a(), cs);

					      if (TypeCheck.checkBinOpError(NEGAT11, expZero.type, e2.type)) {
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



	public static final BitSet FOLLOW_statement_in_s64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affectation_in_statement92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_statement105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block145 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_block149 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_inst_list_in_block154 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block169 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list197 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list202 = new BitSet(new long[]{0x0000020000000028L});
	public static final BitSet FOLLOW_DECL_in_declaration231 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_list_in_declaration238 = new BitSet(new long[]{0x0000004000004008L});
	public static final BitSet FOLLOW_decl_item_in_decl_list266 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COM_in_decl_list272 = new BitSet(new long[]{0x0000004000004000L});
	public static final BitSet FOLLOW_decl_item_in_decl_list276 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_decl_item298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARDECL_in_decl_item312 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_decl_item314 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTEGER_in_decl_item316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_affectation342 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_affectation346 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_affectation349 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression370 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression374 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression379 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression394 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression398 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression403 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression422 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression427 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression443 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression447 = new BitSet(new long[]{0x0000800002C14200L});
	public static final BitSet FOLLOW_expression_in_expression452 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_in_expression469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEGAT_in_primary522 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_primary_in_primary526 = new BitSet(new long[]{0x0000000000000008L});
}
