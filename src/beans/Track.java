package beans;

public class Track {

	String title; 
	int number;
	
	//default constructor
	public Track() {
		title = "";
		number = 0;
	}
	
	//constructor
	public Track(String title, int number) {
		super();
		this.title = title;
		this.number = number;
	}
	
	//getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	} 
	
}
