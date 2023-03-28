package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/12916
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성
 */
public class programers_문자열_영단어 {
    public int solution(String s) {
    	String [] words= {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	
    	for(int i=0; i<words.length; i++) {
    		s = s.replace(words[i], i+"");
    	}
    	return Integer.parseInt(s);
    }
    
}
