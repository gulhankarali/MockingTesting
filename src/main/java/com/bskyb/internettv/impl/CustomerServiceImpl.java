package com.bskyb.internettv.impl;

import com.bskyb.internettv.impl.Customer;
import com.bskyb.internettv.impl.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private String parentalControlLevelCustomer;
    private String movieIdCustomer;

    public CustomerServiceImpl(){
        this.parentalControlLevelCustomer=parentalControlLevelCustomer;
        this.movieIdCustomer=movieIdCustomer;
    }

    public void setParentalControlLevel(String parentalControlLevelCustomer){
        this.parentalControlLevelCustomer=parentalControlLevelCustomer;
    }

    public String getParentalControlLevel(){
        return this.parentalControlLevelCustomer;
    }

    public String getMovieIdCustomer(){
        return this.movieIdCustomer;
    }
    public void setMovieIdCustomer(String movieIdCustomer){
        this.movieIdCustomer=movieIdCustomer;
    }

    @Override
    public String getCustomerTitle() {
        return this.movieIdCustomer;
    }

    @Override
    public String getCustomerParentalLevel() {
        return this.parentalControlLevelCustomer;
    }

    @Override
    public Customer getCustomer() {
        return new Customer();
    }
}
