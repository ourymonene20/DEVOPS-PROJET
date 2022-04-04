package com.diti5.school.controller;

import com.diti5.school.dao.IClasse;
import com.diti5.school.dao.IEleve;
import com.diti5.school.dao.IParent;
import com.diti5.school.entities.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class EleveController {

    @Autowired
    IEleve elevedao;

    @Autowired
    IClasse classedao;

    @Autowired
    IParent parentdao;

    @RequestMapping(value = "/eleve/showForm/")
    public String showForm(ModelMap map){
        Eleve eleve = new Eleve();
        map.addAttribute("eleve",eleve);
        map.addAttribute("classe", classedao.findAll());
        map.addAttribute("parent", parentdao.findAll());
        return "admin/eleve/add";
    }

    @RequestMapping(value = "/eleve/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        map.addAttribute("classe", classedao.findAll());
        List<Eleve> els = elevedao.findAll();
        return new ModelAndView("admin/eleve/list","eleves",els);
    }

    @RequestMapping(value ="/eleve/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("eleve") Eleve eleve){
        //Date date = new Date();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
       // String dateNaissance = formatter.format(date.toInstant());
        //eleve.setDateNaissance(dateNaissance);
        try {
            elevedao.save(eleve);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/eleve/list";
    }

    @RequestMapping(value = "/eleve/delete", method = RequestMethod.GET)
    public String delete(int id){
        try {
            elevedao.delete(elevedao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/eleve/list";
    }
}
