package com.metaweather.apitests.Utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiMethods
{
    private MWPaths paths = new MWPaths();
    private HttpRequest httpRequest = new HttpRequest();

    public ResponseEntity<String> locationSearchQuery(String query)
    {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("query", query);

        return httpRequest.sendRequest( HttpMethod.GET, MWPaths.BASE_URL + paths.locationSearchQuery, uriVariables);
    }

    public ResponseEntity<String> location(String woeid)
    {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("woeid", woeid);

        return httpRequest.sendRequest( HttpMethod.GET, MWPaths.BASE_URL + paths.locationWoeid, uriVariables);
    }

    public ResponseEntity<String> locationDay(String woeid, String date)
    {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("woeid", woeid);
        uriVariables.put("date", date);

        return httpRequest.sendRequest( HttpMethod.GET, MWPaths.BASE_URL + paths.locationDay);
    }
}
