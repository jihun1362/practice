import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class prac {

    public static void main(String[] args) {
        //Q1 평균 점수 구하기
        int a = 80;
        int b = 75;
        int c = 55;
        int d = a + b + c;
        System.out.println(d / 3);
        //Q2 홀짝 판별하기
        int e = 44;
        if (e % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }
        //Q3 홍길동 씨의 주민등록번호는 881120-1068234이다. 홍길동 씨의 주민등록번호를 연월일(YYYYMMDD) 부분과 그 뒤의 숫자 부분으로 나누어 출력
        String hong = "881120-1068234";
        System.out.println(hong.substring(0, 6));
        System.out.println(hong.substring(7));
        //Q4 주민등록번호 뒷자리의 맨 첫 번째 숫자는 성별을 나타낸다. 주민등록번호에서 성별을 나타내는 숫자를 출력
        String pin = "881120-1068234";
        System.out.println(pin.charAt(7));
        //Q5 다음과 같은 문자열 a:b:c:d가 있다. 문자열의 replace 함수를 사용하여 a#b#c#d로 바꿔서 출력
        String f = "a:b:c:d";
        System.out.println(f.replace(":", "#"));
        //Q6 다음과 같은 [1, 3, 5, 4, 2] 리스트를 [5, 4, 3, 2, 1]로 만들어 보자.
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        System.out.println(myList); // [1, 3, 5, 4, 2] 출력
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);
        //Q7 다음과 같은 ['Life', 'is', 'too', 'short'] 리스트를 "Life is too short" 문자열로 만들어 출력해 보자.
        ArrayList<String> myList2 = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        String result = String.join(" ", myList2);
        System.out.println(result);
        //Q8 다음의 맵 grade에서 "B"에 해당되는 값을 추출해 보자. (추출하고 나면 grade에는 "B"에 해당하는 아이템이 사라져야 한다.)
        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
        System.out.println(grade.remove("B"));
        System.out.println(grade);
        //Q9 다음의 numbers 리스트에서 중복 숫자를 제거해 보자.
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);  // [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 출력
        Set<Integer> temp = new HashSet<>(numbers);
        ArrayList<Integer> result2 = new ArrayList<>(temp);  // Set을 다시 List로 변경
        System.out.println(result2);
        //Q10 다음은 커피의 종류(1: 아메리카노, 2:아이스 아메리카노, 3:카페라떼)를 입력하면 커피의 가격을 알려주는 프로그램을 만들어라
        printCoffeePrice(coffeeType.CAFE_LATTE);
    }
    enum coffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE;
    };
    static void printCoffeePrice(coffeeType type) {
        HashMap<coffeeType, Integer> priceMap = new HashMap<>();
        priceMap.put(coffeeType.AMERICANO, 3000);  // 1: 아메리카노
        priceMap.put(coffeeType.ICE_AMERICANO, 4000);  // 2: 아이스 아메리카노
        priceMap.put(coffeeType.CAFE_LATTE, 5000);  // 3: 카페라떼

        int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }
}
