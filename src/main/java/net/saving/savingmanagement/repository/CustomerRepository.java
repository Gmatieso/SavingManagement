package net.saving.savingmanagement.repository;

import net.saving.savingmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //Accepts all crud database methods
}
