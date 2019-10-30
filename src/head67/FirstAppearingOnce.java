package head67;

public class FirstAppearingOnce {
	private int[] nums = new int[256];
	StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

	}
    public void Insert(char ch)
    {
        nums[ch]++;
        sb.append(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for (char c : sb.toString().toCharArray() ) {
			if(nums[c]==1) return c;
		}
		return '#';
    }
}
