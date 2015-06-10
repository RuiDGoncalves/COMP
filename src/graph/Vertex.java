package graph;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
	private List<Edge> edges;
	private String name;
	//dijkstra
	private int pathValue;
	private Edge pathParent;	
	public Vertex() {}
	
	public Vertex(String name) {
		this.edges = new ArrayList<Edge>();
		this.name = name;
		pathValue = Integer.MAX_VALUE;
		pathParent = new Edge();
	}

	public int getEdgesSize() {
		return edges.size();
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public List<Edge> getEdges() {
		return edges;
	}
		
}
