package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

//TODO: Necessary?

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTExpression extends ASTNode {

	ASTNode child = new ASTText("Not overwritten");

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public void addChild(ASTNode node) {
		child = node;
	}

	public ASTNode getChild() {
		return child;
	}

}