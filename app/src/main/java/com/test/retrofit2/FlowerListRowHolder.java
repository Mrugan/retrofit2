package com.test.retrofit2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by spm3 on 9/22/2015.
 */
public class FlowerListRowHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView title;

    public FlowerListRowHolder(View view) {
        super(view);
        this.thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        this.title = (TextView) view.findViewById(R.id.title);
    }

}
