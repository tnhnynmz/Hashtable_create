public class HashTable<K, V>{
	private final static int TABLE_SIZE = 997;
	private int maxSize, currentSize;
	HashEntry<K, V>[] table;
	public float loadFactor;
	public int collisionCount, hashSwitch;

	
	@SuppressWarnings("unchecked")
	public HashTable(float loadFactor, int hashSwitch) {
		table = (HashEntry<K, V>[])new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
		this.loadFactor = loadFactor;
		this.hashSwitch = hashSwitch;
		maxSize = (int) (table.length * loadFactor);
		currentSize = 0;
		collisionCount = 0;
	}
	public int hashFunctionYHF(K key) {
		int hash = 1;
		try {
			String keyString = key.toString();
			for (int i = 0; i < keyString.length(); i++) {
				hash *= keyString.charAt(i);
				hash = hash % 997;
			}
		} catch (Exception e) {
			System.out.println("Key is not a string or it can not be casted to string..");
		}
		return hash;
	}
	public int getKeyValueYHF(K key) {
		int hash = 1;
		try {
			String keyString = key.toString();
			for (int i = 0; i < keyString.length(); i++) {
				hash *= keyString.charAt(i);
			}
		} catch (Exception e) {
			System.out.println("Key is not a string or it can not be casted to string..");
		}
		return hash;
	}

	public int hashFunctionPAF(K key) {
		int hash = 0;
		try {
			String keyString = key.toString();
			for (int i = 0; i < keyString.length(); i++) {
				hash += (keyString.charAt(i) * Math.pow(31, keyString.length() - (i + 1))) % 997;
			}
			hash = hash % 997;
		} catch (Exception e) {
			System.out.println("Key is not a string or it can not be casted to string..");
		}
		return hash;
	}
	public int getKeyValuePAF(K key) {
		int hash = 0;
		try {
			String keyString = key.toString();
			for (int i = 0; i < keyString.length(); i++) {
				hash += (keyString.charAt(i) * Math.pow(31, keyString.length() - (i + 1)));
			}
		} catch (Exception e) {
			System.out.println("Key is not a string or it can not be casted to string..");
		}
		return hash;
	}

	public int getIndex(K key) {
		int value = -1;
		int hash = 0;
		switch (hashSwitch) {
		case 1: {
			hash = hashFunctionYHF(key);
			break;
		}
		case 2:
			hash = hashFunctionPAF(key);
			break;
		}
		// Linear Search
		boolean foundFlag = true;
		do {
			if (table[hash] == null) {
				return value;
			} else if (table[hash].getKey().equals(key)) {
				value = hash;
				return value;
			} else {
				foundFlag = false;
				hash++;
			}
		} while (!foundFlag);
		return value;

	}

	public HashEntry<K, V> getHashEntry(K key) {
		HashEntry<K,V> value = null;
		int hash = 0;
		switch (hashSwitch) {//Hash Switch decides which function will be used.
		case 1: {
			hash = hashFunctionYHF(key);
			break;
		}
		case 2:
			hash = hashFunctionPAF(key);
			break;
		}// Linear Search
		boolean foundFlag = true;
		do {
			if (table[hash] == null) {
				return value;
			} else if (table[hash].getKey().equals(key)) {
				return table[hash];
			} else {
				foundFlag = false;
				hash++;
			}
		} while (!foundFlag);
		return value;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void put(K key, V value) {
		if (currentSize >= maxSize)
			resize();
		int hash = 0;
		switch (hashSwitch) {
		case 1: {
			hash = hashFunctionYHF(key);
			break;
		}
		case 2:
			hash = hashFunctionPAF(key);
			break;
		}
		if (table[hash] == null) { // Check if the index is empty
			table[hash] = new HashEntry<K, V>(key, value, 0);
			currentSize++;
		} 
		else {
			HashEntry<K,V> entryToReInsert = null;
			int currentIndex = hash;
			boolean isInserted = false;
			while (!isInserted) {// Indexleri dolaþ öncelikliyse yerleþtir, deðiþtirdiðin deðeri tut
				if (table[currentIndex] == null) {
					table[currentIndex] = new HashEntry<K, V>(key, value, (currentIndex - hash));
					isInserted = true;
					currentSize++;
				} else if (table[currentIndex].getKey().equals(key)) {
					table[currentIndex] = (HashEntry<K, V>) new HashEntry(table[currentIndex].getKey(),
							(int)table[currentIndex].getValue() + 1, currentIndex- hash);
					isInserted = true;
				} else if (table[currentIndex].getdIB() < (currentIndex - hash)) {
					collisionCount++;
					entryToReInsert = table[currentIndex];
					table[currentIndex] = new HashEntry<K,V>(key, value, (currentIndex - hash));
					isInserted = true;
				} else
					currentIndex++;
			} // Deðiþtirdiðin deðere tekrar yer bul
			if (entryToReInsert != null) {
				put((K)entryToReInsert.getKey(), (V)entryToReInsert.getValue());
			}
		}

	}

	public void getCurrentsize() {
		System.out.println(currentSize);
	}

	@SuppressWarnings("unchecked")
	public void resize() {
		int newSize = 2 * table.length;
		maxSize = (int) (newSize * loadFactor);
		HashEntry<K, V>[] oldTable = table;
		table = (HashEntry<K,V>[]) new HashEntry[newSize];
		for (int i = 0; i < oldTable.length; i++)
			if (oldTable[i] != null)
				table[i] = oldTable[i];
	}
	public int getColCount() {
		int colCount = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null && table[i].getdIB() != 0)
				colCount++;
		}
		return colCount;
	}

}
