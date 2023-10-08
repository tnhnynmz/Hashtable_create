

public class Main {

	public static void main(String[] args) {
		//Create basics
		Menu createMenu = new Menu();
		float loadFactor = createMenu.loadFactor();
		int chooseFunction = createMenu.function();
		HashTable<String, Integer> table = new HashTable<String, Integer>(loadFactor, chooseFunction);
		String[] wordsToSearch = null;
		
		//File operations
		String path_search = "search.txt";
		String path_story = "story.txt";
		FileRead reader = null;
		try {
			reader = new FileRead(path_story);
			reader.read_words_put(path_story, table);
		} catch (Exception e) {
			System.out.println("Story text not found!");
		}
		try {
			reader = new FileRead(path_search);
			wordsToSearch = reader.read_words(path_search);
		} catch (Exception e) {
			System.out.println("Search text not found!");
		}
		/*long time, totalTime = 0;
		for (int i = 0; i < wordsToSearch.length; i++) {
			time = System.nanoTime();
			table.getHashEntry(wordsToSearch[i]);
			time = System.nanoTime() - time;
			totalTime += time;
			System.out.println(time);
		}
		System.out.println(".."+totalTime/100);*/
		//Print operations
		if (chooseFunction == 1) {
			for (int i = 0; i < wordsToSearch.length; i++) {
				if (table.getHashEntry(wordsToSearch[i]) == null)
					System.out.println(wordsToSearch[i] + " not found..." + "\n");
				else {
					System.out.println("Search : "+wordsToSearch[i]+"\nKey : "+table.getKeyValueYHF(wordsToSearch[i])
					+ "\nCalculated Index(Hash) : " + table.hashFunctionYHF(wordsToSearch[i])
					+ "\nCount : "+table.getHashEntry(wordsToSearch[i]).getValue()+"\nTable Index : "+table.getIndex(wordsToSearch[i])
					+"\n");
				}
			}
		}
		else {
			for (int i = 0; i < wordsToSearch.length; i++) {
				if (table.getHashEntry(wordsToSearch[i]) == null)
					System.out.println(wordsToSearch[i] + " not found..." + "\n");
				else {
					System.out.println("Search : "+wordsToSearch[i]+"\nKey : "+table.getKeyValuePAF(wordsToSearch[i])
					+ "\nCalculated Index(Hash) : " + table.hashFunctionPAF(wordsToSearch[i]) 
					+ "\nCount : "+table.getHashEntry(wordsToSearch[i]).getValue()+"\nTable Index : "+table.getIndex(wordsToSearch[i])
					+"\n");
				}
			}
		}
		System.out.println("All occured collisions : "+table.collisionCount + "\nCollisions while putting : "
				+table.getColCount());
	}

}
