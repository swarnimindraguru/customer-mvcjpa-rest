package com.capg.dao;

import com.capg.entities.Customer;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Customer findById(int id) {
        Customer user = entityManager.find(Customer.class, id);
        return user;
    }


    @Override
    public List<Customer> fetchAll() {
        String jql = "from Customer";
        TypedQuery<Customer> query = entityManager.createQuery(jql, Customer.class);
        List<Customer> list = query.getResultList();
        return list;
    }

    @Override
    public Customer save(Customer customer) {
        customer = getEntityManager().merge(customer);
        return customer;
    }

    @Override
    public boolean remove(int id) {
        Customer customer = findById(id);
        getEntityManager().remove(customer);
        return true;
    }

}
