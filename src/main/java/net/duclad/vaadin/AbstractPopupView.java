package net.duclad.vaadin;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

/**
 * AbstractPopupView is the base class of all MVP views that are displayed in a modal popup window.
 * It takes care of finding appropriate presenter component for the view.
 * 
 * @param
 * 			<P>
 *            type of the presenter this view uses.
 * 
 * @author Peter / Vaadin
 */
public abstract class AbstractPopupView<P extends AbstractPresenter> extends AbstractView<P> {

	private Window window;

	@Override
	protected void onViewReady() {
		super.onViewReady();

		window = new Window();
		window.setWidth(getWindowPixelWidth(), Unit.PIXELS);
		window.setModal(isModal());
		window.setContent(this);

		UI.getCurrent().addWindow(window);
	}

	protected abstract int getWindowPixelWidth();

	protected abstract boolean isModal();

	public void close() {
		window.close();
	}
}
