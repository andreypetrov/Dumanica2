package com.petrovdevelopment.dumanica.dumanica.adapters;

/**
 * Created by andrey on 2014-09-30.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AbstractAdapter<Data> extends BaseAdapter {
    List<Data> data;
    Context context;

    public AbstractAdapter(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Data getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) convertView = createNewCell(parent);

        update(convertView, position, convertView.getTag());
        return convertView;
    }

    private View createNewCell(ViewGroup parent) {
        View newCell = LayoutInflater.from(context).inflate(getCellResourceId(), parent, false);
        newCell.setTag(createHolder(newCell));
        return newCell;
    }


    public abstract void update(View view, int position, Object holder);

    public abstract int getCellResourceId();

    /**
     * To be implemented only in views with more than ten cells, to improve performance.
     * The object returned by this method can be used within the update method
     *
     * @param view
     * @return
     */
    public abstract Object createHolder(View view);

}
