package edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree.*;
import edu.kit.ipd.pronat.postpipelinedatamodel.code.Method;
import edu.kit.ipd.pronat.postpipelinedatamodel.code.Parameter;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public abstract class CStyleVisitor extends AbstractVisitor {

	@Override
	public String toNewMethod(ASTRoot astRoot, Method method) {

		String code = "";
		code += indent() + generateHead(method) + "{\n";
		code += toCode((ASTBlock) astRoot);
		code += "}\n";
		return code;

	}

	@Override
	public String toCode(ASTBranch astBranch) {
		String code = "";
		//Conditions
		code += indent() + "if (";
		for (ASTNode cond : astBranch.getConditions().getExpressions()) {
			code += cond.visit(this) + " && ";
		}
		if (!astBranch.getConditions().getExpressions().isEmpty()) {
			code = code.substring(0, code.length() - 4);
		}
		code += ")\n";
		//Then-Block
		indentUp();
		code += indent() + "{\n" + astBranch.getThenBlock().visit(this);
		indentDown();
		//Else-Block
		code += indent() + "} else {";
		indentUp();
		code += astBranch.getElseBlock().visit(this) + indent() + "}";
		indentDown();
		return code;
	}

	@Override
	public String toCode(ASTMethodCall astMethod) {
		String s = "";
		if (astMethod.getComment() != null) {
			s += indent() + "// " + astMethod.getComment() + "\n";
		}
		Method method = astMethod.getMethod();
		s += indent() + method.getName() + "(";
		for (Parameter para : method.getParameters()) {
			s += para.getName() + ", ";
		}
		if (!method.getParameters().isEmpty()) {
			s = s.substring(0, s.length() - 2);
		}
		s += ");";
		return s;
	}

	@Override
	public String toCode(ASTConditionCall astMethod) {
		String s = "";
		Method method = astMethod.getMethod();
		s += method.getName() + "(";
		for (Parameter para : method.getParameters()) {
			s += para.getName() + ", ";
		}
		if (!method.getParameters().isEmpty()) {
			s = s.substring(0, s.length() - 2);
		}
		s += ")";
		return s;
	}

	@Override
	public String toCode(ASTFor node) {
		String s = "";
		s += indent() + "for(" + node.getExpression().visit(this) + ";";
		s += node.getCondition().visit(this) + ";" + node.getCounter().visit(this) + ") {\n";
		indentUp();
		s += node.getBlock().visit(this) + indent() + "}";
		indentDown();
		return s;
	}

	@Override
	public String toCode(ASTDeclaration node) {
		String s = node.getType() + " " + node.getName() + "=" + node.getParameters();
		return s;
	}

	@Override
	public String toCode(ASTWhile node) {
		String s = "";
		if (node.isDo_while()) {
			s += "do {\n";
			indentUp();
			s += node.getBlock().visit(this);
			indentDown();
			s += indent() + "} while(";
			for (ASTNode c : node.getConditions().getExpressions()) {
				if (node.isNegated()) {
					s += "!";
				}
				s += c.visit(this) + " && ";
			}
			if (!node.getConditions().getExpressions().isEmpty()) {
				s = s.substring(0, s.length() - 4);
			}
			s += ");";

		} else {
			s += indent() + "while(";
			for (ASTNode c : node.getConditions().getExpressions()) {
				if (node.isNegated()) {
					s += "!";
				}
				s += c.visit(this) + " && ";
			}
			if (!node.getConditions().getExpressions().isEmpty()) {
				s = s.substring(0, s.length() - 4);
			}
			s += ") {\n";
			indentUp();
			s += node.getBlock().visit(this) + indent() + "}";
			indentDown();
		}
		return s;
	}

	@Override
	public String toCode(ASTText astText) {
		String s = indent();
		if (astText.isComment()) {
			s += indent() + "//";
		}
		s += astText.getText();
		return s;
	}

	@Override
	public String toCode(ASTComperator node) {
		String s = node.getLeft() + " ";
		s += toComparatorSign(node.getSign());
		s += " " + node.getRight();
		return s;
	}

	protected String generateHead(Method method) {
		String s = "private " + method.getReturnType() + " ";
		s += indent() + method.getName() + "(";
		for (Parameter para : method.getParameters()) {
			s += para.getName() + ", ";
		}
		if (!method.getParameters().isEmpty()) {
			s = s.substring(0, s.length() - 2);
		}
		s += ")";
		return s;
	}
}
