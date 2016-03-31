package com.bbs.utils;

import java.util.List;


/** 
 * ��Ŀ���ƣ�BBS
 * �����ƣ�PageUtils 
 * �������� ��ҳ���ҵĹ�����
 * �����ˣ�̳��
 * ����ʱ�䣺2016��3��31�� ����12:38:34
 * �޸��ˣ�TanLiu 
 * �޸�ʱ�䣺2016��3��31�� ����12:38:34
 * �޸ı�ע�� 
 * @version 
 */ 
public class PageUtils<T> {
	private int currentPage=1;   //��ǰҳ��
	private int pageSize=4;      //ÿһҳ��ʾ��Ŀ������
	private int totalCount;      //�ܹ��ж�������
	private int totalPage;       //һ���ж���ҳ
	private List<T> pageData;    //Ҫ��ѯҳ������
	
	
	//-------------------------getter&&setter-------------------------	
	public int getTotalPage() {
		if(totalCount!=0&&pageSize==0){
			totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1); //������ҳ��
		}
		
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
	
	

}
