package com.bskyb.internettv;

import com.bskyb.internettv.impl.Customer;
import com.bskyb.internettv.impl.CustomerServiceImpl;
import com.bskyb.internettv.impl.ParentalControlServiceImpl;
import com.bskyb.internettv.thirdparty.MovieServiceImpl;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParentControlServiceTest {


    @Test
    public void test() throws Exception {

        MovieServiceImpl movieServiceImpl;
        ParentalControlServiceImpl parentalControlServiceImpl;
        CustomerServiceImpl customerServiceImpl;

        try{
            movieServiceImpl= mock(MovieServiceImpl.class);
            parentalControlServiceImpl = mock(ParentalControlServiceImpl.class);
            customerServiceImpl= mock(CustomerServiceImpl.class);
//
//            CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl(){
//               @Override
//                public Customer getCustomer(){
//                   return new Customer();
//               }
//            };

            when(parentalControlServiceImpl.canWatchMovie("18", "Homeland")).thenReturn(true);

            when(movieServiceImpl.getParentalControlLevel("Homeland")).thenReturn("18");

            verify(parentalControlServiceImpl, atLeast(1)).canWatchMovie("18", "Homeland");

            verify(movieServiceImpl, atLeast(1)).getParentalControlLevel("Homeland");


        }
        // first exception
        catch (TitleNotFoundException e) {
            System.out.println("Title not found");
        }
        //second exception
        catch (TechnicalFailureException e){
            System.out.println("Technical failure has occurred");
        }

    }
}
