package network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 实现了一个简单的socket服务器、
 * @author CC
 *
 */
public class SimpleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket s = new ServerSocket(10086);
			Socket skt = s.accept();
			InputStream is = skt.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info ;
			System.out.println("服务器启动完成");
			
			while(null != (info = br.readLine())) {
				System.out.println("服务器收到： " + info);
			}
			skt.shutdownInput();
			OutputStream os = skt.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os, charsetName)
			PrintWriter pw = new PrintWriter(os);
			pw.write("欢迎你");
			System.out.println("发出欢迎~~~");
			pw.flush();
			
			pw.close();
			os.close();
			
			br.close();
			isr.close();
			is.close();
			skt.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
