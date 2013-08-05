
import java.io.*;

public class ObjectWriter<T> {
	
	private T obj;
	private String fileName;
	
	public ObjectWriter() {
		
	}

	public ObjectWriter(T obj, String fileName) {
		this.obj = obj;
		this.fileName = fileName;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void writeObjFile() throws FileNotFoundException, IOException {
		
		ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream(this.fileName));
		
		output.writeObject(this.obj);
		System.out.println("Save file to " + fileName);
		output.close();
	
	}	
	
	public T readObjFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream input = new ObjectInputStream(
				new FileInputStream(fileName));
		
		this.obj = (T) input.readObject();
		System.out.println("Complete reading " + fileName);
		input.close();
		
		return this.obj;
	}
	
	
}
