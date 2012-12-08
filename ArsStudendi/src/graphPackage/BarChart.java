package graphPackage;


import java.util.Map;




public class BarChart extends Graph{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.util.HashMap<String, Long> barChartMap;

	public BarChart(String graphName, java.util.HashMap<String, Long> barChartMap) {
		super(graphName, GraphType.BARCHART);
		this.barChartMap=barChartMap;
	}

	public java.util.HashMap<String, Long> getBarChartMap() {
		return barChartMap;
	}

	public void setBarChartMap(java.util.HashMap<String, Long> barChartMap) {
		this.barChartMap = barChartMap;
	}
}
	
