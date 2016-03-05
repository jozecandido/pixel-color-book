package pcb.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public final class Comon {

	private static final int BUFFER_SIZE = 8192;

	public static String encondeBase64(byte[] byteArray) {
		return Base64.getEncoder().encodeToString(byteArray);
	}
	
	public static byte[] decodeBase64(String image) {
		return Base64.getDecoder().decode(image);
	}
	
	public static byte[] encodeFile(File image) throws IOException {
		
		InputStream inputStream = null;
		byte[] byteArray;

		try {
			inputStream = new FileInputStream(image);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		    	output.write(buffer, 0, bytesRead);
		    }
		    
			byteArray = output.toByteArray();
		} finally {
			if(inputStream != null)
				inputStream.close();
		}		
		return byteArray;
	}
}
