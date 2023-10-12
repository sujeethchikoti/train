package com.infinite.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinite.util.Database;

@Controller
public class TrainDetails {
	@RequestMapping(value="/traindetails",method=RequestMethod.POST)
	public String details(HttpServletRequest request, HttpServletResponse response,Model m) throws IOException {
		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DataSource datasource = Database.getDataSource();
			con = datasource.getConnection();
			ps1 = con.prepareStatement("select * from details");
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				if (rs1.getString(5).equalsIgnoreCase(destination)) {
					if (rs1.getString(3).equalsIgnoreCase(source)) {
						PreparedStatement ps2 = con
								.prepareStatement("select * from details where source=? and destination=?");
						ps2.setString(1, source);
						ps2.setString(2, destination);
						ResultSet rs2 = ps2.executeQuery();
						if (rs2.next()) {
						
							String msg=	"<tr>"+"<td>" + rs1.getString(1) + "</td>"+"<td>" + rs1.getString(2) + "</td>"+"<td>" + rs1.getString(3) + "</td>"+"<td>" + rs1.getString(5) + "</td>"+"<td>" + rs1.getString(6) + "</td>"+"<td>" + rs1.getString(9) + "</td>"+"</tr>";
							m.addAttribute("message", msg);
							return "details";
						}
						
					} else if (rs1.getString(4).equalsIgnoreCase(source)) {
						PreparedStatement ps3 = con
								.prepareStatement("select * from details where via=? and destination=?");
						ps3.setString(1, source);
						ps3.setString(2, destination);
						ResultSet rs3 = ps3.executeQuery();
						if (rs3.next()) {
							
							String msg = "<tr>"+"<td>" + rs1.getString(1) + "</td>"+"<td>" + rs1.getString(2) + "</td>"+"<td>" + rs1.getString(4) + "</td>"+"<td>" + rs1.getString(5) + "</td>"+"<td>" + rs1.getString(8) + "</td>"+"<td>" + rs1.getString(9) + "</td>"+"</tr>";
							m.addAttribute("message",msg);
							return "details";
						}
						
					}
				}
				if (rs1.getString(3).equalsIgnoreCase(source)) {
					if (rs1.getString(4).equalsIgnoreCase(destination)){
						PreparedStatement ps4 = con.prepareStatement("select * from details where source=? and via=? ");
						ps4.setString(1, source);
						ps4.setString(2,destination );
						ResultSet rs4 = ps4.executeQuery();
						if(rs4.next()){
							String msg = "<tr>"+"<td>" + rs1.getString(1) + "</td>"+"<td>" + rs1.getString(2) + "</td>"+"<td>" + rs1.getString(3) + "</td>"+"<td>" + rs1.getString(4) + "</td>"+"<td>" + rs1.getString(6) + "</td>"+"<td>" + rs1.getString(7) + "</td>"+"</tr>";
							m.addAttribute("message",msg);
							return "details";
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg="No Trains Found";
		m.addAttribute("message",msg);
		return "invaliddetails";
	}
}
