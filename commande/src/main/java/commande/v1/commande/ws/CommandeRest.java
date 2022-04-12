package commande.v1.commande.ws;

import commande.v1.commande.bean.Commande;
import commande.v1.commande.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/commande")
public class CommandeRest {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return commandeService.deleteByReference(reference);
    }

    @GetMapping("/total-less-than/{total}")
    public List<Commande> findByTotalLessThan(@PathVariable double total) {
        return commandeService.findByTotalLessThan(total);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Commande entity) {
        return commandeService.save(entity);
    }
}
