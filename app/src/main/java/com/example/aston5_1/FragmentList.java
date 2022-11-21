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
               manager(text1.getText().toString(),text11.getText().toString());
           }
       });

        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text2.getText().toString(),text22.getText().toString());
            }
        });


        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text3.getText().toString(),text33.getText().toString());
            }
        });


        cardFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment();
                manager(text4.getText().toString(),text44.getText().toString());
            }
        });
        return view;
    }




    public void replaceFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        ((FragmentTransaction) transaction).replace(R.id.fragment_container, fragmentLast);
        transaction.commit();
    }

     public void manager(String text,String number){
         FragmentManager fm=getFragmentManager();
         FragmentTransaction ft=fm.beginTransaction();
         Bundle args = new Bundle();
         args.putString("CID", text);
         args.putString("C", number);
         fragmentLast.setArguments(args);
         ft.commit();
     }




}
