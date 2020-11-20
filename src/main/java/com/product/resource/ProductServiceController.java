package com.product.resource;



import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.exception.ErrorResponse;
import com.product.model.ProductObject;
import com.product.service.ProductService;

@RestController
public class ProductServiceController {
	
	   @Autowired
	   ProductService productService;

	   /**
	 * @param id
	 * @return
	 */
	   
	  @SuppressWarnings("rawtypes")
	  @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	   public ResponseEntity getProductById(@PathVariable("id") UUID id) {
		 
		 ProductEntity productEntityObj = productService.getProductById(id);
		 if(productEntityObj == null ) {
			 throw new ErrorResponse("Product ID Not found: " + id);
		 }else {
			 return ResponseEntity.ok(productService.getProductById(id));
		 }
		 
	   }
	  
	   /**
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	   public ResponseEntity getAllProducts() {
	     return  ResponseEntity.ok(productService.getProducts());
	   
	}
	   
	   
	   /**
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	   public String updateProduct(@RequestBody ProductObject product) {
	      String message = productService.updateProduct(product);
	      return message;
	   }
	   
	
	   /**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	   public String delete(@PathVariable("id") UUID id) {
	      
	    String message =  productService.deleteProduct(id);
	    return message;
	   
	 }
	 
	 /**
	 * @param product
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	   @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	   public ResponseEntity createProduct(@RequestBody ProductObject product) {
	      return ResponseEntity.ok(productService.createProduct(product));
	   }

}
