package com.example.inclass10;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Edit_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private EditText fname,lname;
    ImageView iv_profile;
    Button save_btn;
    public Edit_Fragment() {
        // Required empty public constructor
    }
    SelectAvatarFromEdit ctx;
    String gender="";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx=(SelectAvatarFromEdit)getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        iv_profile=getView().findViewById(R.id.avatar_create);
        if(this.gender.equals("female")){
            iv_profile.setImageResource(R.drawable.female);
        }
        if(this.gender.equals("male")){
            iv_profile.setImageResource(R.drawable.male);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_, container, false);
        fname=view.findViewById(R.id.firstName);
        lname=view.findViewById(R.id.lastName);
        save_btn=view.findViewById(R.id.save_btn);
        iv_profile=view.findViewById(R.id.avatar_create);

        iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.select();
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=fname.getText().toString()+" " + lname.getText().toString();
                if(fname.getText().toString().equals("")){
                    fname.setError("Required Fiels");
                    return;
                }
                if(lname.getText().toString().equals("")){
                    lname.setError("Required Fiels");
                    return;
                }
                if(gender.equals("")){
                    Toast.makeText(getContext(),"Please select Gender",Toast.LENGTH_SHORT).show();
                    return;
                }

                ctx.senddata(name,gender);
            }
        });
        return view;
    }

    public void setGender(String gender) {
        this.gender=gender;
    }

    public interface SelectAvatarFromEdit{
        void select();
        void senddata(String name,String gender);
    }

}
