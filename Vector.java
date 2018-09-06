import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.lang.RuntimeException;
import java.util.Arrays;

public class VectorAnswers<E> extends AbstractList<E> implements List<E>, RandomAccess {
  
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
  
  public VectorAnswers() {
  	this(10); 
  }
  
  public VectorAnswers(int initialCapacity) {
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
  
  public void add(int index, E element) {
		// Add element at index.
  }
  
  public E remove(int index) {
		// Remove the element at index. Make sure there are no gaps
		// Return the removed element
  }
  
	public int indexOf(Object o) {
		// Returns the index of the first occurrence of the specified element 
		// in this list, or -1 if this list does not contain the element. 
  }
  
  public static void main(String[] args) {
  	VectorAnswers<Integer> intlist = new VectorAnswers<Integer>();
    VectorAnswers<String> stringlist = new VectorAnswers<String>();
    VectorAnswers<VectorAnswers<Integer>> intveclist = new VectorAnswers<VectorAnswers<Integer>>();

		for (Integer i = 0; i < 10; i++) {
				intlist.add(i);
		}

		System.out.println(intlist.indexOf(7));
		System.out.println(intlist.indexOf("seven"));
  }
}

