package com.diti5.school.controller;

import com.diti5.school.dao.INiveau;
import com.diti5.school.entities.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class NiveauController {

    @Autowired
    INiveau niveaudao;

    @RequestMapping(value = "niveau/showForm/")
    public String showForm(ModelMap map){
        Niveau niveau = new Niveau();
        map.addAttribute("niveau",niveau);
        return "admin/niveau/add";
    }

    @RequestMapping(value = "/niveau/list", method = RequestMethod.GET)
    public ModelAndView list(){
        List<Niveau> nis = niveaudao.findAll();
        return new ModelAndView("admin/niveau/list","niveaus",nis);
    }

    @RequestMapping(value ="/niveau/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("niveau") Niveau niveau){

        try {
            niveaudao.save(niveau);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/niveau/list";
    }

    @RequestMapping(value = "/niveau/delete")
    public String delete(int id){
        try {
            niveaudao.delete(niveaudao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/niveau/list";
    }
}
