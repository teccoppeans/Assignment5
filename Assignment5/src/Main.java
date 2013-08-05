import java.io.*;
import java.util.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ObjectWriter<Dictionary> writer = new ObjectWriter<Dictionary>();
		String dictionaryName = "testDictionary";
		Dictionary dic;
		
//		try {
//			try {
//				dic = writer.readObjFile(dictionaryName);
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				dic = new Dictionary(dictionaryName);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			dic = new Dictionary(dictionaryName);
//		}
		
		//writer = new ObjectWriter<Dictionary>(dic, dic.getName());
		
		dic = new Dictionary(dictionaryName);
		Scanner reader;
		
		System.out.println("Dictionary loaded.");
		while (true) {
			reader = new Scanner(System.in);
			System.out.println("Please enter a command. (search, remove, exit) ");
			String input = "";
			input = reader.nextLine();
			if ("exit".equalsIgnoreCase(input.trim())) {
				//writer.writeObjFile();
				break;
			}
			else {
				if ("search".equalsIgnoreCase(input.trim())) {
					System.out.println("Enter a word to find the definition of or add to dictionary: ");
					String word = reader.nextLine();
					dic.search(word);
				}
				else if ("remove".equalsIgnoreCase(input.trim())) {
					System.out.println("Enter a word to remove from the dictionary: ");
					String word = reader.nextLine();
					try {
						dic.remove(word);
					} catch (EmptyBSTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					System.out.println("Command not recognized.");
			}
		}
		System.out.println("Finished.");
		reader.close();
	}

}
