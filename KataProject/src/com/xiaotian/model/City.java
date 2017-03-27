package com.xiaotian.model;


public class City {
	private int cityId;
	private String cityName;
    private String country;
    private String attractions;
    private int visited;
    
    public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAttractions() {
		return attractions;
	}
	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}
}
