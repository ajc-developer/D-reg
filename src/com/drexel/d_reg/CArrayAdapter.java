package com.drexel.d_reg;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CArrayAdapter extends BaseAdapter {

  private ArrayList<Class> listData;

  private LayoutInflater layoutInflater;

  public CArrayAdapter(Context context, ArrayList<Class> listData) {
    this.listData = listData;
    layoutInflater = LayoutInflater.from(context);
  }

  public void setListData(ArrayList<Class> data){
    listData = data;
  }

  @Override
  public int getCount() {
    return listData.size();
  }


  @Override
  public Object getItem(int position) {
    return listData.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
        convertView = layoutInflater.inflate(R.layout.class_view, null);
        holder = new ViewHolder();
        holder.crn = (TextView) convertView.findViewById(R.id.crn);
        holder.name = (TextView) convertView.findViewById(R.id.className);
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.crn.setText(listData.get(position).getCrn().toString());
    holder.name.setText(listData.get(position).getNickName().toString());

    return convertView;
}

  static class ViewHolder {
    TextView crn;
    TextView name;
  }
}