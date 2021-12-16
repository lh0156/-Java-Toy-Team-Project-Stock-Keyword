package createMap;

public class SecondCheck {

   public static Object SecondCheck() {
      
      Check.checkKeyword();
      
      for (String s : Check.resultMap.keySet()) { // 20번 다 솎아낸 후의 CreateMap을 가지고 다시  ex:) 
         int equalsCount = 0;
         int indexNumber = -1;
         if(!Check.resultMap.get(s).equals("not")) {
            while (Check.resultMap.toString().indexOf(Check.resultMap.get(s), indexNumber) != -1) {
               indexNumber = Check.resultMap.toString().indexOf(Check.resultMap.get(s), indexNumber) + Check.resultMap.get(s).length() + 1;
               equalsCount++;
            }
         System.out.printf("equalsCount :  %d\r\n",equalsCount);
         if (equalsCount >= 3) {
            System.out.printf("전:%d \r\n",CreateMap.map.size());
            CreateMap.map.remove(Check.resultMap.get(s));
            System.out.printf("후:%d \r\n",CreateMap.map.size());
            return SecondCheck();
            }
         }
      }
      return "last";
   }
}