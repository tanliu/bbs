package com.bbs.services.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServices {
		/**
		 * 方法描述:验证用户名不为空
		 * @param username
		 * @return
		 */
		public String CheckUsername(String username){
			if(username.equals("")){
				return "false";}else
					return "true";
		}

		/**
		 * 方法描述:验证password不为空
		 * @param password
		 * @return
		 */
		public  String CheckPassword(String password){
			if(password.equals("")){
				return "false";}else
					return "true";
		}
		/**
		 * 方法描述:验证邮箱格式
		 * @param email
		 * @return
		 */
		public  String CheckEmail(String email){
			if(email.equals("")){
				return "false";
				}
			else{
				 if(email.contains("@") && email.contains(".com")){
					 return "true";
			       }else{ 
			    	  return "false";
			    	   }
			}
		}
		
		
		
		 /**
		 * 方法描述:MD5加密
		 * @param password
		 * @return
		 */
		public final static String MD5(String password) {  
		        char hexDigits[] = { '0', '1', '2', '3', '4',  
		                             '5', '6', '7', '8', '9',  
		                             'A', 'B', 'C', 'D', 'E', 'F' };  
		        try {  
		            byte[] btInput = password.getBytes();  
		     //获得MD5摘要算法的 MessageDigest 对象  
		            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
		     //使用指定的字节更新摘要  
		            mdInst.update(btInput);  
		     //获得密文  
		            byte[] md = mdInst.digest();  
		     //把密文转换成十六进制的字符串形式  
		            int j = md.length;  
		            char str[] = new char[j * 2];  
		            int k = 0;  
		            for (int i = 0; i < j; i++) {  
		                byte byte0 = md[i];  
		                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
		                str[k++] = hexDigits[byte0 & 0xf];  
		            }  
		            return new String(str);  
		        }  
		        catch (Exception e) {  
		            e.printStackTrace();  
		            return null;  
		        }  
		    }  
		 
		}  
		

