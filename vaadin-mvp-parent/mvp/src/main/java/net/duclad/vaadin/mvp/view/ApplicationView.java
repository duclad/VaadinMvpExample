package net.duclad.vaadin.mvp.view;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;

import java.util.UUID;

/**
 * Interface that must be implemented by all applications view
 *
 * @param <P>
 */
public interface ApplicationView<P extends AbstractPresenter> extends View {

    /**
     * A name of the view presented in the UI
      * @return
     */
    String getName();

    /**
     * An icon associated with this view in the UI
     * @return
     */
    Resource getIcon();

    /**
     * Internal id of the view. It defaults to the complete class name of this view
     * @return
     */
    default String getId(){
        return this.getClass().getName();
    }

    /**
     * The concrete class implementation of the view
     * @return
     */
    default Class<? extends View> getType() {
        return this.getClass();
    }
}
