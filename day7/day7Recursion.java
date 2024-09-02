class day7Recursion{
	public static void main(String[] args){

		System.out.println(bunnyEars2(3));
	}

	public static int bunnyEars2(int bunnies){
		if(bunnies<1){
			return 0;
		}
		if (bunnies%2==0) {
			return bunnyEars2(bunnies-1)+1;			
		} else {
			return bunnyEars2(bunnies-1)+2;
		}
	}
}