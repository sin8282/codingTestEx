package test;


import java.util.Arrays;
import java.util.LinkedList;
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성

 */
public class programers_완전탐색_수식최대화 {
	char [][] priority = {
			{'*','+','-'}
			,{'*','-','+'}
			,{'+','*','-'}
			,{'+','-','*'}
			,{'-','*','+'}
			,{'-','+','*'}
	};
    public long solution(String expression) {
    	//100-200*300+500+20
    	//100 200 300 500 20
    	// - * + +
        long answer = 0;
        long sumMax = 0;
        for(char selected[] :priority) {
            LinkedList<String> number = new LinkedList<String>(Arrays.asList(expression.split("\\+|\\-|\\*")));
            LinkedList<String> exp =new LinkedList<String>( Arrays.asList(expression.split("[0-9]+")));
        	long sum = 0;
        	long cal = 0;
        	for(int i=0; i<3; i++) {
        		for(int j=1; j<exp.size();) {
        			int index = exp.get(j).charAt(0) == selected[i] ? j : 0;
        			if(index > 0) {
        				switch (selected[i]) {
        				case '+': cal= Long.parseLong(number.get(index-1)) + Long.parseLong(number.get(index)); break;
        				case '-': cal= Long.parseLong(number.get(index-1)) - Long.parseLong(number.get(index)); break;
        				case '*': cal= Long.parseLong(number.get(index-1)) * Long.parseLong(number.get(index)); break;
        				}
        				number.set(index-1, cal+"");
        				number.remove(index);
        				exp.remove(index);
    					sum=cal;
        			}else j++;
        		}
        	}
        	if (sumMax < Math.abs(sum)) sumMax = Math.abs(sum);
        	answer = sumMax;
        }
        return answer;
    }

}
