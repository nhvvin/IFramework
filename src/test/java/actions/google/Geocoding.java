package actions.google;

import com.sss.selenium.IFrameworkAssert;
import com.sss.utility.IFrameworkRESTFullAPI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Geocoding {
    private static JSONObject getLocation(String address) throws Exception {
        JSONObject resultJson = IFrameworkRESTFullAPI.getInstance().sendGet(String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=AIzaSyAoUX7VgD_Q7JtXfkfQW3H86QhJAdCysy8", address));
        JSONArray results = (JSONArray) resultJson.get("results");
        if (!results.isEmpty()) {
            JSONObject result = (JSONObject) results.get(0);
            JSONObject geometry = (JSONObject) result.get("geometry");
            return (JSONObject) geometry.get("location");
        }
        return new JSONObject();
    }

    public static void verifyLocation(String address, JSONObject expected) throws Exception {
        JSONObject actualLocation = getLocation(address);
        IFrameworkAssert.verifyEquals(actualLocation, expected);
    }
}
