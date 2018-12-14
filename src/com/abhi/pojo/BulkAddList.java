package com.abhi.pojo;

import java.util.Arrays;
import java.util.List;

public class BulkAddList {

	private int clientId;
	private String url;
	private int[] list;
	private String[] attr;
	private String[] dataType;
	private long ts;
	private int sendToEaf;
	private int wc;
	private String foreignKey;
	private int cwc;
	private String responseKey;
	private String statusFlags;
	private String jobId;
	private String progressKey;
	private int proIncrCount;
	private List<List<String>> data;
	private int staticList;
	private int emailCount;
	private int mobileCount;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int[] getList() {
		return list;
	}

	public void setList(int[] list) {
		this.list = list;
	}

	public String[] getAttr() {
		return attr;
	}

	public void setAttr(String[] attr) {
		this.attr = attr;
	}

	public String[] getDataType() {
		return dataType;
	}

	public void setDataType(String[] dataType) {
		this.dataType = dataType;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public int getSendToEaf() {
		return sendToEaf;
	}

	public void setSendToEaf(int sendToEaf) {
		this.sendToEaf = sendToEaf;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public int getCwc() {
		return cwc;
	}

	public void setCwc(int cwc) {
		this.cwc = cwc;
	}

	public String getResponseKey() {
		return responseKey;
	}

	public void setResponseKey(String responseKey) {
		this.responseKey = responseKey;
	}

	public String getStatusFlags() {
		return statusFlags;
	}

	public void setStatusFlags(String statusFlags) {
		this.statusFlags = statusFlags;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getProgressKey() {
		return progressKey;
	}

	public void setProgressKey(String progressKey) {
		this.progressKey = progressKey;
	}

	public int getProIncrCount() {
		return proIncrCount;
	}

	public void setProIncrCount(int proIncrCount) {
		this.proIncrCount = proIncrCount;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}

	public int getStaticList() {
		return staticList;
	}

	public void setStaticList(int staticList) {
		this.staticList = staticList;
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

	@Override
	public String toString() {
		return "BulkAddList [clientId=" + clientId + ", url=" + url + ", list=" + Arrays.toString(list) + ", attr="
				+ Arrays.toString(attr) + ", dataType=" + Arrays.toString(dataType) + ", ts=" + ts + ", sendToEaf="
				+ sendToEaf + ", wc=" + wc + ", foreignKey=" + foreignKey + ", cwc=" + cwc + ", responseKey="
				+ responseKey + ", statusFlags=" + statusFlags + ", jobId=" + jobId + ", progressKey=" + progressKey
				+ ", proIncrCount=" + proIncrCount + ", data=" + data + ", staticList=" + staticList + ", emailCount="
				+ emailCount + ", mobileCount=" + mobileCount + "]";
	}

}