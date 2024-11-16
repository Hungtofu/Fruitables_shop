package Fruitables.shop.service.serviceIMP;

import Fruitables.shop.payload.Request.SignInRequest;
import Fruitables.shop.payload.Request.SignUpRequest;

public interface LoginServiceIMP {

    boolean addUser(SignUpRequest signUpRequest);
    boolean checkSignIn(SignInRequest signInRequest);

}
