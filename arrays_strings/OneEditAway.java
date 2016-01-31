package arrays_strings;

public class OneEditAway {
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";

        int i = -2;
        System.out.println(Math.abs(i));

    }

    public static boolean isOneOrZeroEditAway(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        if (Math.abs(str1.length()-str2.length()) > 1) {
            return false;
        }

        if (str1.length() == str2.length()) { // need to replace
            int replacementCount = 0;
            for (int i=0; i<str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    replacementCount++;
                }
                if (replacementCount > 1){
                    return false;
                }
            }
            return true;
        } // end if
        else if (str1.length() - str2.length() == 1) { // str1 is longer
            // add code
            return true;
        }
        //add code
        return true;
    }
}
