package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Position;
import com.h2sm.mainservice.dtos.Sign;
import com.h2sm.mainservice.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SignService {
    private final SignRepository signRepository;
    private final AssignmentService assignmentService;
    private final DocumentService documentService;

    public void createSignAfterUploadingFile(Long assignmentId, Long documentID){
        var document = documentService.getDocumentFromDB(documentID);
        var ass = assignmentService.getAssignment(assignmentId);
        var sign = new Sign(document,ass);
        signRepository.save(sign);
    }

    public void setSignForDirector(Long assId){
        var sign = signRepository.findSignByAssignment_Aid(assId);
        if (sign.isPresent()){
            var presentSign = sign.get();
            presentSign.setDirectorSigned(true);
            signRepository.save(presentSign);
        }
    }
    public void setSignForHead(Long assId){
        var sign = signRepository.findSignByAssignment_Aid(assId);
        if (sign.isPresent()){
            var presentSign = sign.get();
            presentSign.setHeadSigned(true);
            signRepository.save(presentSign);
        }
    }
    public void setSignForWorker(Long assId){
        var sign = signRepository.findSignByAssignment_Aid(assId);
        if (sign.isPresent()){
            var presentSign = sign.get();
            presentSign.setWorkerSigned(true);
            signRepository.save(presentSign);
        }
    }

}
