class urMom{
	public static void main(String[] args){
		int[][] arr= {
			{1,2,4,2,1},
			{5,6,7,9,2}
		};
		int[] res = m1(arr);
		System.out.println(res[0]);
	}
	public static int[] m1(int[][] m){
		int[] result = new int[2];
		result[0]=m.length;
		result[1]=m[0].length;
		return result;
	}
}