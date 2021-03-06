package com.barvius.ai_1.entity;

import java.util.ArrayList;
import java.util.List;

public class Diagnose {
    private long id;
    private String name;
    private List<Symptom> symptoms = new ArrayList<>();

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

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void addSymptom(Symptom symptom){
        this.symptoms.add(symptom);
    }

    public void addSymptoms(List<Symptom> symptoms){ this.symptoms.addAll(symptoms);}

    public void clearSymptoms(){
        this.symptoms.clear();
    }

    public Diagnose(String name) {
        this.name = name;
    }

    public Diagnose(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Diagnose() { }

    @Override
    public String toString() {
        return name;
    }

    public boolean symptomAvailable(Symptom symptom){
        if(this.symptoms.isEmpty()){
            return false;
        }
        for (Symptom i: this.symptoms) {
            if(i.getId() == symptom.getId()){
                return true;
            }
        }
        return false;
    }

    public void deleteSymptom(Symptom symptom){
        symptoms.remove(symptom);
    }
}
