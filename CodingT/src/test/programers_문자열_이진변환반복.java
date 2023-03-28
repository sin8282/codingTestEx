package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성
 */
public class programers_문자열_이진변환반복 {
    public int[] solution(String s) {
        int[] result = new int[2];
        int zeroCnt = 0;
        int metrixCnt = 0;

        while(!s.equals("1")) {
        	int init = ZeroCnt(s);
        	zeroCnt += init;
        	metrixCnt++;
        	s = Integer.toString(s.length()-init,2);
        	
        }
        result[0] = metrixCnt;
        result[1] = zeroCnt;
        return result;
    }
    
    public int ZeroCnt(String str) {
    	return str.length() - str.replaceAll("0", "").length();
    }
}
