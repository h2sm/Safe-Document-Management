package com.h2sm.mainservice.services;

import com.h2sm.mainservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerService {
    public final WorkerRepository repo;
}
