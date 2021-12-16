package crolling;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StockCrolling {
   
   public static String getStocData(String stocName) {
      String url = "https://finance.naver.com/item/coinfo.naver?code=";
      String stocNumber = getStockNumber(stocName);
      
      try {
         String html =Jsoup.connect(url+stocNumber).get().body().text();
         return html;
      }catch(Exception e){
         e.printStackTrace();
      }
   return "error";
   }

   private static String getStockNumber(String stocName) {
      String url ="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=";
      String addUrl="+주가";
      try {
         String[] arr = Jsoup.connect(url+stocName+addUrl)
                        .get().select("div.api_subject_bx")
                        .text().split(" ");
         return arr[2];
      } catch (IOException e) {
         e.printStackTrace();
      }
      return "last";
   }
}