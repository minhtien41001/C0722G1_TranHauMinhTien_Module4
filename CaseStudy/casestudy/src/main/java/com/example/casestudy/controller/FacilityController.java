package com.example.casestudy.controller;

import com.example.casestudy.repository.facility.IFacilityRepository;
import com.example.casestudy.repository.facility.IFacilityTypeRepository;
import com.example.casestudy.repository.facility.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Autowired
    IFacilityTypeRepository iFacilityTypeRepository;

    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @GetMapping("")
    public String showList(@PageableDefault(value = 5)Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "facilityType", defaultValue = "")String facilityType,
                           Model model){
        model.addAttribute("listFacility",iFacilityRepository.searchFacility1(nameSearch, facilityType, pageable));
        model.addAttribute("listFacilityType",iFacilityTypeRepository.findAll());
        model.addAttribute("listRent")
    }
}
