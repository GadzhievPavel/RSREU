package com.example.rsreu.data.json_parser.api.source.subsource;

public class Denominator
{
    //@SerializedName("weekDay")
    private int weekDay;
   // @SerializedName("timeId")
    private int timeId;
   // @SerializedName("duration")
    private int duration;
    //@SerializedName("title")
    private String title;
    //@SerializedName("type")
    private String type;
   // @SerializedName("optional")
    private int optional;
   // @SerializedName("teachers")
    private String teachers;
    //@SerializedName("room")
    private String room;
   // @SerializedName("build")
    private String build;
  //  @SerializedName("dates")
    private String dates;

    public void setWeekDay(int weekDay){
        this.weekDay = weekDay;
    }
    public int getWeekDay(){
        return this.weekDay;
    }
    public void setTimeId(int timeId){
        this.timeId = timeId;
    }
    public int getTimeId(){
        return this.timeId;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getDuration(){
        return this.duration;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setOptional(int optional){
        this.optional = optional;
    }
    public int getOptional(){
        return this.optional;
    }
    public void setTeachers(String teachers){
        this.teachers = teachers;
    }
    public String getTeachers(){
        return this.teachers;
    }
    public void setRoom(String room){
        this.room = room;
    }
    public String getRoom(){
        return this.room;
    }
    public void setBuild(String build){
        this.build = build;
    }
    public String getBuild(){
        return this.build;
    }
    public void setDates(String dates){
        this.dates = dates;
    }
    public String getDates(){
        return this.dates;
    }
}
