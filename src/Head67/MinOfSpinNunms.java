package Head67;

public class MinOfSpinNunms {
    public static int minNumberInRotateArray(int [] array) {
    	
    	int lo = 0;
        int hi = array.length-1;
        int mid = 0;
        if(array[0]<array[hi]) return array[0];
        while(lo<=hi){
             mid = lo+(hi-lo)/2;
             //这个题的难点在于要和数组尾部比较而不是和头部比较。比如{2，1}如果和头部比较，mid和lo都是2，少了比较；
             //如果和尾部比较，mid=2，hi=1才正确；
             //另外不要忘了mid<尾部时 不能排除mid是最小的情况
            if(array[mid]>array[hi]) lo = mid + 1;
            else if(array[mid]<array[hi]) hi = mid;
            else hi--;
        }
        return array[mid];//return lo 也行
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,5,1,2};
		int[] array1 = {1,0,1,1,1};
		System.out.println(minNumberInRotateArray(array));
		System.out.println(minNumberInRotateArray(array1));
		
	}

}
