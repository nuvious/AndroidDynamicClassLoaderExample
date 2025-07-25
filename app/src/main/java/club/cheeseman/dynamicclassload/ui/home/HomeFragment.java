package club.cheeseman.dynamicclassload.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

import club.cheeseman.dynamicclassload.R;
import club.cheeseman.dynamicclassload.databinding.FragmentHomeBinding;
import dalvik.system.InMemoryDexClassLoader;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        InputStream classesDexIS = getContext().getResources().openRawResource(R.raw.classes);
        String ret = null;
        try {
            InMemoryDexClassLoader loader = new InMemoryDexClassLoader(ByteBuffer.wrap(classesDexIS.readAllBytes()), null);
            Class testClass = loader.loadClass("Hello");
            Method method = testClass.getMethod("hi");
            method.setAccessible(true);
            homeViewModel.setText((String) method.invoke(testClass.newInstance()));
        } catch (IOException | ClassNotFoundException | NoSuchMethodException |
                 IllegalAccessException | java.lang.InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return root;
    }

    public void onStartView(){


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}