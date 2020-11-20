//package com.product.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="supplier")
//public class SupplierEntity {
//	
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    private long id;
//	    
//		@Column(name = "name")
//	    private String name;
//	    
//	    @Column(name = "email")
//	    private String email;
//	    
//	    
//	//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//	//    @OneToOne
//	//    private String supplierID;
//	    
//	    public long getId() {
//			return id;
//		}
//
//		public void setId(long id) {
//			this.id = id;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}
//	    
//	  
//}
