package com.example.aston5_1;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentList extends Fragment {
    Fragment fragmentLast;
    CardView cardOne;
    CardView cardTwo;
    CardView cardThree;
    CardView cardFour;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text11;
    TextView text22;
    TextView text33;
    TextView text44;
    int numbers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_list, container, false);

       cardOne = (CardView) view.findViewById(R.id.cardOne);
       cardTwo = (CardView) view.findViewById(R.id.cardTwo);
       cardThree = (CardView) view.findViewById(R.id.cardThree);
       cardFour = (CardView) view.findViewById(R.id.cardFour);
       text1 = (TextView) view.findViewById(R.id.text1);
        text2 = (TextView) view.findViewById(R.id.text2);
        text3 = (TextView) view.findViewById(R.id.text3);
        text4 = (TextView) view.findViewById(R.id.text4);
        text11 = (TextView) view.findViewById(R.id.text11);
        text22 = (TextView) view.findViewById(R.id.text22);
        text33 = (TextView) view.findViewById(R.id.text33);
        text44 = (TextView) view.findViewById(R.id.text44);



       fragmentLast = new FragmentLast();


       cardOne.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               replaceFragment();
               manager(text1.getText().toString(),text11.getText().toString(),1);
           }
       });

        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text2.getText().toString(),text22.getText().toString(),2);
            }
        });


        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text3.getText().toString(),text33.getText().toString(),3);
            }
        });


        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text4.getText().toString(),text44.getText().toString(),4);
            }
        });
        return view;
    }



    public void replaceFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        ((FragmentTransaction) transaction).replace(R.id.fragment_container, fragmentLast);
        transaction.commit();
    }

     public void manager(String text,String number,int numbers){
         FragmentManager fm=getFragmentManager();
         FragmentTransaction ft=fm.beginTransaction();
         Bundle args = new Bundle();
         args.putString("CID", text);
         args.putString("C", number);
         args.putInt("ok",numbers);
         fragmentLast.setArguments(args);
         ft.commit();
     }

    @Override
    public void onStart() {
        super.onStart();
         numbers = getArguments() != null ? getArguments().getInt("k") : 0;
        if (numbers == 1 )
        {
            if (getArguments() != null) {
                text1.setText(getArguments().getString("A"));
                text11.setText(getArguments().getString("B"));
            }
        }
        if (numbers == 2){
            if (getArguments() != null) {
                text2.setText(getArguments().getString("A").toString());
                text22.setText(getArguments().getString("B").toString());
            }
        }
        if (numbers == 3){
            if (getArguments() != null) {
                text3.setText(getArguments().getString("A").toString());
                text33.setText(getArguments().getString("B").toString());
            }
        }
        if (numbers == 4){
            if (getArguments() != null) {
                text4.setText(getArguments().getString("A").toString());
                text44.setText(getArguments().getString("B").toString());
            }
        }
    }
}
