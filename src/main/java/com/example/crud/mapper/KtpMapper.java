package com.example.crud.mapper;

import com.example.crud.model.dto.KtpDto;
import com.example.crud.model.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {
    public KtpDto toDto(Ktp ktp) {
        KtpDto dto = new KtpDto();
        dto.setId(ktp.getId());
        dto.setNomorKtp(ktp.getNomorKtp());
        dto.setNamaLengkap(ktp.getNamaLengkap());
        dto.setAlamat(ktp.getAlamat());
        dto.setTanggalLahir(ktp.getTanggalLahir());
        dto.setJenisKelamin(ktp.getJenisKelamin());
        return dto;
    }
}