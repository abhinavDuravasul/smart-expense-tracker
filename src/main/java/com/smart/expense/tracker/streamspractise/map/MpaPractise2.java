package com.smart.expense.tracker.streamspractise.map;

import java.util.List;
import java.util.stream.Collectors;

public class MpaPractise2 {

//  1  Square of Numbers
//    Given a List<Integer>, return a list where each element is squared.

    static  List<Integer>  squaresOfNums(List<Integer> nums){

        return nums.stream().map((Integer number)-> number*number).collect(Collectors.toList());
    }

//   2 Extract First Character
//    Given a list of words, return a list of the first letter of each word.

      static List<Character> xtractFirstCharacterOfStr(List<String> words){

       return words.stream().map((String word)->word.charAt(0)).collect(Collectors.toList());

      }

//   3 Convert Strings to Integers
//    Given a list of numeric strings, convert them into actual Integer values.

      List <Integer>   convertToNumericStrings(List<String> names){
      return names.stream().map((word)-> Integer.valueOf(word)).collect(Collectors.toList());
}



    public static void main(String[] args) {

        List<Integer> nums = List.of(2,4,6,8,9,7);
        System.out.println( "Squares of Numbers : "   +squaresOfNums(nums));

        List<String> words = List.of("Abhinav", "SreeLeela");
        System.out.println(xtractFirstCharacterOfStr(words));

    }
}
