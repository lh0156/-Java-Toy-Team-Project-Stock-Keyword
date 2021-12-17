package Calculate;

import CreateMap.CompanyMap;
import CreateMap.resultMap;

public class SecondCheck {

   public static Object SecondCheck() {
      
      resultMap.checkKeyword();
      
      for (String s : resultMap.resultMap.keySet()) { // 20번 다 솎아낸 후의 CreateMap을 가지고 다시  ex:) 
         int equalsCount = 0;
         int indexNumber = -1;
         if(!resultMap.resultMap.get(s).equals("not")) {
            while (resultMap.resultMap.toString().indexOf(resultMap.resultMap.get(s), indexNumber) != -1) {
               indexNumber = resultMap.resultMap.toString().indexOf(resultMap.resultMap.get(s), indexNumber) + resultMap.resultMap.get(s).length() + 1;
               equalsCount++;
            }
         System.out.printf("equalsCount :  %d\r\n",equalsCount);
         if (equalsCount >= 3) {
            System.out.printf("전:%d \r\n",CompanyMap.map.size());
            CompanyMap.map.remove(resultMap.resultMap.get(s));
            System.out.printf("후:%d \r\n",CompanyMap.map.size());
            return SecondCheck();
            }
         }
      }
      return "last";
   }
}