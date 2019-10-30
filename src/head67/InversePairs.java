package head67;

public class InversePairs {
	public static int InversePairs(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j])
					count++;
			}
		}
		return count;
	}

	public static int InversePairs1(int[] array) {// �鲢�汾
		int[] auk = new int[array.length];
		return InversePairsCore(array, 0, array.length - 1, auk);

	}

	private static int InversePairsCore(int[] nums, int left, int right, int[] auk) {
		if (left >= right)
			return 0;
		int mid = left + (right - left) / 2;
		int lcount = InversePairsCore(nums, left, mid, auk);
		int rcount = InversePairsCore(nums, mid + 1, right, auk);
		int i = mid;
		int j =right;
		int count = 0;
		int k = right;
		while(i>=left&&j>=mid+1){
			if(nums[i]>nums[j]) {
				auk[k--] = nums[i--];
				count+=j-mid;
			}else auk[k--] = nums[j--];
		}
		while(i>=left) auk[k--] = nums[i--];
		while(j>=mid+1) {
//			count+= j-mid;
			auk[k--] = nums[j--];
		}
		for(int l=left;l<=right;l++) nums[l]=auk[l];//����Ҫ����ָOFFER��û����
		return  lcount+rcount+count;
	}


	public static void main(String[] args) {
		int[] s = { 1, 2, 3, 4, 5, 6, 7, 0 };
		System.out.println(InversePairs1(s));
	}

}
