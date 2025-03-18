package com.projet.moneyManage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.moneyManage.models.TypeRevenu;
import com.projet.moneyManage.repositories.TypeRevenuRepository;

@Service
public class TypeRevenuService {
    @Autowired
    private TypeRevenuRepository typeRevenuRepository;

    public List<TypeRevenu>  findAll(){
        return typeRevenuRepository.findAll();
    }

    public TypeRevenu findById(Long idTypeRevenu){
        return typeRevenuRepository.findById(idTypeRevenu).get();

    }
}
