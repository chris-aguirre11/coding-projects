package hashtable;

import java.util.ArrayList;
import java.util.List;

public class ChainedHashTable {

	private ChainedHashNode[] table;
	public int size = 0;
	public int capacity = 16;
	
	// These 2 lists are added to provide statistics on # of items examined during a PUT/GET
	public List<Integer> numItemsCheckedPUT = new ArrayList<Integer>();
	public List<Integer> numItemsCheckedGET = new ArrayList<Integer>();
	
	
	public ChainedHashTable(int capacity) {
		this.capacity = capacity;
		table = new ChainedHashNode[capacity];
	}
	
	public ChainedHashTable() {
		table = new ChainedHashNode[capacity];
	} 
	
	public float currentLoadFactor() {
		return (float)size / (float)capacity;
	}
	
	public void put(Object key, Object value) {
		int arrayIndx = computeArrayInd(key);
		if(table[arrayIndx] == null) {
			size++;
			table[arrayIndx] = new ChainedHashNode(key, value, null);
			numItemsCheckedPUT.add(1);
		}
		else {
			ChainedHashNode current = table[arrayIndx];
			int numCheckedItems = 1;
			
			// Check if key already exists in bucket. If it does, simply update its value
			while(current != null) {
				if(current.key.equals(key)){
					current.value = value;
					numItemsCheckedPUT.add(numCheckedItems);
					return;
				}
				current = current.nextNode;
				numCheckedItems += 1;
			}
			
			//If key does not exist in bucket, add new entry to head of bucket
			ChainedHashNode newEntry = new ChainedHashNode(key, value, table[arrayIndx]);
			table[arrayIndx] = newEntry;
			size++;
			numItemsCheckedPUT.add(numCheckedItems);
		}
	}
	
	public Object get(Object key) {
		int arrayIndx = computeArrayInd(key);
		if(table[arrayIndx] == null) {
			numItemsCheckedGET.add(1);
			return null;
		}
		else {
			ChainedHashNode current = table[arrayIndx];
			int numCheckedItems = 1;
			
			// Check if key already exists in bucket. If it does, simply update its value
			while(current != null) {
				if(current.key.equals(key)){
					numItemsCheckedGET.add(numCheckedItems);
					return current.value;
				}
				current = current.nextNode;
				numCheckedItems += 1;
			}
			numItemsCheckedGET.add(numCheckedItems);
		}
		return null;
	}
	
	public Object remove(Object key) {
		Object objectToRemove = null;
		if(containsKey(key)) {
			int arrayIndx = computeArrayInd(key);
			ChainedHashNode current = table[arrayIndx];
			
			// First check if 1st item in bucket matches key
			if(current.key.equals(key)){
				size--;
				objectToRemove = current.value;
				table[arrayIndx] = current.nextNode;
			}
			// If not iterate through bucket linked list and look for key
			else {
				while(current.nextNode != null) {
					//TODO Need to fix bug: I am not properly handling the last element of LL whose next == nnull
					if(current.nextNode.key.equals(key)){
						size--;
						objectToRemove = current.nextNode.value;
						current.nextNode = current.nextNode.nextNode;
					}
					current = current.nextNode;
				}
			}
		}
		return objectToRemove;
	}
	
	public boolean containsKey(Object key) {
		Object result = get(key);
		return (result == null) ? false : true;
	}
	
	public float getAverageItemsCheckedGET() {
		int sum = 0;
		for(Integer n: numItemsCheckedGET) {
			sum += n;
		}
		return sum / numItemsCheckedGET.size();
	}
	
	public float getAverageItemsCheckedPUT() {
		int sum = 0;
		for(Integer n: numItemsCheckedPUT) {
			sum += n;
		}
		return sum / numItemsCheckedPUT.size();
	}

	private int computeArrayInd(Object key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode % capacity);
	}
}
