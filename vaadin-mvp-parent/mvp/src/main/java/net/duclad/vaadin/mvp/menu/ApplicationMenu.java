package net.duclad.vaadin.mvp.menu;


import com.vaadin.ui.CustomComponent;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import net.duclad.vaadin.mvp.view.AbstractView;
import net.duclad.vaadin.mvp.view.ApplicationView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

public abstract class ApplicationMenu extends CustomComponent {

	abstract protected void setMenuTitle(String title);

	abstract protected void addMenuItem(ApplicationView view);

	protected void markMenuItemActive(ApplicationView view) {

	}
}
