package arrays_strings;

import java.util.HashMap;
import java.util.Map;

// Question 1.3 Given two strings, write a method to decide if one is a permutation of the other
public class CheckPermuation {

    public static void main(String[] args) {

        String str1 = "mangopeach";
        String str2 = "peachmango";

        System.out.println("Is permutation? (by hashmap) " + isPermutationByHashmap(str1, str2));
        System.out.println("Is permutation? (by sorting) " + isPermutationBySorting(str1,str2));
        System.out.println("Is permutation? (by array) " + isPermutationByArray(str1,str2));


    } // end main

    public static void printHashmap(Map<Character, Integer> str1Hash) {
        System.out.println("Printing str1Hash: " + str1Hash);

        // traverse hashmap
        for(Map.Entry<Character,Integer> entry : str1Hash.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    // put one string into a hashmap then deduct with other string
    public static boolean isPermutationByHashmap(String str1, String str2) {
//        boolean isPerm = true;

        if(str1.length() != str2.length()) {
            return false;
        }
        else {
            Map<Character, Integer> str1Hash = new HashMap<>();

            char key;
            Integer value;

            // put values of str1 into str1Hash
            for(int i=0; i < str1.length(); i++) {
                key = str1.charAt(i);
                value = str1Hash.get(key);

                if (value != null) { // check if exists already
                    value += 1;
                    str1Hash.put(key, value);
                }
                else {
                    str1Hash.put(key, 1);
                }
            } // end for

            // decrement values of str2 from str1Hash
            for(int i=0; i < str2.length(); i++) {
                key = str2.charAt(i);
                value = str1Hash.get(key);

                if(value == null) {
                    return false; // not in the hash
                }
                else {
                    value--;
                    if(value < 0) {
                        return false;
                    }
                    else {
                        str1Hash.put(key, value);
                    }
                }
            }
        }
        return true;
    }

    // sort the two strings then compare them
    public static boolean isPermutationBySorting(String str1, String str2) {

        if ( str1.length() != str2.length() ) {
            System.out.println("returning false");
            return false;
        }
        else {
            String sortedStr1 = sortString(str1);
            String sortedStr2 = sortString(str2);

            //System.out.println("Two sorted strings: " + sortedStr1 + ", " + sortedStr2);

            return (sortedStr1.equals(sortedStr2));
        }
    }

    public static boolean isPermutationByArray(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        else {
            int[] lettersArray = new int[128];
            char c;

            // record in str1
            for (int i=0; i < str1.length(); i++) {
                c = str1.charAt(i);
                lettersArray[c] ++;
            }

            // now decrement with str2
            for (int i=0; i < str2.length(); i++) {
                c = str2.charAt(i);
                lettersArray[c] --;
                if (lettersArray[c] < 0) { // any one is not equal
                    return false;
                }
            } // for

            for (int i : lettersArray) {
                if (i != 0)
                    return false;
            }

            return true;
        }
    }

    public static String sortString(String str) {

        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
//        String sortedString = charArray.toString();   // This does NOT work
//        return new String (charArray);                // works
        return String.valueOf(charArray);               // works
    }

    public static void printCharArray(char[] array) {
        String s = "";
        for(int i=0; i < array.length; i++) {
            s += array[i];
        }
        System.out.println(s);
    }

}
