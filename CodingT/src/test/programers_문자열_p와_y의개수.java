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
public class programers_문자열_p와_y의개수 {
    public boolean solution(String s) {
        s = s.toLowerCase();
        int p = CheckChar(s, "p");
        int y = CheckChar(s, "y");

        return p == y;
    }
    
    public int CheckChar(String source, String find) {
    	return source.length() - source.replaceAll(find, "").length();
    }
}
