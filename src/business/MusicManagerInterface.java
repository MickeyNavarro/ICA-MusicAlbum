package business;

import beans.Album;
import util.TracksNotFoundException;

public interface MusicManagerInterface {
	 Album addAlbum(Album album) throws TracksNotFoundException;
	    
}
