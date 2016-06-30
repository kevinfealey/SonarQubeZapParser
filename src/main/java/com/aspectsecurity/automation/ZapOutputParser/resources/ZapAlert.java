package com.aspectsecurity.automation.ZapOutputParser.resources;

public class ZapAlert {
	
	private final String TYPE;
	private final String OTHER;
	private final String PARAM;
	private final String ALERT;
	private final String EVIDENCE;
	private final String RELIABILITY;
	private final String SOLUTION;
	private final String URL;
	private final String REFERENCE;
	private final String ID;
	private final String RISK;
	private final String DESCRIPTION;
	private final String ATTACK;
	private final String MESSAGE_ID;
	private final String CWE_ID;
	private final String WASC_ID;
	private int Top10;
	private String SUBCAT;
	private String SHORTNAME;

	public ZapAlert(String type, String other, String param, String alert, String evidence, String reliability, String solution, String url, String reference, String id, String risk,
			String description, String attack, String messageId, String cweId, String wascId){
		
		this.TYPE=type;
		this.OTHER=other;
		this.PARAM=param;
		this.ALERT=alert;
		this.EVIDENCE=evidence;
		this.RELIABILITY=reliability;
		this.SOLUTION=solution;
		this.URL=url;
		this.REFERENCE=reference;
		this.ID=id;
		this.RISK=risk;
		this.DESCRIPTION=description;
		this.ATTACK=attack;
		this.MESSAGE_ID=messageId;
		this.CWE_ID=cweId;
		this.WASC_ID=wascId;
		this.Top10 = 0;
		this.SUBCAT = "";
		this.SHORTNAME = "";
	}

	public String toString() {
		String sep = "||";
		return TYPE + sep +
				OTHER + sep +
				PARAM + sep +
				ALERT + sep +
				EVIDENCE + sep +
				RELIABILITY + sep +
				SOLUTION + sep +
				URL + sep +
				REFERENCE + sep +
				ID + sep +
				RISK + sep +
				DESCRIPTION + sep +
				ATTACK + sep +
				MESSAGE_ID + sep +
				CWE_ID + sep +
				WASC_ID + sep +
				Top10 + sep +
				SUBCAT + sep +
				SHORTNAME;
	}
	
	public String getTYPE() {
		return TYPE;
	}
	public String getOTHER() {
		return OTHER;
	}
	public String getPARAM() {
		return PARAM;
	}
	public String getALERT() {
		return ALERT;
	}
	public String getEVIDENCE() {
		return EVIDENCE;
	}
	public String getRELIABILITY() {
		return RELIABILITY;
	}
	public String getSOLUTION() {
		return SOLUTION;
	}
	public String getURL() {
		return URL;
	}
	public String getREFERENCE() {
		return REFERENCE;
	}
	public String getID() {
		return ID;
	}
	public String getRISK() {
		return RISK;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public String getATTACK() {
		return ATTACK;
	}
	public String getMESSAGE_ID() {
		return MESSAGE_ID;
	}
	public String getCWE_ID() {
		return CWE_ID;
	}
	public String getWASC_ID() {
		return WASC_ID;
	}
	public int getTop10() {
		return Top10;
	}
	public void setTop10(int t) {
		Top10 = t;
	}
	public String getSUBCAT() {
		return SUBCAT;
	}
	public void setSUBCAT(String sUBCAT) {
		SUBCAT = sUBCAT;
	}

	public String getSHORTNAME() {
		return SHORTNAME;
	}

	public void setSHORTNAME(String sHORTNAME) {
		SHORTNAME = sHORTNAME;
	}



}
