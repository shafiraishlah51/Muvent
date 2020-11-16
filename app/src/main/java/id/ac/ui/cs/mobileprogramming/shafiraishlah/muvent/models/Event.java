package id.ac.ui.cs.mobileprogramming.shafiraishlah.muvent.models;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;

import java.lang.reflect.Constructor;
import java.util.Objects;

public class Event {
    private String id;
    private String name;
    private double price;
    private boolean isAvailable;
    private String imageUrl;

    public Event(String id, String name, double price, boolean isAvailable, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.getPrice(), getPrice()) == 0 &&
                isAvailable() == event.isAvailable() &&
                getId().equals(event.getId()) &&
                getName().equals(event.getName()) &&
                getImageUrl().equals(event.getImageUrl());
    }

    public static DiffUtil.ItemCallback<Event> itemCallback = new DiffUtil.ItemCallback<Event>() {
        @Override
        public boolean areItemsTheSame(@NonNull Event oldItem, @NonNull Event newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Event oldItem, @NonNull Event newItem) {
            return oldItem.equals(newItem);
        }
    };

    @BindingAdapter("android:productImage")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView).load(imageUrl).fitCenter().into(imageView);
    }
}

