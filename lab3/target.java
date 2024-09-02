class target{
	public static void main(String[] args){
		
		int[] nums = {2,7,11,15};
		int target = 18;

		int[] answer = sumTarget(nums, target);

		for (int i=0;i<answer.length;i++){
			System.out.print(answer[i]+" ");
			
		}

	}

	public static int[] sumTarget(int[] arr, int target){
			int [] indexs = new int [2];
			for(int i=0;i<arr.length;i++){
				for(int j=1;j<arr.length;j++){
					if(arr[i]+arr[j]==target){
						indexs[0] = i;
						indexs[1] = j;
					}
				}
			}
			return indexs;
		}
}