package com.projet.moneyManage.repositories;

import com.projet.moneyManage.models.DepenseRevenu;
import com.projet.moneyManage.models.DepenseRevenuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRevenuRepository extends JpaRepository<DepenseRevenu, DepenseRevenuId> {
    
}
