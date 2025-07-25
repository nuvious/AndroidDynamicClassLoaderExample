package club.cheeseman.dynamicclassload.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import club.cheeseman.dynamicclassload.MainActivity;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setText(String value) {
        mText.setValue(value);
    }
}