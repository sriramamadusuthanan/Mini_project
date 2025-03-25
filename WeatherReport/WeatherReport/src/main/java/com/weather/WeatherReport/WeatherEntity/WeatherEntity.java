package com.weather.WeatherReport.WeatherEntity;

public class WeatherEntity {
	 private double temp;
	 private double wind;
	 private String weatherReport;
	 
	 public String getweatherReport()
	 {
		 return weatherReport;
	 }
	 
	 public void setWeatherReport(String report)
	 {
		 this.weatherReport=report;
	 }
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getWind() {
		return wind;
	}
	public void setWind(double wind) {
		this.wind = wind;
	}
	 
	 @Override
	    public String toString() {
	        return "WeatherEntity{" +
	               "temperature=" + temp +
	               ", windspeed=" + wind +
	               "weatherReport"+weatherReport+
	               '}';
	    } 
}
