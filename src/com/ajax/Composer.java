package com.ajax;

public class Composer {

    private String id;
    private String firstName;
    private String lastName;
    private String category;
    private String cs;
    private String kb;
    private String ts;
    private String remote;
    private String fob;
    private String hpc;
    private String xv;

    public Composer (String id, String firstName, String lastName, String category,String cs,String kb,String ts,String remote,String fob,String hpc,String xv) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
        this.cs = cs;
        this.kb = kb;
        this.ts = ts;
        this.remote = remote;
        this.fob = fob;
        this.hpc = hpc;
        this.xv = xv;
    }

    public String getCategory() {
        return cs;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getkb() {
        return kb;
    }
    public String getts() {
        return ts;
    }
    public String getremote() {
        return remote;
    }
    public String getfob() {
        return fob;
    }
    public String gethpc() {
        return hpc;
    }
    public String getxv() {
        return xv;
    }
    }