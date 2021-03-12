package edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree.*;
import edu.kit.ipd.pronat.postpipelinedatamodel.code.Method;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public interface IVisitor {

	String getID();

	String toNewMethod(ASTRoot astRoot, Method method);

	String toCode(ASTRoot astRoot);

	String toCode(ASTBlock node);

	String toCode(ASTBranch astCondition);

	String toCode(ASTExpression node);

	String toCode(ASTMethodCall astMethod);

	String toCode(ASTFor node);

	String toCode(ASTDeclaration node);

	String toCode(ASTWhile node);

	String toCode(ASTText astText);

	String toCode(ASTComperator node);

	String toCode(ASTParallel node);

	String toCode(ASTConditionCall astConditionCall);

}
