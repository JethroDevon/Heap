/*

Builds a max heap based on an array called heap, insert elements with insert then call
build, with help from rosetta code.
demosntrates building MaxHeap recursivley each time a node is inserted

*/



class MaxHeap{

    private int[] Heap;
    private int size;
    private int max;
 
    private static final int FRONT = 1;
 
    public MaxHeap(int max){

        max = max;
        size = 0;
        Heap = new int[this.max + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
 
    private int parent( int pos){

        return pos / 2;
    }
 
    private int leftChild( int pos){

        return (2 * pos);
    }
 
    private int rightChild( int pos){

        return (2 * pos) + 1;
    }

    //if is leaf node
    private boolean isLN( int pos) {

        if ( pos >=  (size / 2)  &&  pos <= size){

            return true;
        }
        return false;
    }
 
    private void swap( int fpos, int spos){

        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    //builds heap recursivley based on array 
    private void Build( int pos){

        //if is not a leaf node
        if (!isLN(pos)){ 

            //checks if left or right is lower than parent
            if ( Heap[pos] < Heap[leftChild(pos)]  || Heap[pos] < Heap[rightChild(pos)]){

                //if left is empty or less than rebuild that side
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    Build(leftChild(pos));//<--recursive call to build again to percolate down swap changes
                }else {

                    //else the other side
                    swap(pos, rightChild(pos));
                    Build(rightChild(pos));//<--recursive call to build again to percolate down swap changes
                }
            }
        }
    }
 
    public void insert(int element){

        Heap[++size] = element;
        int current = size;
 
        while(Heap[current] > Heap[parent(current)]){

            swap(current,parent(current));
            current = parent(current);
        }	
    }

      public void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }

 
    public void maxHeap() {

        for ( int pos = (size / 2); pos >= 1; pos--){
            Build(pos);
        }
    }
 
    public int remove(){

        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--]; 
       Build(FRONT);
        return popped;
    }

       public static void main(String[] arg){

        System.out.println("The Max Heap is ");
        MaxHeap mh = new MaxHeap(15);

        mh.insert(12);
        mh.insert(8);
        mh.insert(5);
        mh.insert(6);
        mh.insert(14);
        mh.insert(1);
        mh.insert(10);

        //call to build function method
        mh.maxHeap();
        mh.print();

        System.out.println(" max is" + mh.remove());
    }
 }