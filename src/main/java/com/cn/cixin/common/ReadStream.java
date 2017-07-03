package com.cn.cixin.common;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ReadStream {
	private ReadStream() {
	}
	
	public static String read(BufferedInputStream in)
	{
		try {
			byte[] data = new byte[1024];
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			int len;
			while ((len = in.read(data))!=-1) {
				bout.write(data, 0, len);
			}
			bout.close();
			return new String(bout.toByteArray(),"UTF-8");
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
		}
		return "";
	}
	
}
