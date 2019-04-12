public class StopWatch {
	private long m_startTime;
	private long m_stopTime;

	/**
	 * Constructor
	 */
	public StopWatch() {

	}

	/**
	 * This method allows the program to determine when the array has been sorted.
	 */
	public void stop() {
		m_stopTime = System.currentTimeMillis();
	}

	/**
	 * This method allows the program to determine when the array begins sorting.
	 */
	public void start() {
		m_startTime = System.currentTimeMillis();
	}

	/**
	 * This method returns the time the algorithm is completed.
	 * 
	 * @return m_stopTime
	 */
	public long getStopTime() {
		return m_stopTime;
	}

	/**
	 * This method returns the time the algorithm starts with it's given type.
	 * 
	 * @return m_startTime
	 */
	public long getStartTime() {
		return m_startTime;
	}

	/**
	 * This method calculates sorting time.
	 * 
	 * @return m_stopTime - m_startTime the total duration of the sorting time
	 */
	public long getElapsedTimeMilliSeconds() {
		return m_stopTime - m_startTime;
	}

}
