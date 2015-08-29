package com.ufgov.gk.common.system.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import Test;
public class DigestUtil {
	
	private static MessageDigest md  ;
	static {
		 try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e.getMessage(),e);
		}

	}
	
	static public void update(byte[] input) {
		   md.update(input);
	}

	
	static public String digest(){
		 byte[] digest =md.digest();
		 return  new String(Base64.encode(digest));
	}
	
	static public String digest(byte[] input){
	  if(input==null){
	    return "";
	  }
		 byte[] digest =md.digest(input);
//     System.out.println(new String(digest));
//     System.out.println(new String(Test.encode(digest)));
//     System.out.println(new String(Base64.encode(digest)));
		 return  new String(Base64.encode(digest));
	}

	
	static public String digest(Object object){
		return	digest(ObjectUtil.objectToBytes(object));
	}
	

}
