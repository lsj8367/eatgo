package com.example.test.eatgo.application;

import com.example.test.eatgo.domain.Review;
import com.example.test.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReviewServiceTest {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        reviewService = new ReviewService(reviewRepository);
    }

    @DisplayName("review추가하기")
    @Test
    public void addReview(){
        Review review = Review.builder()
                .name("lsj")
                .score(3)
                .description("Mat-it-da")
                .build();
        
        reviewService.addReview(1004L, review);

        verify(reviewRepository).save(any());
    }

}