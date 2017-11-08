package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import EC.EsManager;



/*
 * DB layer to save network connections to DB
 * @author Deepak Agrawal
 */
@XmlRootElement
@XmlSeeAlso(NetConnection.class)
public class NetConnectionDb {
	static List<NetConnection> ncdb = new ArrayList<NetConnection>();
	
	public void add(NetConnection nc, String vnfID) {
		HashMap<String,Object> prim = new HashMap<String,Object>();
		nc.setVnfID(vnfID);
		ncdb.add(nc);
		EsManager es = new EsManager();
		es.initEs();
		prim = convert_to_json(nc,vnfID);
		es.StoreNetworkConnectionEC(vnfID, prim);
		es.closeconn();
		
	}
		
	public HashMap<String,Object>	convert_to_json(NetConnection nc, String vnfID){
		ArrayList<Object> nInfo = new ArrayList<Object>();
		HashMap<String,Object> prim = new HashMap<String,Object>();
		prim.put("vnfID", vnfID);
		HashMap<String,Object> prim2 = new HashMap<String,Object>();
				
		for (nc nc2 : nc.networkConnectionInfo) {
			prim2.put("vnfcID", nc2.getVnfcID());
			ArrayList<Object> vlArr = new ArrayList<Object>();
			
			for (vl VlMC : nc2.getVirtualLinkList()) {
				HashMap<String,Object> vlHash = new HashMap<String,Object>();
				for (Map.Entry<String, Object> entry : VlMC.getVirtualLink().entrySet()) {
				    vlHash.put(entry.getKey(), entry.getValue());
				}
				vlArr.add(vlHash);
			}
			prim2.put("virtualLinkList", vlArr);
			ArrayList<Object> cpArr = new ArrayList<Object>();
			
			for (cp VlMC : nc2.getConnectionPointDataList()) {
				HashMap<String,Object> cpHash = new HashMap<String,Object>();
				for (Map.Entry<String, Object> entry : VlMC.getConnectionPointData().entrySet()) {
				    cpHash.put(entry.getKey(), entry.getValue());
				}
				cpArr.add(cpHash);
			}
			prim2.put("connectionPointDataList", cpArr);
			nInfo.add(prim2);
			
			
		}
		prim.put("networkConnectionInfo", nInfo);
		return prim;
	}

	
	public void add_static(NetConnection nc, String vnfID, String ncID) {
		nc.setVnfID(vnfID);
		nc.setNetworkConnectionID(ncID);
		ncdb.add(nc);
		System.out.printf("vnfID = %s\n", vnfID);
	}
	
	public void remove(NetConnection nc) {
		ncdb.remove(nc);
	
	}
	
	public Map<String,Object> find(String vnfID, String netConnectionID) {
		EsManager es = new EsManager();
		es.initEs();
		Map<String,Object> x = es.getNetworkConnectionInfo(vnfID);
		es.closeconn();
		return x;
		
	}
	
	

}
