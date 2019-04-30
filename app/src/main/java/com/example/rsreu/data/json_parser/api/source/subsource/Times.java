package com.example.rsreu.data.json_parser.api.source.subsource;

public class Times {
    //@SerializedName("id")
    private int id;
    //@SerializedName("to")
    private String to;
    //@SerializedName("from")
    private String from;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
