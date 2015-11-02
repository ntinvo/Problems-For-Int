import java.util.*;

public class permutation {

	/* Check permutation */
	
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "cab";
		System.out.println(isPermutation(s1, s2));

		String s3 = "zac";
		String s4 = "caj";
		System.out.println(isPermutation(s3, s4));
	}

	public static boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		char[] chArray1 = s1.toCharArray();
		char[] chArray2 = s2.toCharArray();
		Arrays.sort(chArray1);
		Arrays.sort(chArray2);
		return (new String(chArray1).equals(new String(chArray2)));
	}
}