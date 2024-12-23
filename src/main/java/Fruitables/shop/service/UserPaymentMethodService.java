package Fruitables.shop.service;

import Fruitables.shop.dto.UserPaymentMethodDTO;
import Fruitables.shop.entity.User;
import Fruitables.shop.entity.UserPaymentMethod;
import Fruitables.shop.repository.PaymentTypeRepository;
import Fruitables.shop.repository.UserPaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentMethodService {
    private final UserPaymentMethodRepository userPaymentRepo;
    private final UserService userService;
    private final PaymentTypeRepository paymentRepo;
    public UserPaymentMethodService(UserPaymentMethodRepository userPaymentRepo, UserService userService, PaymentTypeRepository paymentRepo)
    {
        this.userPaymentRepo = userPaymentRepo;
        this.userService = userService;
        this.paymentRepo = paymentRepo;
    }

    public boolean addPaymentMethod(String email, UserPaymentMethodDTO dto) {
        User user = userService.findByEmail(email);
        if (user == null)
        {
            UserPaymentMethod userPaymentMethod = new UserPaymentMethod();
            userPaymentMethod.setUser(user);
            userPaymentMethod.setPaymentType(paymentRepo.findById(dto.getPaymentTypeId()));
            userPaymentMethod.setProvider(dto.getProvider());
            userPaymentMethod.setAccountNumber(dto.getAccountNumber());
            userPaymentMethod.setExpiryDate(dto.getExpiryDate());
            userPaymentMethod.setIsDefault(dto.getIsDefault());
            try {
                userPaymentRepo.save(userPaymentMethod);
                return true;
            }
            catch (Exception e)
            {
                System.out.println("Error insert user payment method: " + e.getMessage());
                return false;
            }

        }
        return false;
    }
}
