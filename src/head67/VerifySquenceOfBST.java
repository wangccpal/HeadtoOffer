package head67;

/*
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class VerifySquenceOfBST {
	public static boolean VerifySquenceOfBST(int[] sequence) {
		return ver(sequence, 0, sequence.length-1);
	}

	private static boolean ver(int[] sequence, int lo, int hi) {
		if(lo>=hi) return true;//ע���Ǵ��ڵ��ںţ�����������Ϊ�յ����
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
