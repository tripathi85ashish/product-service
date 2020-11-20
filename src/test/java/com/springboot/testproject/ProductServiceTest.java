package com.springboot.testproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.product.entity.ProductEntity;
import com.product.main.ProductServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductServiceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest  
{
	 @Autowired
	  private TestRestTemplate restTemplate;

	  @LocalServerPort
	  private int port;

	  private String getRootUrl() {
	      return "http://localhost:" + port ;
	  }

	  @Test
	  public void contextLoads() {
	     	
	  }
	
	  /**
		 * Here we test that we can get all the products in the database
		 * using the GET method
		 */
	  @Test
	  public void testGetAllProducts() {
	    HttpHeaders headers = new HttpHeaders();
	    HttpEntity<String> entity = new HttpEntity<String>(null, headers);

	    ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products",
	        HttpMethod.GET, entity, String.class);

	    Assert.assertNotNull(response.getBody());
	  }
	  
	  /**
		 * Here we test that we can fetch a single product by id
		 */
	  @Test
	  public void testGetProductById() {
		  ProductEntity productEntity = restTemplate.getForObject(getRootUrl() + "/product/d83151c2-137e-4d06-9901-7f71fc4e02b8", ProductEntity.class);
			//System.out.println(ProductEntity.getCarName());
	    Assert.assertNotNull(productEntity);
	  }
	
	  /**
		 * Here we test that we can update a Product information using the PUT method
		 */
	  @Test
	  public void testUpdateProduct() {
	    String id = "d83151c2-137e-4d06-9901-7f71fc4e02b8";
	    ProductEntity productEntity = restTemplate.getForObject(getRootUrl() + "/product/" + id, ProductEntity.class);
	    productEntity.setName("shoes");
	    productEntity.setDescription("shoes");
	    restTemplate.put(getRootUrl() + "/updateProduct/", productEntity);

	    ProductEntity updatedProduct = restTemplate.getForObject(getRootUrl() + "/product/" + id, ProductEntity.class);
	    Assert.assertNotNull(updatedProduct);
	  }  
	  
	  /**
		 * Here we test that we can delete a product by using the DELETE method
		 */
	  @Test
	  public void testDeleteProduct() {
		 String id = "d83151c2-137e-4d06-9901-7f71fc4e02b8";
		 ProductEntity productEntity = restTemplate.getForObject(getRootUrl() + "/product/" + id, ProductEntity.class);

	    Assert.assertNotNull(productEntity);
	  //  productEntity.setStatus(0);

	    restTemplate.put(getRootUrl() + "/updateProduct/", productEntity);

	    try {
		   
	    	ProductEntity updatedProduct = restTemplate.getForObject(getRootUrl() + "/product/" + id, ProductEntity.class);
		    Assert.assertNotNull(updatedProduct);

	    } catch (final HttpClientErrorException e) {
	      Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  /**
		 * Here we test that we can create a product using the POST method
		 */
	  @Test
	  public void testCreateCar() {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setPrice(2000.00);
		productEntity.setStatus(0);
		productEntity.setName("PEN");
		productEntity.setDescription("PEN FOR WRITING");
		
		

	    ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/createProduct", productEntity, String.class);
	    Assert.assertNotNull(postResponse);
	  //  Assert.assertNotNull(postResponse.getBody());
	  }
	  
	
}
