package com.bskyb.internettv.impl;

public class Customer {

        private String parentalControlLevelCustomer;
        private String movieIdCustomer;

        public Customer(){
            this.parentalControlLevelCustomer=parentalControlLevelCustomer;
            this.movieIdCustomer=movieIdCustomer;
        }

        public Customer(String movieIdCustomer, String parentalControlLevelCustomer){
            this();
            this.parentalControlLevelCustomer="18";
            this.movieIdCustomer="Homeland";
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
}
