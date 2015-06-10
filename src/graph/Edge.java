package graph;

import java.util.List;

public class Edge {
	
	//gerais
	private Vertex source;
	private Vertex target;
	private int value;
	//dijkstra
	private boolean visited;
	
	
	public Edge(Vertex source, Vertex target, int value) {
		this.source = source;
		this.target = target;
		this.value = value;
		visited = false;
	}
	
	public Edge() {}

	public Vertex getSource() {
		return source;
	}

	public Vertex getTarget() {
		return target;
	}

	public int getValue() {
		return value;
	}

}
