package org.mule.modules.anypointplatform.analytics;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.anypointplatform.analytics.config.ConnectorConfig;
import org.mule.modules.anypointplatform.analytics.config.DefaultResponseHandler;

@Connector(name="anypoint-platform-analytics", friendlyName="Anypoint Platform Analytics")
public class AnypointPlatformAnalyticsConnector {
    private static String API_PLATFROM_BASE_URI = "https://anypoint.mulesoft.com/analytics/1.0";
	
    @Config
    ConnectorConfig config;
    
    protected String getUriFor(String resource) {
    	return API_PLATFROM_BASE_URI + resource;
    }

    /**
     * Gets all the apis from the api platform
     *
     * {@sample.xml ../../../doc/anypoint-platform-connector.xml.sample anypoint-platform:greet}
     *
     * @return this list of apis
     * @throws IOException 
     * @throws ClientProtocolException 
     * @throws JSONException 
     */
    @Processor
    public JSONArray getEvents(String apiId, List<String> fields, String startDate, String endDate, EventFormat format) throws ClientProtocolException, IOException, JSONException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String url = String.format("/%s/events?format=%s&apiIds=%s&fields=%s&startDate=%s&endDate=%s", this.config.getOrganizationId(), format.value, apiId, StringUtils.join(fields, "."), startDate, endDate);
        HttpGet getAPIsRequest = new HttpGet(this.getUriFor(url));
        getAPIsRequest.addHeader("Authorization", "Bearer " + this.config.getSessionAccessToken());
        getAPIsRequest.addHeader("Content-Type", "application/json");
        String sessionResponseBody = httpClient.execute(getAPIsRequest, new DefaultResponseHandler());
        return new JSONArray(sessionResponseBody);
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
    
    public enum EventFormat {
    	JSON("json"),
    	CSV("csv");
    	 
    	private String value;

		private EventFormat(String value) {
			this.value = value;
		}
    	
    	
    }

}