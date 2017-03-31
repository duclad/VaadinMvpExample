package net.duclad.pets.vaadinspring.ui.customer;

import com.vaadin.contextmenu.GridContextMenu;
import com.vaadin.contextmenu.Menu;
import net.duclad.pets.vaadinspring.service.customer.Customer;
import net.duclad.pets.vaadinspring.ui.customer.editor.CustomerEditorBean;
import net.duclad.pets.vaadinspring.ui.customer.event.CustomerEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import net.duclad.vaadin.mvp.view.AbstractView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@SpringView(name = "")
public class CustomerViewBean extends AbstractView<CustomerViewPresenter> implements CustomerView, View {

    private Grid<Customer> customerGrid;

    @Autowired
    private ApplicationEventPublisher customerEventSource;

    @Autowired
    @Lazy
    private CustomerEditorBean customerEditor;


    public CustomerViewBean() {
        setSizeFull();

        customerGrid = buildCustomerTable();
        customerGrid.setSizeFull();

        VerticalLayout layout = new VerticalLayout(customerGrid);
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setSizeFull();

        setCompositionRoot(layout);
    }

    private Grid<Customer> buildCustomerTable() {
        Grid<Customer> grid = new Grid<>();
        grid.setSizeFull();
        grid.addColumn(Customer::getFirstName).setCaption("First Name");
        grid.addColumn(Customer::getLastName).setCaption("Last Name");
        GridContextMenu<Customer> gridContextMenu = new GridContextMenu<>(grid);
        gridContextMenu.addGridBodyContextMenuListener(gridContextMenuOpenEvent -> {
            gridContextMenu.removeItems();
            gridContextMenu.addItem("Add", (Menu.Command) menuItem -> customerEventSource.publishEvent(new CustomerEvent(CustomerEvent.EventType.ADD, null)));
            gridContextMenu.addItem("Edit", null);
            gridContextMenu.addItem("Remove", null);
        });
        return grid;
    }

    @Override
    public void enter(ViewChangeEvent event) {
        getPresenter().onViewEnter();
    }

    @Override
    public void populateCustomers(List<Customer> customers) {
        customerGrid.setItems(customers);
    }

    @Override
    public void openCustomerEditor(Customer customer) {
        customerEditor.setCustomer(customer);
    }

    @Override
    @Autowired
    protected void injectPresenter(CustomerViewPresenter presenter) {
        setPresenter(presenter);
    }

    @Override
    public String getName() {
        return "Customers";
    }
}
