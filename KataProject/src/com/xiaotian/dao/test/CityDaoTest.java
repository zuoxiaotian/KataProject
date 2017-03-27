package com.xiaotian.dao.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;

import com.xiaotian.dao.CityDao;
import com.xiaotian.model.City;
import com.xiaotian.util.DbUtil;

@Transactional
public class CityDaoTest {
	private CityDao dao;
	private Connection connection;

	@Before
	public void setUp() throws Exception {
		dao = new CityDao();
		connection = DbUtil.getConnection();
		connection.setAutoCommit(false);
		connection
				.prepareStatement(
						"insert into cities(city,country,attractions,visited) values (\"Manchester\", \"UK\", '[\"football\", \"bars\"]', 0 )")
				.executeUpdate();
		connection
				.prepareStatement(
						"insert into cities(city,country,attractions,visited) values (\"Liverpool\", \"UK\", '[\"football\", \"bars\", \"music\"]', 0 )")
				.executeUpdate();
		connection
				.prepareStatement(
						"insert into cities(city,country,attractions,visited) values (\"York\", \"UK\", '[\"city walls\", \"cathedral\"]', 0 )")
				.executeUpdate();
		connection
				.prepareStatement(
						"insert into cities(city,country,attractions,visited) values (\"Beijing\", \"PRC\", '[\"Great wall\", \"Forbidden city\"]', 0 )")
				.executeUpdate();

	}

	@Test
	public void testAddCity() {
		City city = new City();
		city.setCityName("Paris");
		city.setCountry("France");
		city.setAttractions("Notre dame, Tour Eiffel");
		city.setVisited(0);
		dao.addCity(city);
		try {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("SELECT * FROM cities WHERE city = \"Paris\"");
			ResultSet rs = preparedStatement.executeQuery();
			assertTrue(rs.next());
		} catch (SQLException e) {
			fail("Failed!");
		}
	}

	@Test
	public void testDeleteCity() {
		int before;
		int after;
		try {
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("SELECT count(*) FROM cities WHERE city = \"Manchester\"");
			ResultSet rs = preparedStatement.executeQuery();
			rs = preparedStatement.executeQuery();
			rs.next();
			before = rs.getInt(1);

			preparedStatement = connection.prepareStatement("SELECT * FROM cities WHERE city = \"Manchester\"");
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dao.deleteCity(rs.getInt("id"));

				preparedStatement = connection
						.prepareStatement("SELECT count(*) FROM cities WHERE city = \"Manchester\"");
				rs = preparedStatement.executeQuery();
				if (rs.next()) {
					after = rs.getInt(1);
					assertEquals(before, after + 1);
				}
				;
			}
		} catch (SQLException e) {
			fail("Failed!");
		}
	}

	@Test
	public void testUpdate() {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM cities WHERE city = \"Manchester\"");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				dao.update(dao.getCityById(rs.getInt("id")));
			}
			preparedStatement = connection.prepareStatement("SELECT * FROM cities WHERE city = \"Manchester\"");
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				assertEquals((rs.getInt("visited")), 1);	
			}
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}
}
