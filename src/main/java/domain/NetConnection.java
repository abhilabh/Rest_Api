package domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Data holder for Network Connection
 * @author Deepak Agrawal
 */
class cp {
	private Map<String, Object> ConnectionPointData;
	public cp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cp(final Map<String, Object> connectionPointData) {
		super();
		ConnectionPointData = connectionPointData;
	}
	public Map<String, Object> getConnectionPointData() {
		return ConnectionPointData;
	}
	public void setConnectionPointData(Map<String, Object> connectionPointData) {
		ConnectionPointData = connectionPointData;
	}
	
}

class vl {
	private Map<String, Object> VirtualLink;

	public vl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public vl(Map<String, Object> virtualLink) {
		super();
		VirtualLink = virtualLink;
	}

	public Map<String, Object> getVirtualLink() {
		return VirtualLink;
	}

	public void setVirtualLink(Map<String, Object> virtualLink) {
		VirtualLink = virtualLink;
	}
	
	
}

class nc {
	String vnfcID;
	List<cp> ConnectionPointDataList;
	List<vl> VirtualLinkList;
	
	public nc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public nc(String vnfcID, List<cp> connectionPointDataList, List<vl> virtualLinkList) {
		super();
		this.vnfcID = vnfcID;
		ConnectionPointDataList = connectionPointDataList;
		VirtualLinkList = virtualLinkList;
	}

	public String getVnfcID() {
		return vnfcID;
	}

	public void setVnfcID(String vnfcID) {
		this.vnfcID = vnfcID;
	}

	public List<cp> getConnectionPointDataList() {
		return ConnectionPointDataList;
	}

	public void setConnectionPointDataList(List<cp> connectionPointDataList) {
		ConnectionPointDataList = connectionPointDataList;
	}

	public List<vl> getVirtualLinkList() {
		return VirtualLinkList;
	}

	public void setVirtualLinkList(List<vl> virtualLinkList) {
		VirtualLinkList = virtualLinkList;
	}
}

@XmlRootElement
public class NetConnection {
	String networkConnectionID;
	String vnfID;
	List<nc> networkConnectionInfo;
    String uuid;
    Date time_created;
    
	public NetConnection() {
		super();
		// TODO Auto-generated constructor stub
		this.uuid = UUID.randomUUID().toString();
		this.time_created = new Date();
	}

	public NetConnection(List<nc> networkConnectionInfo) {
		super();
		this.networkConnectionInfo = networkConnectionInfo;
		this.uuid = UUID.randomUUID().toString();
		this.time_created = new Date();
	}

	public String getNetworkConnectionID() {
		return networkConnectionID;
	}

	public void setNetworkConnectionID(String networkConnectionID) {
		this.networkConnectionID = networkConnectionID;
	}

	public List<nc> getNetworkConnectionInfo() {
		return networkConnectionInfo;
	}

	public void setNetworkConnectionInfo(List<nc> networkConnectionInfo) {
		this.networkConnectionInfo = networkConnectionInfo;
	}

	public String getVnfID() {
		return vnfID;
	}

	public void setVnfID(String vnfID) {
		this.vnfID = vnfID;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getTime_created() {
		return time_created;
	}

	public void setTime_created(Date time_created) {
		this.time_created = time_created;
	}

	
}
