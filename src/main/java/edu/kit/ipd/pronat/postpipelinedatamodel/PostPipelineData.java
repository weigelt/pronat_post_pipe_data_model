package edu.kit.ipd.pronat.postpipelinedatamodel;

import edu.kit.ipd.parse.luna.data.AbstractPostPipelineData;
import edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree.ASTRoot;
import edu.kit.ipd.pronat.postpipelinedatamodel.code.Method;

import java.nio.file.Path;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class PostPipelineData extends AbstractPostPipelineData {
	private ASTRoot ast;
	private String code;

	private Method method;
	private Path filepath;

	public PostPipelineData() {
		filepath = null;
		method = null;
		ast = null;
		code = null;
	}

	/**
	 * Checks if the pipelinedata is supposed to be a new method
	 *
	 * @return true if is has Method
	 */
	public boolean isMethod() {
		return method != null;
	}

	public Method getMethod() {
		return method;
	}

	public ASTRoot getAstRoot() {
		return ast;
	}

	public void setAstRoot(ASTRoot ast) {
		this.ast = ast;
	}

	public Path getFilepath() {
		return filepath;
	}

	public void setFilepath(Path filepath) {
		this.filepath = filepath;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}