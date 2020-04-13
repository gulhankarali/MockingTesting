package com.bskyb.internettv.thirdparty;

import com.bskyb.internettv.parental_control_service.ParentalControlService;

public class MovieServiceImpl implements MovieService {

    private ParentalControlService parentalControlService;

    public MovieServiceImpl(ParentalControlService parentalControlService){
        this.parentalControlService=parentalControlService;
    }
    @Override
    public String getParentalControlLevel(String titleId) throws Exception {
        boolean customerCanWatchMovie = parentalControlService.canWatchMovie(getParentalControlLevel(titleId), titleId);
        if (customerCanWatchMovie){
            return getParentalControlLevel(titleId);
        }
        return null;
    }
}
