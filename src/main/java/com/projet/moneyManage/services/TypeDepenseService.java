package com.projet.moneyManage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.TypeDepense;
import com.projet.moneyManage.repositories.TypeDepenseRepository;

@Service
public class TypeDepenseService {
    @Autowired
    private TypeDepenseRepository typeDepenseRepository;

    public List<TypeDepense> findAll(){
        return typeDepenseRepository.findAll();
    }

    public TypeDepense findById(Long id){
        return typeDepenseRepository.findById(id).get();
    }
}
