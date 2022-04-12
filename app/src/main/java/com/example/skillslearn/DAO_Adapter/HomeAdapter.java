package com.example.skillslearn.DAO_Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.skillslearn.R;
import com.example.skillslearn.chaptertopic.TopicActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.myviewholder>{

    List<Category> Data;
    public HomeAdapter(List<Category> data) {
        Data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_card,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.category.setText(Data.get(position).getName());
        holder.card.setId(Integer.parseInt(Data.get(position).getId()));
        Glide.with(holder.category.getContext()).load("https://android-database-api.000webhostapp.com/image/"+Data.get(position).getImage()).into(holder.image);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TopicActivity.class);
                intent.putExtra("chapterName",Data.get(position).getName());
                intent.putExtra("url","https://android-database-api.000webhostapp.com/image/"+Data.get(position).getImage());
                v.getContext().startActivity(intent);
//                    switch (v.getId()) {
//
//                        case 1:
//                            intent.putExtra("chapterName", );
//                            v.getContext().startActivity(intent);
//                            break;
//                        case 2:
//                            intent.putExtra("chapterName", "heading2");
//                            v.getContext().startActivity(intent);
//                            break;
//                        case 3:
//                            intent.putExtra("chapterName", "heading3");
//                            v.getContext().startActivity(intent);
//                            break;
//                        case 4:
//                            intent.putExtra("chapterName", "heading4");
//                            v.getContext().startActivity(intent);
//                            break;
//                        case 5:
//                            intent.putExtra("chapterName", "heading5");
//                            v.getContext().startActivity(intent);
//                            break;
//                        default:
//                            throw new IllegalStateException("Unexpected value: " + v.getId());
//                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView category;
        CardView card;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            category = itemView.findViewById(R.id.category);
            card = itemView.findViewById(R.id.card);


        }
    }


}
