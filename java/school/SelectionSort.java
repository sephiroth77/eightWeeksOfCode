**
 * This class sorts an array using a selection sort algorithm and returns it.
 * 
 * @author adrian aleman
 *
 */
public class SelectionSort extends AbstractSort {
	/**
	 * Constructor
	 */
	public SelectionSort() {
		super("Selection Sort");
	}

	/**
	 * This method sorts an int array using selection sort.
	 * 
	 * @param array int array that is to be sorted.
	 * @return array - the sorted array
	 */
	@Override
	public int[] sort(int[] array) {
		int arrayLength = array.length;

		for (int i = 0; i < arrayLength - 1; i++) {
			// lowest number in array
			int minimum = i;
			for (int j = i + 1; j < arrayLength; j++) {
				if (array[j] < array[minimum]) {
					minimum = j;
				}
			}
			// exchange elements in array
			int temp = array[minimum];
			array[minimum] = array[i];
			array[i] = temp;
		}
		return array;
	}

}