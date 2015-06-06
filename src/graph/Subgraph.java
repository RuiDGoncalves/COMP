package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subgraph{
	int group;
	private HashMap<String, Vertex> nodes;
	
	public Subgraph(int group) {
		this.group = group;
		this.nodes = new HashMap<>();
	}
	
	public void addVertex(Vertex v) {		
		nodes.put(v.getName(), v);
	}	
		
	public HashMap<String, Vertex> getNodes() {
		return nodes;
	}	
}
