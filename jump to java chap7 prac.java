//Q1 다음처럼 house 패키지로 정의된 클래스가 있다.
package house;

public class HousePark {
    protected String lastname = "park";

    public String getLastname() {
        return this.lastname;
    }
}
//다음처럼 Sample 클래스에서 HousePark 클래스를 사용하려 한다.

import HousePark;

public class Sample {
    public static void main(String[] args) {
        HousePark housePark = new HousePark();
        System.out.println(housePark.getLastname());
    }
}
//하지만 위와 같이 작성하면 HousePark 클래스를 찾을 수 없다는 오류가 발생한다. import 문을 수정하여 오류를 해결하시오.

//나의 답
import house.HousePark;

public class sample {
    public static void main(String[] args) {
        HousePark housePark = new HousePark();
        System.out.println(housePark.getLastname());
    }
}

//Q2 다음 코드의 실행 결과를 예측하고 그 이유에 대해 설명하시오.
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int result = 0;
        try {
            int[] a = {1, 2, 3};
            int b = a[3];
            ArrayList c = new ArrayList(Arrays.asList("3"));
            int d = (int) c.get(0);
            int e = 4 / 0;
        } catch (ClassCastException e) {
            result += 1;
        } catch (ArithmeticException e) {
            result += 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            result += 3;
        } finally {
            result += 4;
        }
        System.out.println(result); // result 의 값은 무엇일까?
    }
}

//나의 답
//result = 7이 된다. 왜냐하면 try의 두번째 줄인 int b = a[3];에서 ArrayIndexOutOfBoundsException오류가 뜨기 때문인데
//그 이유는 try첫번째 줄인 int[] a = {1, 2, 3};의 배열의 순서는 0부터이기 때문에 a에는 0,1,2까지 3번째는 없기 때문이다.
//고로 result += 3이 되고 마지막에 finally는 무조건 실행이됨으로 4를 한번 더 더하기 때문에 7이 된다.

//Q3 다음은 HeavyWork 클래스의 work 메서드를 4번 수행하는 예제이다.
class HeavyWork {
    String name;

    HeavyWork(String name) {
        this.name = name;
    }

    public void work() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);  // 0.1 초 대기한다.
            } catch (Exception e) {
            }
        }
        System.out.printf("%s done.\n", this.name);
    }
}

public class Sample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5; i++) {
            HeavyWork w = new HeavyWork("w" + i);
            w.work();
        }
        long end = System.currentTimeMillis();
        System.out.printf("elapsed time:%s ms\n", end - start);
    }
}
//위 코드의 수행 결과는 다음과 같다.
w1 done.
w2 done.
w3 done.
w4 done.
elapsed time:2038 ms
//work 메서드에는 Thread.sleep(100)이 포함되어 있어서 총 수행시간이 0.5초정도 소요된다. 따라서 work 메서드를 4번 수행하면 대략 2초 가량이 소요된다.
//스레드를 사용하여 work 메서드를 동시에 수행하면 시간을 단축할 수 있을 것이다. 위 코드에 스레드를 적용하여 시간을 단축해 보자.

//나의 답
class HeavyWork implements Runnable{
    String name;

    HeavyWork(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);  // 0.1 초 대기한다.
            } catch (Exception e) {
            }
        }
        System.out.printf("%s done.\n", this.name);
    }
}

public class sample {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5; i++) {
            Thread w = new Thread(new HeavyWork("w" + i));
            w.start();
        }
        long end = System.currentTimeMillis();
        System.out.printf("elapsed time:%s ms\n", end - start);
    }
}
elapsed time:24 ms
w1 done.
w2 done.
w4 done.
w3 done.
//출제자의 답
import java.util.ArrayList;

class HeavyWork implements Runnable {
    String name;

    HeavyWork(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        work();
    }

    public void work() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
        System.out.printf("%s done.\n", this.name);
    }
}

public class Sample {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();  // 스레드를 저장할 리스트를 생성한다.
        for (int i = 1; i < 5; i++) {
            Thread t = new Thread(new HeavyWork("w" + i));
            threads.add(t);  // 스레드를 저장한다.
            t.start();
        }
        for (Thread t : threads) {
            t.join();  // 저장한 스레드가 종료될때까지 대기한다.
        }
        long end = System.currentTimeMillis();
        System.out.printf("elapsed time:%s ms\n", end - start);
    }
}
w1 done.
w4 done.
w2 done.
w3 done.
elapsed time:533 ms

//출제자는 배열을 추가하여 모든 스레드가 완전히 종료되는 것을 확이하기 위해 threads 변수에 스레드를 저장한 후 join 메서드로 스레드가 종료될 때까지 대기하였다.

//Q4 정수의 배열에서 홀수에만 2를 곱하여 저장하는 다음 코드가 있다.

import java.util.ArrayList;

public class Sample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 1) {  // 홀수이면 
                temp.add(num * 2);  // 2를 곱하여 temp에 담는다.
            }
        }

        // 정수 리스트를 정수배열로 변환한다.
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
    }
}
//위 코드를 함수형 프로그래밍을 사용하여 표현해 보자.

//나의 답
import java.util.Arrays;

public class sample {
    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 4, 5};
//        ArrayList<Integer> temp = new ArrayList<>();
//        for (int num : numbers) {
//            if (num % 2 == 1) {  // 홀수이면
//                temp.add(num * 2);  // 2를 곱하여 temp에 담는다.
//            }
//        }
//
//        // 정수 리스트를 정수배열로 변환한다.
//        int[] result = new int[temp.size()];
//        for (int i = 0; i < temp.size(); i++) {
//            result[i] = temp.get(i);
//        }
        int[] numbers = {1, 2, 3, 4, 5};
        int[] result = Arrays.stream(numbers)
                .filter((a) -> a % 2 == 1)
                .map((a) -> a * 2)
                .toArray();
        for (int i=0;i< result.length;i++){
            System.out.println(result[i]);
        }
    }
}
//Q5 함수형 프로그래밍을 사용하여 다음의 정수 배열에서 음수를 모두 제거해 보자.
int[] numbers = {1, -2, 3, -5, 8, -3};
//즉, 프로그램 실행 후 다음과 같은 정수 배열을 얻어야 한다.
int[] result = {1, 3, 8};

//나의 답
import java.util.Arrays;

public class sample {
    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, -5, 8, -3};

        int[] result = Arrays.stream(numbers)
                .filter((a) -> a > 0 )
                .toArray();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }


    }
}
