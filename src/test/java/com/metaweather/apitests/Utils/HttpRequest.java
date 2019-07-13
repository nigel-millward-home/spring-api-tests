package com.metaweather.apitests.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpRequest {

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> sendRequest(HttpMethod httpMethod, String url, HttpEntity<?> httpEntity, Map<String, String> uriVariables)
    {
        logging(url, httpMethod, httpEntity);
        return restTemplate.exchange(url, httpMethod, httpEntity, String.class, uriVariables);
    }

    public ResponseEntity<String> sendRequest(HttpMethod httpMethod, String url)
    {
        return sendRequest(httpMethod, url, HttpEntity.EMPTY, null);
    }

    public ResponseEntity<String> sendRequest(HttpMethod httpMethod, String url, Map<String, String> uriVariables)
    {
        return sendRequest(httpMethod, url, HttpEntity.EMPTY, uriVariables);
    }


    private void logging(String url, HttpMethod httpMethod, HttpEntity<?> httpEntity)
    {
        Logger log = LogManager.getLogger();
        log.info("\n");
        log.info("HTTP METHOD: " + httpMethod);
        log.info("URL: " + url);
        log.info("HEADERS : " + httpEntity.getHeaders());
        log.info("BODY : " + httpEntity.getBody());
        log.info("\n");
    }

}
