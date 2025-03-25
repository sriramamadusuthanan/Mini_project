package com.weather.WeatherReport.WeatherService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.WeatherReport.WeatherEntity.WeatherEntity;
import com.weather.WeatherReport.WeatherEntity.WeatherResponse;

@Service
public class Weather_Servies {
	@Value("${openweathermap.api.url}")
	private String apiUrl;
	
	@Value("${openweathermap.api.key}")
	private String apiKey;
	
	//RestTemplate is a built-in Spring class that makes HTTP calls for you (like a little HTTP client).
	//Here, we’re creating an instance so we can use it to call the OpenWeatherMap API.
	private final RestTemplate resttemplate= new RestTemplate();
	
	

    public WeatherEntity getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" 
                     + city 
                     + "&appid=" + apiKey 
                     + "&units=metric";
        try {
        	var response =resttemplate.getForObject(url, WeatherResponse.class);
        	 WeatherEntity result = new WeatherEntity();
             result.setTemp(response.getMain().getTemp());
             result.setWind(response.getWind().getSpeed());
             
             //String weatherCondition = response.getWeather()[0].getMain();
             String weatherCondition=response.getWeather()[0].getMain();
             result.setWeatherReport(weatherCondition);
             System.out.println(result);
             return result;
        }catch(HttpClientErrorException e)
        {
        	if(e.getStatusCode().value()==404)
        	{
        		System.out.println("city not found"+ city);
        	}else
        	{
        		System.out.println("Api error"+e.getMessage());
        	}
        	return null;
        }

       
    }
	
			
}
