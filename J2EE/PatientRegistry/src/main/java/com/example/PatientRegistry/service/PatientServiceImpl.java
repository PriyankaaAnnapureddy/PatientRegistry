package com.example.PatientRegistry.service;

import com.example.PatientRegistry.entity.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {
    private Map<Integer, Patient> patientsMap = new HashMap<>();
    private int currentId = 1; // Keep track of the next available ID

    // Constructor to pre-populate with 3 default records
    public PatientServiceImpl() {
        patientsMap.put(currentId, new Patient(currentId++, "Caster", 25, "Male", "cast@example.com", "New York", LocalDate.of(1998, 1, 15)));
        patientsMap.put(currentId, new Patient(currentId++, "Nate", 30, "Female", "nate@example.com", "Los Angeles", LocalDate.of(1993, 5, 20)));
        patientsMap.put(currentId, new Patient(currentId++, "Austin", 40, "Male", "nat@example.com", "Chicago", LocalDate.of(1983, 3, 12)));
    }

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientsMap.values());
    }

    @Override
    public void addPatient(Patient patient) {
        // Automatically assign a unique ID to the patient before adding
        patient.setId(currentId++);
        patientsMap.put(patient.getId(), patient);
    }

    @Override
    public Patient getPatientByID(int id) {
        return patientsMap.get(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientsMap.put(patient.getId(), patient);
    }

    @Override
    public void deletePatient(int id) {
        patientsMap.remove(id);
    }
}
