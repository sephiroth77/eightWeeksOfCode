/**
 * This class is responsible for deciding algorithm type and timing the sorting
 * process.
 * 
 * @author adrian aleman
 */
public class SortUtility {
	private SORT_ALGORITHM_TYPE m_sortAlgorithmType;
	private StopWatch m_time;
	private long m_elapsedTime = 0;

	/**
	 * Constructor
	 */
	public SortUtility() {
		m_time = new StopWatch();
	}

	/**
	 * @return elapsed time from stopWatch
	 */
	public long getElapsedTime() {
		return m_elapsedTime;
	}

	/**
	 * This method decides which algorithm should be used to sort.
	 * 
	 * @param m_sortAlgorithmType algorithm type
	 * @return sort algorithm of said type
	 * @throws NotImplementedException if algorithm is neither Selection or
	 *                                 QuickSort
	 */
	public AbstractSort getSortAlgorithm(SORT_ALGORITHM_TYPE m_sortAlgorithmType) throws NotImplementedException {
		AbstractSort sort = new SelectionSort();
		switch (m_sortAlgorithmType) {
		case SELECTION:
			sort = new SelectionSort();
			break;
		case QUICK:
			sort = new QuickSort();
			break;
		default:
			throw new NotImplementedException("Sorry, none of the algorithms were selected.");
		}
		return sort;
	}

	/**
	 * This method wraps the call to the sort implementation with the StopWatch
	 * start/stop methods to time the processing.
	 * 
	 * @param array               array in need of sorting
	 * @param m_sortAlgorithmType type of algorithm
	 * @return sortedArray
	 * @throws NotImplementedException if the type of algorithm is not valid.
	 */
	public int[] sort(int[] array, SORT_ALGORITHM_TYPE m_sortAlgorithmType) throws NotImplementedException {
		AbstractSort algorithm = getSortAlgorithm(m_sortAlgorithmType);
		m_time.start();
		int[] sortedArray = algorithm.sort(array);
		m_time.stop();

		m_elapsedTime = m_time.getElapsedTimeMilliSeconds();
		return sortedArray;
	}

}