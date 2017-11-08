package domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * CRUD API for Network Connection Manager
 */

public class NetConnectionManager {
	private static NetConnectionDb ncdb = new NetConnectionDb();
	static {// Add some dummy netconnection for testing
		final Map<String, Object> cpdata1 = new LinkedHashMap<String, Object>(6);
		cpdata1.put("connectionPointID", "cp0001_abc_123");
		cpdata1.put("cpName", "cp001");
		cpdata1.put("type", "hostAggreg01");
		cpdata1.put("order", "12");
		cpdata1.put("isDefault", "true");
		cpdata1.put("antiSpoof", "true");
		final Map<String, Object> cpdata2 = new LinkedHashMap<String, Object>(6);
		cpdata2.put("connectionPointID", "cp0002_abc_123");
		cpdata2.put("cpName", "cp002");
		cpdata2.put("type", "hostAggreg01");
		cpdata2.put("order", "12");
		cpdata2.put("isDefault", "true");
		cpdata2.put("antiSpoof", "true");
		final Map<String, Object> vldata1 = new LinkedHashMap<String, Object>(9);
		vldata1.put("virtualLinkID", "vl001_uu001");
		vldata1.put("vlName", "VLsansumgLink001");
		vldata1.put("type", "ELAN");
		vldata1.put("tenant_vlan", "40");
		vldata1.put("ipVersion", "ipv6");
		vldata1.put("networkID", "VNFC1");
		vldata1.put("segmentationID", "VNFC1");
		vldata1.put("networkType", "vlan");
		vldata1.put("dhcp", "true");
		final Map<String, Object> vldata2 = new LinkedHashMap<String, Object>(9);
		vldata1.put("virtualLinkID", "vl002_uu002");
		vldata1.put("vlName", "VLsansumgLink002");
		vldata1.put("type", "ELAN");
		vldata1.put("tenant_vlan", "40");
		vldata1.put("ipVersion", "ipv6");
		vldata1.put("networkID", "VNFC1");
		vldata1.put("segmentationID", "VNFC1");
		vldata1.put("networkType", "vlan");
		vldata1.put("dhcp", "true");
		
		List<vl> vllist1 = new ArrayList<vl>();
		final vl vl1 = new vl(vldata1);
		final vl vl2 = new vl(vldata2);
		vllist1.add(vl1);
		vllist1.add(vl2);
		
		List<cp> cplist1 = new ArrayList<cp>();
		final cp cp1 = new cp(cpdata1);
		final cp cp2 = new cp(cpdata2);
		cplist1.add(cp1);
		cplist1.add(cp2);
		
		final nc nc1 = new nc("vnfc_pcrf_001_deepak", cplist1, vllist1);
		List<nc> nclist1 = new ArrayList<nc>();
		nclist1.add(nc1);
		
		final Map<String, Object> cpdata3 = new LinkedHashMap<String, Object>(6);
		cpdata3.put("connectionPointID", "cp0003_abc_123");
		cpdata3.put("cpName", "cp003");
		cpdata3.put("type", "hostAggreg01");
		cpdata3.put("order", "12");
		cpdata3.put("isDefault", "true");
		cpdata3.put("antiSpoof", "true");
		final Map<String, Object> cpdata4 = new LinkedHashMap<String, Object>(6);
		cpdata4.put("connectionPointID", "cp0004_abc_123");
		cpdata4.put("cpName", "cp002");
		cpdata4.put("type", "hostAggreg01");
		cpdata4.put("order", "12");
		cpdata4.put("isDefault", "true");
		cpdata4.put("antiSpoof", "true");
		final Map<String, Object> vldata3 = new LinkedHashMap<String, Object>(9);
		vldata3.put("virtualLinkID", "vl003_uu001");
		vldata3.put("vlName", "VLsansumgLink001");
		vldata3.put("type", "ELAN");
		vldata3.put("tenant_vlan", "40");
		vldata3.put("ipVersion", "ipv6");
		vldata3.put("networkID", "VNFC1");
		vldata3.put("segmentationID", "VNFC1");
		vldata3.put("networkType", "vlan");
		vldata3.put("dhcp", "true");
		
		List<vl> vllist2 = new ArrayList<vl>();
		final vl vl3 = new vl(vldata3);
		vllist2.add(vl3);
		
		List<cp> cplist2 = new ArrayList<cp>();
		final cp cp3 = new cp(cpdata3);
		final cp cp4 = new cp(cpdata4);
		cplist2.add(cp3);
		cplist2.add(cp4);
		
		final nc nc2 = new nc( "vnfc_pcrf_002_deepak", cplist2, vllist2);
		nclist1.add(nc2);
		
		ncdb.add_static(new NetConnection(nclist1), "vnf_pcrf_01_deepak", "vlan_subnet_01");

	}
	
	/*
	 * Get one specified NC from a vnf and netConnection_ID
	 */
	/*public static NetConnection finds(String vnfID, String netConnectionID){
		NetConnection nc = ncdb.find(vnfID, netConnectionID);
		return((nc == null)?null:nc);
	}*/
	public static Map<String,Object> find(String vnfID, String netConnectionID){
		Map<String,Object> nc = ncdb.find(vnfID, netConnectionID);
		return((nc == null)?null:nc);
	}
	
	/*
	 * POST - Add a NC
	 */
	public static void add(NetConnection nc, String vnfID) {
		ncdb.add(nc, vnfID);
		System.out.println("add hit here \n"+ nc.vnfID);
	}

	/*
	 * @DELETE - Delete a NC 
	 */
	public static void delete(String name, String netConnectionID) {
		//NetConnection nc = finds(name, netConnectionID);
		//ncdb.remove(nc);
	}
	
	/*
	 * @PUT - Update a NC
	 */
	public static NetConnection update(NetConnection nc, String vnfID, String netConnectionID) {
	//	NetConnection nc_origin = find(vnfID, netConnectionID);
	//	if (nc_origin == null) {
		//	return null;
	//	}
		
		/*
		 * Delete the old NC
		 */
	//	delete(nc_origin.getVnfID(), netConnectionID);
	//	add(nc, vnfID);
		return nc;
	}
	
	/*
	 * GET VL from vnfc
	 
	public static VirtualLink find_vl_from_vnfc(String vnfc_name) {
		ncdb.init();
		VirtualLink vl = ncdb.find_vl_from_vnfc(vnfc_name);
		ncdb.close();
		return vl;
	
	}
	*/

}
