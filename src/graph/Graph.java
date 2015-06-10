package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph {
	
	private Map<Integer, Subgraph> subgraphs;	
	private List<Edge> links;
	
	public Graph() {
		this.subgraphs = new HashMap<>();
		this.links = new ArrayList<>();
	}

	public Map<Integer, Subgraph> getSubgraphs() {
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
	
	public List<Vertex> getNodes(){
		
		List<Vertex> nodes = new ArrayList<Vertex>();
			
		for(int i=0; i<subgraphs.size(); i++){
			nodes.addAll(  subgraphs.get(i).getNodesList() );
		}
		
		return nodes;
	}
	
	public List<Edge> getLinks() {
		return links;
	}
	
	public Vertex verify(int group, Vertex vertice){
		
		Subgraph subgrafo = subgraphs.get(group);
		if( subgrafo == null )
			return vertice;
		
		Vertex node = subgrafo.getNode(vertice.getName());
		if( node == null)
			return vertice;

		return node;
	}
	
	public Vertex getNoEstrela(){
				
		List<Vertex> nodes = this.getNodes();
		Vertex node = nodes.get(0);
		int size = node.getEdgesSize();
				
		Iterator it = subgraphs.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Subgraph subgrafo = ((Subgraph) pair.getValue());
			
			
			Iterator it2 = subgrafo.getNodes().entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry pair2 = (Map.Entry) it2.next();
				Vertex nodeTemp = ((Vertex) pair2.getValue());
				
				if(size < nodeTemp.getEdgesSize()){

					size = nodeTemp.getEdgesSize();
					node = nodeTemp;
				}
				
			}
			
		}
				
		return node;
	}
	
	@Override
	public String toString(){
		
		StringBuilder texto = new StringBuilder();
		
		texto.append("Numero arestas: " + links.size() + " ");
		Iterator it = subgraphs.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String temp = ( (Subgraph) pair.getValue() ).toString(); 

			texto.append("Subgrafo: " + temp + " ");

		}
		
		
		return texto.toString();
	}
}
























