package com.example.pas_05_10rpl1;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    List<String> data1;
    List<String> data2;
    List<Integer> images;
    Context context;

    public Adapter(Context ct,String s1[], String s2[], Integer img[]) {
        context = ct;
        data1 = new ArrayList<>();
        Collections.addAll(data1, s1);
        data2 = new ArrayList<>();
        Collections.addAll(data2, s2);
         images = new ArrayList<>();
        Collections.addAll(images, img);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.myText1.setText(data1.get(position));
        holder.myText2.setText(data2.get(position));
        holder.myimage.setImageResource(images.get(position));




    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener
    {

        TextView myText1, myText2;
        ImageView myimage;
        ConstraintLayout mainLayout;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myimage = itemView.findViewById(R.id.myimage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            cardView = itemView.findViewById(R.id.mCardView);
            cardView.setOnCreateContextMenuListener(this);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra("data1", data1.get(getAdapterPosition()));
                    intent.putExtra("data2", data2.get(getAdapterPosition()));
                    intent.putExtra("myimage", images.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(Menu.NONE,1, 1 , "Delete").setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            data1.remove(getAdapterPosition());
            data2.remove(getAdapterPosition());
            images.remove(getAdapterPosition());
            notifyDataSetChanged();
            return false;
        }
    }
}
