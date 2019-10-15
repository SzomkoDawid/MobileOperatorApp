package model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String postCode;
    @Column(name = "street_name", nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String country;
    @Column(name = "home_number", nullable = false)
    private String homeNumber;
    @OneToOne(mappedBy = "address", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private User user;
}
