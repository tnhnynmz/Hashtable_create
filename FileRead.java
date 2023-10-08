import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class FileRead {
	public File file;
	public FileReader fr;
	public BufferedReader br;
	public FileRead(String fileName) throws IOException{
		file = new File(fileName);
		fr = new FileReader(file);
		br = new BufferedReader(fr);
	}
	public void read_words_put(String fileName, HashTable<String, Integer> table) throws IOException{
		String line = " ";
		String[] words = null;
		try {
			//System.out.println(System.nanoTime()); //for indexing time
			while ((line = br.readLine()) != null) {
				if(!line.equals("")) {
					line = line.replace('I','i').toLowerCase();
					words = line.split(" ");
					for (int i = 0; i < words.length; i++) {
						table.put(words[i], 1);
					}
				}
			}
			//System.out.println(System.nanoTime()); //for indexing time
		} catch (Exception e) {
			System.out.println("There is no text.");
		}
		br.close();
	}
	public String[] read_words(String fileName) throws IOException{
		String line, wordsLine = "";
		String[] words = null;
		try {
			while ((line = br.readLine()) != null) {
				if(!line.equals("")) {
					wordsLine += line + " ";
				}
			}
			words = wordsLine.split(" ");
		} catch (Exception e) {
			System.out.println("There is no text.");
		}
		br.close();
		return words;
	}
}
