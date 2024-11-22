package Fruitables.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "delivery_information")
public class DeliveryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name",length = 65)
    private String firstName;

    @Column(name = "last_name", length = 65)
    private String lastName;

    @Column(name = "phone_numbers",  length = 65)
    private String phoneNumbers;

    @Column(name = "address1", length = 65)
    private String address1;

    @Column(name = "address2", length = 65)
    private String address2;

    @Column(name = "commune", length = 65)
    private String commune;

    @Column(name = "district", length = 65)
    private String district;

    @Column(name = "province", length = 65)
    private String province;

}
