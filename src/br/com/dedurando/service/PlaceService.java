package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Place;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PlaceBLL;

@WebService
public class PlaceService {
	
	@WebMethod
	public Place find(Place place){
		return new PlaceBLL().find(place);
	} 
	
	@WebMethod
	public Place[] findAll(){
		List<Place> places = new PlaceBLL().findAll();
		return places.toArray(new Place[places.size()]);
	}
	
	@WebMethod
	public Place findByName(Place place){
		return new PlaceBLL().findByName(place);
	}
	
	@WebMethod
	public Place save(Place place) throws BusinessException{
		return new PlaceBLL().save(place);
	}
}
