package com.example.aston5_1;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentLast extends Fragment {
    EditText textName;
    EditText textNumber;
    Button button;
    Fragment fragmentList;
    int numbers;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_last, container, false);
        String name = getArguments().getString("CID");
        String number = getArguments().getString("C");
        textName = (EditText) view.findViewById(R.id.textName);
        textNumber = (EditText) view.findViewById(R.id.textNumber);
        button = (Button) view.findViewById(R.id.button);
        textName.setText(name);
        textNumber.setText(number);
        fragmentList = new FragmentList();
        numbers = getArguments().getInt("ok");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transactionn = getFragmentManager().beginTransaction();
                ((FragmentTransaction) transactionn).replace(R.id.fragment_container, fragmentList);
                transactionn.commit();
                FragmentManager fmm=getFragmentManager();
                FragmentTransaction ftt=fmm.beginTransaction();
                Bundle argst = new Bundle();
                argst.putString("A", textName.getText().toString());
                argst.putString("B", textNumber.getText().toString());
                argst.putInt("k",numbers);
                fragmentList.setArguments(argst);
                ftt.commit();
            }
        });
        return view;
    }

}
