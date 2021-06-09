package com.example.edukit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CatGridAdapter extends BaseAdapter {
    private List<CategoryModel> catList;

    public CatGridAdapter(List<CategoryModel> catList) {
        this.catList = catList;
    }

    @Override
    public int getCount() {
        return catList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1;
        if (view == null){
            view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cat_item_layout,viewGroup,false);
        }
        else {
            view1 = view;
        }

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SplashActivity.selected_cat_index = i;
                Intent intent = new Intent(viewGroup.getContext(),SetsActivity.class);
                viewGroup.getContext().startActivity(intent);
            }
        });

        ((TextView) view1.findViewById(R.id.catName)).setText(catList.get(i).getName());
        return view1;
    }
}
