package cn.ryando.sina;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by zhongkun on 2017/12/26.
 */
public class SimpleApplication extends DaggerApplication {

    private static final String TAG = SimpleApplication.class.getSimpleName();
    public static SimpleApplication app;

    @dagger.Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildModule.class, MainActivity.Module.class})
    public interface Component extends AndroidInjector<SimpleApplication> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<SimpleApplication> {
        }
    }

    @Module @Singleton
    public static class AppModule {
        @Provides
        @Singleton
        Context provideApp(SimpleApplication app) {
            return app;
        }

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerSimpleApplication_Component.builder().create(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
