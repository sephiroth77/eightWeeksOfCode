/**
 * This is an abstract class that makes sorting algorithms possible
 * 
 * @author adrian aleman
 */
public abstract class AbstractSort {
	private String m_name;

	/**
	 * Constructor
	 * 
	 * @param name takes the name of the type of sorting algorithm
	 */
	public AbstractSort(String name) {
		m_name = name;
	}

	/**
	 * This method is the blueprint for the sort method in QuickSort.java and
	 * SelectionSort.java
	 * 
	 * @param array
	 * @return null
	 */
	public int[] sort(int[] array) {
		return null;
	}
}