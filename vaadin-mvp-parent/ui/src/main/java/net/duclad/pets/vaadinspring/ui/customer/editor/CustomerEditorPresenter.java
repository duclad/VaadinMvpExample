package net.duclad.pets.vaadinspring.ui.customer.editor;

import net.duclad.pets.vaadinspring.service.customer.Customer;
import net.duclad.pets.vaadinspring.service.customer.CustomerService;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
@Scope(value = "prototype")
public class CustomerEditorPresenter extends AbstractPresenter<CustomerEditor> {

	@Autowired
	private CustomerService customerService;

	public void onCancelClicked() {
	}

	public void onFormSaveClicked() {
		if (getView().isFormContentValid()) {
			Customer customer = getView().fetchFormContent();
			try {
				customerService.store(customer);
				getView().showSaveSucceeded();
				getView().close();
			} catch (Exception e) {
				e.printStackTrace();
				getView().showSaveFailed();
			}
		}
	}
}
