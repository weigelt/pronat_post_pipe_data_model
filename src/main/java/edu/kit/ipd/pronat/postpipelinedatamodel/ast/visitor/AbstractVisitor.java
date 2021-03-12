package edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree.*;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public abstract class AbstractVisitor implements IVisitor {

	@Override
	public String toCode(ASTBlock node) {
		String s = "";

		for (ASTNode expression : node.getExpressions()) {
			s += expression.visit(this) + "\n";
		}
		return s;
	}

	@Override
	public String toCode(ASTRoot astRoot) {
		indentUp();
		String code = toCode((ASTBlock) astRoot);
		indentDown();
		return code;
	}

	@Override
	public String toCode(ASTExpression node) {
		if (node == null) {
			return "Error: Node is null";
		}
		return node.getChild().visit(this);
	}

	protected int indentLevel = 0;

	protected void indentUp() {
		indentLevel++;
	}

	protected void indentDown() {
		indentLevel--;
	}

	protected String indent() {
		String s = "";
		for (int i = 0; i < indentLevel; i++) {
			s += "\t";
		}
		return s;
	}

	protected String toComparatorSign(ASTComperator.SIGN sign) {
		String s = "";
		switch (sign) {
		case EQ:
			s += "==";
			break;
		case GE:
			s += ">=";
			break;
		case GT:
			s += ">";
			break;
		case LE:
			s += "<=";
			break;
		case LT:
			s += "<";
			break;
		case NE:
			s += "!=";
			break;
		default:
			break;
		}
		return s;
	}

}
