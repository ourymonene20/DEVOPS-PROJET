package com.diti5.school.controller;

import com.diti5.school.dao.IAbsenceEleve;
import com.diti5.school.dao.IEleve;
import com.diti5.school.entities.AbsenceEleve;
import com.diti5.school.entities.Eleve;
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
public class AbsenceEleveController {
    @Autowired
    IAbsenceEleve absenceelevedao;
    @Autowired
    IEleve elevedao;

    @RequestMapping(value = "/absenceEleve/showForm/")
    public String showForm(ModelMap map){
        AbsenceEleve absenceEleve = new AbsenceEleve();
        map.addAttribute("absenceEleve",absenceEleve);
        Eleve eleve = new Eleve();
        map.addAttribute("eleve", eleve);
        return "admin/absenceEleve/add";
    }

    @RequestMapping(value = "/absenceEleve/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        map.addAttribute("absenceEleve", absenceelevedao.findAll());
        List<AbsenceEleve> ab = absenceelevedao.findAll();
        map.addAttribute("eleve", elevedao.findAll());
        List<Eleve> els = elevedao.findAll();
        return new ModelAndView("admin/absenceEleve/list","absenceeleves",ab);
    }

    @RequestMapping(value ="/absenceEleve/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("absenceEleve") AbsenceEleve absenceEleve){
        //Date date = new Date();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        // String dateNaissance = formatter.format(date.toInstant());
        //eleve.setDateNaissance(dateNaissance);
        try {
            absenceelevedao.save(absenceEleve);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/absenceEleve/list";
    }

    @RequestMapping(value = "/absenceEleve/delete", method = RequestMethod.GET)
    public String delete(int id){
        try {
            absenceelevedao.delete(absenceelevedao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/absenceEleve/list";
    }
}
