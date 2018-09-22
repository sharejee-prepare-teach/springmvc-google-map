package com.mkyong.web.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.location.ServerLocation;
import com.mkyong.web.location.ServerLocationBo;

@Controller
public class MapController {

	@Autowired
	ServerLocationBo serverLocationBo;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("map");
		return model;

	}

	@RequestMapping(value = "/getLocationByIpAddress", method = RequestMethod.GET)
	public @ResponseBody
	String getDomainInJsonFormat(@RequestParam String ipAddress) {

		ObjectMapper mapper = new ObjectMapper();

		ServerLocation location = serverLocationBo.getLocation(ipAddress);

		String result = "";

		try {
			result = mapper.writeValueAsString(location);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;

	}

}
