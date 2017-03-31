package net.duclad.vaadin.mvp.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.duclad.vaadin.mvp.view.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;

@UIScope
@SpringComponent
public class ApplicationMenuBean extends ApplicationMenu {

	private CssLayout menuLayout;
	private Label menuTitle;

	private Map<ApplicationView, Button> menuItemMap;

	@Autowired
	private ApplicationMenuPresenter presenter;

	public ApplicationMenuBean() {
		setSizeFull();

		menuItemMap = new HashMap<>();

		menuLayout = new CssLayout();
		menuLayout.setSizeFull();
		menuLayout.setPrimaryStyleName(ValoTheme.MENU_ROOT);

		menuTitle = new Label();

		HorizontalLayout titleHolder = new HorizontalLayout(menuTitle);
		titleHolder.setPrimaryStyleName(ValoTheme.MENU_TITLE);

		menuLayout.addComponent(titleHolder);

		setCompositionRoot(menuLayout);
	}

	@PostConstruct
	protected final void init() {
		Logger.getLogger(getClass().getSimpleName()).info("View init");
		presenter.init(this);

	}

	@Override
	public void setMenuTitle(String title) {
		menuTitle.setValue(title);
	}

	@Override
	public void addMenuItem(ApplicationView view) {
		Button menuItem = new Button(view.getName(), view.getIcon());
		menuItem.setPrimaryStyleName(ValoTheme.MENU_ITEM);
		menuItem.addClickListener(e -> presenter.onMenuItemClicked(view));
		menuLayout.addComponent(menuItem);
		menuItemMap.put(view, menuItem);
	}

	@Override
	public void markMenuItemActive(ApplicationView view) {
		menuItemMap.values().forEach(i -> i.removeStyleName("selected"));

		if (menuItemMap.containsKey(view)) {
			menuItemMap.get(view).addStyleName("selected");
		}
	}

}
