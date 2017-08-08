package com.myImdb.controller;

import com.myImdb.DAO.UserDao;
import com.myImdb.model.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by trauma_sushan on 8/7/2017.
 */
@Controller
public class CastController {
    @Autowired
    UserDao dao;

    @GetMapping("/cast")
    public String getAllCast(Model model){
        //model.addAttribute("cast", castDao.getAll());
        return dao.findById("1").toString();
    }

    @PostMapping("/cast")
    public String create(Cast cast){
       // castDao.add(cast);
        return "redirect:/cast";
    }
}
