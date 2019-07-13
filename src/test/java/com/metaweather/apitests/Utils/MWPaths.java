package com.metaweather.apitests.Utils;

public class MWPaths
{
   public static final String  BASE_URL = "https://www.metaweather.com";

   public String locationSearchQuery = "/api/location/search/?query={query}";
   public String locationSearchLattLong = "/api/location/search/?lattlong={latt},{long}";
   public String locationWoeid = "/api/location/{woeid}/";
   public String locationDay = "/api/location/{woeid}/{date}/";
}
