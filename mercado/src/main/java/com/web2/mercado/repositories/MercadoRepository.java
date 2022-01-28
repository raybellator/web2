package com.web2.mercado.repositories;

import com.web2.mercado.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface MercadoRepository extends CrudRepository<Produto,Long> {}
