package com.smart.expense.tracker.streamspractise.map;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapPractise {

    //1 Capitalize Names
   // Given a List<String> of names, return a new list where each name is in uppercase.

    //2 Length of Strings
    //Given a list of strings, return a list of their lengths.

    List<String> capitalizeStrings(List<String> list ) {
      //   List<String> names = Arrays.asList("alice", "bob", "charlie");
        List<String > uppercaseNames  = list.stream().map((String name)->name.toUpperCase()).collect(Collectors.toList());
        list.set(0, "India");
       return  list;
    }

    List<Integer> findLengthOfStrings(List<String> list){

      return  list.stream().map((String lengths)-> lengths.length()).collect(Collectors.toList());
    }

//   3 Add Prefix to Each String
//    Given a list of file names, add the prefix "file_" to each name.

    Set<String> addPrefix(List<String> names){
        return names.stream().map((String name)->"Name_"+name).collect(Collectors.toSet());
    }

    List<String> addPrefix2(List<String> names){
        return names.stream().map((String name)->"Name_"+name).collect(Collectors.toList());
    }



    public static void main(String[] args) {

        List<String> names = Arrays.asList("keth", "bob", "charlie","bob","a","a");
        MapPractise mapPractise = new MapPractise();
        List<String> result = mapPractise.capitalizeStrings(names);
        System.out.println("CAPITALIZE :" +result);
         List<Integer> lengths = mapPractise.findLengthOfStrings(names);
        System.out.println("LENGTH Of Strings :" + lengths);
        Set<String> prefixes = mapPractise.addPrefix(names);
        System.out.println("PREFIX Of Strings :" + prefixes);
        List<String >  prefix2 =  mapPractise.addPrefix2(names);
        System.out.println("PREFIX Of Strings :" + prefix2);


    }

}
