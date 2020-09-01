package com.practice.project;
/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class BracesSequence {
  public static void main(String[] args) {
    System.out.println(isValid("[{()}]"));
  }
  
  public static boolean isValid(String s){
    
    if( s.length() <2 ){
      return false;
    }
    Stack<Character> stk = new Stack<Character>();
    int i =0;
    while(i < s.length()){
      if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
        stk.push(s.charAt(i));
        
      }else{
        if(s.charAt(i) == '}'){
           if( stk.peek()  == '{'){
             stk.pop();
           }else{
             return false;
           }
        }else if(s.charAt(i) == ')'){
          if( stk.peek()  == '('){
              stk.pop();
           }else{
             return false;
           }
          
        }else if(s.charAt(i) == ']'){
          if( stk.peek()  == '['){
              stk.pop();
           }else{
             return false;
           }
          
        }
      }
      i++;
    }
  return stk.empty() ? true: false;
  }
}
