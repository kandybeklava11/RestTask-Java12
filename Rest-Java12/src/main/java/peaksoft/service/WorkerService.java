package peaksoft.service;

import peaksoft.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerService {
    List<Worker> findAll();

    Worker save(Worker worker);

    Worker update(Long id, Worker worker);
    Optional<Worker> findById(Long id);

    String deleteById(Long id);
    List<Worker> sortBySalaryAsc();
    List<Worker> sortBySalaryDesc();
    Worker getAvgYearWorkers();
}
