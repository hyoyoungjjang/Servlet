package com.kh.board.model.vo;

public class Category {
	private int categoryNO;
	private String categotyName;
	
	
	
	public Category() {
		super();
	}



	public Category(int categoryNO, String categotyName) {
		super();
		this.categoryNO = categoryNO;
		this.categotyName = categotyName;
	}



	public int getCategoryNO() {
		return categoryNO;
	}



	public void setCategoryNO(int categoryNO) {
		this.categoryNO = categoryNO;
	}



	public String getCategotyName() {
		return categotyName;
	}



	public void setCategotyName(String categotyName) {
		this.categotyName = categotyName;
	}



	@Override
	public String toString() {
		return "Categoty [categoryNO=" + categoryNO + ", categotyName=" + categotyName + "]";
	}
	
	
}
