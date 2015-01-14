
public class Node
{
	 private int element;
	 private Node next;
	 
	 

	public Node(int element, Node next) {
		super();
		this.element = element;
		this.next = next;
	}
	
	/**
	 * Getter method for element member variable
	 * @return int element value
	 */
	public int getElement() {
		return element;
	}
	
	/**
	 * Setter method for element member variable
	 * @param element
	 */
	public void setElement(int element) {
		this.element = element;
	}
	
	
	/**
	 * Getter method for next Node member object
	 * @return Node object
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * Setter method for next Node member object
	 * @param next
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	 
	 
	 
     
	 
}


