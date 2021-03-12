package edu.kit.ipd.pronat.postpipelinedatamodel.ast;

import java.util.Properties;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public abstract class ASTConstants {

	private static Properties props;

	// All need to be outsourced in Properities (2+1 Constant Files)
	// Arcs
	public static final String AST_CHILD_EXTERN = "AST-Connection";
	public static final String AST_POINTER = "AST-Pointer";
	public static final String AST_BASE_POINTER = "AST-Base-Pointer";
	public static final String AST_CHILD = "AST-CInter";

	// Root
	public static final String AST_ROOT = "AST-Root";
	public static final String NEW_METHOD = "newMethod";

	// While
	public static final String POINTER_SUM = "pointerSum";
	public static final String LOOP_NUMBER = "loopNumber";
	public static final String DO_WHILE = "do-while";
	public static final String AST_WHILE_LOOP = "AST-While-Loop";
	public static final String AST_WHILE_IF = "AST-While-If";
	public static final String AST_WHILE_BASE = "AST-While-Base";

	// For
	public static final String AST_FOR_BASE = "AST-For-Base";
	public static final String AST_FOR_LOOP = "AST-For-Loop";
	public static final String ITERATIONS = "iterations";
	public static final String POSITION = "position";

	// Conditions
	public static final String AST_COND_BASE = "AST-Cond-Base";
	public static final String AST_COND_IF = "AST-Cond-If";
	public static final String AST_COND_ELSE = "AST-Cond-Else";
	public static final String AST_COND_THEN = "AST-Cond-Then";
	public static final String CONDITION_NUMBER = "conditionNumber";

	//Action
	public static final String AST_TEXT = "AST-Text";
	public static final String AST_METHOD = "AST-Method";

	//Parallel
	public static final String AST_PARALLEL_ROOT = "AST-Parallel-Root";
	public static final String AST_PARALLEL_BASE = "AST-Parallel-Base";

	public static final String AST_ERROR = "AST-Error";
	public static final String AST_ERROR_POINTER = "AST-Error-Pointer";

	public class Errors {
		public static final String MISSING_STRUCTURE = "MissingStructure";
		public static final String STRANGE_PARAMETER = "StrangeParameter";
		public static final String EMPTY_SEQUENCE = "EmptySequence";
		public static final String METHOD_WARN_SCORE = "MethodWarningScore";
		public static final String METHOD_ERROR_SCORE = "MethodErrorScore";
	}
}
