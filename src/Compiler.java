import java.util.HashMap;

public abstract class Compiler extends Parser 
{
	
	/*
	 * 	Not sure if this is the best implementation of numbering the arguments of a given program.
	 *	Used a hashmap that maps varName --> int. The hashmap is populated when a variable is pushed or popped in
	 *	Id and AssignStatement classes respectively. See emitInstructions() implementation in Id and AssignStatement.
	 */
	static HashMap<String,Integer> vars = new HashMap<String,Integer>(); 
	static int varCount = 0;
	
	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the emitted instructions
		
		setIO( argv[0], argv[1] );
		setKeywords();

		getToken();

		Statement s = statement();
		if ( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound )
			s.emitInstructions(); // emit instructions to argv[1] file

		closeIO();
	}
}
