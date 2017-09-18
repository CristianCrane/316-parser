This is the third and final step of building a programming language; the intermediate code compiler. The main runnable class is Parser.java. The other classes define all the symbols and structures of the sample language.

Program input:
Stream of text/symbols/tokens that make up your program in a txtfile.

Program output:
Intermediate code instructions that are directly runnable on a stack based machine such as the Java Virtual Machine.

Fundamentally, the purpose of this program is to deduce the semantics of a given program, line by line, and output the appropriate corresponding instructions to the stack based virtual machine - which then executes your programs logic.

This is done by emulating the semantic meaning of each statement through nested conditionals which mirror the semantics of the given statement. If any errors are caught, it is easily identifiable exactly where and what caused it, allowing for precise, detailed error messages.

