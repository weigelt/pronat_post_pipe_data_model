package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;
import edu.kit.ipd.pronat.postpipelinedatamodel.code.Method;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTMethodCall extends ASTNode {

	private Method method;
	private String comment;

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

}
