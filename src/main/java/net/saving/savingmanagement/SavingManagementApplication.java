package net.saving.savingmanagement;

import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.model.PersonalSaving;
import net.saving.savingmanagement.model.Saving;
import net.saving.savingmanagement.model.Transaction;
import net.saving.savingmanagement.repository.CustomerRepository;
import net.saving.savingmanagement.repository.PersonalSavingRepository;
import net.saving.savingmanagement.repository.SavingRepository;
import net.saving.savingmanagement.repository.TransactionRepository;
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

	//autowiring our repository to communicate with this file
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void run(String... args) throws Exception {
		// Seeding Customer
		Customer customer =  new Customer();
		customer.setName("Geoffrey Matieso");
		customer.setPhoneNumber("0726933823");
		customer.setEmailId("matiesogeofrey@gmail.com");
		customer.setMemberNumber("A01");
		customerRepository.save(customer);


		//Seeding Savings
		Saving saving = new Saving();
		saving.setProductName("Education Savings");
		saving.setAmount(5000);
		savingRepository.save(saving);

		//Seeding PersonalSaving
		PersonalSaving personalsaving = new PersonalSaving();
		personalsaving.setName("Geoffrey Matieso");
		personalsaving.setTotalSavings(220.00);
		personalSavingRepository.save(personalsaving);


		//Seeding Transaction
		Transaction transaction = new Transaction();
		transaction.setTransactionDate("2023-06-01 09:15:00");
		transaction.setPaymentMethod("Cash");
		transaction.setAmount(100);
		//save our transaction to go to the database
		transactionRepository.save(transaction);


	}
}
