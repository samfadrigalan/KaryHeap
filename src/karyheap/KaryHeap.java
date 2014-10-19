/**
 * @file KaryHeap.java
 * @author Samantha Fadrigalan and Kayla Thurman
 * Description: Kary Heap Implementation 
 * Course: CSC 3102
 */
package karyheap;
import java.util.Arrays;
/**
 *
 * @author thaddeuspaulfadrigalan
 */
public class KaryHeap {
   private static final int DEFAULT_CAPACITY = 10;
   protected int[] array;
   protected int size;
   protected int k;
   
   /**
    * Constructs a KaryHeap.
    */
   public KaryHeap(){
       array = new int[DEFAULT_CAPACITY];
       size = 0;
   }
   
   /**
    * initializes k to possible number of children
    * @param k number of children
    */
   public void setK(int k){
       this.k = k;
   }   
   
   /**
    * determines parent of ith node
    * @param i node
    * @return parent of ith node
    */
   protected int parent(int i){
       return (k + i - 2)/k;
   }
   
   /**
    * determines jth child of ith node
    * @param i parent node
    * @param j jth child
    * @return jth child of ith node
    */
   protected int child(int i, int j){
       /*
        * added j--
        */
       j=j-1;
       return k * i - (k-2) + j;
   }
   
   /**
    * determines if is empty
    * @return true of heap is empty and false if otherwise
    */
   public boolean isEmpty(){
       return size == 0;
   }
   
   /**
    * determines if node has a parent
    * @param i node
    * @return true if node has a parent and false if otherwise
    */
   protected boolean hasParent(int i){
       return parent(i) > 0;
   }   
   
   /**
    * determines if node has jth child
    * @param i parent node
    * @param j jth child
    * @return true if node has jth child and false if otherwise
    */
   protected boolean hasjthChild(int i, int j){
       return child(i, j) <= size;
   }
   
   /**
    * determines min of min-heap
    * @return min of heap
    */
   public int min(){
       if(this.isEmpty())
           throw new IllegalStateException("Heap underflow");
       return array[1];
   }

   /**
    * Restores min heap property of the tree; 
    * assumes that the trees rooted at the children are min heaps but 
    * a child may be smaller than the parent node
    * @param i 
    */
   protected void bubbleDown(int index){
       int j = 1;
       int smallest = index;
       
       while(j<=k && hasjthChild(index, j)){
           if(array[child(index, j)] < array[smallest])
               smallest = child(index, j);
           j++;
       }
       
       if(index != smallest){
           swap(index, smallest);
           bubbleDown(smallest);
       }
   }
   
   /**
    * Restores min heap property by placing a newly inserted element into
    * its correct position.
    */
   protected void bubbleUp(){
       int index = size;
       
       while(hasParent(index) && array[parent(index)] > array[size]){
           swap(parent(index), index);
           index = parent(index);
       }
   }
   
   /**
    * extracts and returns min of heap, fixes heap property of tree
    * @return min key of heap
    */
   public int extractMin(){
       if(this.isEmpty())
           throw new IllegalStateException("Heap underflow");
       int min = array[1];
       array[1] = array[size];
       size--;
       bubbleDown(1);
       
       return min;
   }
   
   public void insert(int key){
       size++;
       if(size > array.length-1)
           array = resize();
       
       int index = size;
       array[index] = key;
       
       bubbleUp();
   }
   
   /**
    * copies array into new array and doubles length of new array
    * @return new array
    */
   protected int[] resize(){
       return Arrays.copyOf(array, array.length * 2);
   }
   
   /**
    * swaps two elements in array
    * @param index1 index of 1st element
    * @param index2 index of 2nd element
    */
   protected void swap(int index1, int index2){
       int temp = array[index1];
       array[index1] = array[index2];
       array[index2] = temp;
   }
}
