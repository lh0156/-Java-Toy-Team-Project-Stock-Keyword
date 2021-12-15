package createMap;

public class SecondCheck {

	public static Object SecondCheck() {
		int equalsCount = 0;
		int indexNumber = -1;

		
		Check.checkKeyword();
		
		for (String s : Check.resultMap.keySet()) { // 20번 20번 다 솎아낸 후의 CreateMap을 가지고 다시  ex:) 
			while (Check.resultMap.keySet().toString().indexOf(s, indexNumber) != -1) {
				indexNumber = Check.resultMap.keySet().toString().indexOf(s, indexNumber) + s.length() + 1;
				equalsCount++;
			}
			if (equalsCount >= 3) {
				
				System.out.println("전: " + CreateMap.map.size());
				CreateMap.map.remove(Check.resultMap.get(s));
				System.out.println("후: " + CreateMap.map.size());
				return SecondCheck();
			}
		}
		
		return "파일 삭제가 완료되었습니다";
		
	}
}
