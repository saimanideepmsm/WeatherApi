package org.example;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class JsonData
{
    public static JSONObject data;
    public static JSONArray datalist;
    public static HashMap<Object,weathermodel> hm = new HashMap<>();
    public  JsonData() throws IOException, InterruptedException, JSONException
    {
        String url = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
        var getrequest = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var res = client.send(getrequest, HttpResponse.BodyHandlers.ofString());
        String s = res.body();
        JSONObject data = new JSONObject(s);
        datalist = data.getJSONArray("list");
        this.generatedata();

    }
    public void generatedata()
    {
        for(int i=0;i<datalist.length();i++)
        {
//            System.out.println(datalist.getJSONObject(i));
            JSONObject main = (JSONObject) datalist.getJSONObject(i).get("main");
//            System.out.println(main);
            JSONObject windspeed = (JSONObject) datalist.getJSONObject(i).get("wind");
            weathermodel model =new weathermodel();
            model.setPressure(main.get("pressure"));
            model.setTemperature(main.get("temp"));
            model.setWindspeed(windspeed.get("speed"));
            String date = datalist.getJSONObject(i).get("dt_txt").toString().substring(0,10);
            hm.put(date,model);
        }
        System.out.println(hm);
    }
}

