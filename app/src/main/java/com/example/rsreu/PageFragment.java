package com.example.rsreu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rsreu.data.Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PageFragment extends Fragment {
    static final String TAG = "myLogs";

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String SAVE_PAGE_NUMBER = "save_page_number";
    static ArrayList<ArrayList<Answer>> week = new ArrayList<>();
    int pageNumber;


    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);

        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        Log.d(TAG, "onCreate: " + pageNumber);

        int savedPageNumber = -1;
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
        Log.d(TAG, "savedPageNumber = " + savedPageNumber);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // RecycleViewAdapter adaptersMon= new RecycleViewAdapter(week.get(0));
        RecycleViewAdapter[] adapters= new RecycleViewAdapter[5];

        Log.e("PAGE", String.valueOf(adapters.length));
        for (int i=0;i<adapters.length;i++){
            Log.e("IN FOR", String.valueOf(week.get(i).get(0).getWeekDay()));
            if((week.get(i).get(0).getWeekDay()-1)==i){
                RecycleViewAdapter viewAdapter=new RecycleViewAdapter(week.get(i));
                adapters[i]= viewAdapter;
                Log.e("IN IF","USE GOOD");
                Log.e("IS NOT NULL", String.valueOf(adapters[i]==null));
            }
            else{
                adapters[i]=null;
            }
        }
        View view = inflater.inflate(R.layout.fragment, container,false);
        Map<Integer,RecyclerView> map = new HashMap<>();
        RecyclerView monday=(RecyclerView)view.findViewById(R.id.rec);
        RecyclerView vtornik=(RecyclerView)view.findViewById(R.id.rec1);
        RecyclerView wen=(RecyclerView)view.findViewById(R.id.rec2);
        RecyclerView th=(RecyclerView)view.findViewById(R.id.rec3);
        RecyclerView fri=(RecyclerView)view.findViewById(R.id.rec4);
        RecyclerView sut=(RecyclerView)view.findViewById(R.id.rec5);
//        monday.setLayoutManager(new LinearLayoutManager(getActivity()));
//        monday.setAdapter(adaptersMon);
        map.put(0,monday);
        map.put(1,vtornik);
        map.put(2,wen);
        map.put(3,th);
        map.put(4,fri);
        map.put(5,sut);

        for (int i=0;i<adapters.length;i++){
            map.get(i).setLayoutManager(new LinearLayoutManager(getActivity()));
            map.get(i).setAdapter(adapters[i]);

        }
//        monday.setLayoutManager(new LinearLayoutManager(getActivity()));
//        vtornik.setLayoutManager(new LinearLayoutManager(getActivity()));
//        wen.setLayoutManager(new LinearLayoutManager(getActivity()));
//        th.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recycleViewAdapter=new RecycleViewAdapter(subjectNames);
//        string.add("fdsd");
//        string.add("][[][]");
//        recAdapter=new RecycleViewAdapter(string);
//        monday.setAdapter(recycleViewAdapter);
//        vtornik.setAdapter(recAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + pageNumber);
    }
}
