package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTBlock extends ASTNode {

	List<ASTNode> expressions;

	public ASTBlock() {
		expressions = new ArrayList<>();
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);

	}

	public List<ASTNode> getExpressions() {
		return expressions;
	}

	// @Override
	public void addChild(ASTNode child) {
		expressions.add(child);
		expressions.sort(new Comparator<ASTNode>() {

			@Override
			public int compare(ASTNode o1, ASTNode o2) {
				return Double.compare(o1.getPosition(), o2.getPosition());
			}
		});
	}

}
