package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

// TODO: Rewrite to initiate object?

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTDeclaration extends ASTNode {

	String type;
	String name;
	String parameters; // Why List? => Constructor

	public ASTDeclaration(String type, String name, String para) {
		this.type = type;
		this.name = name;
		parameters = para;
	}

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

}
