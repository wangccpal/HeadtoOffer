package javapuzzle;
/**
 * 实现一个复制函数，通过 java CopyFile (file1,file2) 调用
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class CopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = args[0];
		String d = args[1];
		File source = new File(s.substring(1, s.length()));
		File dest = new File(d.substring(0, d.length()-1));
		byte[] bs = new byte[(int) source.length()];
		try {
			FileInputStream is = new FileInputStream(source);
			is.read(bs);
			System.out.println(Arrays.toString(bs));
			
			FileOutputStream os = new FileOutputStream(dest);
			os.write(bs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
