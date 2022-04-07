package com.diti5.school.controller;

import com.diti5.school.dao.IDiplome;
import com.diti5.school.dao.IEleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiplomeController {

    @Autowired
    private IDiplome diplomedao;
    @Autowired
    private IEleve elevedao;
}
