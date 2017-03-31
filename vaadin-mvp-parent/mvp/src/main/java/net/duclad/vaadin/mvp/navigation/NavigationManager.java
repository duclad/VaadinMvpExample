package net.duclad.vaadin.mvp.navigation;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import net.duclad.vaadin.mvp.MvpUI;
import net.duclad.vaadin.mvp.view.ApplicationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.Set;

@UIScope
@SpringComponent
public class NavigationManager {

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private ApplicationEventPublisher eventPublished;

    @Autowired
    private ViewDisplay viewDisplay;

    @Autowired
    private Set<ApplicationView> applicationViews;

    private Navigator navigator;

    @Autowired
    private MvpUI ui;

    @PostConstruct
    protected void initialize() {
        navigator = new Navigator(ui, viewDisplay);
        navigator.addProvider(viewProvider);
    }

    public void navigateTo(ApplicationView view) {
        eventPublished.publishEvent(new NavigationEvent(view));
    }

    @EventListener
    protected void onNavigationEvent(NavigationEvent event) {
        Optional<ApplicationView> targetView = applicationViews.stream().filter(view -> view.getId().equals(event.getTarget().getId())).findFirst();
        if (targetView.isPresent()) {
            navigator.navigateTo(event.getTarget().getId());
        } else {
            // TODO: fallback
//			navigator.navigateTo(Views.CUSTOMER.getId());
        }
    }

    public Set<ApplicationView> getApplicationViews(){
        return applicationViews;
    }
}
