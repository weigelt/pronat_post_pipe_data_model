package edu.kit.ipd.pronat.postpipelinedatamodel.ast;

import edu.kit.ipd.parse.luna.graph.INode;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class Symbol { // Maybe use Inheritance. That way it's more extendable

	private int id;
	private String name;
	private String type; // could be Advanced
	private INode node;
	private Symbol reference;

	public Symbol(String name, String type, INode node) {
		this.name = name;
		this.type = type;
		this.node = node;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public INode getNode() {
		return node;
	}

	public void setReference(Symbol reference) {
		this.reference = reference;
	}

	public Symbol getReference() {
		return reference;
	}

	@Override
	public String toString() {
		String s = type + " " + name;
		if (reference != null) {
			s += " -> (" + reference + ")";
		}
		return s;

	}

}
