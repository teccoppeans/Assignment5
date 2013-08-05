
public class BST<T extends Comparable<T>> implements BSTInterface<T>{

	protected BSTNode<T> root;
	protected boolean found;
	
	public BST() {
		root = null;
	}
	
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		root = recAdd(data, root);
	}
	
	private BSTNode<T> recAdd(T element, BSTNode<T> tree) {
		if (tree == null)
			tree = new BSTNode<T>(element);
		else if (element.compareTo(tree.getData()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		else
			tree.setRight(recAdd(element, tree.getRight()));
		return tree;
	}

	@Override
	public boolean remove(T data) throws EmptyBSTException {
		// TODO Auto-generated method stub
		root = recRemove(data, root);
		return found;
	}
	
	private BSTNode<T> recRemove(T element, BSTNode<T> tree) {
		if (tree == null)
			found = false;
		else if (element.compareTo(tree.getData()) < 0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if (element.compareTo(tree.getData()) > 0)
			tree.setRight(recRemove(element, tree.getRight()));
		else {
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}
	
	private BSTNode<T> removeNode (BSTNode<T> tree) {
		T data;
		if (tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else {
			data = getPredecessor(tree.getLeft());
			tree.setData(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}
	
	private T getPredecessor (BSTNode<T> tree) {
		while (tree.getRight() != null)
			tree = tree.getRight();
		return tree.getData();
	}

	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		return recContains(data, root);
	}

	private boolean recContains(T element, BSTNode<T> tree) {
		if (tree == null)
			return false;
		else if (element.compareTo(tree.getData()) < 0)
			return recContains(element, tree.getLeft());
		else if (element.compareTo(tree.getData()) > 0)
			return recContains(element, tree.getRight());
		else
			return true;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return recSize(root);
	}
	
	private int recSize(BSTNode<T> tree) {
		if (tree == null)
			return 0;
		else
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}
	
	@Override
	public T get(T data) {
		// TODO Auto-generated method stub
		return recGet(data, root);
	}
	
	private T recGet(T element, BSTNode<T> tree) {
		if (tree == null)
			return null;
		else if (element.compareTo(tree.getData()) < 0)
			return recGet(element, tree.getLeft());
		else if (element.compareTo(tree.getData()) > 0)
			return recGet(element, tree.getRight());
		else
			return tree.getData();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}
	
	@Override
	public String inOrder() {
		// TODO Auto-generated method stub
		return inOrder(root);
	}
	
	public String inOrder(BSTNode<T> tree) {
		// TODO Auto-generated method stub
		String s = "";
		if (tree != null) {
			s += inOrder(tree.getLeft());
			s += tree.getData();
			s += inOrder(tree.getRight());
		}
		return s;
	}
	
	@Override
	public String preOrder() {
		// TODO Auto-generated method stub
		return preOrder(root);
	}
	
	
	public String preOrder(BSTNode<T> tree) {
		// TODO Auto-generated method stub
		String s = "";
		if (tree != null) {
			s += tree.getData();
			s += preOrder(tree.getLeft());
			s += preOrder(tree.getRight());
		}
		return s;
	}
	
	@Override
	public String postOrder() {
		// TODO Auto-generated method stub
		return postOrder(root);
	}
	
	public String postOrder(BSTNode<T> tree) {
		// TODO Auto-generated method stub
		String s = "";
		if (tree != null) {
			s += postOrder(tree.getLeft());
			s += postOrder(tree.getRight());
			s += tree.getData();
		}
		return s;
	}
	
	public String toString() {
		return inOrder();
	}

}
