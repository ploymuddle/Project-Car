package com.example.car.dao.impremants;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.car.dao.CarDAO;
import com.example.car.model.Car;

@Repository
public class CarDAOimp implements CarDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String TABLE = "car2";
	private final String CarID = "car_id";
	private final String CarName = "car_name";
	private final String CarBrand = "car_brand";
	private final String CarPrice = "car_price";
	private final String isDelete = "car_delete";

	final RowMapper<Car> ROW_MAPPER = (ResultSet rs, int i) -> {

		final Car mapperObject = new Car();
		mapperObject.setCarID(rs.getInt(CarID));
		mapperObject.setCarName(rs.getString(CarName));
		mapperObject.setCarBrand(rs.getString(CarBrand));
		mapperObject.setCarPrice(rs.getInt(CarPrice));
	
		return mapperObject;
	};
	

//	@Override
//	public boolean checkId(int id)  {
//
//		boolean result = true;
//		StringBuilder sql = new StringBuilder();
//		List<Object> parameters = new ArrayList<>();
//
//		sql.append(" select * ").append(" from ").append(TABLE);
//		sql.append(" where ").append(CarID).append(" = ? ");
//		sql.append(" and ").append(isDelete).append(" = ? ");
//		parameters.add(id);
//		parameters.add("N");
//
//		List<Car> ans = jdbcTemplate.query(sql.toString(), parameters.toArray(), ROW_MAPPER);
//		if (ans.isEmpty()) {
//			result = false;
//		}
//		return result;
//	}
	
//	@Override
//	public List<Car> find() {
//		StringBuilder sql = new StringBuilder();
//		List<Car> cars = new ArrayList<Car>();
//		List<Object> parameters = new ArrayList<>();
//
//		sql.append(" select * from ").append(TABLE);
//		sql.append(" where ").append(isDelete).append(" = ? ");
//		parameters.add("N");
//
//		cars = jdbcTemplate.query(sql.toString(), parameters.toArray(), ROW_MAPPER);
//
//		return cars;	
//	}

	@Override
	public List<Car> find(Car findObject) throws Exception {

		StringBuilder sql = new StringBuilder();
		List<Car> cars = new ArrayList<Car>();
		List<Object> parameters = new ArrayList<>();
		try {
			sql.append(" select * from ").append(TABLE);
			sql.append(" where 0 = 0 ");
		
			if(findObject != null) {
				sql.append(" and ").append(isDelete).append(" = ? ");
				parameters.add("N");
		
				if (findObject.getCarID() != 0 ) {
				
					sql.append(" and ").append(CarID).append(" = ? ");
					parameters.add(findObject.getCarID());
				}
			}
			cars = jdbcTemplate.query(sql.toString(), parameters.toArray(), ROW_MAPPER);
		}

		catch(Exception e) {
			System.out.print(e);
		}
		return cars;
	}

	@Override
	public void update(Car updateObject)  {
		
		ArrayList<Object> parameters = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" update ").append(TABLE).append(" SET ");

			if (updateObject != null) {
				updateObject.getCarName();
				sql.append(CarName).append(" = ? ").append(",").append(CarBrand).append(" = ? ").append(",")
						.append(CarPrice).append(" = ? ");
				
				sql.append(" where ").append(CarID).append(" = ? ");
				
				parameters.add(updateObject.getCarName());
				parameters.add(updateObject.getCarBrand());
				parameters.add(updateObject.getCarPrice());
				
				parameters.add(updateObject.getCarID());
			}
			jdbcTemplate.update(sql.toString(), parameters.toArray());	
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
 
	@Override
	public void insert(Car insertObject) {
		
		ArrayList<Object> parameters = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
			
		try {
			sql.append(" INSERT INTO ").append(TABLE).append(" ( ");

			if (insertObject != null) {
				sql.append(CarName).append(",").append(CarBrand).append(",").append(CarPrice).append(",").append(isDelete).append(" ) ");

				sql.append(" VALUES ").append(" ( ");
				sql.append(" ? ").append(",").append(" ? ").append(",").append(" ? ").append(",").append(" ? ").append(" ) ");
				
				parameters.add(insertObject.getCarName());
				parameters.add(insertObject.getCarBrand());
				parameters.add(insertObject.getCarPrice());
				parameters.add("N");
			}
			jdbcTemplate.update(sql.toString(), parameters.toArray());
	
		}
		catch(Exception e) {
				System.out.print(e);
		}
	}

	@Override
	public void delete(int id) {

		StringBuilder sql = new StringBuilder();
		List<Object> parameters = new ArrayList<>();
		
		try {
			
//			sql.append(" delete  from ").append(TABLE);
		
			sql.append(" update ").append(TABLE).append(" set ");
			sql.append(isDelete).append(" = ? ");
		
			sql.append(" where ").append(CarID).append(" = ? ");
		
			parameters.add("Y");
		
			parameters.add(id);

			jdbcTemplate.update(sql.toString(), parameters.toArray());
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

	@Override
	public List<Car> getID() {
			
		List<Car> cars = new ArrayList<Car>();
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" Select * from ").append(TABLE).append(" Order by ").append(CarID).append(" DESC");
			cars = jdbcTemplate.query(sql.toString(), ROW_MAPPER);
			System.out.print(cars.get(0).getCarID());
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return 	cars;
	}
}
