class day7{
	public static void main(String[] args){
		rPrint(5);
		
		System.out.println("Sum of nums: " + rAdd(4));

		System.out.println("Factorial: "+rFact(4));

		String check = "UTEP";

		System.out.println(isPalindrome(check));
	}

	static boolean isPalindrome(String s){
		if(s.length==0 || s.length==1){
			return true;
			if(s.charAt(0) != s.charAt(s.length()-1)){
				return false;	
			}
			String sub = s.substring(1,s.length()-1);
			return isPalindrome(sub);
		}
	}

	static void rPrint(int i){
		if(i<0){
			return;
		}
		System.out.println(i);
		rPrint(i-1);
	}

	static int rAdd(int n){
		if(n<1){
			return 0;
		}

		return n+rAdd(n-1);
	}

	//factorial 4!=4*3*2*1

	static int rFact(int n){
		if (n<0) {
			return 1;			
		}

		return n*rFact(n-1);
	}
}