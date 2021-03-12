package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTFor extends ASTNode {
	private ASTExpression expression;
	private ASTExpression condition;
	private ASTExpression counter;
	private ASTBlock block;
	private int iterations;

	private static int variable = 0;

	public ASTFor() {
		block = new ASTBlock();
		counter = new ASTExpression();
		condition = new ASTExpression();
		expression = new ASTExpression();

		// TODO Auto-generated constructor stub
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);

	}

	public ASTExpression getExpression() {
		return expression;
	}

	public void setExpression(ASTExpression expression) {
		this.expression = expression;
	}

	public ASTExpression getCondition() {
		return condition;
	}

	public void setCondition(ASTExpression condition) {
		this.condition = condition;
	}

	public ASTExpression getCounter() {
		return counter;
	}

	public void setCounter(ASTExpression counter) {
		this.counter = counter;
	}

	public ASTBlock getBlock() {
		return block;
	}

	public void setBlock(ASTBlock block) {
		this.block = block;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIteration(int iterations) {
		this.iterations = iterations;
		String iter = "iter" + variable++;
		expression.addChild(new ASTDeclaration("int", iter, "0"));
		condition.addChild(new ASTComperator(iter, ASTComperator.SIGN.LT, "" + iterations));
		ASTText inc = new ASTText(iter + "++");
		inc.setComment(false);
		counter.addChild(inc);
	}

	public void setIteration(int iterations, String variable, int loopNumber) {
		this.iterations = iterations;
		String iter = variable + loopNumber;
		expression.addChild(new ASTDeclaration("int", iter, "0"));
		condition.addChild(new ASTComperator(iter, ASTComperator.SIGN.LT, "" + iterations));
		ASTText inc = new ASTText(iter + "++");
		inc.setComment(false);
		counter.addChild(inc);

	}

	public String getVariableName() {
		return ((ASTDeclaration) expression.getChild()).getName();
	}
}
