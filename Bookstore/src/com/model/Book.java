package com.model;

public class Book {

	    public  int id;
	    public String title;
	    public  String author;
	    public float price;
	    
		@Override
		public String toString() {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
		}

		public Book() {
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
			
		}
	       
		
}