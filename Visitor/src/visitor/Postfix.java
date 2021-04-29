package visitor;

public class Postfix extends Visitor {

	@Override
	public void visit(Operand target) {
		System.out.print(target.getValue());
	}

	@Override
	public void visit(Operator target) {
		target.getLeft().accept(this);
		target.getRight().accept(this);
		System.out.println(((Operator) target).getOperator());
		
	}

}
