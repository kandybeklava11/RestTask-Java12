package peaksoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.entity.Medicines;
import peaksoft.entity.Pharmacy;

import java.util.List;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {
    @Query("select p from Pharmacy p inner join p.workers w on w.id= :workerId")
    @Transactional
    Pharmacy findByWorkerId(Long WorkerId);

    Pharmacy searchByName(String name);
    @Query("SELECT p FROM Pharmacy p WHERE p.id = (SELECT p2.pharmacy.id FROM Worker p2 GROUP BY p2.pharmacy.id ORDER BY COUNT(p2) DESC)")
    Pharmacy findPharmacyWithMostWorkers();
    @Query("select p.medicines,p.name from Pharmacy p inner join p.medicines m where p.name=?1")
    Pharmacy findAllMedicinesByPharmacyName(String name);

}
