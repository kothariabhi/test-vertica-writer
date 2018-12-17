package com.abhi.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class NGNAppAct {

	// fixed
	private String appId;
	private String pushId;
	private String sessionId; // TODO decide whether long or string?
	private String identity;
	private String oldIdentity;
	private long tx;
	private String token;
	private String oldToken;
	private String adId;
	private String osType;
	private String make;
	private String model;
	private String osVersion;
	private String appName;
	private String appVersion;
	private String sdkVersion;
	private long cts;
	private String lat;
	private String lng;
	private String profileDetails;
	private Map<String, Object> payload;
	private String trId;
	private String action;
	private String atcm;
	private int atci;
	private String atcs;
	private int isAmplified;
	private String apnClickLink;
	private String eventName;
	private String cg;
	private String msgId;
	private String utmSource;
	private String utmMedium;
	private String utmCampaign;
	private String utmContent;
	private String utmTerm;

	// derived
	private int clientId;
	private Integer userId; // can be null
	private boolean identified;
	private int eventId;
	private int bod;
	private String deviceDetails;
	private long ts;
	private Date tsDate;
	private Integer osId;
	private String eventType;
	private List<Double> coordinates;
	private int channelId;

	// not confirmed but getting used in code .
	private String uniqueId;
	private String clientKey;
	private String messageId;
	private String device;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getOldIdentity() {
		return oldIdentity;
	}

	public void setOldIdentity(String oldIdentity) {
		this.oldIdentity = oldIdentity;
	}

	public long getTx() {
		return tx;
	}

	public void setTx(long tx) {
		this.tx = tx;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOldToken() {
		return oldToken;
	}

	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public long getCts() {
		return cts;
	}

	public void setCts(long cts) {
		this.cts = cts;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getProfileDetails() {
		return profileDetails;
	}

	public void setProfileDetails(String profileDetails) {
		this.profileDetails = profileDetails;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAtcm() {
		return atcm;
	}

	public void setAtcm(String atcm) {
		this.atcm = atcm;
	}

	public int getAtci() {
		return atci;
	}

	public void setAtci(int atci) {
		this.atci = atci;
	}

	public String getAtcs() {
		return atcs;
	}

	public void setAtcs(String atcs) {
		this.atcs = atcs;
	}

	public int getIsAmplified() {
		return isAmplified;
	}

	public void setIsAmplified(int isAmplified) {
		this.isAmplified = isAmplified;
	}

	public String getApnClickLink() {
		return apnClickLink;
	}

	public void setApnClickLink(String apnClickLink) {
		this.apnClickLink = apnClickLink;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getUtmSource() {
		return utmSource;
	}

	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}

	public String getUtmMedium() {
		return utmMedium;
	}

	public void setUtmMedium(String utmMedium) {
		this.utmMedium = utmMedium;
	}

	public String getUtmCampaign() {
		return utmCampaign;
	}

	public void setUtmCampaign(String utmCampaign) {
		this.utmCampaign = utmCampaign;
	}

	public String getUtmContent() {
		return utmContent;
	}

	public void setUtmContent(String utmContent) {
		this.utmContent = utmContent;
	}

	public String getUtmTerm() {
		return utmTerm;
	}

	public void setUtmTerm(String utmTerm) {
		this.utmTerm = utmTerm;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(boolean identified) {
		this.identified = identified;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getBod() {
		return bod;
	}

	public void setBod(int bod) {
		this.bod = bod;
	}

	public String getDeviceDetails() {
		return deviceDetails;
	}

	public void setDeviceDetails(String deviceDetails) {
		this.deviceDetails = deviceDetails;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public Date getTsDate() {
		return tsDate;
	}

	public void setTsDate(Date tsDate) {
		this.tsDate = tsDate;
	}

	public Integer getOsId() {
		return osId;
	}

	public void setOsId(Integer osId) {
		this.osId = osId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

}
