package com.franmauriz.aop.app.cotrollers;

import org.springframework.web.bind.annotation.RestController;

import com.franmauriz.aop.app.services.SaludoService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class SaludoController {

    @Autowired
    private SaludoService saludoService;

    @GetMapping("/saludo")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", saludoService.sayHello("Manue","Hola pasisa")));
    }


    @GetMapping("/error")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", saludoService.sayHelloError("Manue","Hola pasisa")));
    }
    
}
