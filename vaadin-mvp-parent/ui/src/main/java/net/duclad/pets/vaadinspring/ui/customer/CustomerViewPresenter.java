package net.duclad.pets.vaadinspring.ui.customer;

import javax.ejb.EJB;

import net.duclad.pets.vaadinspring.service.customer.Customer;
import net.duclad.pets.vaadinspring.service.customer.CustomerService;
import net.duclad.pets.vaadinspring.ui.customer.event.CustomerEvent;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import org.springframework.context.event.EventListener;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class CustomerViewPresenter extends AbstractPresenter<CustomerView> {

	@EJB
	private CustomerService customerService;

	@Override
	protected void onPresenterReady() {
		super.onPresenterReady();

		getView().populateCustomers(customerService.getCustomers());
	}

	@EventListener(condition = "#event.eventType == T(net.duclad.pets.vaadinspring.ui.customer.event.CustomerEvent.EventType).ADD")
	public void onAddEvent(CustomerEvent event) {
		getView().openCustomerEditor(new Customer());
	}

	@EventListener(condition = "#event.eventType ==T(net.duclad.pets.vaadinspring.ui.customer.event.CustomerEvent.EventType).EDIT")
	public void onEditEvent(CustomerEvent event) {
		getView().openCustomerEditor(event.getTarget());
	}

	@EventListener(condition = "#event.eventType == T(net.duclad.pets.vaadinspring.ui.customer.event.CustomerEvent.EventType).REMOVE")
	public void onRemoveCustomerClicked(CustomerEvent event) {
		customerService.delete(event.getTarget());
		getView().populateCustomers(customerService.getCustomers());
	}
}
