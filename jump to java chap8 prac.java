//Q1 10 미만의 자연수에서 3과 5의 배수를 구하면 3, 5, 6, 9이다. 이들의 총합은 23이다. 1000 미만의 자연수에서 3의 배수와 5의 배수의 총합을 구하라.
//나의 답
public class Problem1 {
    public static void main(String[] args) {
        int result = 0;
        for (int n = 1; n < 1000; n++) {
            if (n % 3 == 0 || n % 5 == 0) {
                result += n;
            }
        }
        System.out.println(result);
    }
}
