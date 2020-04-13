package com.bskyb.internettv.impl;

import com.bskyb.internettv.parental_control_service.ParentalControlService;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.MovieServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ParentalControlServiceImpl implements ParentalControlService {

    private MovieServiceImpl movieServiceImpl;
    private CustomerServiceImpl customerServiceImpl;

    private static final List controlLevelList = Arrays.asList("U", "PG", "12", "15", "18");

    public ParentalControlServiceImpl(MovieServiceImpl movieServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
        this.customerServiceImpl=customerServiceImpl;
    }

    public boolean canWatchMovie(String customerParentalControlLevel, String movieId) throws Exception {
            String parentalControlLevel = movieServiceImpl.getParentalControlLevel(movieId);
            return isCanWatchTheMovie(customerParentalControlLevel, parentalControlLevel);
    }

    private boolean isCanWatchTheMovie(String customerParentalControlLevel, String parentalControlLevel) {
        if (controlLevelList.contains(parentalControlLevel)) {
            return controlLevelList.indexOf(customerParentalControlLevel) >= controlLevelList.indexOf(parentalControlLevel);
        }
        return false;
    }
}
