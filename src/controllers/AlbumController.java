package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Album;
import business.MusicManagerInterface;
import util.TracksNotFoundException;
@ManagedBean 
@ViewScoped
public class AlbumController {
	
	@EJB
	MusicManagerInterface managerEJB;
	
	//method to returns the name of the response view 
	public String onSubmit(Album album) {
		//Call Music Manager Business Service
		try { 
			album = managerEJB.addAlbum(album);
		}
		catch (TracksNotFoundException e){ 
			System.out.println("EXCEPTION: Tracks Not Found");
		}
		
		//Forward to Test Response View along with the User Managed Bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return "AddAlbumResponse.xhtml";
	}
}
