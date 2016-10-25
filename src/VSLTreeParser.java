// $ANTLR 3.5.2 ./src/VSLTreeParser.g 2016-10-25 09:54:26

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
	// ./src/VSLTreeParser.g:9:1: s[SymbolTable symTab] returns [Code3a code] : stat= statement[symTab] ;
	public final Code3a s(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:10:3: (stat= statement[symTab] )
			// ./src/VSLTreeParser.g:11:3: stat= statement[symTab]
			{
			pushFollow(FOLLOW_statement_in_s63);
			stat=statement(symTab);
			state._fsp--;

			 code = stat; symTab.print();
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
	// ./src/VSLTreeParser.g:21:1: block[SymbolTable symTab] returns [Code3a code] : ^( BLOCK l= inst_list[symTab] ) ;
	public final Code3a block(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a l =null;

		try {
			// ./src/VSLTreeParser.g:22:3: ( ^( BLOCK l= inst_list[symTab] ) )
			// ./src/VSLTreeParser.g:24:3: ^( BLOCK l= inst_list[symTab] )
			{
			match(input,BLOCK,FOLLOW_BLOCK_in_block133); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_inst_list_in_block137);
			l=inst_list(symTab);
			state._fsp--;

			match(input, Token.UP, null); 

			code = l;
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
	// ./src/VSLTreeParser.g:27:1: inst_list[SymbolTable symTab] returns [Code3a code] : ^( INST (stat= statement[symTab] )+ ) ;
	public final Code3a inst_list(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		Code3a stat =null;

		try {
			// ./src/VSLTreeParser.g:28:5: ( ^( INST (stat= statement[symTab] )+ ) )
			// ./src/VSLTreeParser.g:28:8: ^( INST (stat= statement[symTab] )+ )
			{
			code = new Code3a();
			match(input,INST,FOLLOW_INST_in_inst_list165); 
			match(input, Token.DOWN, null); 
			// ./src/VSLTreeParser.g:28:38: (stat= statement[symTab] )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ASSIGN_KW||LA2_0==BLOCK) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// ./src/VSLTreeParser.g:28:39: stat= statement[symTab]
					{
					pushFollow(FOLLOW_statement_in_inst_list170);
					stat=statement(symTab);
					state._fsp--;

					code.append(stat);
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
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



	// $ANTLR start "affectation"
	// ./src/VSLTreeParser.g:33:1: affectation[SymbolTable symTab] returns [Code3a code] : ^( ASSIGN_KW e= expression[symTab] IDENT ) ;
	public final Code3a affectation(SymbolTable symTab) throws RecognitionException {
		Code3a code = null;


		CommonTree IDENT1=null;
		ExpAttribute e =null;

		try {
			// ./src/VSLTreeParser.g:34:3: ( ^( ASSIGN_KW e= expression[symTab] IDENT ) )
			// ./src/VSLTreeParser.g:34:3: ^( ASSIGN_KW e= expression[symTab] IDENT )
			{
			match(input,ASSIGN_KW,FOLLOW_ASSIGN_KW_in_affectation200); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expression_in_affectation204);
			e=expression(symTab);
			state._fsp--;

			IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_affectation207); 
			match(input, Token.UP, null); 

			code = Code3aGenerator.genAff((IDENT1!=null?IDENT1.getText():null),e,symTab) ;
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
	// ./src/VSLTreeParser.g:39:1: expression[SymbolTable symTab] returns [ExpAttribute expAtt] : ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] );
	public final ExpAttribute expression(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		ExpAttribute e1 =null;
		ExpAttribute e2 =null;
		ExpAttribute pe =null;

		try {
			// ./src/VSLTreeParser.g:40:3: ( ^( PLUS e1= expression[symTab] e2= expression[symTab] ) | ^( MINUS e1= expression[symTab] e2= expression[symTab] ) | ^( MUL e1= expression[symTab] e2= expression[symTab] ) | ^( DIV e1= expression[symTab] e2= expression[symTab] ) |pe= primary_exp[symTab] )
			int alt3=5;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt3=1;
				}
				break;
			case MINUS:
				{
				alt3=2;
				}
				break;
			case MUL:
				{
				alt3=3;
				}
				break;
			case DIV:
				{
				alt3=4;
				}
				break;
			case IDENT:
			case INTEGER:
				{
				alt3=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// ./src/VSLTreeParser.g:40:5: ^( PLUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,PLUS,FOLLOW_PLUS_in_expression230); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression234);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression239);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 

					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.ADD, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:48:4: ^( MINUS e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MINUS,FOLLOW_MINUS_in_expression254); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression258);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression263);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.SUB, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 3 :
					// ./src/VSLTreeParser.g:55:4: ^( MUL e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,MUL,FOLLOW_MUL_in_expression278); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression282);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression287);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.MUL, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 4 :
					// ./src/VSLTreeParser.g:62:5: ^( DIV e1= expression[symTab] e2= expression[symTab] )
					{
					match(input,DIV,FOLLOW_DIV_in_expression303); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expression_in_expression307);
					e1=expression(symTab);
					state._fsp--;

					pushFollow(FOLLOW_expression_in_expression312);
					e2=expression(symTab);
					state._fsp--;

					match(input, Token.UP, null); 

					 
					      Type ty = TypeCheck.checkBinOp(e1.type, e2.type);
					      VarSymbol temp = SymbDistrib.newTemp();
					      Code3a cod = Code3aGenerator.genBinOp(Inst3a.TAC.DIV, temp, e1, e2);
					      expAtt = new ExpAttribute(ty, cod, temp);
					    
					}
					break;
				case 5 :
					// ./src/VSLTreeParser.g:69:5: pe= primary_exp[symTab]
					{
					pushFollow(FOLLOW_primary_exp_in_expression329);
					pe=primary_exp(symTab);
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



	// $ANTLR start "primary_exp"
	// ./src/VSLTreeParser.g:74:1: primary_exp[SymbolTable symTab] returns [ExpAttribute expAtt] : ( INTEGER | IDENT );
	public final ExpAttribute primary_exp(SymbolTable symTab) throws RecognitionException {
		ExpAttribute expAtt = null;


		CommonTree INTEGER2=null;
		CommonTree IDENT3=null;

		try {
			// ./src/VSLTreeParser.g:75:3: ( INTEGER | IDENT )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==INTEGER) ) {
				alt4=1;
			}
			else if ( (LA4_0==IDENT) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ./src/VSLTreeParser.g:75:5: INTEGER
					{
					INTEGER2=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_primary_exp357); 

					      ConstSymbol cs = new ConstSymbol(Integer.parseInt((INTEGER2!=null?INTEGER2.getText():null)));
					      expAtt = new ExpAttribute(Type.INT, new Code3a(), cs);
					    
					}
					break;
				case 2 :
					// ./src/VSLTreeParser.g:80:5: IDENT
					{
					IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_primary_exp369); 

					      Operand3a id = symTab.lookup((IDENT3!=null?IDENT3.getText():null));
					      expAtt = new ExpAttribute(id.type, new Code3a(), symTab.lookup((IDENT3!=null?IDENT3.getText():null)));
					    
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
	// $ANTLR end "primary_exp"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_s63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_affectation_in_statement92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_statement105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BLOCK_in_block133 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_inst_list_in_block137 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INST_in_inst_list165 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_inst_list170 = new BitSet(new long[]{0x0000020000000028L});
	public static final BitSet FOLLOW_ASSIGN_KW_in_affectation200 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_affectation204 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_IDENT_in_affectation207 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression230 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression234 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression239 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression254 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression258 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression263 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MUL_in_expression278 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression282 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression287 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIV_in_expression303 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression307 = new BitSet(new long[]{0x0000000002C14200L});
	public static final BitSet FOLLOW_expression_in_expression312 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_primary_exp_in_expression329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_primary_exp357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_primary_exp369 = new BitSet(new long[]{0x0000000000000002L});
}
