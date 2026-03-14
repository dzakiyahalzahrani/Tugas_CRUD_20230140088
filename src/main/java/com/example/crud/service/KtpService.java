package com.example.crud.service;

import com.example.crud.model.dto.KtpAddRequest;
import com.example.crud.model.dto.KtpDto;
import java.util.List;

public interface KtpService {
    List<KtpDto> findAll();
    KtpDto findById(Integer id);
    KtpDto save(KtpAddRequest request);
    KtpDto update(Integer id, KtpAddRequest request);
    void delete(Integer id);
}