import java.util.ArrayList;

public class BookInfo {
	
	private String title;
	private int pageCount;
	public String author;
	public String genre;
	
	public static ArrayList<BookInfo> book = new ArrayList<BookInfo>();
	
	public BookInfo()
	{
		title = "";
		author = "";
		pageCount = 0;
		genre = "";
		
	}
	
	public BookInfo(String title, String author, int pageCount, String genre)
	{
		this.title = title;
		this.pageCount = pageCount;
		this.author = author;
		this.genre = genre;
		book.add(this);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getPageCount()
	{
		return pageCount;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	public void setPageCount(int newPageCount)
	{
		pageCount = newPageCount;
	}
	
	public void setAuthor(String newAuthor)
	{
		author = newAuthor;
	}
	
	public void setGenre(String newGenre)
	{
		genre = newGenre;
	}
	
	public String toString()
	{
		return "We recommend " + title + " it is " + pageCount + " pages long and it is by " + author + ".";
	}
	
	public static void printRecommended(double pages)
	{
		double max = pages + 100;
		double mid = pages;
		double min = pages - 100;
		
		ArrayList<BookInfo> reach = new ArrayList<BookInfo>();
		ArrayList<BookInfo> target = new ArrayList<BookInfo>();
		
		for(int i = 0; i < book.size(); i++)
		{
			int p = book.get(i).getPageCount();
			BookInfo b = book.get(i);
			
			if(p <= max && p >= mid)
			{
				reach.add(b);
			}
			
			if(p < mid && p >= min)
			{
				target.add(b);
			}
		}
		
		System.out.println("Books that you will finish by your target time: ");
		
		for(BookInfo i: target)
		{
			System.out.println(i);
		}
		
		System.out.println("Some books that may take you a little longer: ");
		
		for(BookInfo k: reach)
		{
			System.out.println(k);
		}
		
	}
	
	public int numPages(int weeks, int hours)
	{
		return hours*60*weeks;
	}
	

}
