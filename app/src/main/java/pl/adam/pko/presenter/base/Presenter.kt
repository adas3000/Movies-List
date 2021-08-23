package pl.adam.pko.presenter.base

import pl.adam.pko.view.view.MvpView

interface Presenter<T : MvpView> {
    fun attachView(view: T)
    fun detachView()
}