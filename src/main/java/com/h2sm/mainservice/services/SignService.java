package com.h2sm.mainservice.services;

import com.h2sm.mainservice.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignService {
    private final SignRepository signRepository;
}
