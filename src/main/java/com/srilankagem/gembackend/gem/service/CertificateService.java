package com.srilankagem.gembackend.gem.service;

import com.srilankagem.gembackend.common.exception.DuplicateResourceException;
import com.srilankagem.gembackend.gem.dto.CertificateRequest;
import com.srilankagem.gembackend.gem.dto.CertificateResponse;
import com.srilankagem.gembackend.gem.repository.CertificateRepository;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }
    public CertificateResponse createCertificate(CertificateRequest request){

        if(certificateRepository.existsByCertificateNumber(request.getCertificateNumber())){
            throw new DuplicateResourceException("Certificate with "
                    + request.getCertificateNumber()+" this number already exists");
        }
        if(certificateRepository.existsByGemStoneId(request.getGemId())){
            throw new DuplicateResourceException("Certificate with "
                    + request.getGemId()+" already exists");
        }


    }
}
