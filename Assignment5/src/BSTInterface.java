
public interface BSTInterface<T extends Comparable<T>> {
	public void add(T data);
	public boolean remove(T data) throws EmptyBSTException;
	public boolean contains(T data);
	public int size();
	public T get(T data);
	public boolean isEmpty();
	public String inOrder();
	public String preOrder();
	public String postOrder();
}
