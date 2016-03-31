package com.bbs;

import java.sql.SQLException;
import java.util.UUID;

import com.bbs.utils.DBHelper;

public class test {

	public static void main(String args[]){
		
		for(int i=0;i<10;i++){
			
			System.out.println("-=-------"+UUID.randomUUID().toString().replace("-", ""));
			
		}

		
		
	}
}
