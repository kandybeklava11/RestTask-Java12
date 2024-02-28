package peaksoft.service;

import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.entity.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface PharmacyService {
    List<Pharmacy> findAll();

    Pharmacy save(Pharmacy pharmacy);

    Pharmacy update(Long id, Pharmacy pharmacy);
    Optional<Pharmacy> findById(Long id);

    String deleteById(Long id);

    Pharmacy getPharmacyByWorkerId(Long workerId);

    Pharmacy searchByName(String name);

    Pharmacy getPharmacyWithMostWorkers();
    Pharmacy findAllMedicinesByPharmacyName(String name);

}
