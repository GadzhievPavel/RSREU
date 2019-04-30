package com.example.rsreu;



import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.rsreu.data.Answer;

import java.util.ArrayList;
import java.util.Random;

@SuppressLint("ValidFragment")
public class PageFragment extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private ArrayList<Answer> answers;

    int pageNumber;
    int backColor;
    private Context context;

    public PageFragment(Context context, ArrayList<Answer> answers){
        this.answers=answers;
        this.context=context;
    }
    static PageFragment newInstance(int page, Context context,ArrayList<Answer> answers) {
        PageFragment pageFragment = new PageFragment(context,answers);
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyRecyclerViewAdapter adapter;
        View view = inflater.inflate(R.layout.fragment, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new MyRecyclerViewAdapter(context,answers);
        //adapter.setClickListener(context);
        recyclerView.setAdapter(adapter);
        return view;
    }
}