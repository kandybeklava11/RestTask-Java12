package peaksoft.API;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.medicines.MedicinesRequest;
import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.service.MedicinesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicinesApi {
    private final MedicinesService medicinesService;
    @GetMapping
    public List<MedicinesResponse> findAll(){
        return medicinesService.findAll();
    }

    @PostMapping
    public MedicinesResponse save(@RequestBody MedicinesRequest medicines){
        return medicinesService.save(medicines);
    }
    @PutMapping("/{id}")
    public MedicinesResponse update(@RequestBody MedicinesRequest medicines,@PathVariable Long id){
        return medicinesService.update(id,medicines);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        return medicinesService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<MedicinesResponse> findById(@PathVariable Long id){
        return medicinesService.findById(id);
    }
    @GetMapping("/asc")
    public List<MedicinesResponse> sortByNameAsc(){
        return medicinesService.sortByNameAsc();
    }
    @GetMapping("/desc")
    public List<MedicinesResponse> sortByNameDesc(){
        return medicinesService.sortByNameDesc();
    }
    @GetMapping("/search/{name}")
    public MedicinesResponse searchByName(@PathVariable("name") String name){
        return medicinesService.searchByName(name);
    }
}
