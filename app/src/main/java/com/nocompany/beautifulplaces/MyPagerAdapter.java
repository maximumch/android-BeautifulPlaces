package com.nocompany.beautifulplaces;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<Place> places;

    public MyPagerAdapter(List<Place> places) {
        this.places = places;
    }

    // Вызывается пейджером если есть необходимость уничтожить view
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    // Создание view адаптером для педжера из элемента контейнера
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        Context context = collection.getContext();
        View layout = LayoutInflater.from(context)
                .inflate(R.layout.page, collection,false);

        Place p = places.get(position);
        String pictureUrl = p.getPicture();
        ImageView picture = (ImageView) layout.findViewById(R.id.picture);
        TextView place = (TextView) layout.findViewById(R.id.place);
        TextView description = (TextView) layout.findViewById(R.id.description);
        TextView priceold = (TextView) layout.findViewById(R.id.priceold);
        TextView pricenew = (TextView) layout.findViewById(R.id.pricenew);
        place.setText(p.getPlace());
        description.setText(p.getDescription());
        priceold.setText(p.getOldPrice());
        pricenew.setText(p.getNewPrice());

        // С помощью Picasso
        Picasso
                .with(context) // Используя Context
                .load(pictureUrl) // Загружаем картинку по URL
                .fit() // Автоматически определяем размеры ImageView
                .centerCrop() // Масштабируем картинку
                .into(picture); // в ImageView


        // Возвращаем "надутый" и настроенный view
        collection.addView(layout);
        return layout;
    }

    // Сколько всего элементов в контейнере
    @Override
    public int getCount() {

        return places.size();
    }

    // Чтобы определить, нет ли уже такого view
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
