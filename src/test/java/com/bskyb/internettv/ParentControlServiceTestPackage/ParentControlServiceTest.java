package com.bskyb.internettv.ParentControlServiceTestPackage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bskyb.internettv.impl.ParentalControlServiceImpl;
import com.bskyb.internettv.thirdparty.MovieService;
import com.bskyb.internettv.thirdparty.TechnicalFailureException;
import com.bskyb.internettv.thirdparty.TitleNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ParentControlServiceTest {

	private static final String MOVIE_ID = "Homeland";
	private static final String CUSTOMER_PERANTAL_CONTROL_LEVEL = "PG";
	
	@InjectMocks
	private ParentalControlServiceImpl parentalControlServiceImpl;

	@Mock
	private MovieService movieService;


	@Test
	public void test_canWatchMovie_ReturnTrue_WhenParentControlMatchWithMovie() throws Exception {

		when(movieService.getParentalControlLevel(MOVIE_ID)).thenReturn("PG");
		
		boolean result = parentalControlServiceImpl.canWatchMovie(CUSTOMER_PERANTAL_CONTROL_LEVEL, MOVIE_ID);

		verify(movieService).getParentalControlLevel(any(String.class));

		assertTrue(result);
	}

	@Test
	public void test_canWatchMovie_ReturnFalse_WhenParentControlMatchWithMovie() throws Exception {

		when(movieService.getParentalControlLevel(MOVIE_ID)).thenReturn("18");

		boolean result = parentalControlServiceImpl.canWatchMovie(CUSTOMER_PERANTAL_CONTROL_LEVEL, MOVIE_ID);

		verify(movieService).getParentalControlLevel(any(String.class));

		assertFalse(result);
	}

	@Test(expected = TechnicalFailureException.class)
	public void test_canWatchMovie_ThrowTechnicalFailureException_WhenParantControlMatchWithMovie() throws Exception {

		when(movieService.getParentalControlLevel(MOVIE_ID)).thenThrow(new TechnicalFailureException());

		parentalControlServiceImpl.canWatchMovie(CUSTOMER_PERANTAL_CONTROL_LEVEL, MOVIE_ID);

		verify(movieService).getParentalControlLevel(any(String.class));

	}

    @Test(expected = TitleNotFoundException.class)
    public void test_canWatchMovie_ThrowTitleNotFoundException_WhenParantControlMatchWithMovie() throws Exception {

        when(movieService.getParentalControlLevel(MOVIE_ID)).thenThrow(new TitleNotFoundException());

        parentalControlServiceImpl.canWatchMovie(CUSTOMER_PERANTAL_CONTROL_LEVEL, MOVIE_ID);

        verify(movieService).getParentalControlLevel(any(String.class));

    }
}
