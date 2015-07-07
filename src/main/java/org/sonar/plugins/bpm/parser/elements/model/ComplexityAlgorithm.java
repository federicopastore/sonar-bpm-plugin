/**
 * 
 */
package org.sonar.plugins.bpm.parser.elements.model;

/**
 * @author federicopastore
 *
 */
public interface ComplexityAlgorithm {

	public Double calculateCoefficientNetworkComplexity();
	public Double calculateCyclomaticNumber();
	public Double calculateComplexityIndex();
	public Double calculateRestrictivenessEstimator();
	public Double calculateNumberTreesInGraph();
}
