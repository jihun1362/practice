//Q1 두 개의 숫자를 입력받아 그 합을 출력하는 프로그램을 작성하시오.

//나의
답
import java.util.Locale;
import java.util.Scanner;

public class prac3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(a+b);
    }
}

//Q2 영문을 입력하고 엔터를 입력하면 입력한 영문을 대문자로 변경하여 출력하는 프로그램을 작성하시오.
//(단, 사용자가 "END" 라는 문자열을 입력하기 전까지 반복해서 문장을 입력받을 수 있게 할것)

//나의 답
import java.util.Locale;
import java.util.Scanner;

public class prac3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result;
        while (true) {
            result = sc.nextLine();
            if (result.substring(result.length() - 3).equals("END")) {
                break;
            }
        }
        System.out.println(result.toUpperCase());
    }
}

//Q3 다음은 "sample.txt"라는 파일에 "Write once, run anywhere" 문자열을 저장한 후 다시 그 파일을 읽어서 출력하는 프로그램이다.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sample {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("sample.txt");
        fw.write("Write once, run anywhere");

        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        String line = br.readLine();
        System.out.println(line);  // null 이 출력된다.
    }
}
// 이 프로그램은 우리가 예상한 "Write once, run anywhere"라는 문장을 출력하지 않고 null을 출력한다.
//   우리가 예상한 값을 출력할 수 있도록 프로그램을 수정해 보자.

//나의 답
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class prac3 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("sample.txt");
        fw.write("Write once, run anywhere");
        fw.close();
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;

            System.out.println(line);
        }
        br.close();
    }
}

//Q4 사용자의 입력을 파일(sample.txt)에 저장하는 프로그램을 작성해 보자.
//(단 프로그램을 다시 실행하더라도 기존에 작성한 내용을 유지하고 새로 입력한 내용을 추가해야 한다.)

//나의 답
import java.io.*;
import java.util.Scanner;


public class prac3 {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        
        PrintWriter pw = new PrintWriter("sample.txt");
        pw.println(sc.nextLine());
        pw.close();
        
        PrintWriter pw2 = new PrintWriter(new FileWriter("sample.txt", true));
        pw2.println(sc.nextLine());
        pw2.close();

        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null)
                break;
            System.out.println(line);
        }
        br.close();
    }
}
//Q5 다음과 같은 내용을 지닌 파일 sample.txt 파일이 있다.
//이 파일의 내용 중 "python" 이라는 문자열을 "java"로 바꾸어서 저장해 보자.

Life is too short
you need python

//나의답
import java.io.*;
import java.util.ArrayList;


public class prac3 {
    public static void main(String[] args) throws IOException {
      
        // 변경 전 체크
        BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while (true) {
            line = br.readLine();
            if (line == null)
                break;
            list.add(line);
        }
        System.out.println(list);
        br.close();

        // 줄 단위로 읽으면 줄바꿈 문자가 없어지므로 줄바꿈 문자를 포함한다.
        String text = String.join("\n", list);

        // python 이라는 단어를 java로 변경한다.
        text = text.replaceAll("python", "java");

        // 변경된 내용을 다시 파일에 적는다.
        FileWriter fw = new FileWriter("sample.txt");
        fw.write(text);
        fw.close();
        // 변경 후 체크
        BufferedReader br2 = new BufferedReader(new FileReader("sample.txt"));
        ArrayList<String> list2 = new ArrayList<>();
        String line2;
        while (true) {
            line2 = br2.readLine();
            if (line2 == null)
                break;
            list2.add(line2);
        }
        System.out.println(list2);
        br.close();
    }
}
