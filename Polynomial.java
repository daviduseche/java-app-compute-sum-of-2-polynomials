
public class Polynomial {

	 private Node firstNode;
	 /**
	  * Default Polynomial constructor
	  */
     public Polynomial() {
        this.firstNode=null;
     }
     
     
    /**
     * A method to return the first Node object
     * @return first Node
     */
     public Node getFirstNode() {
		return firstNode;
	}
    /**
     * A method to set the first Node object
     * @param first Node
     */
	public void setFirst(Node firstNode) {
		this.firstNode = firstNode;
	}



	/**
      * Method to insert new Node object
      * @param coEfficient
      * @param power
      */
    public void insertNode(int coEfficient){
    	
        Node newNode=new Node(coEfficient,null);// instantiate a new node using 2 arguments Node constructor
        
        Node cache = this.firstNode; //set to first node
        
        if(cache!=null){//if first node not equal null, store the new Node to the last empty node otherwise set this new Node as first node
        	
	        Node currentNode = null;
	        while((currentNode = cache.getNext()) != null){//find the node which next node is empty
	               cache = currentNode;//set the current node to be tested 
	        }
	        cache.setNext(newNode); //store the new node to last empty node
	        
        }else{
        	
        	this.firstNode=newNode;
        }
    }
    
    /**
     * A method that returns the size of this polynomial
     * @return size of Polynomial nodes
     */
    public int getSize(){
    	
    	int size=0;
    	Node currentNode=this.firstNode;
    	while(currentNode != null){
            currentNode = currentNode.getNext();
            size++;
        }
    	return size;
    
    }
    
    /**
     * Method that returns Node at specific index
     * @param index
     * @return Node 
     */
    public Node getNodeAt(int index){
    	
    	int ctr=0;
    	Node currentNode=this.firstNode;
    	while(currentNode != null){
    		if(ctr==index){
    			return currentNode;
    		}
            currentNode = currentNode.getNext();
            ctr++;
        }
    	return null;
    	
    }
    
    /**
     * 
     * Override toString() method of super class Object to customize the result
     * @return  data of this List
     */
    @Override
   public String toString(){
	   
	   String result="List is empty";
	   if(getSize()>0){
		   Node currentNode=this.firstNode;
		   result="";
	       while(currentNode != null){
	    	   
	    	   result+=currentNode.getElement()+" ";
	           currentNode = currentNode.getNext();
	           
	       }
	   }
	   return result;
   }
}
