package com.example.rsreu.util;



import android.util.Log;

import com.example.rsreu.data.Answer;
import com.example.rsreu.data.json_parser.api.source.subsource.Denominator;
import com.example.rsreu.data.json_parser.api.source.subsource.Numerator;
import com.example.rsreu.data.json_parser.api.source.subsource.Settings;
import com.example.rsreu.data.json_parser.api.source.subsource.Times;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerMaker {
    private ArrayList<Settings> settings;
    private ArrayList<Times> times;

    public AnswerMaker(ArrayList<Settings> settings, ArrayList<Times> times){
        this.settings=settings;
        this.times=times;
    }
    private String getStartTime( int timeId){
        //Log.e("getStartTime", String.valueOf(timeId--));
        timeId--;
        return times.get(timeId).getFrom();

    }
    private String getEndTime(int timeId, int duration){
        String s;
        int i=timeId-1;
        if(duration==4){
            s=times.get(timeId).getTo();
        }
        if(duration==8){
            s="17:00";
        }
        else
            s=times.get(i).getTo();
        return s;
    }
    public Map<Integer,ArrayList<ArrayList<Answer>>> getAnswers(ArrayList<ArrayList<Numerator>> listNumerator,
                                                     ArrayList<ArrayList<Denominator>> listDenominator){

        Map<Integer,ArrayList<ArrayList<Answer>>> arrayLists=new HashMap<Integer, ArrayList<ArrayList<Answer>>>();
        ArrayList<ArrayList<Answer>> weekDaysN =new ArrayList<>();
        for (int i=0;i<listNumerator.size();i++){
            ArrayList<Answer> day=new ArrayList<>();
            for (int j=0;j<listNumerator.get(i).size();j++){
                Answer answer=new Answer();
                answer.setFromTime(getStartTime(listNumerator.get(i).get(j).getTimeId()));
                answer.setToTime(getEndTime(listNumerator.get(i).get(j).getTimeId(),listNumerator.get(i).get(j).getDuration()));
                answer.setBuild(listNumerator.get(i).get(j).getBuild());
                answer.setRoom(listNumerator.get(i).get(j).getRoom());
                answer.setTeacher(listNumerator.get(i).get(j).getTeachers());
                answer.setTitle(listNumerator.get(i).get(j).getTitle());
                answer.setWeekDay(listNumerator.get(i).get(j).getWeekDay());
                day.add(answer);
            }
            weekDaysN.add(day);
        }
        arrayLists.put(0,weekDaysN);
        ArrayList<ArrayList<Answer>> weekDaysD =new ArrayList<>();
        for (int i=0;i<listDenominator.size();i++){
            ArrayList<Answer> day=new ArrayList<>();
            for (int j=0;j<listDenominator.get(i).size();j++){
                Answer answer=new Answer();
                answer.setFromTime(getStartTime(listDenominator.get(i).get(j).getTimeId()));
                answer.setToTime(getEndTime(listDenominator.get(i).get(j).getTimeId(),listDenominator.get(i).get(j).getDuration()));
                answer.setBuild(listDenominator.get(i).get(j).getBuild());
                answer.setRoom(listDenominator.get(i).get(j).getRoom());
                answer.setTeacher(listDenominator.get(i).get(j).getTeachers());
                answer.setTitle(listDenominator.get(i).get(j).getTitle());
                answer.setWeekDay(listDenominator.get(i).get(j).getWeekDay());
                day.add(answer);
            }
            weekDaysD.add(day);
        }
        arrayLists.put(1,weekDaysD);
        return arrayLists;
    }
    public ArrayList<Answer> getAnswersN(List<Numerator> numerators){
        ArrayList<Answer> answers=new ArrayList<>();
        for (int i=0;i<numerators.size();i++){
            Answer answer= new Answer();
            answer.setFromTime(getStartTime(numerators.get(i).getTimeId()));
            answer.setToTime(getEndTime(numerators.get(i).getTimeId(),numerators.get(i).getDuration()));
            answer.setTitle(numerators.get(i).getTitle());
            answer.setRoom(numerators.get(i).getRoom());
            answer.setTeacher(numerators.get(i).getTeachers());
            answer.setBuild(numerators.get(i).getBuild());
            answers.add(answer);
        }
        return answers;
    }
    public List<Answer> getAnswersD(List<Denominator> denominators){
        ArrayList<Answer> answers=new ArrayList<>();
        for (int i=0;i<denominators.size();i++){
            answers.get(i).setFromTime(getStartTime(denominators.get(i).getTimeId()));
            answers.get(i).setToTime(getEndTime(denominators.get(i).getTimeId(),denominators.get(i).getDuration()));
            answers.get(i).setBuild(denominators.get(i).getBuild());
            answers.get(i).setRoom(denominators.get(i).getRoom());
            answers.get(i).setTeacher(denominators.get(i).getTeachers());
            answers.get(i).setTitle(denominators.get(i).getTitle());
        }
        return answers;
    }
}
