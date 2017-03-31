package net.duclad.vaadin.mvp.navigation;


import net.duclad.vaadin.mvp.view.ApplicationView;

public class NavigationEvent {

	private final ApplicationView target;

	public NavigationEvent(ApplicationView target) {
		this.target = target;
	}

	public ApplicationView getTarget() {
		return target;
	}
}
