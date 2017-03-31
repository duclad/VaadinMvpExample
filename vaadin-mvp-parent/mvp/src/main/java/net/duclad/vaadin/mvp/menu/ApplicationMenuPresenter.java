package net.duclad.vaadin.mvp.menu;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import net.duclad.vaadin.mvp.navigation.NavigationEvent;
import net.duclad.vaadin.mvp.navigation.NavigationManager;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import net.duclad.vaadin.mvp.view.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

import java.util.logging.Logger;

@UIScope
@SpringComponent
public class ApplicationMenuPresenter extends AbstractPresenter {

    @Autowired
    private ApplicationEventPublisher navigationEventSource;

    @Autowired
    private NavigationManager navigationManager;

    private ApplicationMenu menu;

    /**
     * Notifies the presenter that its view is initialized so that presenter can
     * start its own initialization if required.
     *
     * @param menu
     */
    protected final void init(ApplicationMenu menu) {
        Logger.getLogger(getClass().getSimpleName()).info("Menu Presenter init");
        this.menu = menu;
        onPresenterReady();
    }

    @Override
    protected void onPresenterReady() {
        super.onPresenterReady();

        navigationManager.getApplicationViews().forEach(menuitem -> menu.addMenuItem(menuitem));
        menu.setMenuTitle("Vaadin - MVP example");
    }

    public void onMenuItemClicked(ApplicationView view) {
        navigationEventSource.publishEvent(new NavigationEvent(view));
    }

    @EventListener
    protected void onNavigationEvent(NavigationEvent event) {
        menu.markMenuItemActive(event.getTarget());
    }
}
