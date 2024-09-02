import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.print("Enter a string to check if it is a palindrome: ");
        String palindrome = scanner.nextLine();
        if ("exit".equals(palindrome)) return;

        if (isPalindromeRecursive(palindrome,0, palindrome.length() - 1)) {
            System.out.println("The input string is a palindrome.");
        } else {
            System.out.println("The input string is not a palindrome.");
        }

        System.out.println("--------------------------------------");
        System.out.print("Enter a sentence to count the number of words: ");
        String countWords = scanner.nextLine();
        if ("exit".equals(countWords)) return;

        int wordCount = countWordsRecursive(countWords);
        System.out.println("Word count: " + wordCount);

        System.out.println("--------------------------------------");
        System.out.print("Enter a string to encrypt: ");
        String encryptMessage = scanner.nextLine();
        if ("exit".equals(encryptMessage)) return;
        System.out.print("Enter the number of shifts: ");
        int shiftInt = scanner.nextInt();
        scanner.nextLine();

        String encryptedMessage = encryptRecursive(encryptMessage, shiftInt);
        System.out.println("Encrypted message: " + encryptedMessage);


        System.out.println("--------------------------------------");
        System.out.println("Enter a sentence to replace '13' with 'thirteen': ");
        String original = scanner.nextLine();
        if ("exit".equals(original)) return;
        String replaced = replace13WithThirteenRecursive(original);
        System.out.println(replaced);


        System.out.println("--------------------------------------");
        System.out.println("Enter a word ");
        String word = scanner.nextLine();
        System.out.println("Enter a char you wish to remove from the word ");
        char ch = scanner.next().charAt(0);
        if ("exit".equals(word)) return;
        word = removeOccurrencesRecursive(word, ch);
        System.out.println(word);


    }

    /**
     * Complete this method to check if the input string is a palindrome
     * given a string, left index and right index
     * @param str
     * @param left
     * @param right
     * @return boolean
     */
    public static boolean isPalindromeRecursive(String str, int left, int right) {
        //I wasnt too sure how to use int left and right but I was able to get it work without them.
        if(str.length()<=1){ //Checks if the str is empty or has 1 char. (Words with an odd number of chars will have one leftover).
            return true;
        }
        if(str.charAt(0)==str.charAt(str.length()-1)){ //Checks if the first and last char are =.
            return isPalindromeRecursive(str.substring(1,str.length()-1), left, right); //Returns the string without the first and last chars.
        } else {
            return false;
        }
    }
    /**
     * Complete this method to count the number of words on a sentence
     * given a sentence
     * @param paragraph
     * @return int
     */
    public static int countWordsRecursive(String paragraph) {
        if(paragraph.length()==0){ //base case
            return 1; //since i am checking the number of spaces, the last word will not have a space after, therefore we must account for that by returning 1.
        }
        if(paragraph.charAt(0)==' '){ //checking for a space.
            return 1+countWordsRecursive(paragraph.substring(1)); //if there is one we add 1 to the count.
        } else {
            return countWordsRecursive(paragraph.substring(1)); //else, we just return the method with a shorter string.
        }
    }

    /**
     * Write a Java program that implements the Caesar Cipher encryption algorithm.
     * The user is going to enter a plaintext message and a shift value.
     * Encrypt the message using the Caesar Cipher with the given shift value and display the encrypted message.
     * @param message
     * @param shift
     * @return String
     */
    public static String encryptRecursive(String message, int shift) {
        if(message.length()==0){ //Base case.
            return message; 
        }
        char newChar =(char) (message.charAt(0)+shift); //Changes the char to the new one.
        return newChar+encryptRecursive(message.substring(1), shift); //Returns the new char and continues going throughout the string and doing the same.
    }

    /**
     * Write a java recursive program to replace all instances of the string "13" with â€œthirteenâ€
     * @param str
     * @return String
     */
    public static String replace13WithThirteenRecursive(String str) {
        if(str.length()<=1){ //Base case because "13" is more than one char, therefore if the string is length 1, we dont need to check.
            return str;
        }
        if(str.charAt(0)=='1' && str.charAt(1)=='3'){ //if 13 is found:
            return "thirteen" + replace13WithThirteenRecursive(str.substring(2)); //it is replaced with thirteen, and we continue going through the string.
        } else {
            return str.substring(0,1)+replace13WithThirteenRecursive(str.substring(1)); //otherwise, the original string should still be returned.
        }
    }

    /**
     * Write a recursive Java function to remove all occurrences of a specified character from a given string.
     * @param str
     * @param ch
     * @return String
     */
    public static String removeOccurrencesRecursive(String str, char ch) {
        if(str.length()==0){ //Base case.
            return "";
        }
        if(str.charAt(0)==ch){ //Checks if the character is the one we need to remove.
            return removeOccurrencesRecursive(str.substring(1), ch); //returns the string excluding that char.
        } else {
            return str.charAt(0)+removeOccurrencesRecursive(str.substring(1),ch); //otherwise, the original string/char is still returned.
        }
    }





}