package edu.kit.ipd.pronat.postpipelinedatamodel.ast;

import java.util.Map;

import edu.kit.ipd.parse.luna.graph.IGraph;
import edu.kit.ipd.parse.luna.graph.INode;

/**
 * @author Sebastian Weigelt
 * @author Viktor Kiesel
 */
public interface IASTParentConfidenceCalculator {

	public void init(IGraph graph);

	/**
	 * Finds possible Parents and calculates a confidence matrix for each parent
	 *
	 * @param n
	 *            the specific node, which needs parents
	 * @return a confidence matrix of all possible parents
	 */
	public Map<INode, Double> findPossibleParentAndCalculateConfidence(INode n);

	/**
	 * ASTSynth chooses PCCalc based on the id declared in config file
	 * 
	 * @return the id
	 */
	public String getID();

}
