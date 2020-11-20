package com.product.model;

import java.util.UUID;




public class ProductObject {
	
	   private UUID id; 
	
	   private String name;
	   private double price;
	   private String description;
	 
       private UUID supplierId;
       private Integer status;
	   
	   
		public Integer getStatus() {
		  return status;
	    }
		public void setStatus(Integer status) {
			this.status = status;
		}
		public UUID getId() {
			return id;
		}
		public void setId(UUID id) {
			this.id = id;
		}
	   
	   
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	  
		
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }

	   public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
	    }
		
		public UUID getSupplierId() {
				return supplierId;
		}
		public void setSupplierId(UUID supplierId) {
				this.supplierId = supplierId;
		}
	   
	   
}
