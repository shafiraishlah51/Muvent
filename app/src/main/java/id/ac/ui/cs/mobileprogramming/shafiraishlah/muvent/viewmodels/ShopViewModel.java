package id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.viewmodels;

import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.models.CartItem;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.models.Event;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.repositories.CartRepo;
import id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.repositories.ShopRepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class ShopViewModel extends ViewModel {
    CartRepo cartRepo = new CartRepo();
    ShopRepo shopRepo = new ShopRepo();

    MutableLiveData<Event> mutableEvent = new MutableLiveData<>();

    public LiveData<List<Event>> getEvents() {
        return shopRepo.getEvents();
    }

    public void setEvent(Event event) {
        mutableEvent.setValue(event);
    }

    public LiveData<Event> getEvent() {
        return mutableEvent;
    }

    public boolean addItemToCart(Event event) {
        return cartRepo.addItemToCart(event);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }
}


