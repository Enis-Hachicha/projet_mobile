package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DonutAdapter extends ArrayAdapter<Donut> {
    List<Donut> donutList;
    Context context;
    public DonutAdapter(@NonNull Context context, List<Donut> resource) {
        super(context, R.layout.single_profile_view, resource);
        donutList= resource;
        this.context = context;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(context).inflate(R.layout.single_profile_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Donut donut= getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView prenom = currentItemView.findViewById(R.id.nameT);
        prenom.setText(donut.getNAME());
        TextView label = currentItemView.findViewById(R.id.nameTT);
        label.setText("Donut Name: ");

        TextView nom = currentItemView.findViewById(R.id.familyNameT);
        nom.setText(donut.getFAMILYNAME());
        TextView labelnom = currentItemView.findViewById(R.id.familyNameTT);
        labelnom.setText("Filler Name: ");

        TextView email = currentItemView.findViewById(R.id.emailT);
        email.setText(donut.getEmail());
        TextView labelemail = currentItemView.findViewById(R.id.emailTT);
        labelemail.setText("Sprinkles: ");

        TextView phone = currentItemView.findViewById(R.id.phoneT);
        phone.setText(donut.getPhone());
        TextView labelphone = currentItemView.findViewById(R.id.phoneTT);
        labelphone.setText("Price: ");

        // then return the recyclable view
        return currentItemView;
    }
}
