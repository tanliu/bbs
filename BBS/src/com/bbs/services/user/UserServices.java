package com.bbs.services.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServices {
		/**
		 * ��������:��֤�û�����Ϊ��
		 * @param username
		 * @return
		 */
		public String CheckUsername(String username){
			if(username.equals("")){
				return "false";}else
					return "true";
		}

		/**
		 * ��������:��֤password��Ϊ��
		 * @param password
		 * @return
		 */
		public  String CheckPassword(String password){
			if(password.equals("")){
				return "false";}else
					return "true";
		}
		/**
		 * ��������:��֤�����ʽ
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
		 * ��������:MD5����
		 * @param password
		 * @return
		 */
		public final static String MD5(String password) {  
		        char hexDigits[] = { '0', '1', '2', '3', '4',  
		                             '5', '6', '7', '8', '9',  
		                             'A', 'B', 'C', 'D', 'E', 'F' };  
		        try {  
		            byte[] btInput = password.getBytes();  
		     //���MD5ժҪ�㷨�� MessageDigest ����  
		            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
		     //ʹ��ָ�����ֽڸ���ժҪ  
		            mdInst.update(btInput);  
		     //�������  
		            byte[] md = mdInst.digest();  
		     //������ת����ʮ�����Ƶ��ַ�����ʽ  
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
		

