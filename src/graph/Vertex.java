package graph;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
	private List<Edge> edges;
	private String name;
	
	public Vertex(String name) {
		this.edges = new ArrayList<Edge>();
		this.name = name;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public String getName() {
		return name;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
		
}
