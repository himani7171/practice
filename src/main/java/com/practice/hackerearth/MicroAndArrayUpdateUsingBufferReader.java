package com.practice.hackerearth;
/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//due to scanner it took 11 seconds on hackerrank

class MicroAndArrayUpdateUsingBufferReader {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN

        //Scanner
        int t = Integer.parseInt(name);
        int k=0,n=0;
        
        while (t>0) {
        	int min=  Integer.MAX_VALUE;

        	name=br.readLine(); 
        	String[] split = name.split(" ");
        	
        	n= Integer.parseInt(split[0]);
        	k= Integer.parseInt(split[1]);
        	
        	name=br.readLine(); 
        	split = name.split(" ");
        	
        	for (String p : split) {
				int parseInt = Integer.parseInt(p);
				if(parseInt <min) {
					min = parseInt;
				}
			}
//        	List<Integer> l = Stream.of(split).map(x-> Integer.parseInt(x)).collect(Collectors.toList());
        	
        	
        	//logic 
//        	Integer min = Collections.min(l);
        	if(min > k) {
        		System.out.println(0);
        	}else {
        		System.out.println(k-min);
        	}
        	--t;
        }
        
    }
}
