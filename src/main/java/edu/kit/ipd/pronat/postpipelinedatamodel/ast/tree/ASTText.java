package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTText extends ASTNode {

	private String text;
	private boolean comment = true;

	public ASTText(String text) {
		this.text = text;
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public String getText() {
		return text;
	}

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

}
