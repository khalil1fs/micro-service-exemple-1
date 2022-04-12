package commande.v1.commande.service.facade;

import commande.v1.commande.bean.Commande;
import java.util.List;


public interface CommandeService {
    Commande findByReference(String reference);
    int deleteByReference(String reference);
    List<Commande> findByTotalLessThan(double total);
    List<Commande> findAll();
    int save(Commande entity);



}
