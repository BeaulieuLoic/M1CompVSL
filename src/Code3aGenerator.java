/**
 * This class implements all the methods for 3a code generation (NOTE: this
 * class must be coded by the student; the methods indicated here can be seen as
 * a suggestion, but are not actually necessary).
 * 
 * @author MLB
 * 
 */
public class Code3aGenerator {

	public static int nbLabel=0;


	// Constructor not needed
	private Code3aGenerator() {
	}

	/**
	 * Generates the 3a statement: VAR t
	 **/
	public static Code3a genVar(Operand3a t) {
		Inst3a i = new Inst3a(Inst3a.TAC.VAR, t, null, null);
		return new Code3a(i);
	}

	/**
	 * Generate code for a binary operation
	 * 
	 * @param op
	 *            must be a code op: Inst3a.TAC.XXX
	 */
	public static Code3a genBinOp(Inst3a.TAC op, Operand3a temp, ExpAttribute exp1,
			ExpAttribute exp2) {
		Code3a cod = exp1.code;
		cod.append(exp2.code);
		cod.append(genVar(temp));
		cod.append(new Inst3a(op, temp, exp1.place, exp2.place));
		return cod;
	}

	public static Code3a genAff(String name, ExpAttribute exp, SymbolTable symTab){
		if(symTab.lookup(name) ==null){
		//trycatch ? ou error
			System.out.println("Erreur genAff -> variable " + name+" non déclaré");
			System.exit(0);
			return null;
		}
		if(!symTab.lookup(name).type.isCompatible(exp.type)){
			System.out.println("Erreur genAff -> affectation avec un type incompatible ");
			System.exit(0);
		}
		Code3a cod = exp.code;

		cod.append(new Inst3a(Inst3a.TAC.COPY,  symTab.lookup(name), exp.place, null));
		return cod;
		
	}

	public static Code3a genIfz(Operand3a place, LabelSymbol l){
		return new Code3a(new Inst3a(Inst3a.TAC.IFZ, place, l, null));
	}


	public static Code3a genCodeLabel(LabelSymbol l){
		return new Code3a(new Inst3a(Inst3a.TAC.LABEL, l, null, null));
	}

	public static Code3a genGoto(LabelSymbol l){
		return new Code3a(new Inst3a(Inst3a.TAC.GOTO, l, null, null));
	}

	public static Code3a genReturn(ExpAttribute exp){
		Code3a cod = exp.code;
		cod.append(new Inst3a(Inst3a.TAC.RETURN,  exp.place, null, null));
		return cod;
	}

	public static Code3a genArgs(ExpAttribute exp){
		Code3a cod = exp.code;
		cod.append(new Inst3a(Inst3a.TAC.ARG,  exp.place, null, null));
		return cod;	
	}




} // Code3aGenerator ***
