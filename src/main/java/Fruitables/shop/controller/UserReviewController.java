package Fruitables.shop.controller;

import Fruitables.shop.dto.ReviewsDTO;
import Fruitables.shop.dto.UserReviewDTO;
import Fruitables.shop.payload.Request.UserReviewRequest;
import Fruitables.shop.service.UserReviewService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class UserReviewController {

    private final UserReviewService userReviewService;

    public UserReviewController(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> addUserReviewWithoutAccount(@RequestBody UserReviewRequest review){
        return ResponseEntity.status(HttpStatus.OK).body(userReviewService.addReview(review));
    }

    @PostMapping("/account/post")
    public ResponseEntity<Boolean> addUserReviewWithAccount(@RequestBody UserReviewRequest review){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(!email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(userReviewService.addReview(email, review));
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }

    @PostMapping("/product/{id}")
    public ResponseEntity<ReviewsDTO> getReview(@PathVariable(name = "id") int productId){
        return ResponseEntity.status(HttpStatus.OK).body(userReviewService.getReview(productId));
    }


}
