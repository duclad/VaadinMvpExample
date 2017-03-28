package net.duclad.vaadin.mvp;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.CustomComponent;
import net.duclad.vaadin.ViewDetails;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * AbstractView is the base class of all MVP views. It takes care of finding
 * appropriate presenter component for the view.
 *
 * @param <P> type of the presenter this view uses.
 */
public abstract class AbstractView<P extends AbstractPresenter> extends CustomComponent
        implements ApplicationContextAware, View {

    private P presenter;

    private ApplicationContext applicationContext;

    private String name;
    private Resource icon;
    private String id;
    private Class<? extends View> type;

    @PostConstruct
    protected final void init() {
        Logger.getLogger(getClass().getSimpleName()).info("ViewDetails init");
        ViewDetails viewDetails = this.getClass().getAnnotation(ViewDetails.class);
        this.name = viewDetails.getName();
        this.id = viewDetails.getId();
        this.icon = viewDetails.getIcon();
        presenter.init((ApplicationView) this);

        onViewReady();
    }

    protected void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    protected abstract void injectPresenter(P presenter);

    @Override
    public void detach() {
        getPresenter().onViewExit();
        super.detach();
    }

    protected void onViewReady() {
        Logger.getLogger(getClass().getSimpleName()).info("ViewDetails ready");
    }

    protected P getPresenter() {
        return presenter;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getName() {
        return name;
    }

    public Resource getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public Class<? extends View> getType() {
        return this.getClass();
    }
}
