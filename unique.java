public class unique {
	public static void main(String[] args) {
		String s1 = "abcdef";
		String s2 = "apple";
		System.out.println(isUnique(s1));
		System.out.println(isUnique(s2));
	}

	public static boolean isUnique(String s) {
		boolean[] ch = new boolean[128];

		for (int i = 0; i < s.length(); i++) {
			int temp = (int) s.charAt(i);
			if(ch[temp])
				return false;
			ch[temp] = true;
		}
		return true;
	}
}