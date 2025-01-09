package cz.uhk.kppro.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    private final String API_KEY = "6177747defd440e2bad103510250901";
    private final String URL = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=";

    public String getAPIURL(String city){
        return URL + city;
    }

    public String getTemp(String city) {
        city = URLEncoder.encode(city, StandardCharsets.UTF_8);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(getAPIURL(city))
                .build();

        try (Response response = client.newCall(request).execute()) {
            String output = response.body().string();
            JSONObject node = new JSONObject(output);
            JSONObject current = node.getJSONObject("current");
            float temp = current.getFloat("temp_c");
            return String.valueOf(temp) + " °C";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }
}
