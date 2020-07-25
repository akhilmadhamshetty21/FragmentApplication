package com.example.inclass10;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DisplayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv_gender,tv_name;
    ImageView iv_proile;
    Button edit_btn;
    String name="";
    String gender="";
    DataFromDisplay ctx;


    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=(DataFromDisplay)getActivity();
        if(getArguments() != null){
            name = getArguments().getString(MainActivity.KEY_NAME);
            gender = getArguments().getString(MainActivity.KEY_GENDER);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_display, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_name=view.findViewById(R.id.display_name);
        tv_gender=view.findViewById(R.id.display_gender);
        iv_proile=view.findViewById(R.id.profile_photo);
        edit_btn=view.findViewById(R.id.editbtn);
        tv_name.setText("Name:"+ name);
        tv_gender.setText("Gender:"+ gender);
        if(gender.equals("female"))
            iv_proile.setImageResource(R.drawable.female);
        else if(gender.equals("male"))
            iv_proile.setImageResource(R.drawable.male);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.display();
            }
        });
    }
// TODO: Rename method, update argument and hook method into UI event
    public interface DataFromDisplay{
         void display();
}

}
