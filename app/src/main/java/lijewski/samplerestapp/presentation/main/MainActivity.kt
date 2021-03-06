package lijewski.samplerestapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import lijewski.samplerestapp.R
import lijewski.samplerestapp.presentation.main.dashboard.DashboardFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            val fragment = DashboardFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, DashboardFragment.TAG).commit()
        }
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
