package com.example.rsreu;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rsreu.data.Answer;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private ArrayList<Answer> mData;
    private ItemClickListener mClickListener;

    public RecycleViewAdapter(ArrayList<Answer> data) {
        this.mData = data;
        Log.e("REC","COMPL");
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_time_line,null);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(mData.get(i).getTitle());
        viewHolder.room.setText(mData.get(i).getRoom());
        viewHolder.timeFrom.setText(mData.get(i).getFromTime());
        viewHolder.timeTo.setText(mData.get(i).getToTime());
        Log.e("ViSIB",mData.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView timeFrom;
        TextView timeTo;
        TextView room;

        ViewHolder(View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.title);
            timeFrom=itemView.findViewById(R.id.timeFrom);
            timeTo=itemView.findViewById(R.id.timeTo);
            room=itemView.findViewById(R.id.room);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    String getItem(int id) {
        return mData.get(id).getBuild();
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
