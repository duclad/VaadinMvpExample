package net.duclad.pets.vaadinspring.ui.customer.editor;


import net.duclad.pets.vaadinspring.service.customer.Customer;
import net.duclad.vaadin.mvp.view.ApplicationView;

public interface CustomerEditor extends ApplicationView<CustomerEditorPresenter> {

	boolean isFormContentValid();

	Customer fetchFormContent();

	void showSaveFailed();

	void showSaveSucceeded();

	void close();
}
