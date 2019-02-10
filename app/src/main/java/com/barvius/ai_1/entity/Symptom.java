package com.barvius.ai_1.entity;

public class Symptom {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symptom(String name) {
        this.name = name;
    }

    public Symptom(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Symptom){
            Symptom toCompare = (Symptom) o;
            return this.id == toCompare.id;
        }
        return false;
    }

}
