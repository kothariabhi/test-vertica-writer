package com.abhi.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class PushQuery {

	private Integer userId; // can be null
	private int clientId;
	private String appId;
	private String pushId;
	private String token;
	private String identity;
	private String action;
	private String osType;
	private Integer osId;
	private String osVersion;
	private String appVersion;
	private String sdkVersion;
	private String trId;
	private String location;
	private long ts;
	private long cts;
	private Date tsDate;
	private Date ctsDate;
	private String lat;
	private String lng;
	private Double latDouble;
	private Double lngDouble;
	private List<Map<String, Object>> payload;
	private Map<String, Object> payloadMap;
	private String device;
	private boolean identified;
	private String sessionId; // TODO decide whether long or string?
	private long tx;
	private int eventId;
	// private String ipaddress;
	private String messageId;
	private int channelId;
	private int pts;
	private int sts;
	private String deepLink;
	private int bod;
	private String notificationType;
	private String uniqueId;
	private String clientKey;
	private String make;
	private String model;
	private int automationId;
	private String eventType;
	private String atcm;
	private int atci;
	private String oldToken;
	private List<Double> coordinates;
	private String apnClickLink;
	private String clickLink;
	private Integer clickLinkId;
	private Integer mid;
	private String cg;
	private Integer cgRepeat;

	public PushQuery() {
		super();
	}

	public PushQuery(Integer userId, int clientId, String appId, String pushId, String token, String identity,
			String action, String osType, Integer osId, String osVersion, String appVersion, String sdkVersion,
			String trId, String location, long ts, long cts, Date tsDate, Date ctsDate, String lat, String lng,
			Double latDouble, Double lngDouble, List<Map<String, Object>> payload, Map<String, Object> payloadMap,
			String device, boolean identified, String sessionId, long tx, int eventId, String messageId, int channelId,
			int pts, int sts, String deepLink, int bod, String notificationType, String uniqueId, String clientKey,
			String make, String model, int automationId, String eventType, String atcm, int atci, String oldToken,
			List<Double> coordinates, String apnClickLink, String clickLink, Integer clickLinkId, Integer mid,
			String cg, Integer cgRepeat) {
		super();
		this.userId = userId;
		this.clientId = clientId;
		this.appId = appId;
		this.pushId = pushId;
		this.token = token;
		this.identity = identity;
		this.action = action;
		this.osType = osType;
		this.osId = osId;
		this.osVersion = osVersion;
		this.appVersion = appVersion;
		this.sdkVersion = sdkVersion;
		this.trId = trId;
		this.location = location;
		this.ts = ts;
		this.cts = cts;
		this.tsDate = tsDate;
		this.ctsDate = ctsDate;
		this.lat = lat;
		this.lng = lng;
		this.latDouble = latDouble;
		this.lngDouble = lngDouble;
		this.payload = payload;
		this.payloadMap = payloadMap;
		this.device = device;
		this.identified = identified;
		this.sessionId = sessionId;
		this.tx = tx;
		this.eventId = eventId;
		this.messageId = messageId;
		this.channelId = channelId;
		this.pts = pts;
		this.sts = sts;
		this.deepLink = deepLink;
		this.bod = bod;
		this.notificationType = notificationType;
		this.uniqueId = uniqueId;
		this.clientKey = clientKey;
		this.make = make;
		this.model = model;
		this.automationId = automationId;
		this.eventType = eventType;
		this.atcm = atcm;
		this.atci = atci;
		this.oldToken = oldToken;
		this.coordinates = coordinates;
		this.apnClickLink = apnClickLink;
		this.clickLink = clickLink;
		this.clickLinkId = clickLinkId;
		this.mid = mid;
		this.cg = cg;
		this.cgRepeat = cgRepeat;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
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

	public Double getLatDouble() {
		return latDouble;
	}

	public void setLatDouble(Double latDouble) {
		this.latDouble = latDouble;
	}

	public Double getLngDouble() {
		return lngDouble;
	}

	public void setLngDouble(Double lngDouble) {
		this.lngDouble = lngDouble;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(boolean identified) {
		this.identified = identified;
	}

	public Date getTsDate() {
		return tsDate;
	}

	public void setTsDate(Date tsDate) {
		this.tsDate = tsDate;
	}

	public Date getCtsDate() {
		return ctsDate;
	}

	public void setCtsDate(Date ctsDate) {
		this.ctsDate = ctsDate;
	}

	public long getTx() {
		return tx;
	}

	public void setTx(long tx) {
		this.tx = tx;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getSts() {
		return sts;
	}

	public void setSts(int sts) {
		this.sts = sts;
	}

	public int getBod() {
		return bod;
	}

	public void setBod(int bod) {
		this.bod = bod;
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

	public int getAutomationId() {
		return automationId;
	}

	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
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

	public String getOldToken() {
		return oldToken;
	}

	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getApnClickLink() {
		return apnClickLink;
	}

	public void setApnClickLink(String apnClickLink) {
		this.apnClickLink = apnClickLink;
	}

	public void setClickLink(String clickLink) {
		this.clickLink = clickLink;

	}

	public String getClickLink() {
		return clickLink;

	}

	public void setClickLinkId(Integer id) {
		this.clickLinkId = id;
	}

	public Integer getClickLinkId() {
		return this.clickLinkId;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getCgRepeat() {
		return cgRepeat;
	}

	public void setCgRepeat(Integer cgRepeat) {
		this.cgRepeat = cgRepeat;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

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

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public Integer getOsId() {
		return osId;
	}

	public void setOsId(Integer osId) {
		this.osId = osId;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
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

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public List<Map<String, Object>> getPayload() {
		return payload;
	}

	public void setPayload(List<Map<String, Object>> payload) {
		this.payload = payload;
	}

	public Map<String, Object> getPayloadMap() {
		return payloadMap;
	}

	public void setPayloadMap(Map<String, Object> payloadMap) {
		this.payloadMap = payloadMap;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getDeepLink() {
		return deepLink;
	}

	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
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

}
