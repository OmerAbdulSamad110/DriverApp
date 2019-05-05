package com.example.driver;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class Calendar extends Fragment {

    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.current_learner_cardview, container, false);
//        toolbar = view.findViewById(R.id.toolbar);
//        alertBox();
        return view;
    }

    private void alertBox() {
        Spinner spinner1, spinner2;
        TextView textView1, textView2, textView3;
        String[] dummy = {"Lori Henderson", "Omer Abdul Samad", "Muhammad Shaheer Mustufa Ansari"};
        String[] dummy2 = {"05/02/19", "05/02/19", "31/12/29"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.current_learner_cardview, null);
//        spinner1 = dialogView.findViewById(R.id.select_learner);
//        spinner2=dialogView.findViewById(R.id.select_avail_date);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, dummy);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, dummy2);
//        spinner1.setAdapter(adapter);
//        spinner2.setAdapter(adapter2);

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
