package arrays_strings;

// Question 1.1
public class UniqueCharsInString {

    public static void main(String[] args) {

        String s1 = "chin";

        System.out.println("Is '" + s1 + "' unique chars? " + isUniqueCharsInStringByArray(s1));

    }

    public static boolean isUniqueCharsInStringByArray(String str) {
        if (str.length() > 128) { // greater than 128 chars means not unique
            return false;
        }
        else{
            int[] letters = new int[128];
            char c;

            // put all into array
            for (int i=0; i < str.length(); i++) {
                c = str.charAt(i);
                letters[c] ++;
            }

            // check if any are greater than 1 in array
            for (int i : letters) {
                if ( i > 1 ) {
                    return false;
                }
            }
            return true;
        }

    }
}
