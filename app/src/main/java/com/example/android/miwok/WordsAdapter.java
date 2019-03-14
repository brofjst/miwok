package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter<Words> {
    private int mColorId;

    public WordsAdapter(@NonNull Context context, ArrayList<Words> list, int colorId) {
        super(context, 0, list);
        mColorId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if (listView == null)
            listView = LayoutInflater.from(getContext()).inflate(R.layout.my_layout, parent, false); //occhio al layout

        Words currentWord = getItem(position);

        TextView miwokString = (TextView) listView.findViewById(R.id.miwok_text_view);
        miwokString.setText(currentWord.getMiwokTranslation());

        TextView stdString = (TextView) listView.findViewById(R.id.standard_text_view);
        stdString.setText(currentWord.getDefaultTranslation());

        ImageView iconView = (ImageView) listView.findViewById(R.id.iconField);
        if (currentWord.hasImage()) {
            iconView.setImageResource(currentWord.getImageID());
        } else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorId);
        textContainer.setBackgroundColor(color);

        return listView;
    }
}
