package arrays_strings;

public class Main {

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "elloh";
        int[] letters = new int[128];
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        boolean isPerm;

        // add letter counts of str1
        for( char c : str1CharArray ) {
            letters[c]++;
        }

        // decrement letter counrts of str2
        for (char c : str2CharArray) {
            letters[c]--;
            if(letters[c] < 0 ){
                isPerm = false; // return here
            }
        }

        for (int i=0; i < letters.length; i++) {
            if (letters[i] != 0)
                isPerm = false; // return
        }


    }
}
