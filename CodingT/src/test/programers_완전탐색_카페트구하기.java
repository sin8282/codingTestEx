package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성

 */
public class programers_완전탐색_카페트구하기 {

	 public int[] solution(int brown, int yellow) {
		int []answer = new int[2];
    	loop: for(int w=1; w<=5000; w++) {
    		for(int h=1; h<=w; h++) {
    	    	int b = 2*w +2*h-4;
    	    	int y = (w-2)*(h-2);
    	    	if(b == brown && y==yellow) {
    	    		answer[0]= w;
    	    		answer[1]= h;
    	    		break loop;
    	    	}
    		}
    	}
		return answer;
    }

}
