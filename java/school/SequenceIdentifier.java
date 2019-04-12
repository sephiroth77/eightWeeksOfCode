
package week02;

import java.lang.*;

/**
 * 
 * @author adrian aleman
 *
 */

public class SequenceIdentifier {

	private STATE m_curState;
	private SEQUENCE_TYPE one;
	int term;

	public static enum SEQUENCE_TYPE {

		ARITHMETIC, GEOMETRIC, NONE

	};

	/**
	 * if Internal state of the class. INVALID until identifySequence is called
	 * 
	 * @author Scott LaChance
	 * 
	 */
	protected enum STATE {

		INVALID, VALID

	};

	/**
	 * Default constructor
	 */
	public SequenceIdentifier() {

		m_curState = STATE.INVALID;
	}

	/**
	 * This method returns an enumeration SEQUENCE_TYPE. It takes two parameters,
	 * int[] array and int termIndex.
	 * 
	 * @param array     - Array of integers to evaluate
	 * @param termIndex - index of term to calculate
	 * @return Sequence type and save the type of calculated term.
	 * @throws InvalidStateException If state isn't correct
	 * @throws InvalidDataException  If data isn't valid
	 */
	public SEQUENCE_TYPE identifySequence(int[] array, int termIndex)
			throws InvalidStateException, InvalidDataException {

		reset();
		validateArray(array);
		if (m_curState == STATE.VALID) {
			evaluateSequence(array);
			if (one == SEQUENCE_TYPE.ARITHMETIC) {
				term = array[0] + (termIndex - 1) * (array[1] - array[0]);
			} else if (one == SEQUENCE_TYPE.GEOMETRIC) {
				double result = Math.pow((array[1] / array[0]), (termIndex - 1));
				term = (int) (array[0] * result);
			}

		} else {
			one = SEQUENCE_TYPE.NONE;
		}

		m_curState = STATE.VALID;

		return one;

	}

	/**
	 * This method returns the term if the state is valid.
	 * 
	 * @return the value of the calculated term
	 * @throws InvalidStateException If the state is invalid.
	 */
	public int getCalculatedTerm() throws InvalidStateException {
		switch (m_curState)

		{

		case INVALID:
			throw new InvalidStateException();

		case VALID:

		default:

			break;

		}

		return term;
	}

	/**
	 * This method returns the type of sequence.
	 * 
	 * @return Sequence type
	 */
	public SEQUENCE_TYPE getSequenceType() {
		return one;

	}

	/**
	 * This method determines whether a given array state is valid or invalid.
	 * 
	 * @param array - array of integers to validate
	 * @throws InvalidDataException If
	 */
	private void validateArray(int[] array) throws InvalidDataException {

		if (array != null && array.length >= 3) {
			m_curState = STATE.VALID;
 
		} else if (array == null) {
			throw new InvalidDataException();

		} else if (array.length < 1) {
			throw new InvalidDataException();
		} else {
			m_curState = STATE.INVALID;
		}

	}

	/**
	 * This method evaluates a sequence to determine whether it is arithmetic,
	 * geometric, or neither.
	 * 
	 * @param array - array of integers to evaluate
	 * @return Sequence type
	 */
	private SEQUENCE_TYPE evaluateSequence(int[] array) {

		if (array[array.length - 1] - array[array.length - 2] == array[1] - array[0]) {
			one = SEQUENCE_TYPE.ARITHMETIC;
		} else if ((double) (array[1] / array[0]) == (double) (array[array.length - 1])
				/ (double) (array[array.length - 2])) {
			one = SEQUENCE_TYPE.GEOMETRIC;
		} else {
			one = SEQUENCE_TYPE.NONE;
		}

		return one;

	}

	/**
	 * This method resets the state to invalid.
	 */
	private void reset() {
		m_curState = STATE.INVALID;
	}

}
