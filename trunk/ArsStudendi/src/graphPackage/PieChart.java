package graphPackage;

import java.util.Map;




public class PieChart extends Graph{

	public java.util.HashMap<String, Long> pieChartMap;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PieChart(String graphName, java.util.HashMap<String, Long> pieChartMap) {
		super(graphName, GraphType.PIECHART);
		this.pieChartMap=pieChartMap;
	}
	

}
