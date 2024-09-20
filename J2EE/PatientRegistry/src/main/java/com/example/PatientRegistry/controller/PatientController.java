package com.example.PatientRegistry.controller;

import com.example.PatientRegistry.entity.Patient;
import com.example.PatientRegistry.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "index";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/update/{id}")
    public String updatePatientRecord(@PathVariable int id, Model model) {
        Patient patient = patientService.getPatientByID(id);
        model.addAttribute("patient", patient);
        return "updatePatientRecord";
    }

    @PostMapping("/update")
    public String updatePatientRecord(@ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
}
