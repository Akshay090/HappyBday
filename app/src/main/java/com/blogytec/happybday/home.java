package com.blogytec.happybday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class home extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.home, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("home");


        Button msgButton = (Button) getActivity().findViewById(R.id.NameButton);

        msgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EditText Name = (EditText) getActivity().findViewById(R.id.Name);

                if (Name.getText().toString().length() == 0) {
                    //display in short period of time
                    Toast.makeText(getActivity().getApplicationContext(), "Enter Name Please. BSDK.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // Start NewActivity.class
                    Intent i = new Intent(getActivity(), b_day_wish.class);
                    i.putExtra("text_label", Name.getText().toString());
                    startActivity(i);

                }
            }
        });
    }
}