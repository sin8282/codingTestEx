package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
/* 이건 답안지 보고 좀 배울필요 있음
 * "abcabcabcabcdededededede"
 */
public class programers_문자열_압축 {
	public int solution(String s) {
        int min = Integer.MAX_VALUE;
		for(int i=1; i<=s.length(); i++) {
			int compressLength = compress(s,i);
			if(min > compressLength) {
				min = compressLength;
			}
		}
        return min;
    }
    
    public List<String> split(String source, int cutLength){
		List<String> tokens = new ArrayList<String>();
 		for(int start=0; start<source.length(); start += cutLength) {
			int end = start+cutLength;
			if(end > source.length()) end = source.length();
			tokens.add(source.substring(start,end));
		}
		return tokens;
		
	}
	public int compress(String source, int cutLength) {
		StringBuilder sb = new StringBuilder();
		String pre = ""; 
		int cnt = 0;
		
		for(String token: split(source, cutLength)) {
			if(token.equals(pre)) {
				cnt++;
			}else {
				if(cnt>1) sb.append(cnt);
				sb.append(pre);
				pre = token;
				cnt = 1;
			}
		}
		if(cnt>1) sb.append(cnt);
		sb.append(pre);
		
		return sb.length();
	}

}
