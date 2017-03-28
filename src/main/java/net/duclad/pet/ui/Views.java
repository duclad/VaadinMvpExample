package net.duclad.pet.ui;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import net.duclad.vaadin.ViewDetails;

public enum Views implements ViewDetails {
	CUSTOMER("Customers", FontAwesome.USERS, "", CustomerViewBean.class),
	INVOICE("Invoices", FontAwesome.DOLLAR, "invoice", JobViewBean.class);

	private final String name;
	private final Resource icon;
	private final String id;
	private final Class<? extends View> type;

	private Views(String name, Resource icon, String id, Class<? extends View> type) {
		this.name = name;
		this.icon = icon;
		this.id = id;
		this.type = type;
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
		return type;
	}
}
