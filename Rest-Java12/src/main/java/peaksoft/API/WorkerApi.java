package peaksoft.API;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Worker;
import peaksoft.service.WorkerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/worker")
public class WorkerApi {
    private final WorkerService workerService;

    @GetMapping
    public List<Worker> findAll() {
        return workerService.findAll();
    }

    @PostMapping
    public Worker save(@RequestBody Worker worker) {
        return workerService.save(worker);
    }

    @PutMapping("/{id}")
    public Worker update(@RequestBody Worker worker, @PathVariable Long id) {
        return workerService.update(id, worker);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return workerService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Worker> findById(@PathVariable Long id) {
        return workerService.findById(id);
    }
    @GetMapping("/asc")
    public List<Worker> sortBySalaryAsc(){
        return workerService.sortBySalaryAsc();
    }
    @GetMapping("/desc")
    public List<Worker> sortBySalaryDesc(){
        return workerService.sortBySalaryDesc();
    }
    @GetMapping("/avg-worker")
    public Worker getAvgYearWorkers(){
        return workerService.getAvgYearWorkers();
    }
}

