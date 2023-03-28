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
public class programers_문자열_시저암호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int n = 5;
		char[] cArr = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i< cArr.length; i++) {
			sb.append(push(cArr[i], n));
		}
		
		System.out.println(sb.toString());
	}
	
	private static char push(char c, int n) {
		if(!Character.isAlphabetic(c)) return c;
		int offset = Character.isUpperCase(c) ? 'A' : 'a';
		int position = c - offset;
		position = (position + n) % ('Z'-'A'+1);
		return (char) ((position + offset));
	}
}
