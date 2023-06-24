package net.saving.savingmanagement;

import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SavingManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SavingManagementApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {

		Customer customer =  new Customer();
		customer.setName("Geoffrey Matieso");
		customer.setPhoneNumber("0726933823");
		customer.setEmailId("matiesogeofrey@gmail.com");
		customer.setMemberNumber("A01");
		customerRepository.save(customer);

		Customer customer1 =  new Customer();
		customer1.setName("Peter Nderitu");
		customer1.setPhoneNumber("0795505505");
		customer1.setEmailId("nderitupeter@gmail.com");
		customer1.setMemberNumber("A02");
		customerRepository.save(customer1);

	}
}
