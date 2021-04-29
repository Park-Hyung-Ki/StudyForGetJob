package visitor;

public abstract class Visitor {
	public abstract void visit(Operand target);
	
	public abstract void visit(Operator target);
}
