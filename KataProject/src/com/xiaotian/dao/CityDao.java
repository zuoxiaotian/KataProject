package com.xiaotian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.xiaotian.model.City;
import com.xiaotian.util.DbUtil;

public class CityDao {

    private Connection connection;

    public CityDao() {
        connection = DbUtil.getConnection();
    }

    public void addCity(City city) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cities(city,country,attractions,visited) values (?, ?, ?, 0 )");
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCountry());
            preparedStatement.setString(3, "[\"" + city.getAttractions().replaceAll(",", "\",\"") + "\"]");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCity(int cityId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cities where id=?");
            preparedStatement.setInt(1, cityId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(City city) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cities set visited=? where id=?");
            if(city.getVisited() == 1){
                preparedStatement.setInt(1, 0);	
            }else{
                preparedStatement.setInt(1, 1);
            }
            preparedStatement.setInt(2, city.getCityId());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<City>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from cities");
            while (rs.next()) {
                City city = new City();
                city.setCityId(rs.getInt("id"));
                city.setCityName(rs.getString("city"));
                city.setCountry(rs.getString("country"));
                city.setAttractions(rs.getString("attractions"));
                city.setVisited(rs.getInt("visited"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public City getCityById(int cityId) {
        City city = new City();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cities where id = ?");
            preparedStatement.setInt(1, cityId);
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	city.setCityId(rs.getInt("id"));
            	city.setCityName(rs.getString("city"));
            	city.setCountry(rs.getString("country"));
            	city.setAttractions(rs.getString("attractions"));
            	city.setVisited(rs.getInt("visited"));
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }
}
