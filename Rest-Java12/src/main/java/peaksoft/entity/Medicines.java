package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="medicines")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_gen")
    @SequenceGenerator(name = "med_gen", sequenceName = "med_seq", allocationSize = 1)
    private Long id;
    private String name;
    @Column(nullable = false)
    private double price;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @ManyToMany
    private List<Pharmacy> pharmacies;

    @PrePersist
    private void prePersist(){
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = ZonedDateTime.now();
    }
}
