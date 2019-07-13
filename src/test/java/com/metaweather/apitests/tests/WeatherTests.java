package com.metaweather.apitests.tests;

import com.jayway.jsonpath.JsonPath;
import com.metaweather.apitests.Utils.AbstractTest;
import com.metaweather.apitests.Utils.ApiMethods;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class WeatherTests  extends AbstractTest {

    @Test
    public void getWeatherForLocation()
    {
        ResponseEntity<String> response = apiMethods.location("44418");
        assertEquals(response.getStatusCodeValue(), 200);

        String responseBody = response.getBody();
        String weatherForDay = JsonPath.read(responseBody, "$.consolidated_weather[0].weather_state_name");
        assertEquals("Showers", weatherForDay);
    }

    @Test
    public void getLocationSearchByQuery() throws JSONException {
        ResponseEntity<String> response = apiMethods.locationSearchQuery("london");
        assertEquals(response.getStatusCodeValue(), 200);

        String responseBody = response.getBody();

        JSONArray jsonArray = new JSONArray(responseBody);
        JSONObject obj = jsonArray.getJSONObject(0);

        String title = obj.getString("title");
        String locationType = obj.getString("location_type");
        String latlong = obj.getString("latt_long");

        assertEquals("London",title);
        assertEquals("City",locationType);
        assertEquals("51.506321,-0.12714",latlong);
    }
}
