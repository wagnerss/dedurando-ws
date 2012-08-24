package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Place;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.PlaceService;

public class PlaceServiceTest {

	@Test
	public void save() throws BusinessException {
		PlaceService service = new PlaceService();
		Place place = new Place();
		
		place.setName("Place Teste");
		place.setAddress("Rua Heitor Peixoto");
		place.setCity("SAO PAULO");
		place.setCountry("Brazil");
		place.setLatitude(100);
		place.setLongitude(10);
		place.setName("Casa do Davi");
		place.setNeighborhood("Aclimacao");
		place.setNumber(968);
		place.setState("SAO PAULO");
		place = service.save(place);
		
		Assert.assertTrue(place.getPlaceId() > 0);
	}
	
	@Test
	public void findAll(){
		Place[] places = new PlaceService().findAll();
		Assert.assertTrue(places.length > 0);
	}
	
	@Test
	public void find(){
		Place place = new Place();
		place.setPlaceId((long)1);
		Place place2 =  new PlaceService().find(place);
		Assert.assertNotSame("Find error", place2.getName(), place.getName());
	} 
}