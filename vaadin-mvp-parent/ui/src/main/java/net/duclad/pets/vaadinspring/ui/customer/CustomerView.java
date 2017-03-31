package net.duclad.pets.vaadinspring.ui.customer;

import net.duclad.pets.vaadinspring.service.customer.Customer;
import net.duclad.vaadin.mvp.view.ApplicationView;

import java.util.List;


public interface CustomerView extends ApplicationView<CustomerViewPresenter> {

	void populateCustomers(List<Customer> customers);

	void openCustomerEditor(Customer customer);
}
