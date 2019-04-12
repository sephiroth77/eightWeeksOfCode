/**
 * Provides a set of utility methods to manage XML
 * 
 * @author Adrian Aleman
 *
 */
public class XmlUtility extends java.lang.Object {
	/**
	 * Constructor
	 */
	public XmlUtility() {

	}

	private static Document generateLoginRequestXml(LoginRequest request) {
		Document dom;

		Element root = new Element("login-request");
		Attribute version = new Attribute("version", "1.0");
		root.setAttribute(version);
		String pinFmt = String.format("%d", request.getPin());
		Attribute pin = new Attribute("pin", pinFmt);
		root.setAttribute(pin);
		String accountIdFmt = String.format("%d", request.getAccountId());
		Attribute accountId = new Attribute("account-id", accountIdFmt);
		root.setAttribute(accountId);

		dom = new Document(root);
		return dom;

	}

	private static Document generateLoginResponseXml(LoginResponse response) {
		Document dom;

		// build the root element
		Element root = new Element("login-response");
		Attribute version = new Attribute("version", "1.0");
		root.setAttribute(version);
		String loggedInFmt = response.getLoggedIn().toString();
		Attribute loggedIn = new Attribute("logged-in", loggedInFmt);
		root.setAttribute(loggedIn);
		String sessionFmt = String.format("%d", response.getSessionId());
		Attribute account = new Attribute("session-id", sessionFmt);
		root.setAttribute(account);

		dom = new Document(root);

		return dom;
	}

	private static Week12Object getLoginObject(Element root) {
		String accountIdString = root.getAttributeValue("account-id");
		String pinString = root.getAttributeValue("pin");
		long accountId = Long.parseLong(accountIdString);
		int pin = Integer.parseInt(pinString);

		return new LoginRequest(pin, accountId);

	}

	private static Week12Object getLoginResponseObject(Element root) 
			throws NumberFormatException {
		String loggedInString = root.getAttributeValue("logged-in");
		String sessionIdString = root.getAttributeValue("session-id");
		boolean loggedIn = Boolean.parseBoolean(loggedInString);
		int accountId = Integer.parseInt(sessionIdString);
		return new LoginResponse(loggedIn, accountId);
	}

	/**
	 * Serializes a Week12Object reference to an XML document
	 * 
	 * @param obj Week12Object to serialize
	 * @return XML Document
	 */
	public static Document objectToXml(Week12Object obj) 
			throws Week12Exception {
		Document dom = null;

		if (obj instanceof LoginRequest) {
			dom = generateLoginRequestXml((LoginRequest) obj);
		} else if (obj instanceof LoginResponse) {
			dom = generateLoginResponseXml((LoginResponse) obj);
		} else {
			throw new Week12Exception("Unknown Week12Object");
		}

		return dom;
	}

	/**
	 * Takes an XML document and converts it 
	 * to the appropriate ATM domain object.
	 * @param dom
	 * @return ATM domain object
	 * @throws Week12Exception
	 */
	public static Week12Object xmlToObject(Document dom) throws Week12Exception {
		Week12Object atmObject = null;

		// get the root and determine the type of object
		Element root = dom.getRootElement();
		String elementName = root.getName();
		try {
			// extend this section to build appropriate object
			if (elementName.equals("login-request")) {
				// generate the LoginRequest object
				atmObject = getLoginObject(root);
			}
			// extend this section to build appropriate object
			else if (elementName.equals("login-response")) {
				// generate the LoginResponse object
				atmObject = getLoginResponseObject(root);
			}
		} catch (NumberFormatException ex) {
			throw new Week12Exception(ex);
		}
		return atmObject;
	}

}
