package br.com.dedurando.business;

import java.util.List;

import br.com.dedurando.bean.Place;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class PlaceBLL extends BLL<Place> {
	
	private DAO<Place> dao = new DAO<Place>(Place.class);
    
	public List<Place> findAll(){
		return dao.findAll();
	}
	
	public Place find(Place place){
		return dao.findByID(place.getPlaceId());
	}
	
	public Place findByName(Place place){
		return dao.findByName(place.getName());
	}
	
	public Place save(Place place) throws BusinessException{
		this.validate(place);
		return dao.save(place);
	}
}