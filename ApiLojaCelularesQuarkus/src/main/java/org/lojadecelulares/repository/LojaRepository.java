package org.lojadecelulares.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.lojadecelulares.model.Loja;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LojaRepository implements PanacheRepository<Loja> {
}
