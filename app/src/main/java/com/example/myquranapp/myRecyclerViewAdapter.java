package com.example.myquranapp;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH>{
    ArrayList<String> surahList;
    private View.OnClickListener onItemClickListener;
    public myRecyclerViewAdapter(ArrayList<String> surahList) {
        this.surahList = surahList;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.surahview, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data = surahList.get(position);
        holder.ayatView.setText(holder.data);
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    //TODO: Step 2 of 4: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        onItemClickListener = itemClickListener;
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView ayatView;
        String data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            ayatView=itemView.findViewById(R.id.ayatTextView);
            Typeface typeface = ResourcesCompat.getFont(ayatView.getContext(), R.font.noorehuda);
            ayatView.setTypeface(typeface);


            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);

        }
    }
}
