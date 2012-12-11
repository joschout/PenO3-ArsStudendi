package graphPackage;

import java.util.ArrayList;
import java.util.List;

public class LineChart extends Graph {

	
	private List<LineGraphDataSeries> data;
	private List<String> XAxis;

	public LineChart(String graphName, List<LineGraphDataSeries> data, List<String> XAxis) {
		super(graphName, GraphType.PIECHART);	
		this.data=data;
		this.XAxis=XAxis;
	}

	public List<String> getXAxis() {
		return XAxis;
	}

	public void setXAxis(List<String> xAxis) {
		XAxis = xAxis;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<LineGraphDataSeries> getData() {
		return data;
	}

	public void setData(List<LineGraphDataSeries> data) {
		this.data = data;
	}
	public  List<String> getNamesOfAllDataSeries(){
		List<String> dataNames = new ArrayList<String>();
		for(LineGraphDataSeries dataSeries: getData()){
			dataNames.add(dataSeries.getName());
		}
		return dataNames;
	}

	
}
