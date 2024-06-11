package dev.amitb.common;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class CommonAdapter extends BaseAdapter {

    private Context context;
    private List<ItemToStore> data;
    private LayoutInflater inflater;
    private int selectedPosition = -1;

    public CommonAdapter(Context context, List<ItemToStore> data) {
        this.context = context;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }

        MaterialTextView title = rowView.findViewById(R.id.TXT_title);
        title.setText(data.get(position).getTitle());
        MaterialTextView description = rowView.findViewById(R.id.TXT_description);
        description.setText(data.get(position).getDescription());
        MaterialTextView date = rowView.findViewById(R.id.TXT_when);
        date.setText(data.get(position).getDate());

        if (position == selectedPosition) {
            rowView.setBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_light));
        }else {
            rowView.setBackgroundColor(context.getResources().getColor(R.color.ivory_white));
        }

        return rowView;
    }

    public void setSelectedPosition(int position) {
        this.selectedPosition = position;
        notifyDataSetChanged();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void removeSelectedItem() {
        if (selectedPosition >= 0 && selectedPosition < data.size()) {
            data.remove(selectedPosition);
            selectedPosition = -1; // Reset selection
            notifyDataSetChanged();
        }
    }

    public void addItem(ItemToStore item) {
        data.add(item);
        notifyDataSetChanged();
    }
}
