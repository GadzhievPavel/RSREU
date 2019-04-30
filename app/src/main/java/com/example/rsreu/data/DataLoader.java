package com.example.rsreu.data;

import android.content.Context;
import android.util.Log;

import com.example.rsreu.data.json_parser.api.API;
import com.example.rsreu.data.json_parser.api.source.subsource.Settings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataLoader {
    private API api;
    //private ConnectorLocalDB connectorLocalDB;
    private Context context;
    public DataLoader(API api){
        this.api=api;
       // this.context=context;
    }
    public Settings loadSettings() {
        final Settings[] getSettings = new Settings[1];
        Call<Settings> settingsCall = api.getSettings();
        settingsCall.enqueue(new Callback<Settings>() {
            @Override
            public void onResponse(Call<Settings> call, Response<Settings> response) {
                if (response.isSuccessful()) {
                    Settings settings = response.body();
                    getSettings[0] =settings;
                    Log.e("SETTINGS", "RESP OK");
                }
            }

            @Override
            public void onFailure(Call<Settings> call, Throwable t) {
                Log.e("Fail", t.getLocalizedMessage());
            }
        });
        return getSettings[0];
    }
//    public void loadGroup(final String groupNum) {
//        Call<GroupTime> groupTimeCall = api.getGroup(groupNum);
//        groupTimeCall.enqueue(new Callback<GroupTime>() {
//            @Override
//            public void onResponse(Call<GroupTime> call, Response<GroupTime> response) {
//                GroupTime group = response.body();
//                for (int i = 0; i < group.getDenominators().size(); i++) {
//                    connectorLocalDB.insert(group.getDenominators().get(i),groupNum);
//                    Log.e("GROUP", "RESP OK");
//                }
//                for (int i = 0; i < group.getNumerators().size(); i++) {
//                    connectorLocalDB.insert(group.getNumerators().get(i), groupNum);
//                    Log.e("GROUP", "RESP OK");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GroupTime> call, Throwable t) {
//                Log.e("Fail", t.getLocalizedMessage());
//            }
//        });
//    }
//    public void loadTimes() {
//        Call<TimeList> listCall = api.getTimeList();
//        listCall.enqueue(new Callback<TimeList>() {
//            @Override
//            public void onResponse(Call<TimeList> call, Response<TimeList> response) {
//                TimeList timeList = response.body();
//                for (int i = 0; i < timeList.getTimes().size(); i++) {
//                    connectorLocalDB.insert(timeList.getTimes().get(i));
//                    Log.e("TIME", "RESP OK");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TimeList> call, Throwable t) {
//                Log.e("Fail", t.getLocalizedMessage());
//            }
//        });
  //  }
    }

