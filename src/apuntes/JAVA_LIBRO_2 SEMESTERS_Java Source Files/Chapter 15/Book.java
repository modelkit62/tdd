
public class Book 
{ 
	private String isbn; 
	private String title;
	private String author;
	
	public Book(String isbnIn, String titleIn, String authorIn) 
	{ 
		isbn = isbnIn; 
		title = titleIn; 
		author = authorIn; 
	}
	
	public String getISBN() 
	{ 
		return isbn; 
	}
	
	public String getTitle() 
	{ 
		return title; 
	}
	
	public String getAuthor() 
	{ 
		return author; 
	} 
}

