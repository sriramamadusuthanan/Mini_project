package com.weather.WeatherReport.WeatherController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.WeatherReport.WeatherEntity.WeatherEntity;
import com.weather.WeatherReport.WeatherService.Weather_Servies;

@Controller
public class Weather_Controller {

	@Autowired
	private Weather_Servies weatherservice;
	
//	 @GetMapping("/weather/{city}")
//	    public WeatherEntity getWeather(@PathVariable String city) {
//	        return weatherservice.getWeather(city);
//	    }
	
	@GetMapping("/weather")
	public String getWeather(@RequestParam(value="city",required=false)String city ,Model m)
	{
		if(city!=null && !city.isEmpty())
		{
			WeatherEntity weather =weatherservice.getWeather(city);
			if(weather!=null)
			{
				m.addAttribute("temperature",weather.getTemp());
				m.addAttribute("windspeed",weather.getWind());
				m.addAttribute("condition",weather.getweatherReport());
			}else
			{
				m.addAttribute("error","Could not retrieve weather data for"+city);
			}
		}
		
		return "home";
	}
}
