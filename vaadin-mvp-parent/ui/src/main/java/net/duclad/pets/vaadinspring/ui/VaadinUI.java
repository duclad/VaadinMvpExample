package net.duclad.pets.vaadinspring.ui;

import com.vaadin.annotations.Widgetset;
import net.duclad.vaadin.mvp.MvpUI;
import net.duclad.vaadin.mvp.navigation.NavigationManager;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import net.duclad.vaadin.mvp.view.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@Push
@SpringUI
@Theme("valo")
public class VaadinUI extends MvpUI {

	@Autowired
	@Lazy
	private NavigationManager navigationManager;

	@Autowired
	private ApplicationViewDisplay viewDisplay;

	@Autowired
	@Qualifier(value = "CustomerViewBean")
	private ApplicationView defaultView;

	@Override
	protected void init(VaadinRequest request) {
		setContent(viewDisplay.getComponentContainer());
		navigationManager.navigateTo(defaultView);
	}

	@Override
	public <T extends AbstractPresenter> ApplicationView<T> getDefaultView() {
		return defaultView;
	}
}
