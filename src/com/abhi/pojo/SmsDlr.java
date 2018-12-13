package com.abhi.pojo;

public class SmsDlr {
	
	private int clientid;
	private int msgid;
	private int automationid; 
	private int userid;
	private int sc;
	private int circleid;
	private String ts;
	private String status;
	private String mobile;
	private String reqid;
	private String deliverytime;
	private String operator;
	private String circle;
	private String txnid;
	private String feedid;
	private String senttime;
	private String bbtxnid;
	private String publishDate;
	private String sentTs;	
	private int send_to_eaf=1;
	
	public int getSend_to_eaf() {
		return send_to_eaf;
	}
	public void setSend_to_eaf(int send_to_eaf) {
		this.send_to_eaf = send_to_eaf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getDeliverytime() {
		return deliverytime;
	}
	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getFeedid() {
		return feedid;
	}
	public void setFeedid(String feedid) {
		this.feedid = feedid;
	}
	
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public int getAutomationid() {
		return automationid;
	}
	public void setAutomationid(int automationid) {
		this.automationid = automationid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	private String statuscode;
	private int operatorid;
	public int getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}
	public int getCircleid() {
		return circleid;
	}
	public void setCircleid(int circleid) {
		this.circleid = circleid;
	}


	/**
	 * sc stands for SMS Count
	 * @return the sc
	 */
	public int getSc() {
		return sc;
	}


	/**
	 * @param sc the sc to set
	 */
	public void setSc(int sc) {
		this.sc = sc;
	}
	
	
	public String getSenttime() {
		return senttime;
	}
	public void setSenttime(String senttime) {
		this.senttime = senttime;
	}


	public String getBbtxnid() {
		return bbtxnid;
	}

	public void setBbtnxid(String bbtxnid) {
		this.bbtxnid = bbtxnid;
	}


	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	public String getSentTs() {
		return sentTs;
	}

	public void setSentTs(String sentTs) {
		this.sentTs = sentTs;
	}

	
	 @Override
     public String toString() {
             return "SMSDlr [status=" + status + ", mobile=" + mobile + ", reqid="
                             + reqid + ", deliverytime=" + deliverytime + ", operator="
                             + operator + ", circle=" + circle + ", txnid=" + txnid
                             + ", feedid=" + feedid + ", senttime=" + senttime +", bbtxnid="
                             + bbtxnid + ", publishDate="+publishDate+", sentTs="+sentTs+"]";
     }

}
