package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean 
@ViewScoped
public class Album {
	//variables 
	@NotNull()
	@Size(min=5, max=50) 
	String title; 
	
	@NotNull()
	@Size(min=5, max=25) 
	String artist; 
	
	@Min(1920)
	@Max(2020) 
	int year; 
	List<Track> tracks;
		
	//default constructor
	public Album() {
        this.title = "";
        this.artist = "";
        this.year = 0;
        this.tracks = new ArrayList<Track>();
    }
    
	//constructor
    public Album(final String title, final String artist, final int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.tracks = new ArrayList<Track>();
    }
	
	//getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	} 
	
	//method to return the number of elements in the tracks property 
	public int getNumberTracks() { 
		return tracks.size(); 
	}					
}
