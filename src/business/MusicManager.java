package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Album;
import beans.Track;
import util.TracksNotFoundException;

@Stateless
@Local({ MusicManagerInterface.class })
@LocalBean
public class MusicManager implements MusicManagerInterface {
	
	HashMap<String, List<Track>> trackInfo;
	
	public MusicManager() {

		trackInfo = new HashMap<String, List<Track>>();
		List<Track> listOfTracks = new ArrayList<Track>();
		listOfTracks.add(new Track("3 A.M.", 1));
		listOfTracks.add(new Track("All About that Bass", 2));
		listOfTracks.add(new Track("Mr. Almost", 3));
		trackInfo.put("Title by Meghan Trainor (2014)", listOfTracks);
	}

	private List<Track> getTracks(Album album) {

		String key = album.getTitle() + " by " + album.getArtist() + " (" + album.getYear() + ")";

		if(trackInfo.containsKey(key))
		{
			return trackInfo.get(key);
		}
		else
		{
			return new ArrayList<Track>();
		}
	}
	
	@Override
	public Album addAlbum(Album album) throws TracksNotFoundException {
		//looks up the Track Info by calling getTracks() 
		album.setTracks(getTracks(album));
		
		//returns the updated Album with the list of tracks populated
		return album;
	}

}
