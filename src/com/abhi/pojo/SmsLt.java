package com.abhi.pojo;

public class SmsLt {
	
	private int clientId;
	private int msgId;
	private int userId;
	private int linkId;
	private String trId;
	private String ip;
	private String linkText;
	private long ts;
	private int agentCode;
	private int automationId;
	private String foreignKey;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public int getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(int agentCode) {
		this.agentCode = agentCode;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public String getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}
	@Override
	public String toString() {
		return "SmsLt [clientId=" + clientId + ", msgId=" + msgId + ", userId=" + userId + ", linkId=" + linkId
				+ ", trId=" + trId + ", ip=" + ip + ", linkText=" + linkText + ", ts=" + ts + ", agentCode=" + agentCode
				+ ", automationId=" + automationId + ", foreignKey=" + foreignKey + "]";
	}
	
}
