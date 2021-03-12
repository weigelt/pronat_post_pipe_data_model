package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public abstract class ASTNode implements IVisitable, Comparable<ASTNode> {

	ASTNode parent;
	double position;

	public void setParent(ASTNode parent) {
		this.parent = parent;
	}

	public ASTNode getParent() {
		return parent;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getPosition() {
		return position;
	}

	@Override
	public int compareTo(ASTNode o) {
		return Double.compare(position, o.position);
	}

	// public abstract void addChild(ASTNode child);
}
