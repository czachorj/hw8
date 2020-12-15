//
public class RecursionQuestion {
	public static void main(String[] args) {
		killCommas("sd,f,fsdf,sdf,");
	}

	static String killCommas(String s) {
		int commaCount = 0;

		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ',') {
				commaCount++;
			}
		}

		//base case - no more commas
		if(commaCount ==0) {
			System.out.println(s);
			return s;
		}

		//recursion case
		else {
			int index = s.indexOf(','); //first occurrence of comma


			return killCommas(s.substring(0, index) + s.substring(index + 1)); //concatenate the string up to the comma, and everything after the comma
		}

	}
}
//	
//	
//	static int sumDigits(int num) {
//		int sum;
//		return sum;
//	}
//	
//	static void powerSet(int [] arr) {
//		return;
//	}
//	
//	

