package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/12930
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성
 */
public class programers_문자열_이상한_문자만들기 {
	
	public static void main(String[] args) throws IOException {
		String s = null ;
		
		boolean toUpper = true;
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			if(!Character.isAlphabetic(c)) {
				sb.append(c);
				toUpper = true;
			}else {
				if(toUpper) {
					sb.append(Character.toUpperCase(c));
				}else {
					sb.append(Character.toLowerCase(c));
				}
				toUpper = !toUpper; // 반전시키기
				
			}
		}
		
		sb.toString();
	}
	

}
