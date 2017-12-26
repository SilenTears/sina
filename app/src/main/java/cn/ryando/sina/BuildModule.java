package cn.ryando.sina;

import dagger.Module;
import dagger.Provides;

import static android.os.Build.MODEL;

@Module
@Model
final class BuildModule {
    @Provides
    @Model
    static String provideModel() {
        return MODEL;
    }
}