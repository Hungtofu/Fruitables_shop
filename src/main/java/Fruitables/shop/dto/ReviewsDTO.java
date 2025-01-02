package Fruitables.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsDTO {

    private double AvgRatingPoint;
    private List<ReviewDTO> reviewsList;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDTO{
        private int id;
        private String name;
        private String email;
        private int ratingPoint;
        private String comment;
    }


}
