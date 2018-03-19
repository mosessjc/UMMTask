package com.ummtask.moses.constants;

import com.ummtask.moses.R;
import com.ummtask.moses.model.Model;

import java.util.ArrayList;

/**
 * Created by Moses on 18-03-2018.
 */

public class Data {
    public static ArrayList<Model> trendindData() {
        ArrayList<Model> trending = new ArrayList<>();
        trending.add(new Model(1, "Fenny's Lounge And Kitchen", "Koramangala, Bangalore", "Open", R.drawable.ione, 3, 0, R.drawable.lone, "10 m", "Book for 10 and get the 11th buffet absolutely free"));
        trending.add(new Model(2, "Magan Apulia", "Bhanasankari, Bangalore", "Closed", R.drawable.tone, 4, 1, R.drawable.ltwo, "20 m", "15% off on Rs.200 & Above"));
        trending.add(new Model(3, "Tamburan", "Electronic city, Bangalore", "Open", R.drawable.tthree, 1, 0, R.drawable.lthree, "30 m", "25% offer for all sea foods"));
        trending.add(new Model(4, "Barbeque Nation", "Marathahalli, Bangalore", "Open", R.drawable.tfour, 5, 1, R.drawable.lfour, "40 m", "Early birds offer for early customers"));
        trending.add(new Model(5, "Leroi Oven", "HSR Layout, Bangalore", "Open", R.drawable.tfive, 4, 1, R.drawable.lfive, "50 m", "Complimentary selected soup"));
        trending.add(new Model(6, "Deer Meat", "BTM Nagar, Bangalore", "Open", R.drawable.tsix, 0, 0, R.drawable.lthree, "60 m", "Buy 2 plate Haryali and get 3rd plate free"));
        trending.add(new Model(7, "Almazan Kitchen", "Jaya Nagar, Bangalore", "Open", R.drawable.tseven, 0, 1, R.drawable.lfive, "70 m", "Mutton steak free for first 20 customers"));
        trending.add(new Model(8, "Country Food", "Madiwala, Bangalore", "Open", R.drawable.teight, 3, 1, R.drawable.lsix, "80 m", "Compo offers"));
        return trending;
    }

    public static ArrayList<Model> othersData() {
        ArrayList<Model> others = new ArrayList<>();
        others.add(new Model(1, "Snow Fall Park", "Marathahalli, Bangalore", "Open", R.drawable.snow, 3, 0, R.drawable.lsnowman, "10 m", "10% offer for bulk ticket booking"));
        others.add(new Model(2, "Wonderla", "Koramangala, Bangalore", "Closed", R.drawable.wonderla, 4, 1, R.drawable.lwonderla, "20 m", "Early birds offer"));
        others.add(new Model(3, "Phoenix Mall", "HSR Layout, Bangalore", "Open", R.drawable.mall, 1, 0, R.drawable.lpheonix, "30 m", "Prizes for competiton participants"));
        return others;
    }
}
