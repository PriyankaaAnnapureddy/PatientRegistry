package com.example.PatientRegistry.service;

import com.example.PatientRegistry.entity.Patient;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    void addPatient(Patient patient);
    Patient getPatientByID(int id);
    void updatePatient(Patient patient);
    void deletePatient(int id);
}
