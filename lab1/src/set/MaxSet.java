package set;

import java.util.NoSuchElementException;
import java.util.Iterator;


public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
	private E maxElement;
	
	/**
	 * Constructs a new empty set.
	 */
	public MaxSet() {
		super();
		maxElement = null;
	}
	
	/** Returns the currently largest element in this set. 
	pre: the set is not empty 
	post: the set is unchanged 
	@return the currently largest element in this set 
	@throws NoSuchElementException if this set is empty 
	*/ 
	public E getMax() {
		if(maxElement != null){
			return maxElement;
		}else{
			throw new NoSuchElementException();
		}
	}
	
	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if(maxElement == null){
			maxElement = x;
		}
		else if(maxElement.compareTo(x) < 0){
			maxElement = x;
		}
		return super.add(x);
	}
	
	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		boolean b = super.remove(x);
		if(b){
			if(maxElement.compareTo((E)x) <= 0){
				Iterator itr = super.iterator();
				if(itr.hasNext()){
					maxElement = (E)itr.next();
				}else{
					maxElement = null;
				}
				while(itr.hasNext()){
					E e = (E)itr.next();
					if(maxElement.compareTo(e) < 0){
						maxElement = e;
					}
				}
			}
		}
		return b;
	}
	
	/** Adds all of the elements in the specified set, for which it is 
	possible, to this set. 
	post: all elements, for which it is possible, in the 
	specified set are added to this set. 
	@return true if this set changed as a result of the call 
	*/
	public boolean addAll(SimpleSet<? extends E> c) {
		boolean b = super.addAll(c);
		if(b){
			Iterator itr = c.iterator();
			while(itr.hasNext()){
				E e = (E)itr.next();
				if(e.compareTo(maxElement) > 0){
					maxElement = e;
				}
			}
		}
		return b;
	}
	
	
}