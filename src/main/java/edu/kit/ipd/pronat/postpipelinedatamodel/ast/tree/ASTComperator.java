package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTComperator extends ASTNode {

	public enum SIGN {
		GT, GE, LT, LE, EQ, NE
	}

	String left;
	SIGN sign;
	String right;

	public ASTComperator(String left, SIGN sign, String right) {
		this.left = left;
		this.right = right;
		this.sign = sign;
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public SIGN getSign() {
		return sign;
	}

	public void setSign(SIGN sign) {
		this.sign = sign;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

}
