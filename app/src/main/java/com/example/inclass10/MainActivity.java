package com.example.inclass10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Edit_Fragment.SelectAvatarFromEdit,SelectAvatarFragment.fromSelectAvatar, DisplayFragment.DataFromDisplay {
    final static String KEY_NAME = "name";
    final static String KEY_GENDER = "Gender";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new Edit_Fragment(), "edit")
                .commit();
    }

    @Override
    public void select() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectAvatarFragment(), "selectAvatar")
                .addToBackStack(null)
                .commit()
        ;
    }

    @Override
    public void senddata(String name, String gender) {
        Log.d("Data",name+gender);
        DisplayFragment displayFragment=new DisplayFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_NAME, name);
        arguments.putString(KEY_GENDER, gender);
        displayFragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, displayFragment, "displayAvatar")
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void selectedAvatar(Boolean isFemale) {
        getSupportFragmentManager().popBackStack();
        Edit_Fragment newEditFragment = (Edit_Fragment) getSupportFragmentManager().findFragmentByTag("edit");
        if (isFemale)newEditFragment.setGender("female");
        else newEditFragment.setGender("male");
    }

    @Override
    public void display() {
        getSupportFragmentManager().popBackStackImmediate();
    }
}
