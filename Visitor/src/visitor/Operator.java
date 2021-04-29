package visitor;

import java.util.ArrayList;
import java.util.List;

public class Operator extends Node {
	private Node left, right;
	private char operator;
	
	public Operator(Node left, Node right, char operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
		
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}
	

	public char getOperator() {
		return operator;
	}
	
	
}
