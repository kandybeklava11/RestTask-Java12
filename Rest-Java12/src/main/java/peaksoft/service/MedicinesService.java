package peaksoft.service;


import peaksoft.dto.medicines.MedicinesRequest;
import peaksoft.dto.medicines.MedicinesResponse;

import java.util.List;
import java.util.Optional;

public interface MedicinesService {
    List<MedicinesResponse> findAll();

    MedicinesResponse save(MedicinesRequest medicines);

    MedicinesResponse update(Long id, MedicinesRequest medicines);
    Optional<MedicinesResponse> findById(Long id);

    String deleteById(Long id);
    List<MedicinesResponse> sortByNameAsc();
    List<MedicinesResponse> sortByNameDesc();
    MedicinesResponse searchByName(String name);

}
