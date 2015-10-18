package org.zabus.fantasy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by user on 11.10.2015.
 */

@Controller
public class SquadController {

    @RequestMapping(value = "/squadload", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSquad(@RequestParam("teamID") int teamID)
    {
        String squad = "";
        try {
            URL url = new URL("http://www.sports.ru/fantasy/hockey/team/points/" + teamID + "/0.json");
            Scanner sc = new Scanner(url.openStream());
            squad = sc.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return squad;
    }
}
