package com.example.crud.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "ktp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomorKtp", unique = true, nullable = false)
    private String nomorKtp;

    @Column(name = "namaLengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name = "jenisKelamin")
    private String jenisKelamin;
}
