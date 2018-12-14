package com.abhi.pojo;

import java.util.Arrays;
import java.util.Map;

public class SingleAddList {

	private int existing;
	private int clientId;
	private int[] list;
	private int userId;
	private Map<String, Object> attributes;
	private long ts;
	private int sendToEaf;
	private int wc;
	private Integer identified;
	private int emailCount;
	private int mobileCount;
	private Integer whitelisted;

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public Integer getIdentified() {
		return identified;
	}

	public void setIdentified(Integer identified) {
		this.identified = identified;
	}

	public int getEmailCount() {
		return emailCount;
	}

	public void setEmailCount(int emailCount) {
		this.emailCount = emailCount;
	}

	public int getMobileCount() {
		return mobileCount;
	}

	public void setMobileCount(int mobileCount) {
		this.mobileCount = mobileCount;
	}

	public Integer getWhitelisted() {
		return whitelisted;
	}

	public void setWhitelisted(Integer whitelisted) {
		this.whitelisted = whitelisted;
	}

	public int getExisting() {
		return existing;
	}

	public void setExisting(int existing) {
		this.existing = existing;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int[] getList() {
		return list;
	}

	public void setList(int[] list) {
		this.list = list;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSendToEaf() {
		return sendToEaf;
	}

	public void setSendToEaf(int sendToEaf) {
		this.sendToEaf = sendToEaf;
	}

	@Override
	public String toString() {
		return "SingleAddList [existing=" + existing + ", clientId=" + clientId + ", list=" + Arrays.toString(list)
				+ ", userId=" + userId + ", attributes=" + attributes + ", ts=" + ts + ", sendToEaf=" + sendToEaf
				+ ", wc=" + wc + ", identified=" + identified + ", emailCount=" + emailCount + ", mobileCount="
				+ mobileCount + ", whitelisted=" + whitelisted + ", getAttributes()=" + getAttributes() + ", getTs()="
				+ getTs() + ", getWc()=" + getWc() + ", getIdentified()=" + getIdentified() + ", getEmailCount()="
				+ getEmailCount() + ", getMobileCount()=" + getMobileCount() + ", getWhitelisted()=" + getWhitelisted()
				+ ", getExisting()=" + getExisting() + ", getClientId()=" + getClientId() + ", getList()="
				+ Arrays.toString(getList()) + ", getUserId()=" + getUserId() + ", getSendToEaf()=" + getSendToEaf()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}