package cn.ryando.sina;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.Binds;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

public class MainActivity extends AppCompatActivity {

    @dagger.Subcomponent
    interface Component extends AndroidInjector<MainActivity>{
        @dagger.Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
    }

    @dagger.Module(subcomponents = Component.class)
    abstract class Module{
        @Binds @IntoMap @ActivityKey(MainActivity.class)
        abstract AndroidInjector.Factory<? extends Activity> bind(Component.Builder builder);
    }

    @Inject
    SimpleApplication app;

    @Inject @Model String model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.test_tv);
        tv.setText(model + "\n" + app.toString());
    }
}
