package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/12932
/*
 */
public class programers_문자열_자연수_뒤집기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		
		String str = new StringBuilder(Long.toString(n)).reverse().toString();
		char[] c = str.toCharArray();
		int[] result = new int[c.length];
		for(int i=0; i< c.length; i++) {
			result[i] = c[i]-'0';
		}
		
		System.out.println(Arrays.toString(result));
	}
}
