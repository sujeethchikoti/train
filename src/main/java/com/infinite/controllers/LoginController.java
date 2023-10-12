package com.infinite.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.util.Database;

@Controller
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response,Model m) {
		Connection con = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("uname", username);
		try {
			DataSource datasource = Database.getDataSource();
			con = datasource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(username)) {
					if (rs.getString(2).equals(password)) {
						return "home";
					} else {
						return "invalid";
					}
				} else {
					return "invalid";
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		String msg="Wrong Username and Password";
		m.addAttribute("message",msg);
		return "invalidlogin";
	}
}
