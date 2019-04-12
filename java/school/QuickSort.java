/**
 * This class sorts arrays with the QuickSort algorithm.
 * 
 * @author adrian aleman
 */
public class QuickSort extends AbstractSort {
	/**
	 * Constructor
	 */
	public QuickSort() {
		super("QuickSort");
	}

	/**
	 * This method sorts the given array.
	 * 
	 * @param array
	 * @return array sorted array
	 */
	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * This method sorts the array using QuickSort algorithm.
	 * 
	 * @param array array that will be sorted
	 * @param min   array index
	 * @param max   array index
	 * @return array returns the sorted array
	 */
	public int[] quickSort(int[] array, int min, int max) {
		if (min < max) {
			int x = partition(array, min, max);

			quickSort(array, min, x - 1);
			quickSort(array, x + 1, max);
		}
		return array;
	}

	/**
	 * This method uses partitioning to divide the array into sub arrays
	 * 
	 * @param array this is the sub array
	 * @param min   the lower value
	 * @param max   the higher value
	 * @return an array that is almost fully sorted
	 */
	public int partition(int[] array, int min, int max) {
		int pivot = array[max];
		int i = (min - 1);
		for (int j = min; j <= max - 1; j++) {
			if (array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[max];
		array[max] = temp;
		return (i + 1);
	}

}