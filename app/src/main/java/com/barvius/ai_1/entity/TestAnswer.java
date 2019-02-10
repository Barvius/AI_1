package com.barvius.ai_1.entity;

import com.barvius.ai_1.entity.Symptom;

public class TestAnswer {
    private Symptom symptom;
    private boolean select;

    public TestAnswer() {
        this.select = false;
    }

    public TestAnswer(Symptom symptom) {
        this.symptom = symptom;
        this.select = false;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
