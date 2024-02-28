package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;

@Getter
@Setter
@Entity
@Table(name="pharmacy")
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ph_gen")
    @SequenceGenerator(name = "ph_gen", sequenceName = "ph_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @ManyToMany(mappedBy = "pharmacies",cascade = REMOVE)
    private List<Medicines> medicines;
    @OneToMany(mappedBy = "pharmacy",cascade = REMOVE,fetch = FetchType.EAGER)
    private List<Worker>workers;

    @PrePersist
    private void prePersist(){
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = ZonedDateTime.now();
    }


}
