package commande.v1.commande.dao;

import commande.v1.commande.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {

    Commande findByReference(String reference);

    int deleteByReference(String reference);

    List<Commande> findByTotalLessThan(double total);
    List<Commande> findByTotalGreaterThan(double total);


}
