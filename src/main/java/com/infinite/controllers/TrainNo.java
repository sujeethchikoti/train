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
public class TrainNo {
	@RequestMapping(value="/trainnodetails", method=RequestMethod.POST)
	public String traindetails(HttpServletRequest request, HttpServletResponse response,Model m) throws IOException{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int trainno = Integer.parseInt(request.getParameter("trainno"));
		try{

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			DataSource datasource=Database.getDataSource();
			con=datasource.getConnection();
			ps=con.prepareStatement("select * from details where trainno=?");
			ps.setInt(1,trainno);
			rs = ps.executeQuery();
			out.println("<html><body>");
			out.println("<h3>Train Details<h3>");
			if(rs.next())
			{
				String msg = "<tr>"+"<td>" + rs.getString(1) + "</td>"+"<td>" + rs.getString(2) + "</td>"+"<td>" + rs.getString(3) + "</td>"+"<td>" + rs.getString(4) + "</td>"+"<td>" + rs.getString(5) + "</td>"+"<td>" + rs.getString(6) + "</td>"+"<td>" + rs.getString(7) + "</td>"+ "</td>"+"<td>" + rs.getString(8) + "</td>"+"<td>" + rs.getString(9) + "</td>"+"</tr>";
				m.addAttribute("message", msg);
				return "train";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		String msg="Train not Found";
		m.addAttribute("message",msg);
		return "invalid";
	}
}
