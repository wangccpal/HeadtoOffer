package javapuzzle;

import java.io.UnsupportedEncodingException;

/**
 * 我们知道char是2字节，只能表示256个字符，所以如果是中文会怎么样？
 * 错，两个字节可以表示256 * 256 个字符，java默认是unicode ，可以表示中文
 * @author CC
 *
 */
public class CharTest {

//	public static void main(String[] args) {
//		char c = 's';
////		char d = "";
//		char e = '是';
//		System.out.println(e);
//	}
    public static void main(String[] args) {  
        String str= "中";  
        char x ='中';  
        byte[] bytes=null;  
        byte[] bytes1=null;  
        try {  
            bytes = str.getBytes("utf-8");  
            bytes1 = charToByte(x);  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println("bytes 大小："+bytes.length);  
        System.out.println("bytes1大小："+bytes1.length);  
    }  
    public static byte[] charToByte(char c) {   
        byte[] b = new byte[2];   
        b[0] = (byte) ((c & 0xFF00) >> 8);   
        b[1] = (byte) (c & 0xFF);   
        return b;   
    }  

}
