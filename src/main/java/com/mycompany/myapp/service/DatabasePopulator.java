package com.mycompany.myapp.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DatabasePopulator {

    public void test() {
        System.out.println("Oui !!!");
    }
}
