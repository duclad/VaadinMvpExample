package net.duclad.vaadin;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Resource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * View details.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewDetails {
    String getName();

    VaadinIcons getIcon();

    String getId();

    Class<? extends com.vaadin.navigator.View> getType();
}
