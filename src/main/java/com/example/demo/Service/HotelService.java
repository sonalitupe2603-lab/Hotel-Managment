package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Hotel;
import com.example.demo.Repository.HotelRepository;
@Service
public class HotelService {
	
	private final HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository)
	{
		this.hotelRepository = hotelRepository;
		
	}
	
	public Hotel addHotel(Hotel hotel)
	{
		return hotelRepository.save(hotel);
		
	}
	
	public List<Hotel> getAllHotel()
	{
		return hotelRepository.findAll();
		
	}
	
	public Optional<Hotel> getHotelById(Integer id)
	{
		return hotelRepository.findById(id);
	}
	
	 public Hotel updateHotel(Integer id, Hotel hotel) {
	        Hotel hotelDetail = hotelRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + id));

	        hotelDetail.setName(hotel.getName());
	        hotelDetail.setLocation(hotel.getLocation());
	        hotelDetail.setPricePerNight(hotel.getPricePerNight());
	        hotelDetail.setRating(hotel.getRating());

	        return hotelRepository.save(hotelDetail);
	    }

	    public void deleteHotel(Integer id) {
	        hotelRepository.deleteById(id);
	    }

}
