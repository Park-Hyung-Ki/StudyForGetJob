package visitor;

public class Operand<V extends Number> extends Node {
	private V value;
	
	public Operand(V value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public V getValue() {
		return value;
	}
	
}
