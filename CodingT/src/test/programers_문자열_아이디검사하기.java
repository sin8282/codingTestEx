package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
/*
 */
public class programers_문자열_아이디검사하기 {
	
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        if(new_id.equals("")) new_id = "a";
        if(new_id.length()>=16) {
        	new_id = new_id.substring(0,15); 
        	new_id = new_id.replaceAll("\\.$", "");
        }
        if(new_id.length()<3) {
        	while(new_id.length()!=3) {
        		new_id += new_id.charAt(new_id.length()-1);
        	}
        }

        return new_id;
    }
}
