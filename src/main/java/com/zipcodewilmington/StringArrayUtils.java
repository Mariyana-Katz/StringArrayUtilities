package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
       //Checking if the array is not empty and return the first element, otherwise return empty string.
        if(array.length>0){
            return array[0];
        }
        else {
            return "";
        }

    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        //Checking if the array is not empty and return the second element, otherwise return empty string.
       if(array.length > 1){
           return array[1];
       }
       return "";
    }


    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
      //Checking is the array is not empty, and returning the last element.
       if(array.length> 0){
           return array[array.length - 1];
       }
       return "";
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        if(array.length>1){
        return array[array.length - 2];
        }
        return "";
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        //using for each loop to see is there a specific value into the string.
        for(String s: array){
          if( s.contains(value)) {
              return true;
          }
       }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
      //I am using for loop to go trough the array but separating the length in half. Then declaring a temporary string variable to use it to switch the spots of the element into the array.
       for(int i = 0; i< array.length/2; i++){
           String temp = array[i];
           array[i] = array[array.length-1-i];
           array[array.length-1-i] = temp;

       }
       return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

         for(int i=0;i<array.length/2;i++){
            if(array[i] != array[array.length-1-i]){
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        //Convert the array to single  lowercase String. Loop trough each letter, to check if it has been used.
        String arr = Arrays.toString(array).toLowerCase();
        for (char letter = 'a'; letter <= 'z'; letter++){
              //Convert char to string.
            String letter1 = Character.toString(letter);
           if(!arr.contains(letter1)){
               return false;
                }
          }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int counter = 0;
        for(String s: array){
            if( s.contains(value)) {
            counter ++;}
        }

        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       //use a temp Arraylist to store the values that are not equal to the valueToRemove.
        // Loop trough each array element, compare the element with  valueToRemove by using !Object.equals() static method.
        //adding the different elements to the arraylist.
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(!Objects.equals(array[i], valueToRemove)){
                list.add(array[i]);}

        }
       //Convert arraylist to array.
        return list.toArray(new String[list.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO

    public static String[] removeConsecutiveDuplicates(String[] array) {
         //the same like the remove one. Creating a temp arralist and for each loop.
        // the if statement checks either the arraylist is empty or the element is not equal to the next element.
        // if that is true the element ii added to the arraylist. Then we convert it to array..
       ArrayList<String> list = new ArrayList<>();
       for(String e: array){
           if(list.isEmpty() || !Objects.equals(list.get(list.size()-1),e)){
               list.add(e);
           }

       }
        //Convert the arraylist into array of type String with the same size/length as tha arraylist.
       return list.toArray(new String[list.size()]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> list = new ArrayList<>();
        String conCat = "";//current concat String.
        String lastStr = "";//last concatenated String.
        for(String e: array) {
           //Compare the element with last string. If the element is not equal add concatenated String
            // to the arraylist and the new element to the lastStr and conCat.
            //Otherwise concatenate the element to the conCat string.

            if(!Objects.equals(lastStr, e)){
                if(conCat.length()>0){
                    list.add(conCat);
                }
                conCat = e;
                lastStr = e;
            }
            else {
                conCat += e;
            }
        }
            //If the concatenated string is not empty,
        // and there are no elements in the array to compare, add the conCat value to the arraylist.
        if(conCat.length()>0) {
            list.add(conCat);
        }
        //Convert the arraylist to the array.
        return list.toArray(new String[list.size()]);
    }
}


