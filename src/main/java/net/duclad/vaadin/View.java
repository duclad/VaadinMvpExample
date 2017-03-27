package net.duclad.vaadin;

import com.vaadin.server.Resource;

public interface View {
    String getName();

    Resource getIcon();

    String getId();

    Class<? extends com.vaadin.navigator.View> getType();
}
