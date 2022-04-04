package com.diti5.school.controller;

import com.diti5.school.dao.IProfesseur;
import com.diti5.school.entities.Professeur;
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
public class ProfesseurController {

    @Autowired
    IProfesseur professeurdao;

    @RequestMapping(value = "professeur/showForm/")
    public String showForm(ModelMap map){
        Professeur professeur = new Professeur();
        map.addAttribute("professeur",professeur);
        return "admin/professeur/add";
    }

    @RequestMapping(value = "/professeur/list", method = RequestMethod.GET)
    public ModelAndView list(){
        List<Professeur> pls = professeurdao.findAll();
        return new ModelAndView("admin/professeur/list","professeurs",pls);
    }

    @RequestMapping(value ="/professeur/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("professeur") Professeur professeur){
        //Date date = new Date();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        //String dateNaissance = formatter.format(date.toInstant());
        //professeur.setDateNaissance(dateNaissance);
        try {
            professeurdao.save(professeur);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/professeur/list";
    }

    @RequestMapping(value = "/professeur/delete")
    public String delete(int id){
        try {
            professeurdao.delete(professeurdao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/professeur/list";
    }

}
