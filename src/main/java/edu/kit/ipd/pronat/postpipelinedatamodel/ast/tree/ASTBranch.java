package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTBranch extends ASTNode {

	private ASTBlock conditions;
	private ASTBlock thenBlock;
	private ASTBlock elseBlock; // No Else if

	public ASTBranch() {
		conditions = new ASTBlock();
		thenBlock = new ASTBlock();
		elseBlock = new ASTBlock();
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public ASTBlock getConditions() {
		return conditions;
	}

	public void addCondition(ASTExpression condition) {
		if (condition.getChild() instanceof ASTMethodCall) {
			condition.addChild(new ASTConditionCall((ASTMethodCall) condition.getChild()));
		}
		conditions.addChild(condition);
	}

	public ASTBlock getThenBlock() {
		return thenBlock;
	}

	public void setThenBlock(ASTBlock thenBlock) {
		this.thenBlock = thenBlock;
	}

	public ASTBlock getElseBlock() {
		return elseBlock;
	}

	public void setElseBlock(ASTBlock elseBlock) {
		this.elseBlock = elseBlock;
	}

	@Override
	public String toString() {
		return "Condition: " + conditions + thenBlock + elseBlock;
	}

}
