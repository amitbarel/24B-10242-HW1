package dev.amitb.a24b_10242_hw1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

import dev.amitb.common.ItemToStore;

public class TaskAdapter extends BaseAdapter {

    private Context context;
    private List<ItemToStore> data;
    private LayoutInflater inflater;
    private int selectedPosition = -1;



    public TaskAdapter(Context context, List<ItemToStore> data) {
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
        ItemToStore task = data.get(position);
        title.setText(task.getTitle());
        MaterialTextView date = rowView.findViewById(R.id.TXT_when);
        date.setText(task.getDescription());

        if (position == selectedPosition) {
            rowView.setBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_light));
        }else {
            rowView.setBackgroundColor(context.getResources().getColor(R.color.gainsboro_white));
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
