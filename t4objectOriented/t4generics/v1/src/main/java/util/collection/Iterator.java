package util.collection;

public class Iterator<U> {

  private Node<U> current;

  public Iterator(Node<U> head) {
      this.current = head;
  }

  public boolean hasNext() {
      return this.current != null;
  }

  public U next() {
      assert this.hasNext();

      U element = this.current.element();
      if (this.current.isLast()) {
          this.current = null;
      } else {
          this.current = this.current.next().get();
      }
      return element;
  }

}

