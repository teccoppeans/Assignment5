import java.io.*;
import java.util.*;


public class Dictionary {
	
	private BST<Entry> dictionary;
	private String name;
	
	
	public Dictionary(String name) {
		this.name = name;
		this.dictionary = new BST<Entry>();
	}
	
	public BST<Entry> getDictionary() {
		return dictionary;
	}
	
	public void setDictionary(BST<Entry> dictionary) {
		this.dictionary = dictionary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void readObject() {
		
	}
	
	public void search(String word) {
		if (dictionary.contains(new Entry(word, "")))
			System.out.println(dictionary.get(new Entry(word, "")));
		else {
			Scanner sc = new Scanner(System.in);
			System.out.println(word + " not found, enter a definition: ");
			String def = sc.nextLine();
			dictionary.add(new Entry(word, def));
			System.out.println(word + " added.");
		}
	}
	
	public void remove(String word) throws EmptyBSTException {
		// TODO Auto-generated method stub
		if (!dictionary.isEmpty() && dictionary.contains(new Entry(word, "")))
			dictionary.remove(new Entry(word, ""));
		else
			System.out.println(word + " not found.");
		
	}
	
	public String toString() {
		return dictionary.toString();
	}
}
