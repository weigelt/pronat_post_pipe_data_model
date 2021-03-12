package edu.kit.ipd.pronat.postpipelinedatamodel.code;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class Parameter {
	private String name;
	private String type;

	public Parameter(String name) {
		this.name = name;
	}

	public Parameter(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
