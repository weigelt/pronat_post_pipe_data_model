package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTWhile extends ASTNode {

	private ASTBlock conditions;
	private ASTBlock block;
	private boolean do_while = false;
	private boolean negated = false;

	public ASTWhile() {
		conditions = new ASTBlock();
		block = new ASTBlock();
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

	public ASTBlock getBlock() {
		return block;
	}

	public void setBlock(ASTBlock block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "ASTWhile:" + conditions + " " + block;
	}

	public boolean isDo_while() {
		return do_while;
	}

	public void setDo_while(boolean do_while) {
		this.do_while = do_while;
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}
}
