package org.himanshu.test.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestRestController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/hello-world")
	@ResponseBody
	public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/getCabins")
	@ResponseBody
	public List<Cabin> fetchCabins(
			@RequestParam(name = "name", required = false, defaultValue = "cabins") String name) {

		List<Cabin> cabinList = new ArrayList<>();
		Connection connection = getConnection();
		if (connection != null) {

			try {
				PreparedStatement stmt = connection.prepareStatement("select * from cabin");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Cabin cabin = new Cabin();
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
					cabin.setCabinId(rs.getInt(1));
					cabin.setCabinName(rs.getString(2));
					cabin.setCabinDescription(rs.getString(3));
					cabinList.add(cabin);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to make connection!");
		}
		return cabinList;

	}

	private Connection getConnection() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "testadmin", "testworld");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		return connection;
	}
}