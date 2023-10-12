package com.infinite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
@RequestMapping(value="/nodetails",method=RequestMethod.POST)
public String display1(){
	return "trainnodetails";
}
@RequestMapping(value="/details",method=RequestMethod.POST)
public String display2(){
	return "traindetails";
}
}
