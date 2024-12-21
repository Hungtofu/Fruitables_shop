package Fruitables.shop.controller;

import Fruitables.shop.dto.UserReviewDTO;
import Fruitables.shop.payload.Request.UserReviewRequest;
import Fruitables.shop.service.UserReviewService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class UserReviewController {

    private final UserReviewService userReviewService;

    public UserReviewController(UserReviewService userReviewService) {
        this.userReviewService = userReviewService;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> addUserReview(@RequestBody UserReviewRequest review){

        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        boolean isSuccess = false;
        if(!email.isEmpty()){
            isSuccess = userReviewService.addReview(email, review);
        }
        return ResponseEntity.status(HttpStatus.OK).body(isSuccess);
    }

}
