import java.io.Serializable;



public class Entry implements Comparable<Entry>, Serializable {
		
	private String word;
	private String definition;
	
	public Entry (String word, String definition) {
		this.word = word;
		this.definition = definition;
	}
	
	@Override
	public int compareTo(Entry o) {
		// TODO Auto-generated method stub
		return word.compareTo(o.getWord());
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String toString() {
		return "Word :" + word + "\n\tDefinition: " + definition + "\n";
	}
	
}
