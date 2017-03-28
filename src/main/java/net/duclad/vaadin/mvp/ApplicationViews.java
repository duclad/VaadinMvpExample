package net.duclad.vaadin.mvp;

import net.duclad.vaadin.ViewDetails;
import org.reflections.Reflections;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationViews {
    private static final ApplicationViews _INSTANCE = new ApplicationViews();
    private final Set<Class<? extends AbstractView>> views;

    private ApplicationViews() {
        Reflections reflections = new Reflections();
        views = reflections.getSubTypesOf(AbstractView.class).stream().//
                filter(abstractViewClass -> abstractViewClass.isAnnotationPresent(ViewDetails.class)).//
                collect(Collectors.toSet());
    }

    public static Set<Class<? extends AbstractView>> list() {
        return _INSTANCE.views;
    }

    public static Stream<Class<? extends AbstractView>> stream() {
        return _INSTANCE.views.stream();
    }
}
