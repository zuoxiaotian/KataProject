package com.xiaotian.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaotian.dao.CityDao;
import com.xiaotian.model.City;

public class CityController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/city.jsp";
    private static String LIST_CITY = "/listCity.jsp";
    private CityDao dao;

    public CityController() {
        super();
        dao = new CityDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        System.out.println(action.toString());

        if (action.equalsIgnoreCase("delete")){
            int cityId = Integer.parseInt(request.getParameter("cityId"));
            dao.deleteCity(cityId);
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities("all"));    
        } else if (action.equalsIgnoreCase("edit")){
            forward = LIST_CITY;
            int cityId = Integer.parseInt(request.getParameter("cityId"));
            City city = dao.getCityById(cityId);
            dao.update(city);
            request.setAttribute("cities", dao.getCities("all"));    
        } else if (action.equalsIgnoreCase("listCity")){
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities("all"));
        }else if (action.equalsIgnoreCase("showvisited")){
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities("visited"));
        }else if (action.equalsIgnoreCase("showUnvisited")){
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities("unvisited"));
        }else if (action.equalsIgnoreCase("sort")){
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities("sort"));
        }else if (action.equalsIgnoreCase("search")){
            forward = LIST_CITY;
            request.setAttribute("cities", dao.getCities(request.getParameter("data")));
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        City city = new City();
        city.setCityName(request.getParameter("cityName"));
        city.setCountry(request.getParameter("country"));
        city.setAttractions(request.getParameter("attractions"));
        String cityId = request.getParameter("cityId");
        if(cityId == null || cityId.isEmpty())
        {
            dao.addCity(city);
        }
        else
        {
            city.setCityId(Integer.parseInt(cityId));
            dao.update(city);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_CITY);
        request.setAttribute("cities", dao.getCities("all"));
        view.forward(request, response);
    }
}