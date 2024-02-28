package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.medicines.MedicinesRequest;
import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.entity.Medicines;
import peaksoft.repo.MedicinesRepo;
import peaksoft.service.MedicinesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicinesServiceImpl implements MedicinesService {
    private final MedicinesRepo medicinesRepo;
    public List<MedicinesResponse> findAll() {
        List<Medicines> medicinesList = medicinesRepo.findAll();
        return medicinesList.stream()
                .map(medicines -> MedicinesResponse.builder()
                        .name(medicines.getName())
                        .price(medicines.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MedicinesResponse save(MedicinesRequest medicines) {
        Medicines medicines1 = Medicines.builder()
                .name(medicines.getName())
                .price(medicines.getPrice())
                .build();
        medicinesRepo.save(medicines1);
        return MedicinesResponse.builder()
                .name(medicines1.getName())
                .price(medicines1.getPrice())
                .build();
    }

    @Override
    public MedicinesResponse update(Long id, MedicinesRequest medicines) {
        Medicines foundMed = medicinesRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Medicine with id: " + id + " not found!"));
        foundMed.setName(medicines.getName());
        foundMed.setPrice(medicines.getPrice());
        medicinesRepo.save(foundMed);

        return  MedicinesResponse.builder()
                .name(foundMed.getName())
                .price(foundMed.getPrice())
                .build();
    }


    @Override
    public Optional<MedicinesResponse> findById(Long id) {
        return  medicinesRepo.findById(id)
                .map(medicines -> MedicinesResponse.builder()
                .name(medicines.getName())
                .price(medicines.getPrice()).build());
    }

    @Override
    public String deleteById(Long id) {
        medicinesRepo.deleteById(id);
        return "successfully deleted!";
    }

    @Override
    public List<MedicinesResponse> sortByNameAsc() {
        List<MedicinesResponse> medicinesList = medicinesRepo.sortByNameAsc();
        return medicinesList.stream()
                .map(medicines -> MedicinesResponse.builder()
                        .name(medicines.getName())
                        .price(medicines.getPrice())
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public List<MedicinesResponse> sortByNameDesc() {
        List<MedicinesResponse> medicinesList = medicinesRepo.sortByNameDesc();
        return medicinesList.stream()
                .map(medicines -> MedicinesResponse.builder()
                        .name(medicines.getName())
                        .price(medicines.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MedicinesResponse searchByName(String name) {
        MedicinesResponse medicines = medicinesRepo.searchByName(name);
        return MedicinesResponse.builder()
                .name(medicines.getName())
                .price(medicines.getPrice())
                .build();
    }

}



