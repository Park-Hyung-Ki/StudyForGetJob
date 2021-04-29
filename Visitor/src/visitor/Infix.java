package visitor;

public class Infix extends Visitor {

	@Override
	public void visit(Operand target) {
		System.out.print(target.getValue());
	}

	@Override
	public void visit(Operator target) {
		target.getLeft().accept(this);
		System.out.println(((Operator) target).getOperator());
		target.getRight().accept(this);
		
	}

}
