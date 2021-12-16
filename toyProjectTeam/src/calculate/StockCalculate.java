package calculate;

import java.util.HashMap;
import createMap.Check;
import crolling.StockMarketPrice;

public class StockCalculate { //Stock
   
   HashMap<String, StockMarketPrice> StockPrice = new HashMap<String, StockMarketPrice>();  
   
//   ArrayList = Stock정보들 모아둔 거
   public static void StockCalculate() {

      for (String key : Check.resultMap.keySet()) {
         String company = Check.resultMap.get(key); // value = 회사명
         
         String text = crolling.StockCrolling.getStocData(company); // void -> String
       
      }
   }

}