package net.saving.savingmanagement.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name")
    private String Name;

    @Column(name ="phone_number")
    private Integer phoneNumber;

    @Column(name="email_id")
    private String emailId;

    @Column(name="member_number")
    private Integer memberNumber;
}
