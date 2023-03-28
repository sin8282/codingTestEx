package test;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum= 0;
		
		for(int i=0; i<cNum.length; i++) {
			sum += cNum[i] - '0'; //문자열을 빼면 숫자형으로 한다.
		}
		System.out.println(sum);
	}
}
