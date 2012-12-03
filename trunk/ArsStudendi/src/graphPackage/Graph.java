package graphPackage;

import java.io.Serializable;

import javax.sql.rowset.serial.SerialArray;


public class Graph implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public Long graphID;
	public String graphName;
	public GraphType graphType;
	
	public Graph( String graphName, GraphType graphType) {
		//this.graphID=graphID;
		this.graphName = graphName;
		this.graphType = graphType;
	}


	

	
}
