package util.collections.list;

class Node<T>  {

	private Node<T> previous;
	private T element;
	private Node<T> next;

	public Node(Node<T> previous, T element, Node<T> next) {
		this.setPrevious(previous);
		this.element = element;
		this.setNext(next);
	}

	public Node(T element, Node<T> next) {
		this(null, element, next);
	}
	public Node(Node<T> previous, T element) {
		this(previous, element, null);
	}

	public Node<T> getPrevious() {
		return this.previous;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
		if (this.previous != null) {
			this.previous.next = this;
		}
	}

	public void setNext(Node<T> next) {
		this.next = next;
		if (this.next != null) {
			this.next.previous = this;
		}
	}

	public boolean isLast(){
		return this.next == null;
	}

	public T get() {
		return this.element;
	}

}
