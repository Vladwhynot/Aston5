package com.example.aston5_1;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class FragmentLast extends Fragment {
    TextView textName;
    TextView textNumber;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_last, container, false);
        String name = getArguments().getString("CID");
        String number = getArguments().getString("C");
        textName = (TextView) view.findViewById(R.id.textName);
        textNumber = (TextView) view.findViewById(R.id.textNumber);
        textName.setText(name);
        textNumber.setText(number);
        return view;




    }
}
