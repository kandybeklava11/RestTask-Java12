package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Pharmacy;
import peaksoft.repo.PharmacyRepo;
import peaksoft.service.PharmacyService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepo pharmacyRepo;
    @Override
    public List<Pharmacy> findAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }

    @Override
    public Pharmacy update(Long id, Pharmacy pharmacy) {
        Pharmacy foundPh = pharmacyRepo.findById(id).orElseThrow(()
                -> new RuntimeException("Pharmacy with id: " + id + " not found!"));
        foundPh.setName(pharmacy.getName());
        foundPh.setAddress(pharmacy.getAddress());
        pharmacyRepo.save(foundPh);
        return foundPh;
    }

    @Override
    public Optional<Pharmacy> findById(Long id) {
        return pharmacyRepo.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        pharmacyRepo.deleteById(id);
        return"successfully deleted !";
    }

    @Override
    public Pharmacy getPharmacyByWorkerId(Long workerId) {
        return pharmacyRepo.findByWorkerId(workerId);
    }

    @Override
    public Pharmacy searchByName(String name) {
        return pharmacyRepo.searchByName(name);
    }

    @Override
    public Pharmacy getPharmacyWithMostWorkers() {
        return pharmacyRepo.findPharmacyWithMostWorkers();
    }

    @Override
    public Pharmacy findAllMedicinesByPharmacyName(String name) {
        return pharmacyRepo.findAllMedicinesByPharmacyName(name);
    }
}
