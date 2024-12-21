package Fruitables.shop.service;

import Fruitables.shop.dto.UserReviewDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.entity.UserReview;
import Fruitables.shop.payload.Request.UserReviewRequest;
import Fruitables.shop.repository.ShopOrderItemRepository;
import Fruitables.shop.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class UserReviewService {

    private final UserService userService;
    private final UserReviewRepository userReviewRepo;
    private final ShopOrderItemRepository shopOrderItemRepo;

    public UserReviewService(UserService userService, UserReviewRepository userReviewRepo, ShopOrderItemRepository shopOrderItemRepo) {
        this.userService = userService;
        this.userReviewRepo = userReviewRepo;
        this.shopOrderItemRepo = shopOrderItemRepo;
    }


    public boolean addReview(String email, UserReviewRequest request){
        User user = userService.findByEmail(email);
        if(user != null){
            UserReview userReview = new UserReview();
            userReview.setUser(user);
            userReview.setComment(request.getCmt());
            userReview.setRatingValue(request.getRatingValue());
            userReview.setOrderProduct(shopOrderItemRepo.findById(request.getShopOrderItemId()));

            try {
                userReviewRepo.save(userReview);
                return true;
            } catch (Exception e){
                System.out.println("Error insert user review: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

}
