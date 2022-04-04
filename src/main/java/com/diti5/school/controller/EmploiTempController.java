package com.diti5.school.controller;

import com.diti5.school.dao.IEmploiTemps;
import com.diti5.school.dao.IProfesseur;
import com.diti5.school.entities.EmploiTemps;
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
public class EmploiTempController {
    @Autowired
    IEmploiTemps emploidao;

    @Autowired
    IProfesseur professeurdao;

    @RequestMapping(value = "emploiTemps/showForm/")
    public String showForm(ModelMap map){
        EmploiTemps emploiTemps = new EmploiTemps();
        map.addAttribute("emploiTemps",emploiTemps);
        map.addAttribute("professeur",professeurdao.findAll());
        return "admin/emploiTemps/add";
    }

    @RequestMapping(value = "/emploiTemps/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        map.addAttribute("professeur",professeurdao.findAll());
        List<EmploiTemps> eml = emploidao.findAll();
        return new ModelAndView("admin/emploiTemps/list","emploiTemps",eml);
    }

    @RequestMapping(value ="/emploiTemps/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("emploiTemps") EmploiTemps emploiTemps){

        try {
            emploidao.save(emploiTemps);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/emploiTemps/list";
    }

    @RequestMapping(value = "/emploiTemps/delete")
    public String delete(int id){
        try {
            emploidao.delete(emploidao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/emploiTemps/list";
    }
}
