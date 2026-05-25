package com.srilankagem.gembackend.gem.controller;

import com.srilankagem.gembackend.common_exception.ResourceNotFoundException;
import com.srilankagem.gembackend.gem.dto.GemStoneRequest;
import com.srilankagem.gembackend.gem.dto.GemStoneResponse;

import com.srilankagem.gembackend.gem.service.GemStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/v1/gems")
@RequiredArgsConstructor
public class GemStoneController {

    private final GemStoneService gemStoneService;

    @GetMapping
    public Page<GemStoneResponse> getAllGemStones(@PageableDefault(size = 20,sort = "color") Pageable pageable) {

        return gemStoneService.getAllGemStone(pageable);

    }
    @PostMapping
    public ResponseEntity<GemStoneResponse> createGemStone (@RequestBody GemStoneRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Custom Head", "Sending Custom Header")
                .body(gemStoneService.createGemStone(request));
    }

    @GetMapping("/id")
    public ResponseEntity<GemStoneResponse> getById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(gemStoneService.getGemStoneById(id));
    }

}
