package com.diti5.school.controller;

import com.diti5.school.dao.IDiplome;
import com.diti5.school.dao.IEleve;
import com.diti5.school.entities.Diplome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DiplomeController {

    @Autowired
    private IDiplome diplomedao;
    @Autowired
    private IEleve elevedao;

    @RequestMapping(value = "/diplome/showForm")
    public String showForm(ModelMap map){
        Diplome diplome = new Diplome();
        map.addAttribute("diplome",diplome);
        map.addAttribute("eleves", elevedao.findAll());
        return "diplome/add";
    }

    @RequestMapping(value = "/diplome/list")
    public ModelAndView list(){
        List<Diplome> diplomes = diplomedao.findAll();
        return new ModelAndView("admin/diplome/list","diplomes",diplomes);
    }

    @RequestMapping(value = "/diplome/add")
    public String add(@ModelAttribute("diplome") Diplome diplome){

        try {
            diplomedao.save(diplome);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/diplome/list";
    }

    @RequestMapping(value = "/diplome/delete")
    public String delete(int id){
        Diplome diplome = diplomedao.getById(id);
        try {
            diplomedao.delete(diplome);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/diplome/list";
    }

    public String update(@ModelAttribute("diplome") Diplome diplome, int id){
        diplome = diplomedao.getById(id);
        try {
            diplomedao.save(diplome);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/diplome/list";
    }
}
