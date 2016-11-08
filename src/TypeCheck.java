import org.antlr.runtime.tree.CommonTree;


/**
 * Type checking operations (NOTE: this class must be implemented by the
 * student; the methods indicated here can be seen as suggestions; note that
 * some minor checks can still be performed directly in VSLTreeParser.g).
 * 
 */
public class TypeCheck {

	// an Example
	/**
	 * Type checking for a binary operation - in VSL+: integer operations only!
	 */
	public static Type checkBinOp(Type t1, Type t2) {
		if (t1 == Type.INT && t2 == Type.INT)
			return Type.INT;
		else {
			return Type.ERROR;
		}
	}


	public static boolean checkBinOpError(CommonTree token, Type t1, Type t2){
		if(checkBinOp(t1,t2) == Type.ERROR){
			if (t1 != Type.INT) {
         		Errors.incompatibleTypes(token, Type.INT, t1,null);
        	}
        
        	if (t2 != Type.INT) {
          		Errors.incompatibleTypes(token, Type.INT, t2,null);
        	}
        	return false;
		}else{
			return true;
		}
	}

}
