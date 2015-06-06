public class Links {
	
	private int source;
	private int target;
	private int value;

	public Links(int source, int target, int value){
		this.source = source;
		this.target = target;
		this.value = value;
	}
			
	public Links() {
	}

	public int getSource(){
		return source;
	}
	
	public int getTarget(){
		return target;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setSource(int source){
		this.source = source;
	}
	
	public void setTarget(int target){
		this.target = target;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
}
