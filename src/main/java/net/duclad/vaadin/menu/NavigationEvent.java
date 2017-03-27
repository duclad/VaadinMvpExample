package net.duclad.vaadin.menu;


import net.duclad.vaadin.View;

public class NavigationEvent {

	private final View target;

	public NavigationEvent(View target) {
		this.target = target;
	}

	public View getTarget() {
		return target;
	}
}
