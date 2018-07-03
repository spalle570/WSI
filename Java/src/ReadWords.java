import java.util.Scanner;

public class ReadWords {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String str = read.nextLine();
		String[] words = str.split(" ");
		String reversedString = "";
		for (int i = 0; i < words.length; i++)
	        {
	           String word = words[i]; 
	           String reverseWord = "";
	           for (int j = word.length()-1; j >= 0; j--) 
		   {
			/* The charAt() function returns the character
			 * at the given position in a string
			 */
			reverseWord = reverseWord + word.charAt(j);
		   }
		   reversedString = reversedString + reverseWord + " ";
		}
		//System.out.println(str);
		System.out.println(reversedString);

	}
}
