package pl.adam.pko.presenter.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import pl.adam.pko.App
import pl.adam.pko.view.view.MvpView
import kotlin.coroutines.CoroutineContext

abstract class BasePresenter<T : MvpView> : Presenter<T>, CoroutineScope, DIAware {

    override val di: DI by closestDI(App.instance)

    private val job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    private var _view: T? = null
    protected val view: T
        get() = _view ?: throw KotlinNullPointerException("View is null")

    override fun attachView(view: T) {
        _view = view
    }

    override fun detachView() {
        _view = null
    }
}