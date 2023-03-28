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
public class programers_완전탐색_모의고사 {
	int[] collectSum = new int[3];
	int[][] student =  {
			{1, 2, 3, 4, 5}
			,{2, 1, 2, 3, 2, 4, 2, 5}
			,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};
    public int[] solution(int[] answers) {
    	checkProblem(student, answers);
    	String result="";
    	int max =0;
    	for(int i=0; i<collectSum.length; i++) {
    		if (max<collectSum[i]) {
    			max = collectSum[i];
    			result = "";
    			result += (i+1)+" ";
    		}else if(max==collectSum[i]) {
    			result += (i+1)+" ";
    		}
    	}
    	String[] strings = result.split(" ");
        int[] nums = new int[strings.length];
        for(int i=0; i<strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        return nums ;
    }
    
    public void checkProblem(int[][] student, int[] answers) {
    	for(int i=0; i< student.length; i++) {
        	for(int j=0; j< answers.length;j++) {
        		int ps = j % student[i].length; //personSolve
        		if(answers[j] == student[i][ps]) {
        			collectSum[i]++;
        		}
        	}
    	}
    }
	    
}

