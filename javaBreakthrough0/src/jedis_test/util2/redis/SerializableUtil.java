package redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableUtil {
 public static <T extends Serializable> byte[] objectToByteArray(T message) throws ClassNotFoundException{
	 ByteArrayOutputStream bout = new ByteArrayOutputStream();
	 byte[] byteArray = null;
	 try {
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(message);
		out.flush();
		byteArray = bout.toByteArray();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return byteArray;
 }
 public static <T extends Serializable> T byteArrayToObeject(byte[] byteArray){
	 
 }
}
