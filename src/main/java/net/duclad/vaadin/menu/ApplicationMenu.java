package net.duclad.vaadin.menu;


import net.duclad.vaadin.ApplicationView;
import net.duclad.vaadin.View;

public interface ApplicationMenu extends ApplicationView<ApplicationMenuPresenter> {

	void setMenuTitle(String title);

	void addMenuItem(View view);

	void markMenuItemActive(View view);
}
