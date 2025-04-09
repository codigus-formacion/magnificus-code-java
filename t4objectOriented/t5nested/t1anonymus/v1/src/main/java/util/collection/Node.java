package util.collection;

import util.values.Optional;

public class Node<U> {

  private Optional<Node<U>> previous;
  private U element;
  private Optional<Node<U>> next;

  private Node(Optional<Node<U>> previous, U element, Optional<Node<U>> next) {
      this.previous = previous;
      this.element = element;
      this.next = next;
  }

  public Node(U element, Optional<Node<U>> next) {
      this(Optional.empty(), element, next);
  }

  public Node(Optional<Node<U>> previous, U element) {
      this(previous, element, Optional.empty());
  }

  public void setNext(Optional<Node<U>> next) {
      this.next = next;
      if (next.isPresent()){
          next.get().previous = Optional.of(this);
      }
  }

  public U element() {
      return this.element;
  }

  public boolean isFirst() {
      return this.previous.isEmpty();
  }

  public boolean isLast() {
      return this.next.isEmpty();
  }

  public Optional<Node<U>> next() {
      return this.next;
  }

  public Optional<Node<U>> previous() {
      return this.previous;
  }

}

