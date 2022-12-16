package org.lojadecelulares.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.lojadecelulares.model.Produto;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {
    public List<Produto> findByLoja(long idLoja) {
        return find("loja_id",idLoja).list();
    }
}
