package net.duclad.vaadin.menu;


import net.duclad.vaadin.mvp.AbstractView;

public class NavigationEvent {

	private final AbstractView target;

	public NavigationEvent(AbstractView target) {
		this.target = target;
	}

	public AbstractView getTarget() {
		return target;
	}
}
