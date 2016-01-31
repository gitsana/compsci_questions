package arrays_strings;

// Twilio interview question
public class AbbreviateString {

    public static void main(String[] args) {

        String string = "Sana";
        System.out.println("Abbreviated string: " + abbreviateString(string));
    }

    public static String abbreviateString(String string) {

        string = string.trim(); // remove whitespaces at the ends
        int count = string.length() - 2;
        String abbreviatedString;
        abbreviatedString = "" + string.charAt(0) + count + string.charAt(string.length()-1);
        return abbreviatedString;
    }
}
