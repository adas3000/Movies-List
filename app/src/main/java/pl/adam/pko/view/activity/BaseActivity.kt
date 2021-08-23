package pl.adam.pko.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import pl.adam.pko.presenter.base.Presenter
import pl.adam.pko.view.view.MvpView

abstract class BaseActivity<T : MvpView> : AppCompatActivity(), DIAware {

    override val di: DI by closestDI()

    abstract val presenter: Presenter<T>

    abstract fun getLayoutRes(): Int

    abstract fun setupView()

    abstract fun getMvpView(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        setupView()
        presenter.attachView(getMvpView())
    }

}