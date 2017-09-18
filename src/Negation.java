import java.util.HashMap;

public class Negation extends Primary
{
	Primary p;
	
	Negation(Primary pr)
	{
		p = pr;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent1 + " ";
		
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " <negation>");
		IO.displayln(indent2 + indent2.length() + " !");
		p.printParseTree(indent2);
	}
	
	@Override
	Val Eval(HashMap<String, Val> state) {
		// TODO Auto-generated method stub
		return null;
	}

	void emitInstructions()
	{
		p.emitInstructions();
		IO.displayln("inv");
	}
	
}
