package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Worker;
import peaksoft.repo.WorkerRepo;
import peaksoft.service.WorkerService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepo workerRepo;

    @Override
    public List<Worker> findAll() {
        return workerRepo.findAll();
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepo.save(worker);
    }

    @Override
    public Worker update(Long id, Worker worker) {
        Worker foundWo = workerRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Worker with id: " + id + " not found!"));
        foundWo.setName(worker.getName());
        foundWo.setEmail(worker.getEmail());
        foundWo.setSalary(worker.getSalary());
        foundWo.setAddress(worker.getAddress());
        foundWo.setDateOfBirth(worker.getDateOfBirth());
        workerRepo.save(foundWo);
        return foundWo;
    }

    @Override
    public Optional<Worker> findById(Long id) {
        return workerRepo.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        workerRepo.deleteById(id);
        return "successfully deleted !";
    }

    @Override
    public List<Worker> sortBySalaryAsc() {
        return workerRepo.sortBySalaryAsc();
    }

    @Override
    public List<Worker> sortBySalaryDesc() {
        return workerRepo.sortBySalaryDesc();
    }

    @Override
    public Worker getAvgYearWorkers() {
        return workerRepo.getAvgYearWorkers();
    }
}
