package peaksoft.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.medicines.MedicinesResponse;
import peaksoft.entity.Medicines;

import java.util.List;

@Repository
public interface MedicinesRepo extends JpaRepository<Medicines, Long> {
    @Query("SELECT NEW peaksoft.dto.medicines.MedicinesResponse (m.name,m.price) FROM Medicines m order by m.name asc")
    @Transactional
    List<MedicinesResponse> sortByNameAsc();

    @Query("SELECT NEW peaksoft.dto.medicines.MedicinesResponse (m.name,m.price) FROM Medicines m order by m.name desc")
    @Transactional
    List<MedicinesResponse> sortByNameDesc();
    @Query("SELECT NEW peaksoft.dto.medicines.MedicinesResponse (m.name,m.price) FROM Medicines m where m.name=?1")
    @Transactional
    MedicinesResponse searchByName(String name);
}
