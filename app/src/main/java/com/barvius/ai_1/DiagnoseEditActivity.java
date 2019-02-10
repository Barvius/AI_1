package com.barvius.ai_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.barvius.ai_1.entity.Diagnose;
import com.barvius.ai_1.entity.Symptom;
import com.barvius.ai_1.ui.StatusBarTools;

import java.util.ArrayList;
import java.util.List;

public class DiagnoseEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_edit);
        long id = getIntent().getLongExtra("id",0);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle(DBHandler.getInstance().selectDiagnoseById(id).getName());
        setSupportActionBar(myToolbar);
        StatusBarTools.setStatusBarColor(getWindow(),getResources().getColor(R.color.backgroundAppBarDark));

        createArea(id);
    }

    protected void createArea(final long id){
        LinearLayout container = (LinearLayout) findViewById(R.id.diagnose_symptoms_list);
        final List<CheckBox> checkBoxList = new ArrayList<>();
        final List<Symptom> symptomList = new ArrayList<>();
        final Diagnose currentDiagnose = DBHandler.getInstance().selectDiagnoseById(id);
        final Button button = findViewById(R.id.btn_diagnose_save);

//        TextView name = (TextView) findViewById(R.id.diagnose_name);
//        name.setText(currentDiagnose.getName());


        symptomList.addAll(DBHandler.getInstance().selectSymptomNames());

        for (Symptom i : symptomList) {
            CheckBox tmp = new CheckBox(new ContextThemeWrapper(this, R.style.uiCheckBoxStyle));
            tmp.setText(i.getName());
            tmp.setId(symptomList.indexOf(i));
            if(currentDiagnose.symptomAvailable(i)){
                tmp.setChecked(true);
            }
            tmp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentDiagnose.clearSymptoms();
                    currentDiagnose.addSymptoms(getSelectedSymptoms(checkBoxList, symptomList));
                    button.setEnabled(true);
                    if(CompareDiagnoses.compare(DBHandler.getInstance().selectDiagnoses(),currentDiagnose)){
                        button.setEnabled(false);
                    }

                }
            });
            checkBoxList.add(tmp);
            container.addView(tmp);
        }


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DBHandler.getInstance().updateDiagnoseSymptoms(currentDiagnose);
                finish();
            }
        });
    }

    List<Symptom> getSelectedSymptoms(List<CheckBox> checkBoxList, List<Symptom> symptomList){
        List<Symptom> list = new ArrayList<>();
        for (CheckBox i: checkBoxList) {
            if (i.isChecked()){
                list.add(symptomList.get(i.getId()));
            }
        }
        return list;
    }


}
