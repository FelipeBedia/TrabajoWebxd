package com.unir.alquiler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.unir.alquiler.model.request.AlquilerRequest;
import com.unir.alquiler.service.AlquilerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AlquilerController {
    
    private final AlquilerService service;

    @PostMapping("/alquileres")
    public ResponseEntity<String> createAlquiler(@RequestBody AlquilerRequest request){
        String result = service.createAlquiler(request);

        if(request != null){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.badRequest().build();
        }
    }
}
