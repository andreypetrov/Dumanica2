package com.petrovdevelopment.dumanica.dumanica.adapters;

/**
 * Created by andrey on 2014-09-30.
 */
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.petrovdevelopment.dumanica.dumanica.R;

public class MainMenuAdapter extends AbstractAdapter<String> {

    public MainMenuAdapter(List<String> data, Context context) {
        super(data, context);
    }

    @Override
    public void update(View view, int position, Object holder) {
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(getItem(position));
    }

    @Override
    public int getCellResourceId() {
        return R.layout.cell_main_menu;
    }

    @Override
    public Object createHolder(View view) {
        return null;
    }

}
