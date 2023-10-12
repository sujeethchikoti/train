package com.infinite.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.util.Database;

@Controller
public class RegisterController {
	Connection on = null;
	PreparedStatement ps = null;

	@RequestMapping(value = "/create")
	public String create() {
		return "login";

	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		try {
			DataSource datasource = Database.getDataSource(); 
			on = datasource.getConnection();
			ps = on.prepareStatement("insert into user values(?,?,?)"); 
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setString(3, email);
			int a = ps.executeUpdate();
			if(a==1)
			return "login";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "invalidregister";
	}
}
