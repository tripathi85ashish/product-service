package com.product.entity;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import com.datastax.driver.core.DataType;


@Table(value="product")
public class ProductEntity  implements Serializable{
	

	//private static final long serialVersionUID = 4285212120081695661L;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6390802787025083062L;


	@PrimaryKey
	@CassandraType(type = DataType.Name.UUID)
	
	private UUID id = UUID.randomUUID();
	
	
	@CassandraType(type = DataType.Name.TEXT)
	private String name;
	
	@CassandraType(type = DataType.Name.DOUBLE)
	private Double price;
	
	@CassandraType(type = DataType.Name.TEXT)
	private String description;
	  
	@CassandraType(type = DataType.Name.INT)
	private Integer status;
	
	@CassandraType(type = DataType.Name.UUID)
	private UUID supplierId;
	

	private Date date=  Calendar.getInstance().getTime();


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public UUID getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(UUID supplierId) {
		this.supplierId = supplierId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
