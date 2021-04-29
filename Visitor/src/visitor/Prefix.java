package visitor;

public class Prefix extends Visitor {

	@Override
	public void visit(Operand target) {
		System.out.print(target.getValue());
	}

	@Override
	public void visit(Operator target) {
		System.out.println(((Operator) target).getOperator());
		target.getLeft().accept(this);
		target.getRight().accept(this);
		
	}

}
