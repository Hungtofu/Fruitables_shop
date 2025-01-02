package Fruitables.shop.service;

import Fruitables.shop.dto.PaymentTypeDTO;
import Fruitables.shop.entity.PaymentType;
import Fruitables.shop.repository.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepo;
    public PaymentTypeService(PaymentTypeRepository paymentTypeRepo)
    {
        this.paymentTypeRepo = paymentTypeRepo;
    }

    public List<PaymentTypeDTO> getAllPaymentType() {
        List<PaymentTypeDTO> paymentList = new ArrayList<>();
        for (PaymentType p : this.paymentTypeRepo.findAll())
        {
            paymentList.add(new PaymentTypeDTO(p));
        }
        return paymentList;
    }
}
