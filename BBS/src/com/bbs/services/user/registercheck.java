package com.bbs.services.user;

/**
 *  ��Ŀ���ƣ�BBS
 * �����ƣ�registercheck 
 * �������� ��֤ע����Ϣ��ʽ�Ƿ���ȷ
 * �����ˣ��޼���
 * ����ʱ�䣺2016-4-1 ����5:49:29
 * �޸��ˣ�lenovo 
 * �޸�ʱ�䣺2016-4-1 ����5:49:29
 * �޸ı�ע�� 
 * @version 
 */
public class registercheck {
public registercheck(){
}

/**
 * ��������:��֤�û�����Ϊ��
 * @param username
 * @return
 */
public String checkusername(String username){
	if(username.equals("")){
		return "false";}else
			return "true";
}

/**
 * ��������:��֤password��Ϊ��
 * @param password
 * @return
 */
public  String checkpassword(String password){
	if(password.equals("")){
		return "false";}else
			return "true";
}
public  String checkemail(String email){
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
}
