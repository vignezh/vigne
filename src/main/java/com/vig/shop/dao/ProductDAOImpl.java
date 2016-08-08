package com.vig.shop.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vig.shop.model.Product;
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO  {
	public ProductDAOImpl() {
	super();
	}
	
	@Autowired
	private SessionFactory session;
	
	
	public void save(Product product){
		session.getCurrentSession().save(product);
	}
	
	
	public void update(Product product){
		session.getCurrentSession().update(product);
	}
	public void delete(String productId){
		session.getCurrentSession().delete(getProduct(productId));
		
	}
	public Product getProduct(String productId){
		return(Product)session.getCurrentSession().get(Product.class,productId);
		
	}
	public List getAllproduct(){
		return session.getCurrentSession().createQuery("from product").list();
	}

}





















