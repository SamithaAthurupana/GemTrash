package com.srilankagem.gembackend.gem.service;

import com.srilankagem.gembackend.gem.dto.GemStoneRequest;
import com.srilankagem.gembackend.gem.dto.GemStoneResponse;
import com.srilankagem.gembackend.gem.models.GemStone;
import com.srilankagem.gembackend.gem.repository.GemStoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class GemStoneService {


    private final GemStoneRepository gemStoneRepository;


    public Page<GemStoneResponse> getAllGemStone(Pageable pageable){
        return gemStoneRepository.findByActiveTrue(pageable).map(this::toResponse);
    }
    public GemStoneResponse createGemStone (GemStoneRequest request){

        GemStone gemStone = GemStone.builder()
                .gemCode(request.getGemCode())
                .type(request.getType())
                .origin(request.getOrigin())
                .caratWeight(request.getCarateWeight())
                .description(request.getDescription())
                .stockQuantity(request.getStockQuantity())
                .pricePerCarate(request.getPricePerCarat())
                .description(request.getDescription())
                .active(true)
                .build();

        return toResponse(gemStoneRepository.save(gemStone));
    }

    private GemStoneResponse toResponse(GemStone gemStone){
        return GemStoneResponse.builder()
                .id(gemStone.getId())
                .gemCode(gemStone.getGemCode())
                .type(gemStone.getType())
                .color(gemStone.getColor())
                .caratWeight(gemStone.getCaratWeight())
                .origin(gemStone.getOrigin())
                .treatment(gemStone.getTreatment())
                .pricePerCarat(gemStone.getPricePerCarate())
                .stockQuantity(gemStone.getStockQuantity())
                .certified(gemStone.isCertified())
                .createdAt(gemStone.getCreatedAt())
                .updatedAt(gemStone.getUpdatedAt())
                .description(gemStone.getDescription())
                .build();
    }
}
