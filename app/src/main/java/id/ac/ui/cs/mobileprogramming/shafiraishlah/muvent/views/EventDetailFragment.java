package id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.R;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.adapters.ShopListAdapter;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.databinding.FragmentEventDetailBinding;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.viewmodels.ShopViewModel;

public class EventDetailFragment extends Fragment {

    FragmentEventDetailBinding fragmentEventDetailBinding;
    ShopViewModel shopViewModel;
    public EventDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentEventDetailBinding = FragmentEventDetailBinding.inflate(inflater, container, false);
        return fragmentEventDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentEventDetailBinding.setShopViewModel(shopViewModel);
    }
}