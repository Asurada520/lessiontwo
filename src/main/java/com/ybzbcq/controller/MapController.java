package com.ybzbcq.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



@RestController
@RequestMapping("/map/")
public class MapController {

//    public static void main(String[] args){
//        String start = "苏州市吴中区石湖东路";
//        String end = "苏州市姑苏区和基广场";
//
//        String startLonLat = getLonLat(start);
//        String endLonLat = getLonLat(end);
//
//        System.out.println(startLonLat);
//        System.out.println(endLonLat);
//        Long dis = getDistance(startLonLat,endLonLat);
//        System.out.println(dis);
//    }
    @RequestMapping(value = "getDistance", method = RequestMethod.GET)
    public String getDistanceReal(@RequestParam("start") String start, @RequestParam("end")String end){
//        String start = "苏州市吴中区石湖东路";
//        String end = "苏州市姑苏区和基广场";

        System.out.println(start);
        System.out.println(end);

        String startLonLat = getLonLat(start);
        String endLonLat = getLonLat(end);

        System.out.println(startLonLat);
        System.out.println(endLonLat);
        Long dis = getDistance(startLonLat,endLonLat);
        System.out.println(dis);

        return dis/1000.0+"";
    }



    private static String getLonLat(String address){
        //返回输入地址address的经纬度信息, 格式是 经度,纬度
        //  http://restapi.amap.com/v3/geocode/geo?key=d871ac8972f969b5bd65a7d452665cf1&address=
        //                     http://restapi.amap.com/v3/geocode/geo?key=d871ac8972f969b5bd65a7d452665cf1&s=rsv3&city=35&address=
        String queryUrl = "http://restapi.amap.com/v3/geocode/geo?key=d871ac8972f969b5bd65a7d452665cf1&s=rsv3&city=35&address="+address;
        //                  http://restapi.amap.com/v3/geocode/geo?key=xxxxxxxxxxxxxxxx&s=rsv3&city=35&address=福建省霞浦县水门畲族乡
        String queryResult = getResponse(queryUrl);  //高德接品返回的是JSON格式的字符串

        JSONObject jo = JSONObject.parseObject(queryResult);
        System.out.println(jo.toString());
        JSONArray ja = jo.getJSONArray("geocodes");
        return JSONObject.parseObject(ja.getString(0)).get("location").toString();
    }

    private static Long getDistance(String startLonLat, String endLonLat){
        //返回起始地startAddr与目的地endAddr之间的距离，单位：米
        Long result = new Long(0);
        //                  http://restapi.amap.com/v3/geocode/geo?key=d871ac8972f969b5bd65a7d452665cf1&s=rsv3&city=35&address=
        String queryUrl = "http://restapi.amap.com/v3/distance?key=6c436a0990f3ca0d68bac912c071f69a&origins="+startLonLat+"&destination="+endLonLat;
        //String temp =     "http://restapi.amap.com/v3/distance?key=d871ac8972f969b5bd65a7d452665cf1&origins="+startLonLat+"&destination="+endLonLat;
        String queryResult = getResponse(queryUrl);
        JSONObject jo = JSONObject.parseObject(queryResult);

        System.out.println(jo.toString());

        JSONArray ja = jo.getJSONArray("results");

        result = Long.parseLong(JSONObject.parseObject(ja.getString(0)).get("distance").toString());
        return result;
//        return queryResult;
    }

    private static String getResponse(String serverUrl){
        //用JAVA发起http请求，并返回json格式的结果
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}