package util.collections.list;

class List<T> {

	private Node<T> first;
	private Node<T> last;

	public List() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public void insertFirst(T element) {
		this.first = new Node<T>(element, this.first);
		if (this.last == null) {
			this.last = this.first;
		}
	}

	public void insertLast(T element) {
		this.last = new Node<T>(this.last, element);
		if (this.first == null) {
			this.first = this.last;
		}
	}

	public T removeFirst() {
		T element = this.first.get();
		this.first = this.first.getNext();
		if (this.first == null) {
			this.last = null;
		} else {
			this.first.setPrevious(null);
		}
		return element;
	}

	public T removeLast() {
		T element = this.last.get();
		this.last = this.last.getPrevious();
		if (this.last == null) {
			this.first = null;
		} else {
			this.last.setNext(null);
		}
		return element;
	}

	public boolean includes(T element) {
		if (this.isEmpty())
			return false;
		Node<T> current = this.first;
		while (current.getNext() != null &&
				!current.get().equals(element)) {
			current = current.getNext();
		}
		return current.get().equals(element);
	}

	public Iterator<T> iterator() {
		return new Iterator<T>(this.first);
	}

}
