package arrays_strings;

// Question 1.8 Given two strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call
// to isSubstring() method.
public class RotationIsSubstring {

    public static void main(String[] args) {

        String str1 = "waterbottle";
        String str2 = "erbottlewat";

        //System.out.println(isSubstring("My nam name is","My nam")); // test isSubstring method

        str1 += str1; // if str2 were a rotation, it would have to be of str1 in a row twice, no matter where the split is
        System.out.println(isSubstring("Is str2 a substring of str1? " + str1,str2));
    }

    public static boolean isSubstring(String string1, String string2) {

        if (string1.indexOf(string2) >= 0) // returns the index of the position, which starts at 0. -1 means not there
            return true;
        else
            return false;
    }


}
