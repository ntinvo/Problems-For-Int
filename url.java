import java.util.*;

public class url {

	/* Replace ' ' with %20 */
	
	public static void main(String[] args) {
		char[] chArray = "\"Mr Tin Vo   \", 9".toCharArray();

		// int len = chArray.length;
		// for(int i = 0; i < len; i++) {
		// 	System.out.print(chArray[i]);
		// }

		System.out.println();
		System.out.println(urlReplace(chArray));
	}

	public static String urlReplace(char[] chArray) {
		StringBuilder s = new StringBuilder();
		StringBuilder num = new StringBuilder();

		for(int i = chArray.length - 1; i > 0; i--) {
			if(chArray[i] == ' ')
				break;
			num.append(chArray[i]);
		}
		num.reverse();
		int len = Integer.parseInt(num.toString());
		
		for(int i = 1; i <= len; i++) {
			if(chArray[i] == ' ')
				s.append("%20");
			else
				s.append(chArray[i]);
		}

		return s.toString();
	}
}