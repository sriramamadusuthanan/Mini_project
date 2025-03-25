package com.weather.WeatherReport.WeatherEntity;

public class WeatherResponse {
	
	private Main main;
	private Wind wind;
	private weatherDes[] weather;
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	public static class Main{
		private double temp;

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}
		
	}
	
	public static class Wind
	{
		private double speed;

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}
		
	}
	
	public static class weatherDes
	{
		private String main;

		public String getMain() {
			return main;
		}

		public void setMain(String weatherMain) {
			this.main = weatherMain;
		}
		
	}
	
	public weatherDes[] getWeather()
	{
		return weather;
	}
	
	public void setWeather(weatherDes[] weather)
	{
		this.weather=weather;
	}
	

}
