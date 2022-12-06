package com.lcrtech.productregistration.repository;

import com.lcrtech.productregistration.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("Select p from Product p where p.id like concat('%', ?1, '%') " +
            "or p.barCode like concat('%', ?1, '%') " +
            "or p.name like concat('%', ?1, '%')")
    List<Product> findProductByAnyData(String data);


}
