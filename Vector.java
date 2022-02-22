import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.lang.RuntimeException;
import java.util.Arrays;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess {
  
  protected Object[] data;
  protected int size;

  public int size() {
   	return size; 
  }
  
  private void rangeCheck(int index) {
   	 if (index < 0 || index >= size)
       throw new IndexOutOfBoundsException("");
  }
  
  @SuppressWarnings("unchecked")
  private E data(int index) {
    return (E) data[index];
  }
  
  private void grow() {
    int newCapacity = data.length*2;
   	data = Arrays.copyOf(data, newCapacity); 
  }
  
  public Vector() {
  	this(10); 
  }
  
  public Vector(int initialCapacity) {
   	data = new Object[initialCapacity];
    size = 0;
  }
  
  public E get(int index) {
    rangeCheck(index);
    return data(index);
  }
  
  public E set(int index, E element) {
    rangeCheck(index);
    E oldValue = data(index);
   	data[index] = element; 
  	return oldValue;
  }
  
  public boolean add(E element) {
   	if (size == data.length) grow(); 
    data[size++] = element;
    return true;
  }
	
  public int indexOf(Object o) {
	// Returns the index of the first occurrence of the specified element 
	// in this list, or -1 if this list does not contain the element. 

  //for loop finds index of the object and returns it. Else returns -1;
    for(int i =0; i<size;i++){
      if(data[i].equals(o)){
        return i;
      } 
    }
    return -1;

    }


	@SuppressWarnings("unchecked")
  public int addAfterIf(Object toAdd, Object elementBefore) {
	// Inserts toAdd after elementBefore, IF elementBefore is located
	// in the second half of the arraylist. If elementBefore is in the
	// first half of the arraylist, add toAdd to the end of the arrayList.
	// Return the index of toAdd
  
    for(int i =0; i<size;i++){
      //if elementbefore is in the arraylist and in the first half, adds toAdd to the end
      if(data[i].equals(elementBefore) && i<size/2){
        
        if (size >= data.length) grow();
          add((E)(toAdd));
          return size;

      //if element before in the arraylit and in the second half, adds toAdd after the elementBefore
      }else if(data[i].equals(elementBefore) && i>=size/2){
        if (size >= data.length) grow();
        for (int j =size; j > i+1; j--){

         data[j] = data[j-1];
        }
        data[i+1] = toAdd;
        size++;
        return i+1;

      }
    }
    return -1;

  }
  
  public static void main(String[] args) {
  	Vector<Integer> intlist = new Vector<Integer>();
    Vector<String> stringlist = new Vector<String>();
    Vector<Vector<Integer>> intveclist = new Vector<Vector<Integer>>();

	for (Integer i = 0; i < 10; i++) {
		intlist.add(i);
	}

	System.out.println(intlist.indexOf(7));
	System.out.println(intlist.indexOf("seven"));

  }
}

