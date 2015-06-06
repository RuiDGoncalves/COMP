
public class Nodes {

	static int ID = 0;
	
	private int id;
	private String name;
	private int group;
	
	
	public Nodes(int id, int group, String name) {
		this.id = id;
		this.group = group;
		this.name = name;
	}
	
	public Nodes() {
		id = ID;
		ID++;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getGroup(){
		return group;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setGroup(int group){
		this.group = group;
	}

}
