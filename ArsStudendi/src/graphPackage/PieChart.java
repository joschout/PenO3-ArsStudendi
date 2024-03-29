package graphPackage;

import java.util.Map;




public class PieChart extends Graph{

	private java.util.HashMap<String, Long> pieChartMap;
	

	public java.util.HashMap<String, Long> getPieChartMap() {
		return pieChartMap;
	}

	public void setPieChartMap(java.util.HashMap<String, Long> pieChartMap) {
		this.pieChartMap = pieChartMap;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PieChart(String graphName, java.util.HashMap<String, Long> pieChartMap) {
		super(graphName, GraphType.PIECHART);
		this.pieChartMap=pieChartMap;
	}
	

}
