package commande.v1.commande.service.impl;

import commande.v1.commande.bean.Commande;
import commande.v1.commande.dao.CommandeDao;
import commande.v1.commande.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommandeImpl implements CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return commandeDao.deleteByReference(reference);
    }

    @Override
    public List<Commande> findByTotalLessThan(double total) {
        return commandeDao.findByTotalLessThan(total);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public int save(Commande entity) {
        if (findByReference(entity.getReference()) != null) {
            return -1;
        } else {
            commandeDao.save(entity);
            return 1;
        }
    }
}
