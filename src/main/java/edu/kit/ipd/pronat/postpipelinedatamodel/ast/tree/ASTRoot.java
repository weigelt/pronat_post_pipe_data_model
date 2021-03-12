package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTRoot extends ASTBlock {

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

}
