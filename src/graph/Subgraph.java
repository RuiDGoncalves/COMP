package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Subgraph{
	int group;
	private Map<String, Vertex> nodes;

	public Subgraph(int group) {
		this.group = group;
		this.nodes = new HashMap<>();
	}

	public void addVertex(Vertex v) {
		nodes.put(v.getName(), v);
	}

	public Vertex getNode(String name) {		
		return nodes.get(name);
	}

	public Map<String, Vertex> getNodes() {
		return nodes;
	}
	
	public List<Vertex> getNodesList() {
		List<Vertex> nodes = new ArrayList<Vertex>();
		
		Iterator it = ((Map<String, Vertex>) this.nodes).entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			nodes.add( (Vertex) pair.getValue() );
		}

		return nodes;
	}

	@Override
	public String toString(){

		StringBuilder texto = new StringBuilder();

		Iterator it = nodes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Vertex tempo = (Vertex) pair.getValue();
			
			texto.append(" " + tempo + " ");
		}

		return  texto.toString();
	}
}

















