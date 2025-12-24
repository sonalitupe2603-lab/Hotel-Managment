package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Hotel;
import com.example.demo.Service.HotelService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	
	private final HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
	
	@GetMapping
    public String viewAllHotels(Model model) {
        List<Hotel> hotels = hotelService.getAllHotel();
        model.addAttribute("hotels", hotels);
        return "hotel-list";
    }
	
	@GetMapping("/add")
	public String addHotelForm(Model model)
	{
		 model.addAttribute("hotel", new Hotel());
	        return "hotel-add";
	    }
	
	@PostMapping("/add")
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/hotels";
    }

	 @GetMapping("/edit/{id}")
	    public String editHotelForm(@PathVariable Integer id, Model model) {
	        Hotel hotel = hotelService.getHotelById(id)
	                .orElseThrow(() -> new RuntimeException("Hotel not found"));
	        model.addAttribute("hotel", hotel);
	        return "hotel-edit";
	    }
	 
	 @PostMapping("/edit/{id}")
	    public String updateHotel(@PathVariable Integer id, @ModelAttribute Hotel hotel) {
	        hotelService.updateHotel(id, hotel);
	        return "redirect:/hotels";
	    }
	 
	 @GetMapping("/delete/{id}")
	    public String deleteHotel(@PathVariable Integer id) {
	        hotelService.deleteHotel(id);
	        return "redirect:/hotels";
	    }
	
	

}
