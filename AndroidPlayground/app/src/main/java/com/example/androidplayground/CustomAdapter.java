package com.example.androidplayground;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private List<Contact> dataSet;
    private Context context;

    public CustomAdapter(@NonNull Context context, List<Contact> dataSet) {
        super(context, R.layout.custom_item_layout, dataSet);
        this.dataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_item_layout, parent, false);

        ImageView contactImage = row.findViewById(R.id.imageView);
        TextView contactName = row.findViewById(R.id.contactName);
        TextView message = row.findViewById(R.id.message);

        contactImage.setImageResource(dataSet.get(position).getProfileImage());
        contactName.setText(dataSet.get(position).getName());
        message.setText(dataSet.get(position).getMessage());
        return row;
    }
}
