package com.diti5.school.controller;

import com.diti5.school.dao.IAnneeScolaire;
import com.diti5.school.dao.IClasse;
import com.diti5.school.dao.IEmploiTemps;
import com.diti5.school.dao.INiveau;
import com.diti5.school.entities.Classe;
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
public class ClasseController {

    @Autowired
    IClasse classedao;

    @Autowired
    IEmploiTemps tempsdao;

    @Autowired
    INiveau niveaudao;

    @Autowired
    IAnneeScolaire anneeScolairedao;

    @RequestMapping(value = "/classe/showForm/")
    public String showForm(ModelMap map){
        Classe classe = new Classe();
        map.addAttribute("classe",classe);
        map.addAttribute("emploi", tempsdao.findAll());
        map.addAttribute("niveau", niveaudao.findAll());
        map.addAttribute("anneeScolaire", anneeScolairedao.findAll());
        return "admin/classe/add";
    }

    @RequestMapping(value = "/classe/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        map.addAttribute("emploi", tempsdao.findAll());
        map.addAttribute("niveau", niveaudao.findAll());
        map.addAttribute("annee", anneeScolairedao.findAll());
        List<Classe> classes = classedao.findAll();
        return new ModelAndView("admin/classe/list","classes",classes);
    }

    @RequestMapping(value ="/classe/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("classe") Classe classe){
        try {
            classedao.save(classe);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/classe/list";
    }

    @RequestMapping(value = "/classe/delete", method = RequestMethod.GET)
    public String delete(int id){
        try {
            classedao.delete(classedao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/classe/list";
    }

}
