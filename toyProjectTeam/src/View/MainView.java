package View;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import CreateMap.resultMap;

public class MainView {
   //\t = 한글6글자 영어 숫자 12글자 총 width = \t*16
   private Scanner scan;
   public Object mainView() {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.printf
      ("                  ███████ ████████  ██████   ██████ ██   ██                                                                                         \r\n"
     + "                  ██         ██    ██    ██ ██      ██  ██                                                                                          \r\n"
     + "                  ███████    ██    ██    ██ ██      █████                                                                                           \r\n"
     + "                       ██    ██    ██    ██ ██      ██  ██                                                                                          \r\n"
     + "                  ███████    ██     ██████   ██████ ██   ██                                                                                         \r\n"
     + "                                                                                                                                                                            \r\n"
     + "                                                                                                                                                                            \r\n"
     + "                      █████  ███    ██ ██████                                                                                                          \r\n"
     + "                     ██   ██ ████   ██ ██   ██                                                                                                         \r\n"
     + "                     ███████ ██ ██  ██ ██   ██                                                                                                         \r\n"
     + "                     ██   ██ ██  ██ ██ ██   ██                                                                                                         \r\n"
     + "                     ██   ██ ██   ████ ██████                                                                                                          \r\n"
     + "                                                                                                                                                                   \r\n"
     + "                                                                                                                                                                   \r\n"
     + "   ██████   ██████  ██████  ██    ██ ██       █████  ██████      ██   ██ ███████ ██    ██ ██     ██  ██████  ██████  ██████  ███████ \r\n"
     + "   ██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██ ██   ██     ██  ██  ██       ██  ██  ██     ██ ██    ██ ██   ██ ██   ██ ██      \r\n"
     + "   ██████  ██    ██ ██████  ██    ██ ██      ███████ ██████      █████   █████     ████   ██  █  ██ ██    ██ ██████  ██   ██ ███████ \r\n"
     + "   ██      ██    ██ ██      ██    ██ ██      ██   ██ ██   ██     ██  ██  ██         ██    ██ ███ ██ ██    ██ ██   ██ ██   ██      ██ \r\n"
     + "   ██       ██████  ██       ██████  ███████ ██   ██ ██   ██     ██   ██ ███████    ██     ███ ███   ██████  ██   ██ ██████  ███████ \r\n"
     + "                                                                                                                                        \r\n");

      printLine();
      lastLine("|");
      lastLine("|                                                실시간 검색어 확인 Enter");
      lastLine("|");
      printLine();
      scan = new Scanner(System.in);
      scan.nextLine();
      clearScreen();
      return printPopularKeyworda();
   }
   
   private Object printPopularKeyworda() {
      
      System.out.println
                ("██████   ██████  ██████  ██    ██ ██       █████  ██████      ██   ██ ███████ ██    ██ ██     ██  ██████  ██████  ██████  ███████ \r\n"
            + "██   ██ ██    ██ ██   ██ ██    ██ ██      ██   ██ ██   ██     ██  ██  ██       ██  ██  ██     ██ ██    ██ ██   ██ ██   ██ ██      \r\n"
            + "██████  ██    ██ ██████  ██    ██ ██      ███████ ██████      █████   █████     ████   ██  █  ██ ██    ██ ██████  ██   ██ ███████ \r\n"
            + "██      ██    ██ ██      ██    ██ ██      ██   ██ ██   ██     ██  ██  ██         ██    ██ ███ ██ ██    ██ ██   ██ ██   ██      ██ \r\n"
            + "██       ██████  ██       ██████  ███████ ██   ██ ██   ██     ██   ██ ███████    ██     ███ ███   ██████  ██   ██ ██████  ███████ \r\n"
            + "                                                                                                                                  \r\n");
      
      int count = 1;
      int checkCompany=0;
      printLine();
      lastLine("|");
      for (String key : resultMap.resultMap.keySet()) {
         String company = resultMap.resultMap.get(key); // 회사명 담아준다.
         lastLine(String.format("|                                         현재 실시간 검색어 %2d 위 : %-50s"
               , count,key));
         if(!resultMap.resultMap.get(key).equals("not")) {
            checkCompany++;
         }
         count++;
      }
      lastLine("|");
      lastLine(String.format("                                   실시간 검색어와 관련된 주식은 %2d 개 검색되었습니다."
            , checkCompany));
      printLine(); 
      System.out.println("|☜메인으로[ 0 ]\t\t\t\t\t\t\t\t\t\t\t\t       관련 주식 확인[ 1 ]☞|");
      printLine();
      System.out.println("입력 :");
      scan = new Scanner(System.in);
      String select = scan.nextLine();
      if(select.equals("1")) {
         clearScreen();
         return printNowStockData();
      }else if(select.equals("0")) {
         clearScreen();
         return mainView();
      }else {
         System.out.println("잘못된 정보입니다. 3초 후 다시 입력하세요.");
         try {
            TimeUnit.SECONDS.sleep(3);
            clearScreen();
            return printPopularKeyworda();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      clearScreen();
      return "last";
   }
   
   private Object printNowStockData() {
      System.out.println(
            "                         ███████ ████████  ██████   ██████ ██   ██                          \r\n"
            + "                         ██         ██    ██    ██ ██      ██  ██                           \r\n"
            + "                         ███████    ██    ██    ██ ██      █████                            \r\n"
            + "                              ██    ██    ██    ██ ██      ██  ██                           \r\n"
            + "                         ███████    ██     ██████   ██████ ██   ██                          \r\n"
            + "                                                                                            \r\n"
            + "                                                                                            \r\n"
            + "    ██ ███    ██ ███████  ██████  ██████  ███    ███  █████  ████████ ██  ██████  ███    ██ \r\n"
            + "    ██ ████   ██ ██      ██    ██ ██   ██ ████  ████ ██   ██    ██    ██ ██    ██ ████   ██ \r\n"
            + "    ██ ██ ██  ██ █████   ██    ██ ██████  ██ ████ ██ ███████    ██    ██ ██    ██ ██ ██  ██ \r\n"
            + "    ██ ██  ██ ██ ██      ██    ██ ██   ██ ██  ██  ██ ██   ██    ██    ██ ██    ██ ██  ██ ██ \r\n"
            + "    ██ ██   ████ ██       ██████  ██   ██ ██      ██ ██   ██    ██    ██  ██████  ██   ████ \r\n"
            + "                                                                                            \r\n"
            + "                                                                                            ");
      printLine();
      System.out.printf("|\t실검\t\t회사명\t\t\t주가\t\t전일대비\t\t수익률\t시가\t\t저가\t\t고가\t|\r\n");
      printLine();
      int count=1;
      for (String key : resultMap.resultMap.keySet()) {
         if(!resultMap.resultMap.get(key).equals("not")) {
            System.out.printf("| %2d  %-15s\t%-10s\t|\r\n",count,key,resultMap.resultMap.get(key));
            count++;
         }
      }
      return null;
   }

   private void printLine() {
      System.out.println("====================================================================================================================================");
   }
   private void clearScreen() {
       for (int i = 0; i < 80; i++)
         System.out.println("");
     }
   private void lastLine(String input) {
      int count=0;
      int totalLine=131;
      for(int i =0 ; i<input.length();i++) {
         if((int)input.charAt(i)>=(int)'가' && (int)input.charAt(i)<=(int)'힣') {
            count+=2;
         }else {
            count++;
         }
      }
      for(int j = totalLine-count; j>0; j--) {
         input+=" ";
      }
      input+='|';
      System.out.println(input);
   }

}