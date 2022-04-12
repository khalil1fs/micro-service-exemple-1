package com.example.paimentv1.service.facade;


import com.example.paimentv1.bean.Paiment;

import java.util.List;

public interface PaimentService {
     Paiment findByReference(String reference);
     int save(Paiment Paiment);
     int update(Paiment Paiment);
     List<Paiment> findAll();
}
