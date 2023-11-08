package com.example.demo.Service;

import com.example.demo.DTO.BirdTypesDTO;
import com.example.demo.Repo.BirdTypesRepo;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Transactional
public class BirdTypesService {
    @Autowired
    BirdTypesRepo repository;
    @Autowired
    private RestTemplate restTemplate;
    public List<BirdTypesDTO> get() {
        return repository.getAll();
    }
}
