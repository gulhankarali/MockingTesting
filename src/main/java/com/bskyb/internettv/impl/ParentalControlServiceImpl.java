package com.bskyb.internettv.impl;

import com.bskyb.internettv.parental_control_service.ParentalControlService;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.MovieService;

import java.util.Arrays;
import java.util.List;

public class ParentalControlServiceImpl implements ParentalControlService {

    private MovieService movieService;

    private static final List controlLevelList = Arrays.asList("U", "PG", "12", "15", "18");

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean canWatchMovie(String customerParentalControlLevel, String movieId) throws Exception {
            String parentalControlLevel = movieService.getParentalControlLevel(movieId);
            return isCanWatchTheMovie(customerParentalControlLevel, parentalControlLevel);
    }

    private boolean isCanWatchTheMovie(String customerParentalControlLevel, String parentalControlLevel) {
        if (controlLevelList.contains(parentalControlLevel)) {
            return controlLevelList.indexOf(customerParentalControlLevel) >= controlLevelList.indexOf(parentalControlLevel);
        }
        return false;
    }
}
