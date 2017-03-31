package net.duclad.vaadin.mvp;

import com.vaadin.ui.UI;
import net.duclad.vaadin.mvp.view.AbstractPresenter;
import net.duclad.vaadin.mvp.view.ApplicationView;

/**
 * Created by ClaudiuDumitrescu on 3/31/2017.
 */
public abstract class MvpUI extends UI{

    public abstract <T extends AbstractPresenter> ApplicationView<T> getDefaultView();

}
