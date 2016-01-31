package arrays_strings;

// Question 1.4 Replace space characters in string with "%20"
public class ReplaceSpacesInString {

    public static char[] ReplaceSpaces(String inputString, int trueStringLength) {

        char[] array = inputString.toCharArray();
        int arrayLength = array.length;
        int j = arrayLength - 1;

        for (int i = (trueStringLength-1) ; i >= 0; i--) {

            if(array[i] != ' ') { // is not a space char
                array[j] = array[i];
                j--;
            }
            else { // is a space char
                array[j] = '%';
                array[j-1] = '0';
                array[j-2] = '2';
                j -= 3;
            }
        }
        return array;
    }

    public static void printArray(char[] charArray) {
        String outputString = "";
        for(int k=0; k < charArray.length; k++){
            outputString += charArray[k];
        }
        System.out.println(outputString);
    }

    // main
    public static void main(String[] args) {

        char[] array = ReplaceSpaces("Mr John Smith    ", 13);
        printArray(array);

        char[] array2 = ReplaceSpaces("Hi there Mr John      ", 16);
        printArray(array2);
    }
}
