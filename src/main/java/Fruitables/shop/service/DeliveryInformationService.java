package Fruitables.shop.service;

import Fruitables.shop.dto.DeliveryInformationDTO;
import Fruitables.shop.entity.DeliveryInformation;
import Fruitables.shop.entity.User;
import Fruitables.shop.repository.DeliveryInformationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryInformationService {
    private final DeliveryInformationRepository deliveryInformationRepository;
    private final UserService userService;
    public DeliveryInformationService(DeliveryInformationRepository deliveryInformationRepository, UserService userService)
    {
        this.deliveryInformationRepository = deliveryInformationRepository;
        this.userService = userService;
    }

    public boolean addDeliveryInfo(String email, String firstName, String lastName, String phoneNumbers, String address1, String address2, String commune, String district, String province)
    {
        User user = userService.findByEmail(email);
        DeliveryInformation deli = new DeliveryInformation(user, firstName, lastName, phoneNumbers, address1, address2, commune, district, province);
        try {
            deliveryInformationRepository.save(deli);
            return true;
        }
        catch (Exception e) {
            System.out.print("Error save cart item: " + e.getMessage());
            return false;
        }
    }

    /*
    public boolean saveUserDeliveryInfo(String email, DeliveryInformationDTO dto){
        User user = userService.findByEmail(email);
        DeliveryInformation deliveryInformation = deliveryInformationRepository.findByUser(user);
        if (deliveryInformation == null)
        {
            DeliveryInformation newDelivery = new DeliveryInformation();
            newDelivery.setUser(user);
            newDelivery.setFirstName(dto.getFirstName());
            newDelivery.setLastName(dto.getLastName());
            newDelivery.setPhoneNumbers(dto.getPhoneNumbers());
            newDelivery.setAddress1(dto.getAddress1());
            newDelivery.setAddress2(dto.getAddress2());
            newDelivery.setCommune(dto.getCommune());
            newDelivery.setDistrict(dto.getDistrict());
            newDelivery.setProvince(dto.getProvince());
            deliveryInformationRepository.save(newDelivery);
            return newDelivery;
        }
        return deliveryInformation;
    }
     */

    public List<DeliveryInformationDTO> getDeliveryInformationByUser(String email) {
        User user = userService.findByEmail(email);
        List<DeliveryInformation> deliveryInformationList = deliveryInformationRepository.findByUser(user);
        List<DeliveryInformationDTO> deliveryInformationDTOList = new ArrayList<>();

        for (DeliveryInformation d : deliveryInformationList) {
            DeliveryInformationDTO de = new DeliveryInformationDTO();
            de.setUser(user);
            de.setFirstName(d.getFirstName());
            de.setLastName(d.getLastName());
            de.setPhoneNumbers(d.getPhoneNumbers());
            de.setAddress1(d.getAddress1());
            de.setAddress2(d.getAddress2());
            de.setCommune(d.getCommune());
            de.setDistrict(d.getDistrict());
            de.setProvince(d.getProvince());
            deliveryInformationDTOList.add(de);
        }
        return deliveryInformationDTOList;
    }

}
