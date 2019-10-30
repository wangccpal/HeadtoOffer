package network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 实现一个简单的socket客户端与服务器通信
 * @author CC
 *
 */
public class SimpleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket skt = new Socket("10.203.7.35", 10086);
			OutputStream os = skt.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("我是一个可爱的客户端");
			pw.flush();
			skt.shutdownOutput();
			
			InputStream is = skt.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info;
			while(null != (info = br.readLine())) {
				System.out.println("客户端收到： " + info);
			}
			
			br.close();
			isr.close();
			is.close();
			pw.close();
			os.close();
			skt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
