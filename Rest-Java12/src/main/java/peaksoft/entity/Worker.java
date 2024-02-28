package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name="worker")
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wor_gen")
    @SequenceGenerator(name = "wor_gen", sequenceName = "wor_seq", allocationSize = 1)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private BigDecimal salary;
    private String address;
    private LocalDate dateOfBirth;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @ManyToOne
    private Pharmacy pharmacy;

    @PrePersist
    private void prePersist(){
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt = ZonedDateTime.now();
    }

    public Worker(Long id, String name, String email, BigDecimal salary, String address, LocalDate dateOfBirth, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
