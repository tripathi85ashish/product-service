package com.product.service;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;










import com.product.entity.ProductEntity;
import com.product.model.ProductObject;
import com.product.repositry.ProductRepositry;



@Service
public class ProductServiceImpl implements ProductService {
	
       @Autowired
	   ProductRepositry productRepositry;
	  
	   public UUID createProduct(ProductObject product) {
		  
		   ProductEntity productEntity = new ProductEntity();
		   
		   productEntity.setName(product.getName());
		   productEntity.setPrice(product.getPrice());
		   productEntity.setDescription(product.getDescription());
		   productEntity.setSupplierId(product.getSupplierId());
		   productEntity.setStatus(0);
		   ProductEntity  ProductEntityObj= productRepositry.save(productEntity);
		   
		 return ProductEntityObj.getId();
	     
	   }
	  
	   
	   
	   public String deleteProduct(UUID productId) {
	  
		     ProductEntity productEntity  = productRepositry.findProductByID(productId);
		  //   productRepositry.deleteById(productId);
			 String message = "";
		     
			 if(productEntity!=null){
			   	 productRepositry.deleteProductByID(productEntity.getId());   	
				 	 message = "Record Deleted Susesfully";
					 
			 }else{
			       message = "Record Not Deleted Susesfully Product ID doesn't Exist";
			 } 
		 
		   return message;
	   }


	
	public ProductEntity getProductById(UUID productId) {
		// TODO Auto-generated method stub
		ProductEntity productEntity  =productRepositry.findProductByID(productId);		
		return productEntity;
	}

	@Override
	public String updateProduct(ProductObject productObject) {
		// TODO Auto-generated method stub
				 
		   ProductEntity productEntity  = productRepositry.findProductByID(productObject.getId());
		   String message = "";
			
		   if(productEntity!=null){
		       
			   productEntity.setId(productEntity.getId());
			   productEntity.setName(productObject.getName());
			   productEntity.setPrice(productObject.getPrice());
			   productEntity.setDescription(productObject.getDescription());
			   productEntity.setSupplierId(productObject.getSupplierId());
			   productEntity.setStatus(productObject.getStatus());
			   
			   productRepositry.save(productEntity);
			   message = "Product Updated SussesFully";
			   
		   }else{ 
			   message = "Product Not Found"; 
		   }	
		   
		   return message;
     }



	@Override
	public List<ProductEntity> getProducts() {
		// TODO Auto-generated method stub
		
	    List<ProductEntity> productEntity  = productRepositry.findAll();
		
		return productEntity;
	}

	   
}