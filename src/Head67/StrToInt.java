package Head67;

public class StrToInt {
    public int StrToInt(String str) {
        if("".equals(str)) return 0;
        int rst = 0;
        int flag = 1;
        for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
            if(i==0&&c=='-') {
                flag=-1;
                continue;
            }
            else if(i==0&&c=='+') {
            	continue;
            }
            if(c>'9' || c<'0') return 0;
            int r = c-'0';
            rst = rst*10 + r; //res = (res << 1) + (res << 3) + (str[i] & 0xf);
        }
        return flag*rst;
    }
    public static void main(String[] args) {
		
	}
}
