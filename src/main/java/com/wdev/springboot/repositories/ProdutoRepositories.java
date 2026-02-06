package com.wdev.springboot.repositories;


import com.wdev.springboot.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProdutoRepositories extends JpaRepository<ProdutoModel, UUID> {

    List<ProdutoModel> findByMarca(String marca);
}
