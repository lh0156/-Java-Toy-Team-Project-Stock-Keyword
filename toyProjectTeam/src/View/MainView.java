package View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Calculate.getStockInfoCalculate;
import CreateMap.resultMap;
import MemberClass.StockIndex;
import MemberClass.StockMarketPrice;
import MemberClass.StockPriceToday;

public class MainView {
   private Scanner scan;
   private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
   
   public Object mainView() {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.printf
                ("                                                           ███████ ████████  ██████   ██████ ██   ██                                                                                         \r\n"
               + "                                                           ██         ██    ██    ██ ██      ██  ██                                                                                          \r\n"
               + "                                                           ███████    ██    ██    ██ ██      █████                                                                                           \r\n"
               + "                                                                ██    ██    ██    ██ ██      ██  ██                                                                                          \r\n"
               + "                                                           ███████    ██     ██████   ██████ ██   ██                                                                                         \r\n"
               + "                                                                                                                                                                                                                     \r\n"
               + "                                                                                                                                                                                                                          \r\n"
               + "                                                                    █████  ███    ██ ██████                                                                                                          \r\n"
               + "                                                                   ██   ██ ████   ██ ██   ██                                                                                                         \r\n"
               + "                                                                   ███████ ██ ██  ██ ██   ██                                                                                                         \r\n"
               + "                                                                   ██   ██ ██  ██ ██ ██   ██                                                                                                         \r\n"
               + "                                                                   ██   ██ ██   ████ ██████                                                                                                          \r\n"
               + "                                                                                                                                                                                       \r\n"
               + "                                                                                                                                                                                       \r\n"
               + "                       ██████   ██████  ██████  ██    ██ ██       █████  ██████      ██   ██ ███████ ██    ██ ██     ██  ██████  ██████  ██████  ███████ \r\n"
               + "                       ██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██ ██   ██     ██  ██  ██       ██  ██  ██     ██ ██    ██ ██   ██ ██   ██ ██      \r\n"
               + "                       ██████  ██    ██ ██████  ██    ██ ██      ███████ ██████      █████   █████     ████   ██  █  ██ ██    ██ ██████  ██   ██ ███████ \r\n"
               + "                       ██      ██    ██ ██      ██    ██ ██      ██   ██ ██   ██     ██  ██  ██         ██    ██ ███ ██ ██    ██ ██   ██ ██   ██      ██ \r\n"
               + "                       ██       ██████  ██       ██████  ███████ ██   ██ ██   ██     ██   ██ ███████    ██     ███ ███   ██████  ██   ██ ██████  ███████ \r\n"
               + "                                                                                                                                                  \r\n");
      printLine();
      lastLine("     |");
      lastLine("     |                                                               실시간 검색어 확인 Enter");
      lastLine("     |");
      printLine();
      scan = new Scanner(System.in);
      scan.nextLine();
      clearScreen();
      return printPopularKeyword();
   }
   
   private Object printPopularKeyword() {
      
      System.out.println
                (
              "                    ██████   ██████  ██████  ██    ██ ██       █████  ██████      ██   ██ ███████ ██    ██ ██     ██  ██████  ██████  ██████  ███████ \r\n"
            + "                    ██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██ ██   ██     ██  ██  ██       ██  ██  ██     ██ ██    ██ ██   ██ ██   ██ ██      \r\n"
            + "                    ██████  ██    ██ ██████  ██    ██ ██      ███████ ██████      █████   █████     ████   ██  █  ██ ██    ██ ██████  ██   ██ ███████ \r\n"
            + "                    ██      ██    ██ ██      ██    ██ ██      ██   ██ ██   ██     ██  ██  ██         ██    ██ ███ ██ ██    ██ ██   ██ ██   ██      ██ \r\n"
            + "                    ██       ██████  ██       ██████  ███████ ██   ██ ██   ██     ██   ██ ███████    ██     ███ ███   ██████  ██   ██ ██████  ███████ \r\n"
            + "          \r\n                                                                 💸모든 화폐 단위는 '원'입니다.💸"
            + "          \r\n                                                               "+String.format("⏱ %s", simpleDateFormat.format(Calendar.getInstance().getTime()))+" 기준 데이터 ⏱");       
      
      int count = 1;
      int checkCompany=0;
      printLine();
      lastLine("     |");
      for (String key : resultMap.resultMap.keySet()) {
         String company = resultMap.resultMap.get(key); // 회사명 담아준다.
         lastLine(String.format("     |                                                       현재 실시간 검색어 %2d 위 : %s %s"
               , count
               ,companyCheckLength(1,key)// 실검
               ,companyCheckLength(1,(!resultMap.resultMap.get(key).equals("not"))? "💡💡💡💡 매칭결과 : "+resultMap.resultMap.get(key)+" 💡💡💡💡":"")
               ));
         if(!resultMap.resultMap.get(key).equals("not")) {
            checkCompany++;
         }
         count++;
      }
      lastLine("     |");
      lastLine(String.format("     |                                                   실시간 검색어와 관련된 주식이 %2d 개 검색되었습니다."
            , checkCompany));
      lastLine("     |");
      lastLine("     |                                                검색된 주식 정보를 탐색하기 위하여 아래의 선택지를 선택해주십시오.");
      printLine();
      lastLine("     |                                         [ 1 ]  금일 주식 정보 [ 2 ]  전일 주식 정보  [ 3 ]  당월 주식 분석");
      printLine();
      System.out.print("                                               입력 : ");
      
      scan = new Scanner(System.in);
      String select = scan.nextLine();
      getStockInfoCalculate getStockData = new getStockInfoCalculate();
      getStockData.getStockCalculate();
      if(select.equals("1")) {
         clearScreen();
         return printNowStockData(getStockData.StockPriceToday);
      }else if(select.equals("2")) {
         clearScreen();
         return printStockPrices(getStockData.StockPrices);
      }else if(select.equals("3")) {
          clearScreen();
          return printCurrentMonthData(getStockData.StockIndex);
       }else {
         System.out.println("     잘못된 정보입니다. 3초 후 다시 입력하세요.");
         try {
            TimeUnit.SECONDS.sleep(3);
            clearScreen();
            return printPopularKeyword();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      clearScreen();
      return "last";
   }
   
   private Object printCurrentMonthData(ArrayList<StockIndex> list) {
      System.out.println(
               "                                                              ███████ ████████  ██████   ██████ ██   ██                          \r\n"
               + "                                                              ██         ██    ██    ██ ██      ██  ██                           \r\n"
               + "                                                              ███████    ██    ██    ██ ██      █████                            \r\n"
               + "                                                                   ██    ██    ██    ██ ██      ██  ██                           \r\n"
               + "                                                              ███████    ██     ██████   ██████ ██   ██                          \r\n"
               + "                                                                                                                               \r\n"
               + "                                                                                                                               \r\n"
               + "                                       ██ ███    ██ ███████  ██████  ██████  ███    ███  █████  ████████ ██  ██████  ███    ██ \r\n"
               + "                                       ██ ████   ██ ██      ██    ██ ██   ██ ████  ████ ██   ██    ██    ██ ██    ██ ████   ██ \r\n"
               + "                                       ██ ██ ██  ██ █████   ██    ██ ██████  ██ ████ ██ ███████    ██    ██ ██    ██ ██ ██  ██ \r\n"
               + "                                       ██ ██  ██ ██ ██      ██    ██ ██   ██ ██  ██  ██ ██   ██    ██    ██ ██    ██ ██  ██ ██ \r\n"
               + "                                       ██ ██   ████ ██       ██████  ██   ██ ██      ██ ██   ██    ██    ██  ██████  ██   ████ \r\n"
               + "                                                                                                 \r\n"
               + "          \r\n                                       "
               + "          \r\n                                                                 💸모든 화폐 단위는 '원'입니다.💸"
               + "          \r\n                                                               "+String.format("⏱ %s", simpleDateFormat.format(Calendar.getInstance().getTime()))+" 기준 데이터 ⏱");  
         printLine();
         lastLine("     |                         [회사이름]              [EPS]             [BPS]           [PER]            [업종 PER]           [PBR]");
         printLine();
         list.forEach(data->{
            lastLine(String.format("     |                        %s%s%s%s%s%s"
                  ,companyCheckLength(18,data.getName())
                  ,checkLength(12,data.getEps())
                  ,checkLength(18,data.getBps())
                  ,checkLength(16,data.getPer())
                  ,checkLength(22,data.getBusinessPer())
                  ,checkLength(16,data.getPbr())
                  ));
         });
         printLine();
         lastLine("     |                                                               [ 0 ]  뒤로가기");
         printLine();
         System.out.print("                                               입력 : ");
         
         scan = new Scanner(System.in);
         String select = scan.nextLine();
         if(select.equals("0")) {
            clearScreen();
             return printPopularKeyword();
         }else {
            System.out.println("     잘못된 정보입니다. 3초 후 다시 입력하세요.");
             try {
                TimeUnit.SECONDS.sleep(3);
                clearScreen();
                return printCurrentMonthData(list);
             } catch (InterruptedException e) {
                e.printStackTrace();
             }
         }
   return "last";
}

   private Object printStockPrices(ArrayList<StockMarketPrice> list) {
         System.out.println(
                  "                                                              ███████ ████████  ██████   ██████ ██   ██                          \r\n"
                  + "                                                              ██         ██    ██    ██ ██      ██  ██                           \r\n"
                  + "                                                              ███████    ██    ██    ██ ██      █████                            \r\n"
                  + "                                                                   ██    ██    ██    ██ ██      ██  ██                           \r\n"
                  + "                                                              ███████    ██     ██████   ██████ ██   ██                          \r\n"
                  + "                                                                                                                               \r\n"
                  + "                                                                                                                               \r\n"
                  + "                                       ██ ███    ██ ███████  ██████  ██████  ███    ███  █████  ████████ ██  ██████  ███    ██ \r\n"
                  + "                                       ██ ████   ██ ██      ██    ██ ██   ██ ████  ████ ██   ██    ██    ██ ██    ██ ████   ██ \r\n"
                  + "                                       ██ ██ ██  ██ █████   ██    ██ ██████  ██ ████ ██ ███████    ██    ██ ██    ██ ██ ██  ██ \r\n"
                  + "                                       ██ ██  ██ ██ ██      ██    ██ ██   ██ ██  ██  ██ ██   ██    ██    ██ ██    ██ ██  ██ ██ \r\n"
                  + "                                       ██ ██   ████ ██       ██████  ██   ██ ██      ██ ██   ██    ██    ██  ██████  ██   ████ \r\n"
                  + "                                                                                                 \r\n"
                  + "          \r\n                                       "
                  + "          \r\n                                                                 💸모든 화폐 단위는 '원'입니다.💸"
                  + "          \r\n                                                               "+String.format("⏱ %s", simpleDateFormat.format(Calendar.getInstance().getTime()))+" 기준 데이터 ⏱"); 
            printLine();
            lastLine("     | [회사이름]        [전일주가]       [전일대비]     [전일대비 수익률]      [주 최고]     [주 최저]     [액면가] "
                  + "           [시가총액]       [발행 주식 수]");
            printLine();
            list.forEach(data->{
               lastLine(String.format("     | %s%s%s%s%s%s%s%s%s"
                     ,companyCheckLength(18, data.getName())
                     ,checkLength(10, data.getStockPrice())
                     ,checkLength(17, data.getPreviousDay()) //전일대비
                     ,checkLength(22, data.getRateYesterDay()) //전일대비 수익률
                     ,checkLength(15, data.getWeekMaximum())
                     ,checkLength(14, data.getWeekMinimum()) // 주최저
                     ,checkLength(13,data.getFaceValue()) // 액면가
                     ,checkLength(22, data.getMarketCapitalization()) // 시가총액
                     ,checkLength(21, data.getMakeStockScore())
                     ));
            });
            printLine();
            lastLine("     |                                                               [ 0 ]  뒤로가기");
            printLine();
            System.out.print("                                               입력 : ");
            
            scan = new Scanner(System.in);
            String select = scan.nextLine();
            if(select.equals("0")) {
               clearScreen();
                return printPopularKeyword();
            }else {
               System.out.println("     잘못된 정보입니다. 3초 후 다시 입력하세요.");
                try {
                   TimeUnit.SECONDS.sleep(3);
                   clearScreen();
                   return printStockPrices(list);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
      return "last";
   }

private Object printNowStockData(ArrayList<StockPriceToday> list) {
      System.out.println(
            "                                                              ███████ ████████  ██████   ██████ ██   ██                          \r\n"
            + "                                                              ██         ██    ██    ██ ██      ██  ██                           \r\n"
            + "                                                              ███████    ██    ██    ██ ██      █████                            \r\n"
            + "                                                                   ██    ██    ██    ██ ██      ██  ██                           \r\n"
            + "                                                              ███████    ██     ██████   ██████ ██   ██                          \r\n"
            + "                                                                                                                               \r\n"
            + "                                                                                                                               \r\n"
            + "                                       ██ ███    ██ ███████  ██████  ██████  ███    ███  █████  ████████ ██  ██████  ███    ██ \r\n"
            + "                                       ██ ████   ██ ██      ██    ██ ██   ██ ████  ████ ██   ██    ██    ██ ██    ██ ████   ██ \r\n"
            + "                                       ██ ██ ██  ██ █████   ██    ██ ██████  ██ ████ ██ ███████    ██    ██ ██    ██ ██ ██  ██ \r\n"
            + "                                       ██ ██  ██ ██ ██      ██    ██ ██   ██ ██  ██  ██ ██   ██    ██    ██ ██    ██ ██  ██ ██ \r\n"
            + "                                       ██ ██   ████ ██       ██████  ██   ██ ██      ██ ██   ██    ██    ██  ██████  ██   ████ \r\n"
            + "                                                                                                 \r\n"
            + "          \r\n                                       "
            + "          \r\n                                                                 💸모든 화폐 단위는 '원'입니다.💸"
            + "          \r\n                                                               "+String.format("⏱ %s", simpleDateFormat.format(Calendar.getInstance().getTime()))+" 기준 데이터 ⏱");
      printLine();
      lastLine("     | [회사이름]         [주가] [전일 주가] [전일대비 수익률] [전일대비 수익가]  [거래대금]   [시가] "
            + "  [거래량]     [고가]   [저가] [최고 상한가] [최저 하한가]");
      printLine();
      list.forEach(data->{
         lastLine(String.format("     | %s%s%s%s%s%s%s%s%s%s%s%s"   
               ,companyCheckLength(18,data.getCompanyName())
               ,checkLength(8,data.getStockPrice())
               ,checkLength(11,data.getYesterdayPrice())
               ,checkLength(18,data.getRateYesterday())
               ,checkLength(18,data.getPreviousday())
               ,checkLength(12,data.getTradingValue())
               ,checkLength(9,data.getMarketPrice())
               ,checkLength(11,data.getTradingVolume())
               ,checkLength(11,data.getHighPrice())
               ,checkLength(9,data.getLowPrice())
               ,checkLength(13,data.getMaximumPrice())
               ,checkLength(14,data.getMinimumPrice())
               ));           
      });
      
      printLine();
      lastLine("     |                                                               [ 0 ]  뒤로가기");
      printLine();
      System.out.print("                                               입력 : ");
      
      scan = new Scanner(System.in);
      String select = scan.nextLine();
      if(select.equals("0")) {
         clearScreen();
          return printPopularKeyword();
      }else {
         System.out.println("     잘못된 정보입니다. 3초 후 다시 입력하세요.");
          try {
             TimeUnit.SECONDS.sleep(3);
             clearScreen();
             return printNowStockData(list);
          } catch (InterruptedException e) {
             e.printStackTrace();
          }
      }
      return "last";
   }

   private void printLine() {
      System.out.println("     =================================================================================="
                        + "===========================================================================");
   }
   private void clearScreen() {
       for (int i = 0; i < 80; i++)
         System.out.println("");
   }
   private String checkLength(int size, String word) {
      int count=0;
      for(int i=0;i<word.length();i++) {
         if((int)word.charAt(i)>=(int)'가' && (int)word.charAt(i)<=(int)'힣') {
               count+=2;
            }else {
               count++;
            }
      }
      for(int j = size-count; j>0; j--) {
         word=" "+word;
         }
      return word;
   }
   private String companyCheckLength(int size, String word) {
      int count=0;
      for(int i=0;i<word.length();i++) {
         if((int)word.charAt(i)>=(int)'가' && (int)word.charAt(i)<=(int)'힣') {
            count+=2;
         }else {
            count++;
         }
      }
      for(int j = size-count; j>0; j--) {
         word+=" ";
      }
      return word;
   }
   private void lastLine(String input) {
      int count=0;
      int totalLine=161;
      for(int i =0 ; i<input.length();i++) {
         if((int)input.charAt(i)>=(int)'가' && (int)input.charAt(i)<=(int)'힣') {
            count+=2;
         }else {
            count++;
         }
      }
      if(input.indexOf("💡")!=-1) {
         count-=3;
      }
      for(int j = totalLine-count; j>0; j--) {
         input+=" ";
      }
      input+='|';
      System.out.println(input);
   }

}