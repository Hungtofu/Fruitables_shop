package Fruitables.shop.service;

import Fruitables.shop.dto.ReviewsDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.entity.User;
import Fruitables.shop.entity.UserReview;
import Fruitables.shop.payload.Request.UserReviewRequest;
import Fruitables.shop.repository.ProductRepository;
import Fruitables.shop.repository.ShopOrderItemRepository;
import Fruitables.shop.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReviewService {

    private final UserService userService;
    private final UserReviewRepository userReviewRepo;
    private final ProductRepository productRepo;

    public UserReviewService(UserService userService, UserReviewRepository userReviewRepo, ProductRepository productRepo) {
        this.userService = userService;
        this.userReviewRepo = userReviewRepo;
        this.productRepo = productRepo;
    }


    public boolean addReview(UserReviewRequest request){
        UserReview userReview = new UserReview();
        userReview.setProduct(productRepo.findById(request.getProductId()));
        userReview.setName(request.getName());
        userReview.setEmail(request.getEmail());
        userReview.setComment(request.getCmt());
        userReview.setRatingValue(request.getRatingValue());
        try {
            userReviewRepo.save(userReview);
            return true;
        } catch (Exception e){
            System.out.println("Error insert user review: " + e.getMessage());
        }
        return false;
    }

    public boolean addReview(String email, UserReviewRequest request){

        User user = userService.findByEmail(email);
        if(user != null){
            UserReview userReview = new UserReview();
            userReview.setProduct(productRepo.findById(request.getProductId()));
            userReview.setUser(user);
            userReview.setName(user.getUserName());
            userReview.setEmail(user.getEmail());
            userReview.setComment(request.getCmt());
            userReview.setRatingValue(request.getRatingValue());
            try {
                userReviewRepo.save(userReview);
                return true;
            } catch (Exception e){
                System.out.println("Error insert user review: " + e.getMessage());
            }
        }
        return false;
    }

    public ReviewsDTO getReview(int productId){
        List<UserReview> userReviewList = userReviewRepo.findByProduct(productRepo.findById(productId));
        List<ReviewsDTO.ReviewDTO> reviewDTOList = new ArrayList<>();
        for(UserReview r : userReviewList){
            ReviewsDTO.ReviewDTO review = new ReviewsDTO.ReviewDTO(r.getId(), r.getName(), r.getEmail(), r.getRatingValue(), r.getComment());
            reviewDTOList.add(review);
        }
        return new ReviewsDTO(getAverageRating(userReviewList), reviewDTOList);
    }

    public double getAverageRating(List<UserReview> list){
        double sumRatingvalue = 0;
        for(UserReview review : list){
            sumRatingvalue += review.getRatingValue();
        }
        return sumRatingvalue/list.size();
    }

}
