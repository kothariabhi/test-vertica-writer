package com.abhi.pojo;

public class EmLt {
	
	private int clientId;
	private int msgId;
	private int userId;
	private String activity;
	private int bod;
	private int cosci;
	private String ip;
	private int linkId;
	private long ts;
	private String trId;
	private int automationId;
	private Integer domainId;
	
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
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getBod() {
		return bod;
	}
	public void setBod(int bod) {
		this.bod = bod;
	}
	public int getCosci() {
		return cosci;
	}
	public void setCosci(int cosci) {
		this.cosci = cosci;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public Integer getDomainId() {
		return domainId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}
	@Override
	public String toString() {
		return "EmLt [clientId=" + clientId + ", msgId=" + msgId + ", userId=" + userId + ", activity=" + activity
				+ ", bod=" + bod + ", cosci=" + cosci + ", ip=" + ip + ", linkId=" + linkId + ", ts=" + ts + ", trId="
				+ trId + ", automationId=" + automationId + ", domainId=" + domainId + "]";
	}
	
}