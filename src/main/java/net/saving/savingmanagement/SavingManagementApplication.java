package net.saving.savingmanagement;

import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.model.PersonalSaving;
import net.saving.savingmanagement.model.Saving;
import net.saving.savingmanagement.repository.CustomerRepository;
import net.saving.savingmanagement.repository.PersonalSavingRepository;
import net.saving.savingmanagement.repository.SavingRepository;
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
	@Autowired
	private SavingRepository savingRepository;

	//autowiring our repository to communicate with thie file
	@Autowired
	private PersonalSavingRepository personalSavingRepository;
	@Override
	public void run(String... args) throws Exception {
		// Seeding Customer
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

		//Seeding Savings
		Saving saving = new Saving();
		saving.setProductName("Education Savings");
		saving.setAmount(5000);
		savingRepository.save(saving);

		Saving saving1 = new Saving();
		saving1.setProductName("Personal Savings");
		saving1.setAmount(10000);
		savingRepository.save(saving1);

		Saving saving2 = new Saving();
		saving2.setProductName("Vacation Savings");
		saving2.setAmount(2500);
		savingRepository.save(saving2);

		//Seeding PersonalSaving
		PersonalSaving personalsaving = new PersonalSaving();
		personalsaving.setName("Geoffrey Matieso");
		personalsaving.setTotalSavings(220.00);
		personalSavingRepository.save(personalsaving);

		PersonalSaving personalsaving1 = new PersonalSaving();
		personalsaving1.setName("Peter Nderitu");
		personalsaving1.setTotalSavings(130.50);
		personalSavingRepository.save(personalsaving1);




	}
}
