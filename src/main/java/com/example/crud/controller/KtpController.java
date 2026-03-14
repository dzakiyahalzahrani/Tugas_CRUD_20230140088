package com.example.crud.controller;

import com.example.crud.model.dto.KtpAddRequest;
import com.example.crud.model.dto.KtpDto;
import com.example.crud.service.KtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class KtpController {
    private final KtpService service;

    @GetMapping
    public List<KtpDto> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public KtpDto getById(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public KtpDto create(@RequestBody KtpAddRequest request) { return service.save(request); }

    @PutMapping("/{id}")
    public KtpDto update(@PathVariable Integer id, @RequestBody KtpAddRequest request) { return service.update(id, request); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { service.delete(id); }
}