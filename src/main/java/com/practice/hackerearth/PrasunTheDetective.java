package com.practice.hackerearth;
import java.io.*;
import java.util.*;

class PrasunTheDetective{
    public static void main(String args[] ) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String i1 = br.readLine().toUpperCase();
        String i2 = br.readLine().toUpperCase();  
//        i1=i1.replaceAll("[^a-zA-Z0-9]", ""); 
//        i2=i2.replaceAll("[^a-zA-Z0-9]", "");
        
        char[] a = i1.toCharArray();
        List<Character> l1= new ArrayList<Character>();
        for (char c : a) {
			l1.add(c);
		}
        //Arrays.sort(a); 
        char[] b = i2.toCharArray();
        List<Character> l2= new ArrayList<Character>();
        for (char c : b) {
			l2.add(c);
		}
        if(l1.containsAll(l2)) {
        	System.out.println("YES");
        }else {
        	System.out.println("NO");
        }
      
    }
}
