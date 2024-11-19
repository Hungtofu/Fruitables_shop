package Fruitables.shop.payload.Request;

import jakarta.validation.constraints.NotBlank;

public class SignInRequest {

    @NotBlank(message = "can't empty!")
    private String email;

    @NotBlank(message = "can't empty!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
