package edu.kit.ipd.pronat.postpipelinedatamodel.ast;

import edu.kit.ipd.parse.luna.graph.IGraph;
import edu.kit.ipd.parse.luna.graph.INode;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public interface IASTPattern {

	public String getBaseType();

	// TODO Graph is bad here, because it shouldn't be used as it doesn't return
	// anything!
	public void init(IGraph graph, INode root, INode symbols);

	public IGraph extractPattern(IGraph graph);

	public boolean checkPattern(IGraph graph);
}
