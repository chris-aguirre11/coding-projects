package hashtable;

import org.junit.Assert;
import org.junit.Test;

public class ChainedHashTableTest {

	@Test
	public void test() {
		ChainedHashTable hashTable = new ChainedHashTable();
		
		// Included in order to see what buckets each String hashes to
//		System.out.println("Chris\t" + Math.abs("Chris".hashCode() % 16));
//		System.out.println("John\t" + Math.abs("John".hashCode() % 16));
//		System.out.println("Thomas\t" + Math.abs("Thomas".hashCode() % 16));
//		System.out.println("Benjamin\t" + Math.abs("Benjamin".hashCode() % 16));
//		System.out.println("Adrian\t" + Math.abs("Adrian".hashCode() % 16));
//		System.out.println("Jose\t" + Math.abs("Jose".hashCode() % 16));
//		System.out.println("Clarence\t" + Math.abs("Clarence".hashCode() % 16));
//		System.out.println("Tina\t" + Math.abs("Tina".hashCode() % 16));
//		System.out.println("Maria\t" + Math.abs("Maria".hashCode() % 16));
//		System.out.println("Othelo\t" + Math.abs("Othelo".hashCode() % 16));
//		System.out.println("Shakespeare\t" + Math.abs("Shakespeare".hashCode() % 16));
		
		hashTable.put("Chris", "coder");
		hashTable.put("John", "carpenter");
		hashTable.put("Thomas", "cleaner");
		hashTable.put("Benjamin", "engineer");
		hashTable.put("Adrian", "doctor");
		hashTable.put("Jose", "architect");
		hashTable.put("Clarence", "hotel clerk");
		hashTable.put("Tina", "salesperson");
		hashTable.put("Maria", "hairdresser");
		hashTable.put("Othelo", "actor");
		hashTable.put("Shakespeare", "director");
		
		float loadFactor = hashTable.currentLoadFactor();
		Assert.assertTrue("Unexpected loadFactor Value. Expected 0.6875 but was " + loadFactor, 0.6875 == loadFactor);
		
		String retrieved1 = (String) hashTable.get("Clarence");
		String retrieved2 = (String) hashTable.get("Tina");
		String retrieved3 = (String) hashTable.get("Chris");
		String retrieved4 = (String) hashTable.get("Benjamin");
		
		String removed1 = (String) hashTable.remove("Thomas");
		String removed2 = (String) hashTable.remove("Tina");
		String removed3 = (String) hashTable.remove("Othelo");
		String removed4 = (String) hashTable.remove("Chris");
		Assert.assertTrue("Unexpected loadFactor Value. Expected 0.4375 but was " + loadFactor, 0.4375 == loadFactor);
	}

}
