package com.gouri.general.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", indexes = {@Index(name = "UNIQUE_EMAIL", columnList = "emailId", unique = true)})
@Builder
@Data
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 15, unique = true)
    private String phoneNumber;
    @Column(length = 50, unique = true)
    private String emailId;
    @Column(length = 50)
    private String Nationality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
