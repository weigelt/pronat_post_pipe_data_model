package edu.kit.ipd.pronat.postpipelinedatamodel.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 * 
 *         Describes a method.
 */
public class Method {

	private String returnType;
	private String name;
	private double score;
	private List<Parameter> parameters;

	/**
	 * void name()
	 */
	public Method(String name) {
		this.name = name;
		returnType = "void";
		parameters = new ArrayList<>();
	}

	/**
	 * type name()
	 */
	public Method(String name, String type) {
		this.name = name;
		returnType = type;
		parameters = new ArrayList<>();
	}

	/**
	 * type name(parameters)
	 */
	public Method(String name, String type, List<Parameter> parameter) {
		this.name = name;
		returnType = type;
		parameters = parameter;
	}

	public Method(String name, String type, List<Parameter> parameter, double score) {
		this.name = name;
		returnType = type;
		parameters = parameter;
		this.score = score;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		String r = returnType + " " + name + "(";
		for (Parameter p : parameters) {
			r += p + ", ";
		}
		if (!parameters.isEmpty()) {
			r = r.substring(0, r.length() - 2);
		}
		return r + ")";
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
