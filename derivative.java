

public class derivative {
	
	public static void main(String[] args) {
		String s = "7*x^2 + -6*x^5 + 2*x^3";		
		derive(s);
	}

	public static void derive(String s) {
		int numPlus = 0;

		for (int i = 0;i < s.length() ;i++ ) {
			if(s.charAt(i) == '+')
				numPlus++;
		}

		int[] coeffs = new int[numPlus + 1];
		int[] exp = new int[numPlus + 1];
		int index;
		String[] tokens = s.split("[ + ]+");

		for (int i = 0; i < tokens.length; i++) {
			String[] val = tokens[i].split("[*x^]+");
			coeffs[i] = Integer.parseInt(val[0]);
			exp[i] = Integer.parseInt(val[1]);
		}

		for (int i = 0; i < coeffs.length; i++) {
			coeffs[i] *= exp[i];
			exp[i] -= 1; 
		}

		for (int i = 0; i < numPlus + 1; i++) {
			System.out.print(coeffs[i] + "*x^" + exp[i]);
			if(i < numPlus)
				System.out.print(" + ");
		}
		System.out.println();

		// String temp = "a + b ++ c";
		// String[] tk = temp.split("[+]+");
		// for (int i = 0; i < tk.length; i++) {
		// 	System.out.println(tk[i]);
		// }
	}
}