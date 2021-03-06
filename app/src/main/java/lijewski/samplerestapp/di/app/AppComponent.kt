package lijewski.samplerestapp.di.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import lijewski.samplerestapp.SampleRestApp
import lijewski.samplerestapp.di.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        BuilderModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        RxModule::class
    ]
)
interface AppComponent : AndroidInjector<SampleRestApp> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<SampleRestApp>
}
