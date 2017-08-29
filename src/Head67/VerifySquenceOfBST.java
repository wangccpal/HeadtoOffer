package Head67;

/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
	public static boolean VerifySquenceOfBST(int[] sequence) {
		return ver(sequence, 0, sequence.length-1);
	}

	private static boolean ver(int[] sequence, int lo, int hi) {
		if(lo>=hi) return true;//注意是大于等于号，包括右子树为空的情况
		int node = sequence[hi];
		int i=lo;
		while(sequence[i]<node&&i<hi){
			i++;
		}
		for(int j=i;j<hi;j++){
			if(sequence[j]<node) return false;
		}
		return ver(sequence,lo,i-1)&&ver(sequence,i,hi-1);
	}

	public static void main(String[] args) {
		int[] nums = {5,7,6,9,11,10,8};
		int [] nums1={1,4,3,5};
		int [] nums2={6,7,5};
		System.out.println(VerifySquenceOfBST(nums2));
	}

}
