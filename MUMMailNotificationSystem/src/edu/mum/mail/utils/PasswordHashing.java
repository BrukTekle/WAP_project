package edu.mum.mail.utils;
import java.sql.*;
import java.security.*;
import javax.crypto.*;

public class PasswordHashing {
			
			private static String algorithm = "DESede";
	        private static Key key = null;
	        private static Cipher cipher = null;
	       
	        public static Key setKey() {
	        	try {
					key= KeyGenerator.getInstance(algorithm).generateKey();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return key;
	        }
	        public static Key getKey() {
	        	return key;
	        }
	        public static byte[] encrypt(String input)throws Exception {
	        	
	            cipher = Cipher.getInstance(algorithm);
	        	            
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] inputBytes = input.getBytes();
	            return cipher.doFinal(inputBytes);
	        }
	        public static String decrypt(byte[] encryptionBytes)throws Exception {
	        	
	            cipher = Cipher.getInstance(algorithm);
	        	cipher.init(Cipher.DECRYPT_MODE, key);
	            byte[] recoveredBytes =  cipher.doFinal(encryptionBytes);
	            String recovered =  new String(recoveredBytes);
	            return recovered;
	          }
	
}
