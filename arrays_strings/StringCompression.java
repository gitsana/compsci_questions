package arrays_strings;

// Question 1.5 Implement a method to perform basic string compression
public class StringCompression {
    public static void main(String[] args) {

        System.out.println(compressedString("hhaappyyyy"));

    }

    public static String compressedString(String str) {

        if (str.length() == 1) {
            return str;
        }
        else {
            char[] strArray = str.toCharArray();
            char letter;
            int letterCount = 0;
            String compressedString = "";
            int i=0;
            letter = strArray[i];

            while (i+1 < strArray.length) {

                letterCount ++;

                // next char is NOT equal to next character
                if (letter != strArray[i+1]) {
                    compressedString = compressedString + letter + letterCount;
                    letterCount = 0;
                }
                i ++;
                letter = strArray[i];
                System.out.println("end of while loop. i=" + i + ", letter=" + letter + ", lettercount= " + letterCount);
            } // end while

            compressedString = compressedString + letter + (letterCount+1);
            System.out.println("Compressed String is: " + compressedString);

            if (compressedString.length() < str.length())
                return compressedString;
            else
                return str;

        } // else

    } // compressedString method
}
