package com.example.paimentv1.ws.required.facade;

// C'est la partie qu'on va connsomer les ws a l'exterieur

import com.example.paimentv1.ws.required.vo.CommandeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="commande-v1")
public interface CommandeRestRequired {


    @GetMapping("/ecom/commande-api/reference/{reference}")
    public CommandeVo findByReference(@PathVariable String reference);

    @PostMapping("/ecom/commande-api/")
    public int save(@RequestBody CommandeVo commandeVo);

    @PutMapping("/ecom/commande-api/")
    public int update(@RequestBody CommandeVo commandeVo);

}
