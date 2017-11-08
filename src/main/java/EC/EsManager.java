package EC;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
//import org.apache.logging.log4j.Logger;

public class EsManager {
    private static TransportClient client;
    public boolean initEs() {
    	EsManager.client = connectEs();
    	if(EsManager.client!= null)
    		return true;
    	return false;
    }
	
    public  TransportClient connectEs(){
    	    
        try {
           
        	    Settings settings = Settings.builder()
                    .put("cluster.name", EcConstants.CLUSTER_NAME).build();
			@SuppressWarnings("resource")
			TransportClient client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EcConstants.IPADDRESS),EcConstants.port));
		//	Logger.info();
					
            return client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void closeconn(){
        client.close();
    }

    private boolean indexExists(String indexName,TransportClient transportClient) {
        try {
            return transportClient.admin().indices()
                    .prepareExists(indexName).get().isExists();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean createIndex(String indexName) {
        try {
            return client.admin().indices()
                    .prepareCreate(indexName).get().isAcknowledged();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean StoreNetworkConnectionEC(String vnfid, Map<String,Object> Json){

        String IndexName = "network_connection";
        if(!indexExists(IndexName,client)){
            if(createIndex(IndexName)){
                System.out.println("index created");
            }
        }
        
        client.prepareIndex(IndexName,"ns", vnfid)
                .setSource(Json).get();

        return  true;

    }
    public Map<String, Object> getNetworkConnectionInfo(String vnfID){
      	GetResponse response2 = client.prepareGet("network_connection", "ns", vnfID).get();
      	return response2.getSource();
    }
 }


