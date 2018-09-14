package com.example.dabuff.objectdetectionadvanced.objectdetect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dabuff.objectdetectionadvanced.appdemo.R;

public class ObjectDetect extends Fragment {
    private Button btnSingleStart;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.objectdetect,container,false);

        btnSingleStart = rootview.findViewById(R.id.btnsinglestart);
        btnSingleStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),OpenCameraActivity.class);
                startActivity(intent);
            }
        });
        return rootview;
    }
}
