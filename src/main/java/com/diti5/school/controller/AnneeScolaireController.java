package com.diti5.school.controller;

import com.diti5.school.dao.IAnneeScolaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AnneeScolaireController {

    @Autowired
    IAnneeScolaire anneeScolairedao;
}
