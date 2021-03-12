package edu.kit.ipd.pronat.postpipelinedatamodel.ast.tree;

import edu.kit.ipd.pronat.postpipelinedatamodel.ast.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public class ASTParallel extends ASTNode {

	List<ASTBlock> sections = new ArrayList<>();

	@Override
	public String visit(IVisitor visitor) {
		return visitor.toCode(this);
	}

	public List<ASTBlock> getSections() {
		return sections;
	}

	public void setSections(List<ASTBlock> sections) {
		this.sections = sections;
	}

	public void addSection(ASTBlock section) {
		sections.add(section);
	}

}
