package com.diti5.school.controller;

import com.diti5.school.dao.IMatiere;
import com.diti5.school.entities.Matiere;
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
public class MatiereController {

    @Autowired
    IMatiere matiereRepository;




    @RequestMapping(value = "/matiere/showForm/")
    public String showForm(ModelMap map){
        Matiere matiere = new Matiere();
        map.addAttribute("matiere",matiere);
        //map.addAttribute("classe", classedao.findAll());

        return "admin/matiere/add";
    }

    @RequestMapping(value = "/matiere/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        map.addAttribute("matiere", matiereRepository.findAll());
        List<Matiere> mats = matiereRepository.findAll();
        return new ModelAndView("admin/matiere/list","matieres",mats);
    }

    @RequestMapping(value ="/matiere/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("matiere") Matiere matiere){
        try {
            matiereRepository.save(matiere);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/matiere/list";
    }

    @RequestMapping(value = "/matiere/delete", method = RequestMethod.GET)
    public String delete(int id){
        try {
            matiereRepository.delete(matiereRepository.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/matiere/list";
    }
}
