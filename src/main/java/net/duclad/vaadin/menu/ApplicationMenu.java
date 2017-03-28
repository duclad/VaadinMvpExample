package net.duclad.vaadin.menu;


import net.duclad.vaadin.mvp.ApplicationView;
import net.duclad.vaadin.ViewDetails;

public interface ApplicationMenu extends ApplicationView<ApplicationMenuPresenter> {

	void setMenuTitle(String title);

	void addMenuItem(ViewDetails view);

	void markMenuItemActive(ViewDetails view);
}
