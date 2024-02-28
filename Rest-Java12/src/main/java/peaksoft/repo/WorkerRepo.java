package peaksoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.entity.Worker;

import java.util.List;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {
    @Query("SELECT w FROM Worker w ORDER BY w.salary ASC")
    @Transactional
    List<Worker> sortBySalaryAsc();

    @Query("SELECT w FROM Worker w ORDER BY w.salary DESC")
    @Transactional
    List<Worker> sortBySalaryDesc();
    @Query("SELECT AVG(DATEDIFF(CURRENT_DATE(),w.dateOfBirth )) AS middle_age from Worker w")
    Worker getAvgYearWorkers();

}
