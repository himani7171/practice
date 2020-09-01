package com.practice.project;

/* Problem Name is &&& Group Anagrams &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Given a list of words, group them by anagrams
 *     Input: List of "cat", "dog", "god"
 *     Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 *  2) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  3) Consider adding some additional tests in doTestsPass().
 *  4) Implement the AnagramSolution group() method correctly.
 *  5) If time permits, try to improve your implementation.
 
 a =141 b=142 c=143 d=144, e=145
 ad,  bc

abb == dc
 abc = bd
 */
import java.util.*;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class Solution11 {

  /**
   * A means for grouping words by anagram (same letters irrespective of order)
   */
  @FunctionalInterface
  interface AnagramSolution {
    Set<Set<String>> group(List<String> words);
  }

  /**
   * public static boolean doTestsPass()
   * Returns true if all tests pass. Otherwise returns false
   */
  public static boolean doTestsPass(){
    // todo: implement more tests, please
    // feel free to make testing more elegant
    
    Set<Set<String> > grouped = new HashSet<>();

    // given some words
    List<String> words = Arrays.asList("cat", "dog", "god", "cat");

    Map<String, Set<String>> sortedResult = new HashMap<>();
    
    for( String word : words){
      char[] a = word.toCharArray();
      Arrays.sort(a);
      String sorted =  new String (a);
      if(sortedResult.get(sorted) !=null ){
        sortedResult.get(sorted).add(word);
      }else{
        Set<String> res = new HashSet<String>();
        res.add(word);
        sortedResult.put(sorted, res);
      }
      
    }
    
     grouped = sortedResult.values().stream().collect(Collectors.toSet());
    // we expect god and dog to be identified as anagrams, whilst cat isn't
    boolean result = true;
    result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
    result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
    return result;
  };

// cc ca
  private static boolean checkAnagram( String a , String b ) {
   
    List<Character> first = a.chars()         
        .mapToObj(e -> (char)e)   
        .collect(Collectors.toList());
    List<Character> second =  b.chars()       
        .mapToObj(e -> (char)e)   
        .collect(Collectors.toList());
 
      if(first.containsAll(second) && second.containsAll(first) ) {
        return true;
              
    }
    return false;
  }
  /**
   * Execution entry point.
   */
  public static void main(String[] args){
    if(doTestsPass()){
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }

  }
}
