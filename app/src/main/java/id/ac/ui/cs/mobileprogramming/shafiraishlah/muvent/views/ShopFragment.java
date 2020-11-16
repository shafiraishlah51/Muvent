package id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


import java.util.List;
import android.util.Log;

import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.R;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.adapters.ShopListAdapter;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.databinding.FragmentShopBinding;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.models.Event;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.viewmodels.ShopViewModel;

public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

    private static final String TAG = "ShopFragment";
    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;
    private NavController navController;
    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding= FragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopListAdapter = new ShopListAdapter(this);
        fragmentShopBinding.shopRecyclerView.setAdapter(shopListAdapter);
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getEvents().observe(getViewLifecycleOwner(), new Observer<List<Event>>() {

            @Override
            public void onChanged(List<Event> events) {
                shopListAdapter.submitList(events);
            }
        });
        navController = Navigation.findNavController(view);
    }

    @Override
    public void addItem(Event event) {
        boolean isAdded = shopViewModel.addItemToCart(event);
        if (isAdded) {
            Snackbar.make(requireView(), event.getName() + " added to cart.", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
                        }
                    })
                    .show();
        } else {
            Snackbar.make(requireView(), "Already have the max quantity in cart.", Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemClick(Event event) {
        shopViewModel.setEvent(event);
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);
    }
}