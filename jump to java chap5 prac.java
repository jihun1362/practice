//Q1 다음은 Calculator 클래스와 그 사용법을 담은 코드이다.

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}

public class Sample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(10);
        System.out.println(cal.getValue());  // 10 출력
    }
}
//Calculator 클래스를 상속하는 UpgradeCalculator를 만들고 값을 뺄 수 있는 minus 메서드를 추가해 보자. 즉 다음과 같이 동작하는 클래스를 만들어야 한다.
// UpgradeCalculator cal = new UpgradeCalculator();
// cal.add(10);
// cal.minus(3);
// System.out.println(cal.getValue());  // 10에서 3을 뺀 7을 출력

//나의 답
class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}

class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}

public class prac3 {
    public static void main(String[] args) {
        UpgradeCalculator cal = new UpgradeCalculator();
        cal.add(10);
        cal.minus(3);
        System.out.println(cal.getValue());  // 10에서 7을 뺀 3을 출력
    }
}

//Q2 객체변수 value가 100 보다 큰 값은 가질 수 없도록 제한하는 MaxLimitCalculator 클래스를 만들어 보자. 즉 다음과 같이 동작해야 한다.

// MaxLimitCalculator cal = new MaxLimitCalculator();
// cal.add(50);  // 50 더하기
// cal.add(60);  // 60 더하기
// System.out.println(cal.getValue());  // 100 출력
//단 MaxLimitCalculator 클래스는 반드시 다음의 Calculator 클래스를 상속해서 만들어야 한다.

//나의 답
class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}

class  MaxLimitCalculator extends Calculator{
    int getValue() {
        if (value > 100) {
            return 100;
        }
        return this.value;
    }
}

public class prac3 {
    public static void main(String[] args) {
        MaxLimitCalculator cal = new MaxLimitCalculator();
        cal.add(50);  // 50 더하기
        System.out.println(cal.getValue());
        cal.add(60);  // 60 더하기
        System.out.println(cal.getValue());  // 100 출력
    }
}

//Q3 다음의 클래스에 주어진 정수가 홀수인지 짝수인지 판별해 주는 메서드(isOdd)를 추가해 보자. (홀수이면 true, 짝수면 false를 리턴해야 한다.)

//나의 답

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }

    boolean isOdd(int val){
        return val%2 == 1;

    }
}

class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}

class  MaxLimitCalculator extends Calculator{
    int getValue() {
        if (value > 100) {
            return 100;
        }
        return this.value;
    }
}

public class prac3 {
    public static void main(String[] args) {
        MaxLimitCalculator cal = new MaxLimitCalculator();
        cal.add(50);  // 50 더하기
        System.out.println(cal.getValue());
        cal.add(60);  // 60 더하기
        System.out.println(cal.getValue());  // 100 출력
        System.out.println(cal.isOdd(2));
        System.out.println(cal.isOdd(1));
    }
}

//Q4 다음 클래스에 정수 배열 또는 정수의 리스트 입력시 그 평균값을 구해 정수로 리턴하는 avg 메서드를 추가해 보자.

// 정수 배열을 사용한 예는 다음과 같다.
// int[] data = {1, 3, 5, 7, 9};
// Calculator cal = new Calculator();
// int result = cal.avg(data);
// System.out.println(result);  // 5 출력

// 정수 리스트를 사용한 예는 다음과 같다.
// ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
// Calculator cal = new Calculator();
// int result = cal.avg(data);
// System.out.println(result);  // 5 출력

//나의 답
import java.util.ArrayList;
import java.util.Arrays;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }

    boolean isOdd(int val){
        return val%2 == 1;

    }

    int avg(int[] val){
        int total=0;
        for (int i:val){
            total+=i;
        }
        int average = total/val.length;
        return average;
    }
    int avg(ArrayList<Integer> val){
        int total=0;
        for (int i:val){
            total+=i;
        }
        int average = total/val.size();
        return average;
    }

}

class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}

class  MaxLimitCalculator extends Calculator{
    int getValue() {
        if (value > 100) {
            return 100;
        }
        return this.value;
    }
}

public class prac3 {
    public static void main(String[] args) {
        ArrayList<Integer> data1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        int[] data2 = {1, 3, 5, 7, 9};
        Calculator cal = new Calculator();
        int result1 = cal.avg(data1);
        int result2 = cal.avg(data2);
        System.out.println(result1);  // 5 출력
        System.out.println(result2);  // 5 출력
    }
}

//Q5 다음 프로그램의 출력결과를 예측하고 그 이유에 대해서 설명하시오.
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = a;
        a.add(4);
        System.out.println(b.size());
    }
}
//나의 답
//a와 b가 동일한 객체를 가르키고 a에 4가 추가되어 리스트가 (1,2,3,4)가 되었으므로 b의 총 개수는 4개가됩니다.

//Q6 다음은 Calculator 객체를 생성하고 값을 더한 후에 그 결과값을 출력하는 예제이다.
//하지만 코드를 실행하면 오류가 발생한다. Calculator 클래스를 수정하여 다음의 코드에서 오류가 발생하지 않도록 하시오.

class Calculator {
    Integer value;
    void add(int val) {
        this.value += val;
    }

    public Integer getValue() {
        return this.value;
    }
}

public class Sample {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(cal.getValue());
    }
}
//나의 답
class Calculator {
    Integer value=0;
    void add(int val) {
        this.value += val;
    }

    public Integer getValue() {
        return this.value;
    }
}

public class prac3 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(cal.getValue());
    }
}

//Q7 다음은 광물의 가치를 계산하는 MineralCalculator 클래스와 그 사용법이 담긴 코드이다.
//광물 계산기는 금인 경우 100, 은인 경우 90, 구리의 경우는 80의 가치를 더하는 기능(add 메스드)이 있다.

class Gold {
}

class Silver {
}

class Bronze {
}

class MineralCalculator {
    int value = 0;

    public void add(Gold gold) {
        this.value += 100;
    }

    public void add(Silver silver) {
        this.value += 90;
    }

    public void add(Bronze bronze) {
        this.value += 80;
    }

    public int getValue() {
        return this.value;
    }
}

public class Sample {
    public static void main(String[] args) {
        MineralCalculator cal = new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Silver());
        cal.add(new Bronze());
        System.out.println(cal.getValue());  // 270 출력
    }
}
// 하지만 이 광물 계산기는 광물이 추가될 때마다 add 메서드를 추가해야 한다는 단점이 있다.
// 광물이 추가되더라도 MineralCalculator 클래스를 변경할 필요가 없도록 코드를 수정하시오.

//나의 답
interface MineralCost{
    int add();
}

class Gold extends MineralCalculator implements MineralCost{
    @Override
    public int add() {
        return 100;

    }
}

class Silver extends MineralCalculator implements MineralCost{
    @Override
    public int add() {
        return 90;

    }
}

class Bronze extends MineralCalculator implements MineralCost{
    @Override
    public int add() {
       return 80;

    }
}

class MineralCalculator{
    int value = 0;

    public void add(MineralCost mineralCost) {
       this.value += mineralCost.add();
    }

    public int getValue() {
        return this.value;
    }
}

public class prac3 {
    public static void main(String[] args) {
        MineralCalculator cal = new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Silver());
        cal.add(new Bronze());
        System.out.println(cal.getValue());  // 270 출력
    }
}
//Q8 다음의 코드를 보고 1번, 2번, 3번, 4번, 5번 문장 중에서 오류가 발생하는 문장을 모두 찾고 오류의 원인에 대해서 설명하시오.

interface Predator {
}

class Animal {
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
}

public class Sample {
    public static void main(String[] args) {
        Animal a = new Animal();  // 1번 
        Animal b = new Dog();  // 2번
        Animal c = new Lion();  // 3번
        Dog d = new Animal();  // 4번
        Predator e = new Lion();  // 5번
    }
}
//나의 답
//4번 문장에서 오류가 발생한다.
//Dog는 Animal의 자식 클래스로 부모 클래스는 자식 클래스의 자료형으로 사용할 수 없기 떄문이다.

//Q9 다음의 코드를 보고 1번, 2번, 3번, 4번, 5번, 6번 문장 중에서 오류가 발생하는 문장을 모두 찾고 오류의 원인에 대해서 설명하시오.

interface Predator {
    String bark();
}

abstract class Animal {
    public String hello() {
        return "hello";
    }
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
    public String bark() {
        return "Bark bark!!";
    }
}

public class Sample {
    public static void main(String[] args) {
        Animal a = new Lion();
        Lion b = new Lion();
        Predator c = new Lion();

        System.out.println(a.hello());  // 1번
        System.out.println(a.bark());   // 2번
        System.out.println(b.hello());  // 3번
        System.out.println(b.bark());   // 4번
        System.out.println(c.hello());  // 5번
        System.out.println(c.bark());   // 6번
    }
}
//나의 답
//2번 문장과 5번 문장에서 오류가 발생한다.
//2번 문장이 오류가 발생하는 이유는 a 객체가 Animal 타입으로 생성되었기 때문이다.
//Animal 타입의 객체는 hello 메서드만 사용이 가능하다.
//5번 문장이 오류가 발생하는 이유는 c 객체가 Predator 타입으로 생성되었기 때문이다.
//Predator 타입의 객체는 bark 메서드만 사용이 가능하다.
