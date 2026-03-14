package com.example.crud.service.impl;

import com.example.crud.mapper.KtpMapper;
import com.example.crud.model.dto.KtpAddRequest;
import com.example.crud.model.dto.KtpDto;
import com.example.crud.model.entity.Ktp;
import com.example.crud.repository.KtpRepository;
import com.example.crud.service.KtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KtpServiceImpl implements KtpService {
    private final KtpRepository repository;
    private final KtpMapper mapper;

    @Override
    public List<KtpDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public KtpDto findById(Integer id) {
        Ktp ktp = repository.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        return mapper.toDto(ktp);
    }

    @Override
    public KtpDto save(KtpAddRequest req) {
        if(repository.findByNomorKtp(req.getNomorKtp()).isPresent()) throw new RuntimeException("KTP sudah terdaftar");
        Ktp ktp = new Ktp(null, req.getNomorKtp(), req.getNamaLengkap(), req.getAlamat(), req.getTanggalLahir(), req.getJenisKelamin());
        return mapper.toDto(repository.save(ktp));
    }

    @Override
    public KtpDto update(Integer id, KtpAddRequest req) {
        Ktp ktp = repository.findById(id).orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        ktp.setNamaLengkap(req.getNamaLengkap());
        ktp.setAlamat(req.getAlamat());
        ktp.setTanggalLahir(req.getTanggalLahir());
        ktp.setJenisKelamin(req.getJenisKelamin());
        return mapper.toDto(repository.save(ktp));
    }

    @Override
    public void delete(Integer id) { repository.deleteById(id); }
}