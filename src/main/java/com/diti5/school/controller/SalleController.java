package com.diti5.school.controller;


import com.diti5.school.dao.SalleRepository;
import com.diti5.school.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class SalleController {

    @Autowired//pour linjection de dependance
    SalleRepository salleRepository;//besoin de repository pour la salle
    @GetMapping("/salle")
    //@RequestMapping(value = "/salle", method = RequestMethod.GET) //declarer une methode de type post
    public String showForm(Model model) {
        Salle salle= new Salle();
        model.addAttribute("salles",salle);
        return "salle";
    }
    //@PostMapping("/addsalle")
    @RequestMapping(value = "/addsalle", method = RequestMethod.POST)
    public String createsalle(Salle salle ) {
        salleRepository.save(salle);
        return "redirect:/list_salle";
    }
    //afficher liste salle
    @GetMapping("/list_salle")
    //@RequestMapping(value = "/salle", method = RequestMethod.GET) //declarer une methode de type post
    public String showsalle(Model model) {

        List<Salle>  salle= salleRepository.findAll();
        model.addAttribute("salles",salle);
        return "affichesalle";
    }
    //methode suppression
    @GetMapping("/deletesalle/{id}")
    public String deletesalle(@PathVariable("id") int id, Model model) {
        salleRepository.deleteById(id);
        return "redirect:/affichesalle";
    }
    //methode recuperation id pour modification

    @GetMapping("/modifiersalle/{idsalle}")
    public String editsalle(@PathVariable("idsalle") int idsalle, Model model){
        Salle salle = salleRepository.getById(idsalle);
        model.addAttribute("salle", salle);

        // return "inscription";
        return "salle";
    }







}
