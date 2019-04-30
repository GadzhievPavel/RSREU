package com.example.rsreu;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.rsreu.data.Answer;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Answer> answers;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, ArrayList<Answer> answers) {
        this.mInflater = LayoutInflater.from(context);
        this.answers=answers;
    }
    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_time_line, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.timeTo.setText(answers.get(position).getToTime());
        holder.SubjectName.setText(answers.get(position).getTitle());
        holder.timeFrom.setText(answers.get(position).getFromTime());
        holder.room.setText(answers.get(position).getRoom());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return answers.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView timeTo;
        TextView SubjectName;
        TextView timeFrom;
        TextView room;

        ViewHolder(View itemView) {
            super(itemView);
            timeFrom = itemView.findViewById(R.id.timeFrom);
            SubjectName = itemView.findViewById(R.id.title);
            timeTo = itemView.findViewById(R.id.timeTo);
            room =itemView.findViewById(R.id.room);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return answers.get(id).getTeacher();
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
