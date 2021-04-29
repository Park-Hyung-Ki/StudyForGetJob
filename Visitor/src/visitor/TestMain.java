package visitor;

public class TestMain {

	public static void main(String[] args) {
		Operand five = new Operand(5);
		Operand eight = new Operand(8);
		Operator mul = new Operator(five, eight, '*');
		
		Operand three = new Operand(3);
		Operator plus = new Operator(three, mul, '+');
		
		
	Prefix prefix = new Prefix();
	plus.accept(prefix);
	System.out.println();
	
	Postfix postfix = new Postfix();
	plus.accept(postfix);
	System.out.println();
	
	
	Infix infix = new Infix();
	plus.accept(infix);
	System.out.println();
	
	}

}
