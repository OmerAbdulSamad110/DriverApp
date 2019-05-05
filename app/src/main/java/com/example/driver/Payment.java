package com.example.driver;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends Fragment {
    ConstraintLayout layout;
    TextView sortCode, accNo, bank;
    EditText sortCodeEt, accNoEt, bankEt;
    Button updateBtn;
    RecyclerView recyclerView;
    FloatingActionButton editBtn, backBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.payment_fragment, container, false);
        layout = view.findViewById(R.id.innerCLayout);
        sortCode = view.findViewById(R.id.sortCodeText);
        accNo = view.findViewById(R.id.accNoText);
        bank = view.findViewById(R.id.bankText);
        sortCodeEt = view.findViewById(R.id.sortCodeEdit);
        accNoEt = view.findViewById(R.id.accNoEdit);
        bankEt = view.findViewById(R.id.bankEdit);
        updateBtn = view.findViewById(R.id.updateBtn);
        editBtn = view.findViewById(R.id.editBtn);
        backBtn = view.findViewById(R.id.backBtn);
        editBtnClick();
        backBtnClick();
        return view;
    }


    private void constraintChange(int viewId)
    {
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        set.connect(R.id.bank, ConstraintSet.TOP, viewId, ConstraintSet.BOTTOM, 8);
        set.applyTo(layout);
    }

    private void editBtnClick() {
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortCodeEt.setVisibility(View.VISIBLE);
                accNoEt.setVisibility(View.VISIBLE);
                bankEt.setVisibility(View.VISIBLE);
                updateBtn.setVisibility(View.VISIBLE);
                backBtn.show();

                editBtn.hide();
                sortCode.setVisibility(View.GONE);
                accNo.setVisibility(View.GONE);
                bank.setVisibility(View.GONE);
                constraintChange(R.id.sortCodeEdit);
            }
        });
    }

    private void backBtnClick() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortCode.setVisibility(View.VISIBLE);
                accNo.setVisibility(View.VISIBLE);
                bank.setVisibility(View.VISIBLE);
                editBtn.show();

                backBtn.hide();
                sortCodeEt.setVisibility(View.GONE);
                accNoEt.setVisibility(View.GONE);
                bankEt.setVisibility(View.GONE);
                updateBtn.setVisibility(View.GONE);
                constraintChange(R.id.sortCodeText);
            }
        });
    }

}
