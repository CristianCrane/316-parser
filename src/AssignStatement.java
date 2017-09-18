
public class AssignStatement extends Statement 
{

	// ⟨assignment⟩ → ⟨id⟩ "=" ⟨expr⟩ ";" 

	String id; // variable on the left side of the assignment
	Expr expr;       // expression on the right side of the assignment

	AssignStatement(String s, Expr e)
	{
		id = s;
		expr = e;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent1 + " ";
				
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " <assignment>");
		IO.displayln(indent2 + indent2.length() + id);
		IO.displayln(indent2 + indent2.length() + " =");
		expr.printParseTree(indent2);
	}
	
	void emitInstructions()
	{
		expr.emitInstructions();

		// if we haven't saved the var yet assign it the next number
		if (!Compiler.vars.containsKey(id))
			Compiler.vars.put(id, Compiler.varCount++);
			
		// display the number mapped to this var
		IO.displayln("pop #" + Compiler.vars.get(id));
	}

}
