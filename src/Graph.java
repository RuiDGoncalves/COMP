import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private HashMap<String, Integer> nodes;	
	private ArrayList<Links> links;
	
	public Graph() {
		this.nodes = new HashMap<>();
		this.links = new ArrayList<>();
	}

	public HashMap <String, Integer> getNodes() {
		return nodes;
	}
	
	public void addNode(Nodes node) {		
		nodes.put(node.getName(), node.getGroup());
		}
	
	public void addLink(Links link) {
		links.add(link);
	}
	
	public ArrayList<Links> getLinks() {
		return links;
	}
}
