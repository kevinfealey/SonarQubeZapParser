package com.aspectsecurity.automation.ZapOutputParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aspectsecurity.automation.ZapOutputParser.resources.ZapAlert;

public class ZapXMLParser {

	/*
	* args[0] should be the path of the ZAP XML output file
	*/
	public static void main(String[] args) {
		ArrayList<ZapAlert> alerts = loadAlertsFromXML(args[0]);
		printData(alerts);
	}

	public static ArrayList<ZapAlert> loadAlertsFromXML(String filePath) {
		System.out.println("Loading ZAP Alerts from: " + filePath);
		ArrayList<ZapAlert> alerts = createAlertsFromDocument(createDocumentFromXML(filePath));
		System.out.println("# Alerts found: " + alerts.size());
		return alerts;
	}

	public static String removeWhiteSpaceFromString(String in) {
		return in.replaceAll("\\s", "_");

	}

	public static int countAlertsOfType(ArrayList<ZapAlert> alertlist,
			String alertType) {
		int count = 0;
		for (ZapAlert a : alertlist) {
			if (a.getALERT().compareTo(alertType) == 0) {
				count++;
			}
		}
		return count;
	}

	public static int countAlertsOfShortname(ArrayList<ZapAlert> alertlist,
			String alertShortname) {
		int count = 0;
		for (ZapAlert a : alertlist) {
			if (a.getSHORTNAME().compareTo(alertShortname) == 0) {
				count++;
			}
		}
		return count;
	}

	private static void printData(ArrayList<ZapAlert> alerts) {

		System.out.println("Number of Alerts '" + alerts.size() + "'.");

		int i = 0;
		Iterator<ZapAlert> it = alerts.iterator();
		while (it.hasNext()) {
			System.out.println(i + ": " + it.next().getID());
			i++;
		}
	}

	private static Document createDocumentFromXML(String filePath) {
		// get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document dom = null;
		try {
			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parse using builder to get DOM representation of the XML file
			System.out.println("loading XML: " + filePath);
			dom = db.parse(filePath);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return dom;
	}

	public static ArrayList<ZapAlert> createAlertsFromDocument(Document dom) {
		String elementName = "";

		elementName = "alert";

		ArrayList<ZapAlert> alerts = new ArrayList<ZapAlert>();

		// get the root element
		Element docEle = dom.getDocumentElement();

		// get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName(elementName);

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// get the alert element
				Element el = (Element) nl.item(i);

				ZapAlert alert = null;

				alert = getZapAlert(el);

				// add it to list
				if (alert.getID() != null)
					alerts.add(alert);
			}
		}

		return alerts;
	}

	/**
	 * I take a ZapAlert element and read the values in, create a ZapAlert
	 * object and return it
	 */
	private static ZapAlert getZapAlert(Element empEl) {
		// for each <alert> element get text or int values

		String type = empEl.getAttribute("type");
		String other = getTextValue(empEl, "other");
		String param = getTextValue(empEl, "param");
		String alert = getTextValue(empEl, "alert");
		String evidence = getTextValue(empEl, "evidence");
		String reliability = getTextValue(empEl, "reliability");
		String solution = getTextValue(empEl, "solution");
		String url = getTextValue(empEl, "url");
		String reference = getTextValue(empEl, "reference");
		String id = getTextValue(empEl, "id");
		String risk = getTextValue(empEl, "risk");
		String description = getTextValue(empEl, "description");
		String attack = getTextValue(empEl, "attack");
		String messageId = getTextValue(empEl, "messageId");
		String cweId = getTextValue(empEl, "cweid");
		String wascId = getTextValue(empEl, "wascid");

		// Create a new ZapAlert with the value read from the xml nodes
		ZapAlert e = new ZapAlert(type, other, param, alert, evidence,
				reliability, solution, url, reference, id, risk, description,
				attack, messageId, cweId, wascId);

		return e;
	}

	/**
	 * I take a xml element and the tag name, look for the tag and get the text
	 * content i.e for <employee><name>John</name></employee> xml snippet if the
	 * Element points to employee node and tagName is 'name' I will return John
	 */
	private static String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			if (el.hasChildNodes())
				textVal = el.getFirstChild().getNodeValue();

		}

		return textVal;
	}

}
