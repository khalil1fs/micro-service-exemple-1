package com.example.paimentv1.dao;

import com.example.paimentv1.bean.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaimentDao extends JpaRepository<Paiment,Long> {
    Paiment findByReference(String reference);
}
