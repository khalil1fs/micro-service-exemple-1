package com.example.paimentv1.service.impl;

import com.example.paimentv1.bean.Paiment;
import com.example.paimentv1.dao.PaimentDao;
import com.example.paimentv1.service.facade.PaimentService;
import com.example.paimentv1.util.NumberUtil;
import com.example.paimentv1.ws.required.facade.CommandeRestRequired;
import com.example.paimentv1.ws.required.vo.CommandeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaimentServiceImpl implements PaimentService {

    @Override
    public Paiment findByReference(String reference) {
        return paimentDao.findByReference(reference);
    }

    @Override
    public List<Paiment> findAll() {
        return paimentDao.findAll();
    }

    @Autowired
    private com.example.paimentv1.dao.PaimentDao paimentDao;
    @Autowired
    private CommandeRestRequired commandeRestRequired;


    @Override
    public int save(Paiment paiment) {
        CommandeVo commandeVo = commandeRestRequired.findByReference(paiment.getCommandeReference());
        if (commandeVo == null || commandeVo.getId()==null) {
                return -1;
        }else if(NumberUtil.toDouble(commandeVo.getTotalPaye())+paiment.getMontant() > NumberUtil.toDouble(commandeVo.getTotal()))
                return -2;
        else{
        paimentDao.save(paiment);
        commandeVo.setTotalPaye(NumberUtil.toString(NumberUtil.toDouble(commandeVo.getTotalPaye())+paiment.getMontant()));
        commandeRestRequired.update(commandeVo);
            return 1;
        }
    }

    @Override
    public int update(Paiment paiment) {
        paimentDao.save(paiment);
        return 1;
    }

}
