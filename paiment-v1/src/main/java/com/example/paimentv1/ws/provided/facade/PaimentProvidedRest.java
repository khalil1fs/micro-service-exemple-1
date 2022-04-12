package com.example.paimentv1.ws.provided.facade;


import com.example.paimentv1.bean.Paiment;
import com.example.paimentv1.service.facade.PaimentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// C'est la partie qu'on va exposer a l'exterieur


@RestController
@RequestMapping("ecom/paiment-api")
@Api("Gestion de Paiment")
public class PaimentProvidedRest {

    @ApiOperation("find Paiment by ref")
    @GetMapping("/reference/{reference}")
    public Paiment findByReference(@PathVariable String reference) {
        return paimentService.findByReference(reference);
    }

    @ApiOperation("save a Paiment if the reference does not exist")
    @PostMapping("/")
    public int save(@RequestBody Paiment paiment) {
        return paimentService.save(paiment);
    }

    @ApiOperation("update a Paiment")
    @PutMapping("/")
    public int update(@RequestBody Paiment paiment) {
        return paimentService.update(paiment);
    }

    @ApiOperation("get All Paiment")
    @GetMapping("/")
    public List<Paiment> findAll() {
        return paimentService.findAll();
    }

    @Autowired
    private com.example.paimentv1.service.facade.PaimentService paimentService;

}
