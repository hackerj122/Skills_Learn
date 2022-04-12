package com.example.skillslearn.chaptertopic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.skillslearn.R;

public class TopicAdapter extends BaseAdapter {

    String topicname[];
    Context context;

    public TopicAdapter(String[] topicname, Context context) {
        this.topicname = topicname;
        this.context = context;
    }

    @Override
    public int getCount() {
        return topicname.length;
    }

    @Override
    public Object getItem(int position) {
        return topicname[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        LayoutInflater inflater;

        if (convertView==null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.topic_item_layout,null);
        }

        TextView textView = gridView.findViewById(R.id.topic_text);
        textView.setText(topicname[position]);
        return gridView;
    }
}
