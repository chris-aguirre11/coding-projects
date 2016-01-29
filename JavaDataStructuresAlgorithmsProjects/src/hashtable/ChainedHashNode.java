package hashtable;

public class ChainedHashNode {
	
	public Object key;		 
	public Object value;
	public ChainedHashNode nextNode;
	
	public ChainedHashNode(Object key, Object value, ChainedHashNode nextNode) {
		this.key = key;
		this.value = value;
		this.nextNode = nextNode;
	}

	public void setNextNode(ChainedHashNode newNextNode) {
		this.nextNode = newNextNode;
	}
}
