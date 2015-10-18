package org.zabus.fantasy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zabus.fantasy.dal.model.Player;
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.service.TeamService;

import java.util.HashSet;
import java.util.Map;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	@Autowired
	private TeamService teamService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");
		
		return "index";
	}

//	@RequestMapping(value = "/pos/{teamID}", method = RequestMethod.GET)
//	public @ResponseBody Team getPos(@PathVariable("teamID") int id)
//	{
//		Team team = teamService.findOne(id);
//		logger.debug("getTeams() is executed: teamID = " + id + " pos " + team.getCurrentPos());
//		return team;
//	}

	@RequestMapping(value = "/pos", method = RequestMethod.GET)
	@ResponseBody
	public Player getPos(@RequestParam("id") String id)
	{
		logger.debug("getTeams() is executed, teamID = " + id);
		Player player = teamService.findOne(Integer.valueOf(id)).getPlayer();
		player.setTeams(new HashSet<Team>());
		return player;
	}


}