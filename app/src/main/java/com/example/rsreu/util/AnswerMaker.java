package com.example.rsreu.util;



import com.example.rsreu.data.Answer;
import com.example.rsreu.data.json_parser.api.source.subsource.Denominator;
import com.example.rsreu.data.json_parser.api.source.subsource.Numerator;
import com.example.rsreu.data.json_parser.api.source.subsource.Settings;
import com.example.rsreu.data.json_parser.api.source.subsource.Times;

import java.util.ArrayList;
import java.util.List;

public class AnswerMaker {
    private ArrayList<Settings> settings;
    private ArrayList<Times> times;

    public AnswerMaker(ArrayList<Settings> settings, ArrayList<Times> times){
        this.settings=settings;
        this.times=times;
    }
    private String getStartTime( int timeId){
        String s;
        int i=timeId--;
        s=times.get(i).getFrom();
        return s;
    }
    private String getEndTime(int timeId, int duration){
        String s;
        int i=timeId--;
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
