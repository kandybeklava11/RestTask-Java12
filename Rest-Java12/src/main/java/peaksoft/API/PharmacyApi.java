package peaksoft.API;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Pharmacy;
import peaksoft.service.PharmacyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pharmacy")
public class PharmacyApi {
    private final PharmacyService pharmacyService;

    @GetMapping
    public List<Pharmacy> findAll() {
        return pharmacyService.findAll();
    }

    @PostMapping
    public Pharmacy save(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.save(pharmacy);
    }

    @PutMapping("/{id}")
    public Pharmacy update(@RequestBody Pharmacy pharmacy, @PathVariable Long id) {
        return pharmacyService.update(id, pharmacy);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return pharmacyService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Pharmacy> findById(@PathVariable Long id) {
        return pharmacyService.findById(id);
    }
    @GetMapping("/worker-pharmacy/{workerId}")
    public Pharmacy getPharmacyByWorkerId(@PathVariable Long workerId){
        return pharmacyService.getPharmacyByWorkerId(workerId);
    }
    @GetMapping("/search/{name}")
    public Pharmacy searchByName(@PathVariable("name") String name){
        return pharmacyService.searchByName(name);
    }
    @GetMapping("/max-worker")
    public Pharmacy getPharmacyWithMostWorkers(){
        return pharmacyService.getPharmacyWithMostWorkers();
    }
    @GetMapping("/all-med-by-ph-name/{name}")
    public Pharmacy getAllMedicinesByPharmacyName(@PathVariable String name){
        return pharmacyService.findAllMedicinesByPharmacyName(name);
    }
}
