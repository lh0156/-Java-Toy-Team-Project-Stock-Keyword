package createMap;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import crolling.KeywordCrolling;

public class Check {
   public static Map<String, String> resultMap;
   public static String txt = "";
   public static Object checkKeyword() {
      String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=";
      String addUrl = "+관련주식";
      String recent = "https://search.naver.com/search.naver?where=news&query=%EB%B0%A9%EC%97%AD%EC%88%98%EC%B9%99%20%EA%B4%80%EB%A0%A8%EC%A3%BC%EC%8B%9D&sm=tab_opt&sort=0&photo=0&field=0&pd=13&ds=&de=&docid=&related=0&mynews=0&office_type=0&office_section_code=0&news_office_checked=&nso=so%3Ar%2Cp%3Aall&is_sug_officeid=0";
      String isTeenrecent = "&sort=0&photo=0&field=0&pd=13&ds=2021.09.17&de=2021.12.16&cluster_rank=15&mynews=0&office_type=0&office_section_code=0&news_office_checked=&nso=so:r,p:3m,a:all&start=";
      resultMap = new HashMap<String, String>();
      
      try {
         for (int i = 0; i < KeywordCrolling.keyword.size(); i++) {
            Document d = Jsoup.connect(url + KeywordCrolling.keyword.get(i) + addUrl + recent).get();
            txt = d.body().text();
            

            for(int j=11; j<=21; j+=10) {
            	d = Jsoup.connect(url + KeywordCrolling.keyword.get(i) + addUrl + isTeenrecent + j).get();
            	txt += d.body().text();
            	
            }

            
            count(txt, KeywordCrolling.keyword.get(i));
         }
      } catch (Exception e) {
         return SecondCheck.SecondCheck();
      }
      return "check";
   }

   private static void count(String txt, String keyword) {

      for (String key : CreateMap.map.keySet()) {
         int index = -1;
         int count = 0;
         while (txt.indexOf(key, index) != -1) {
            index = txt.indexOf(key, index) + key.length() + 1;
            count++;
         }
         CreateMap.map.put(key, count);
      }
      int max = 0;
      for (String s : CreateMap.map.keySet()) {
         if (CreateMap.map.get(s) > max) {
            max = CreateMap.map.get(s);
         }
      }
      if(max!=0) {
         for (String s : CreateMap.map.keySet()) {
            if (CreateMap.map.get(s) == max) {
               resultMap.put(keyword, s);
            }
         }
      }else {
         resultMap.put(keyword, "not");
      }
      CreateMap.clearValue();
   }

}