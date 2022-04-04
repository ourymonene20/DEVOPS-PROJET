package com.diti5.school.controller;

import com.diti5.school.dao.IParent;
import com.diti5.school.entities.Parent;
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
public class ParentController {
    @Autowired
    private IParent parentdao;

    @RequestMapping(value = "/parent/showForm/")
    public String showForm(ModelMap map){
       Parent parent = new Parent();
        map.addAttribute("parent",parent);
        return "admin/parent/add";
    }

    @RequestMapping(value = "/parent/list", method = RequestMethod.GET)
    public ModelAndView list(ModelMap map){
        List<Parent> parents = parentdao.findAll();
        return new ModelAndView("admin/parent/list","parents", parents);
    }

    @RequestMapping(value ="/parent/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("parent") Parent parent){
        //Date date = new Date();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        // String dateNaissance = formatter.format(date.toInstant());
        //eleve.setDateNaissance(dateNaissance);
        try {
            parentdao.save(parent);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/admin/parent/list";
    }

    @RequestMapping(value = "/parent/delete", method = RequestMethod.GET)
    public String delete(int id){
        try {
            parentdao.delete(parentdao.getById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/parent/list";
    }
}
