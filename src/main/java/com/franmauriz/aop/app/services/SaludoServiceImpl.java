package com.franmauriz.aop.app.services;

import org.springframework.stereotype.Service;

@Service
public class SaludoServiceImpl implements SaludoService{

    @Override
    public String sayHello(String person, String phrase) {
        String saludo = person + ": " + phrase;
        return saludo;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
      throw new RuntimeException("Sucedio un error");
    }

    

}
