package com.happyrecipek.web.admin.products.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import com.happyrecipek.web.com.system.annotations.Description;

@Entity
@Table(name="product_manager")
public class productManager {
	@Id
	@Column(name="PRODUCT_MANAGER_SEQ")
	@Description(logicalName="제품관리순번")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productManagerSeq;
	
	@Column(name="PRODUCT_MANAGER_COST")
	@Description(logicalName="제품가격")
	private int productManagerCost;
	
	@Column(name="PRODUCT_MANAGER_STOCK")
	@Description(logicalName="제품재고")
	private int productManagerStock;
	
	@Column(name="PRODUCT_MANAGER_SALE")
	@Description(logicalName="제품할인율")
	private int productManagerSale;
	
	@Column
	@Description(logicalName = "사용여부")
	private String useYn;
	
	@Column(name="REGISTER_DATE", updatable=false)
	@Description(logicalName="등록일")
	@CreationTimestamp
	private Timestamp registerDate;
	
	@Column(name="REGISTER_ID")
	@Description(logicalName="등록자")
	private String registerId;
	
	@Column(name="UPDATE_DATE", updatable=true)
	@Description(logicalName="수정일")
	@LastModifiedDate
	private Timestamp updateDate;
	
	@Column(name="UPDATE_ID")
	@Description(logicalName="수정자")
	private String updateId;

	public int getProductManagerSeq() {
		return productManagerSeq;
	}

	public void setProductManagerSeq(int productManagerSeq) {
		this.productManagerSeq = productManagerSeq;
	}

	public int getProductManagerCost() {
		return productManagerCost;
	}

	public void setProductManagerCost(int productManagerCost) {
		this.productManagerCost = productManagerCost;
	}

	public int getProductManagerStock() {
		return productManagerStock;
	}

	public void setProductManagerStock(int productManagerStock) {
		this.productManagerStock = productManagerStock;
	}

	public int getProductManagerSale() {
		return productManagerSale;
	}

	public void setProductManagerSale(int productManagerSale) {
		this.productManagerSale = productManagerSale;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
}
