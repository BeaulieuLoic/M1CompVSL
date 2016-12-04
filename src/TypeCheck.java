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
		if (t1.isCompatible(Type.INT) && t2.isCompatible(Type.INT))
			return Type.INT;
		else {
			return Type.ERROR;
		}
	}

	public static boolean isInt(Type t){
		return t.isCompatible(Type.INT);
	}

	public static boolean checkBinOpError(CommonTree token, Type t1, Type t2){
		if(checkBinOp(t1,t2) == Type.ERROR){
			if (!t1.isCompatible(Type.INT)) {
         		Errors.incompatibleTypes(token, Type.INT, t1,null);
        	}
        
        	if (!t2.isCompatible(Type.INT)) {
          		Errors.incompatibleTypes(token, Type.INT, t2,null);
        	}
        	return false;
		}else{
			return true;
		}
	}

	public static boolean isPrototype(Type elem){
		if (elem instanceof FunctionType) {
			return ((FunctionType) elem).prototype;
		}else{
			return false;
		}
	} 
	
	public static boolean isFunction(Type elem){
		return (elem instanceof FunctionType);
	}

	public static boolean isArrayInt(CommonTree token, ExpAttribute expAtt, Operand3a tab, String nomIdent){
      if (tab == null) {
        //System.out.println("Erreur TypeCheck.isArrayInt -> la variable "+nomIdent+ " n'existe pas");
        Errors.unknownIdentifier(token,nomIdent, 
          "Erreur TypeCheck.isArrayInt -> la variable "+nomIdent+ " n'existe pas");
        return false;
      }

      if (!TypeCheck.isInt(expAtt.type)) {
        //System.out.println("Erreur TypeCheck.isArrayInt -> l'expression donnée n'est pas de type int");
        Errors.incompatibleTypes(token,Type.INT,expAtt.type,
          "Erreur TypeCheck.isArrayInt -> l'expression donnée n'est pas de type int");

        return false;
      }

      if (!(tab instanceof VarSymbol)) {
        //System.out.println("Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas une variable");
        Errors.miscError(token, 
        	"Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas une variable");
        return false;
      }


      if (tab.type.isCompatible(Type.POINTER)) {
      	return true;
      }


      if (!(tab.type instanceof ArrayType)) {
        //System.out.println("Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas un tableau");
        Errors.incompatibleTypes(token,"Array or POINTER",tab.type,
          "Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas un tableau");

        return false;
      }

      ArrayType symbolIdent = (ArrayType) tab.type;
      ArrayType tmp = new ArrayType(Type.INT, 0);

      if (!(symbolIdent.isCompatible(tmp))) {// utile ?
        //System.out.println("Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas un tableau d'int");
        Errors.miscError(token, 
        	"Erreur TypeCheck.isArrayInt -> "+nomIdent+" n'est pas un tableau d'int");      	
        return false;
      }
		return true;
	}
}
