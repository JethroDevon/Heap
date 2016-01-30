
/////////////////////////////////////////////////////////
//     This class is derived from week-5 stack class   //
// 	 This version is for demonstrating heap functions  // 
/////////////////////////////////////////////////////////
//													   //
//		     by Jethro Holcroft 05/12/2013			   //
//													   //
/////////////////////////////////////////////////////////

public class Heap{

	//this is the root of the data structure, last stores the last node in the data structure.
	public HeapNode root; 

	private int[] heap;
	private int max, size;

	//constructor creates an initial root node to build from with data at roo from args
	public Heap(Object _obj){

		max (int) _obj;
		size = 0;
		heap = new int(this.max + 1);
		root = create(max);	
		heap[0] = Integer.MAX_VALUE;
	}

	//returns a HeapNode with initialiser for object in args
	public HeapNode create(Object data){

		return new HeapNode(data);
	}

	//creates and returns HeapNode with two child branches
	//left and right 
	public void combine(HeapNode _par, HeapNode l, HeapNode r){
	
		l.setParent(_par);
		r.setParent(_par);
		root.setLeft(l);
		root.setRight(r);
	}

	//overloaded version of above jsut uses root as parent nodes
	//left and right 
	public void combine(Heap l, Heap r){
	

		root.setLeft(l.root);
		root.setRight(r.root);
	}

	//returns true if Heap is empty
	public boolean HeapEmpty(HeapNode t){

		if(t == null){

			return true;
		}else{

			return false;
		}
	}

	//swaps data in node that this function is called with the one passed in args
	public void swapNode(HeapNode t){

		Object temp = t.getObject();
		t.setObj(root.getObject());
		root.setObj(temp);
	}

	//returns true if node in args is higher than this nodes root
	public boolean isHigher(HeapNode t){

		if((int)root.getObject() < (int)t.getObject()){

			return true;
		}else{

			return false;
		}
	} 



	//recursivley iterates and reads in named order
	public void preOrder(HeapNode t){


		if(!HeapEmpty(t)){

			System.out.print(t.getObject());				
			preOrder(t.getLeft());
			preOrder(t.getRight());	
		}			
	}

	public void postOrder(HeapNode t){

		if(!HeapEmpty(t)){

			preOrder(t.getLeft());
			preOrder(t.getRight());
			System.out.print(" "+t.getObject()+" ");
		}	
	}

	public void inOrder(HeapNode t){

		if(!HeapEmpty(t)){

			preOrder(t.getLeft());
			System.out.print(" "+t.getObject()+" ");
			preOrder(t.getRight());		
		}	
	}





	////////////////////////////////////////////////////////////////
	//////The node class creates an object that can be linked///////
	//////to another object identicle to itself, it contains ///////
	//////////////////////an object.////////////////////////////////
	////////////////////////////////////////////////////////////////
	public class HeapNode{

		//variables contain two parts two node structure, one to
		//contain data the other to contain a link to another node.
		private Object obj;
		private HeapNode left, right, parent;

		//sets next to null, this cinstructor takes no object args
		public HeapNode(){
			
			obj = null;
			left = null;
			right = null;
			parent = null;
		}

		//initializes object variable, setsleft and right to null
		public HeapNode(Object o){
			
			obj = o;
			left = null;
			right = null;
			parent = null;
		}

		//initializes object variable, sets left and right
		public HeapNode(Object o, HeapNode _left, HeapNode _right){
			
			obj = o;
			left = _left;
			right = _right;
			parent = null;
		}

		//initializes object variable, sets left and right and the parent node
		public HeapNode(Object o, HeapNode _left, HeapNode _right, HeapNode _parent){
			
			obj = o;
			left = _left;
			right = _right;
			parent = _parent;
		}

				
		//sets node objects private string variable to args.
		void setObj(Object o){

			obj = o;
		}

		//returns this node objects private object 'obj'
		Object getObject(){

			return obj;
		}

		//sets this nodes private left HeapNode object to node in args.
		void setLeft(HeapNode _left){

			left = _left;
		}

		//this function gets the left field of the Heap node
		HeapNode getLeft(){

			return left;
		} 

		//sets this nodes private right HeapNode object to node in args.
		void setRight(HeapNode _right){

			right = _right;
		}

		//this function gets the right field of the Heap node
		HeapNode getRight(){

			return right;
		} 

		//sets this nodes private right Heapnode object to node in args.
		void setParent(HeapNode _parent){

			parent = _parent;
		}

		//this function gets the right field of the Heap node
		HeapNode getParent(){

			return parent;
		} 

	}//end HeapNode class
}//end Heap class