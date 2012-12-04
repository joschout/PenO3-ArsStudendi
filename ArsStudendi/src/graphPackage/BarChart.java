package graphPackage;


import java.util.Map;




public class BarChart extends Graph{

	public java.util.HashMap<String, Long> barChartMap;

	public java.util.HashMap<String, Long> getBarChartMap() {
		return barChartMap;
	}

	public void setBarChartMap(java.util.HashMap<String, Long> barChartMap) {
		this.barChartMap = barChartMap;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BarChart(String graphName, java.util.HashMap<String, Long> barChartMap) {
		super(graphName, GraphType.BARCHART);
		this.barChartMap=barChartMap;
	}
}
	
