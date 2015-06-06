package graph;

import java.util.List;

public class Edge {
	
	private Vertex source;
	private Vertex target;
	private int value;
	
	public Edge(Vertex source, Vertex target, int value) {
		this.source = source;
		this.target = target;
		this.value = value;
	}

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
