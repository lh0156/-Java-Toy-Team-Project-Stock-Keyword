package crolling;


import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class crollingTest {

   public static void main(String[] args) throws IOException {
	   Scanner scan = new Scanner(System.in);
	   
	   
	   
	   String url = "https://finance.naver.com/item/coinfo.nhn?code=234100";
      
	   
      
      Document d = Jsoup.connect(url).get();
      
      String text = d.body().text();
      System.out.println(text);
      
//      int point = text.indexOf("cm");
//      String cm = text.substring(point-3, point+2);
//      
//      System.out.println("이름: ");
//      System.out.println(cm);
      
//      Elements e = d.select("div#main_pack");
//      String txt=""   ;
//      for(Element e1 :e) {
//         txt += e.text()+"\r\n";
//      }
//      System.out.println(txt);

   }

}