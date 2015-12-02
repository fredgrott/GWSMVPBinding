package com.github.shareme.gwsmvpbinding.library;

import android.database.Observable;
import android.support.annotation.CallSuper;

/**
 * BaseBindingPresenter, the way this works is a NameViewDataBinding as just a final class contains
 * the a set method that refers to a view.setMethod which of course has the the BindingAdapter
 * annotation.  I than create a ScreenView that extends relativelayout to get the correct lifecycle events
 * and presenter, screenviewbinding, and viewmodel are injected and setup is implemented in that
 * class.
 * Created by fgrott on 12/2/2015.
 */
@SuppressWarnings("unused")
public abstract class BaseBindingPresenter<VM extends Observable> {

    private VM viewModel;

    @CallSuper
    public final void attach(VM viewModel) {
        if (this.viewModel == null) {
            this.viewModel = viewModel;
        }
        resume();
    }

    @CallSuper
    public final void detach() {
        this.viewModel = null;
        pause();
    }

    protected final boolean hasViewModel(){
        return viewModel != null;
    }

    public final VM getViewModel() {
        return viewModel;
    }

    private void resume(){

    }

    private void pause(){

    }

    protected abstract void load();

    protected void unload(){

    }



}
