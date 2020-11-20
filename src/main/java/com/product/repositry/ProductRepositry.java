package com.product.repositry;


import java.util.List;



import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.entity.ProductEntity;

@Repository
public interface ProductRepositry extends CassandraRepository<ProductEntity,UUID>{
	
	
    @Query("SELECT * FROM product  WHERE id=?0 AND status=0 ALLOW FILTERING ")
    ProductEntity findProductByID(UUID id);
    
    @Query("Update product  SET status=1  WHERE id =?0")
    void deleteProductByID(UUID id);
	
}
