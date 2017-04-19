package com.crazymonkey.jersey.grizzly;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TestJson {
	/*
	@XmlElement(name="rT")
	private String RequestType = null;

	@XmlElement(name="v")
	private String Version = null;

	@XmlElement(name="aId")
	private String ApplicationID = null;
	
	@XmlElement(name="l")
	private String Length = null;

	@XmlElement(name="cC")
	private String CommandCode = null;
	
	@XmlElement(name="eeId")
	private String EndToEndIdentifier = null;

	@XmlElement(name="hhId")
	private String HopByHopIdentifier = null;

	@XmlElement(name="rF")
	private String RequestFlag = null;
	
	@XmlElement(name="pF")
	private String ProxiableFlag = null;

	@XmlElement(name="eF")
	private String ErrorFlag = null;
	
	@XmlElement(name="rtF")
	private String RetransmitFlag = null;
	*/
	@XmlElement(name="sId")
	String SessionId;
	
	@XmlElement(name="auaId")
	String AuthApplicationId;
	
	@XmlElement(name="oH")
	String OriginHost;
	
	@XmlElement(name="oR")
	String OriginRealm;
	
	@XmlElement(name="dH")
	private String DestinationHost = null;
	
	@XmlElement(name="dR")
	private String DestinationRealm = null;
	
	@XmlElement(name="ccrT")
	Integer CCRequestType;
	
	@XmlElement(name="ccrN")
	Integer CCRequestNumber;
	
	@XmlElement(name="rC")
	String ResultCode;
	

	/*
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getApplicationID() {
		return ApplicationID;
	}
	public void setApplicationID(String applicationID) {
		ApplicationID = applicationID;
	}
	public String getLength() {
		return Length;
	}
	public void setLength(String length) {
		Length = length;
	}
	public String getCommandCode() {
		return CommandCode;
	}
	public void setCommandCode(String commandCode) {
		CommandCode = commandCode;
	}
	public String getEndToEndIdentifier() {
		return EndToEndIdentifier;
	}
	public void setEndToEndIdentifier(String endToEndIdentifier) {
		EndToEndIdentifier = endToEndIdentifier;
	}
	public String getHopByHopIdentifier() {
		return HopByHopIdentifier;
	}
	public void setHopByHopIdentifier(String hopByHopIdentifier) {
		HopByHopIdentifier = hopByHopIdentifier;
	}
	public String getRequestFlag() {
		return RequestFlag;
	}
	public void setRequestFlag(String requestFlag) {
		RequestFlag = requestFlag;
	}
	public String getProxiableFlag() {
		return ProxiableFlag;
	}
	public void setProxiableFlag(String proxiableFlag) {
		ProxiableFlag = proxiableFlag;
	}
	public String getErrorFlag() {
		return ErrorFlag;
	}
	public void setErrorFlag(String errorFlag) {
		ErrorFlag = errorFlag;
	}
	public String getRetransmitFlag() {
		return RetransmitFlag;
	}
	public void setRetransmitFlag(String retransmitFlag) {
		RetransmitFlag = retransmitFlag;
	}
	*/
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String sessionId) {
		this.SessionId = sessionId;
	}
	public String getAuthApplicationId() {
		return AuthApplicationId;
	}
	public void setAuthApplicationId(String authApplicationId) {
		this.AuthApplicationId = authApplicationId;
	}
	public String getOriginHost() {
		return OriginHost;
	}
	public void setOriginHost(String originHost) {
		this.OriginHost = originHost;
	}
	public String getOriginRealm() {
		return OriginRealm;
	}
	public void setOriginRealm(String originRealm) {
		this.OriginRealm = originRealm;
	}
	public String getDestinationHost() {
		return DestinationHost;
	}
	public void setDestinationHost(String destinationHost) {
		DestinationHost = destinationHost;
	}
	public String getDestinationRealm() {
		return DestinationRealm;
	}
	public void setDestinationRealm(String destinationRealm) {
		DestinationRealm = destinationRealm;
	}
	public Integer getCCRequestType() {
		return CCRequestType;
	}
	public void setCCRequestType(Integer cCRequestType) {
		this.CCRequestType = cCRequestType;
	}
	public Integer getCCRequestNumber() {
		return CCRequestNumber;
	}
	public void setCCRequestNumber(Integer cCRequestNumber) {
		this.CCRequestNumber = cCRequestNumber;
	}
	public String getResultCode() {
		return ResultCode;
	}
	public void setResultCode(String resultCode) {
		this.ResultCode = resultCode;
	}
	/*
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	*/
	public TestJson() {
		super();
		SessionId = "";
		AuthApplicationId = "";
		OriginHost = "";
		OriginRealm = "";
		DestinationHost = "";
		DestinationRealm = "";
		CCRequestType = 0;
		CCRequestNumber = 0;
		ResultCode = "";		
	}
	
	public TestJson(String sessionId, String authApplicationId, String originHost, String originRealm,
			String destinationHost, String destinationRealm, Integer cCRequestType, Integer cCRequestNumber,
			String resultCode) {
		super();
		SessionId = sessionId;
		AuthApplicationId = authApplicationId;
		OriginHost = originHost;
		OriginRealm = originRealm;
		DestinationHost = destinationHost;
		DestinationRealm = destinationRealm;
		CCRequestType = cCRequestType;
		CCRequestNumber = cCRequestNumber;
		ResultCode = resultCode;
	}
}
