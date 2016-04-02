package com.bbs.services.user;

/**
 *  项目名称：BBS
 * 类名称：registercheck 
 * 类描述： 验证注册信息格式是否正确
 * 创建人：罗吉林
 * 创建时间：2016-4-1 下午5:49:29
 * 修改人：lenovo 
 * 修改时间：2016-4-1 下午5:49:29
 * 修改备注： 
 * @version 
 */
public class registercheck {
public registercheck(){
}

/**
 * 方法描述:验证用户名不为空
 * @param username
 * @return
 */
public String checkusername(String username){
	if(username.equals("")){
		return "false";}else
			return "true";
}

/**
 * 方法描述:验证password不为空
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
