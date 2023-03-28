package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*투 포인터 : 두개의 포인터를 움직이면서 수식을 처리하는 개념
https://www.youtube.com/watch?v=ZovjkF2DzIs&t=549s
*/
public class Test4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int NUM = sc.nextInt();
		int count = 1;
		int st_index = 1;
		int end_index = 1;
		int sum = 1;
		while(NUM != end_index) {
			if(sum == NUM) {
				count++; 				
				end_index++;
				sum += end_index;
			}else if(sum <NUM) {
				end_index++;
				sum += end_index;
			}else{ // sum > NUM
				sum -= st_index;
				st_index++;
			}
		}
		System.out.println(count);
	}
}
