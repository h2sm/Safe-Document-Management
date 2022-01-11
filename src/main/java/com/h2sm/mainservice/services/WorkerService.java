package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Position;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    public final WorkerRepository repo;

    public List<Worker> getAllWorkers(){
        return repo.getAllWorkers();
    }
    public List<Worker> getWorkersWithThisPosition(Position position){
        return repo.getWorkerWithThisPosition(position.name());
    }
}
