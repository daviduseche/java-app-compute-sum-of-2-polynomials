import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Project1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		readFile("poly.txt");//this the directory or path where the data file located and for example this poly.txt is the data file
		

	}
	
	
	public static void readFile(String file){
		
            Polynomial p1=null;
            Polynomial p2=null;
			FileReader fileReader=null;
			BufferedReader inFile=null;
			String onLine;
			
			try{
			    fileReader=new FileReader(file);
			    inFile=new BufferedReader(fileReader);
			    int ctr=1;
			    while((onLine=inFile.readLine())!=null){
			    	if(onLine.trim().length()>0){//trim space between polynomial 
			 
			    		if(ctr==1){//this condition is for 1st polynomial object
			    			p1=new Polynomial();
			    			insert(p1,onLine);
			    			System.out.println("P1     :"+p1);
			    			ctr++;
			    			
			    		}else if(ctr==2){//this condition for 2nd polynomial object and display one(1) set of polynomial object
			    			p2=new Polynomial();
			    			insert(p2,onLine);
			    			ctr=1;
			    			
			    			System.out.println("P2     :"+p2);
			    			System.out.println("SUM    :"+sum(p1,p2));
			    			System.out.println("PRODUCT:"+product(p1,p2));
			    			System.out.println();
			    		}
			    				
			    
			    	}
			    }
			}catch(IOException e){e.printStackTrace();}
			
	
		
	}
	
	public static void insert(Polynomial p,String line){
		
		String coEffientArray[]=line.split(" ");		
		for(String coEfficient:coEffientArray){
       
			 p.insertNode(Integer.parseInt(coEfficient));
		}
	}
	
	/**
	 * A method to computes the sum of two(2) polynomials
	 * @param p1
	 * @param p2
	 * @return sum of Polynomial
	 */
	public static Polynomial sum(Polynomial p1,Polynomial p2){
		 
			  
			   Node currentNodeInP1 = p1.getFirstNode();
			   Node currentNodeInP2=p2.getFirstNode();
			   Polynomial sumOfPolynomial=new Polynomial();
			   while(currentNodeInP1!=null || currentNodeInP2!=null){
				   
				   int p1CoEfficient=currentNodeInP1!=null?currentNodeInP1.getElement():0;
				   int p2CoEfficient=currentNodeInP2!=null?currentNodeInP2.getElement():0;
				   
				   sumOfPolynomial.insertNode(p1CoEfficient + p2CoEfficient);
				   
				   
				   currentNodeInP1=currentNodeInP1!=null?currentNodeInP1.getNext():null;
				   currentNodeInP2=currentNodeInP2!=null?currentNodeInP2.getNext():null;
			   }
			   return sumOfPolynomial;
		  
	
	}
	
	/**
	 * A method that computes the product of two(2) polynomials
	 * @param p1
	 * @param p2
	 * @return product of Polynomial
	 */
	public static Polynomial product(Polynomial p1, Polynomial p2){
		
			  
			   Node currentNodeInP2=  p2.getFirstNode();
			   Polynomial productOfPolynomial=new Polynomial();
			   
			   int ctr=0;
               while(currentNodeInP2!=null){
				    
            	   Node currentNodeInP1 = p1.getFirstNode();
            	   int currentCoEfficientInP2=currentNodeInP2.getElement();
            	   Node productNode=productOfPolynomial.getFirstNode();
            	   int start=ctr;
            	   
            	   while(currentNodeInP1!=null){
            		         		   
            		   if(productNode!=null && start<productOfPolynomial.getSize()){
            			           			   
            		    	Node nodeToBeModified=productOfPolynomial.getNodeAt(start);
            		    	nodeToBeModified.setElement(nodeToBeModified.getElement()+(currentNodeInP1.getElement() * currentCoEfficientInP2));		    	
            		    	start++;
            		    	
            		   }else{
            			   
            			   productOfPolynomial.insertNode(currentNodeInP1.getElement() * currentCoEfficientInP2);
            			   
            		   }
            		   if(ctr>0){
            			  
            		       productNode=productNode.getNext();
            		      
            		   }
            		   currentNodeInP1=currentNodeInP1.getNext();
            		   		   
            	   }
            	
				   ctr++;
				   currentNodeInP2=currentNodeInP2.getNext();	   
				   
			   }
			   
			  
			  return productOfPolynomial;
			  
		
	}
	
	

}
