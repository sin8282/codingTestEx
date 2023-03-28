package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/68935
/*
 */
public class programers_문자열_3진법뒤집기 {
	
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(str);
        answer = Integer.parseInt(sb.reverse().toString(),3);
        return answer;
    }
}
