import java.util.*;

class Id extends Primary
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " " + id);
	}

	Val Eval(HashMap<String,Val> state)
	{
		Val idVal = state.get(id);
		if ( idVal != null )
			return idVal.cloneVal();
		else
		{
			System.out.println( "variable "+id+" does not have a value" );
			return null;
		}
	}
	
	void emitInstructions()
	{
		// if we haven't saved the var yet assign it the next number
		if (!Compiler.vars.containsKey(id))
			Compiler.vars.put(id, Compiler.varCount++);
			
		// display the number mapped to this var
		IO.displayln("push #" + Compiler.vars.get(id));
	}
}