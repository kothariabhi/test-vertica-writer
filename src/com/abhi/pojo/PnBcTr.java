package com.abhi.pojo;

import java.util.Arrays;

public class PnBcTr {
	
	private int clientId;
	private int msgId;
	private int automationId;
	private long ts;
	private int[] userId;
	private String[] pushId;
	private String status;
	private String trId;
	private String[] description;
	private String eventType;
	private int identified;
	private String appId;
	private int[] bod;
	private String[] token;
	private String siteId;
	private String browser;
	private int sourceId;
	private boolean skip;
	private String os;
	
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
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public int[] getUserId() {
		return userId;
	}
	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	public String[] getPushId() {
		return pushId;
	}
	public void setPushId(String[] pushId) {
		this.pushId = pushId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public int getIdentified() {
		return identified;
	}
	public void setIdentified(int identified) {
		this.identified = identified;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public int[] getBod() {
		return bod;
	}
	public void setBod(int[] bod) {
		this.bod = bod;
	}
	public String[] getToken() {
		return token;
	}
	public void setToken(String[] token) {
		this.token = token;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public boolean isSkip() {
		return skip;
	}
	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
	@Override
	public String toString() {
		return "PnBcTr [clientId=" + clientId + ", msgId=" + msgId + ", automationId=" + automationId + ", ts=" + ts
				+ ", userId=" + Arrays.toString(userId) + ", pushId=" + Arrays.toString(pushId) + ", status=" + status
				+ ", trId=" + trId + ", description=" + Arrays.toString(description) + ", eventType=" + eventType
				+ ", identified=" + identified + ", appId=" + appId + ", bod=" + Arrays.toString(bod) + ", token="
				+ Arrays.toString(token) + ", siteId=" + siteId + ", browser=" + browser + ", sourceId=" + sourceId
				+ ", skip=" + skip + ", os=" + os + "]";
	}
	
}