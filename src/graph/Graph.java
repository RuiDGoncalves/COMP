package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private HashMap<Integer, Subgraph> subgraphs;	
	private List<Edge> links;
	
	public Graph() {
		this.subgraphs = new HashMap<>();
		this.links = new ArrayList<>();
	}

	public HashMap<Integer, Subgraph> getSubgraphs() {
		return subgraphs;
	}
	
	public void add(int group, Vertex v) {		
		Subgraph subgrafo = subgraphs.get(group);
		
		if(subgrafo == null)
			this.subgraphs.put(group, new Subgraph(group));
			
		subgraphs.get(group).addVertex(v);
	}
	
	public void add(Edge e) {
		links.add(e);
	}
	
	public List<Edge> getLinks() {
		return links;
	}
	
}
