package net.duclad.pets.vaadinspring.service.customer;

import java.util.List;

public interface CustomerService {

	void store(Customer customer);

	void delete(Customer customer);

	List<Customer> getCustomers();
}
