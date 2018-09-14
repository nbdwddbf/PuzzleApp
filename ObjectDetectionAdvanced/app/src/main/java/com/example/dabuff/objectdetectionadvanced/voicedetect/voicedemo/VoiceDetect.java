package com.example.dabuff.objectdetectionadvanced.voicedetect.voicedemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dabuff.objectdetectionadvanced.objectdetect.OpenCameraActivity;
import com.iflytek.sunflower.FlowerCollector;

import com.example.dabuff.objectdetectionadvanced.appdemo.R;

public class VoiceDetect extends Fragment{

    private Toast mToast;

    @SuppressLint("ShowToast")
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootview = inflater.inflate(R.layout.main,container,false);
        requestPermissions();
        mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
        //SimpleAdapter listitemAdapter = new SimpleAdapter();
        //((ListView) rootview.findViewById(R.id.listview_main)).setAdapter(listitemAdapter);

        Button buttonIse = rootview.findViewById(R.id.buttonIse);
        buttonIse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),IseDemo.class);
                startActivity(intent);
            }
        });

        Button buttonIat = rootview.findViewById(R.id.buttonIat);
        buttonIat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent = intent.setClass(getActivity(),IatDemo.class);
                startActivity(intent);
            }
        });

        Button buttonIknow = rootview.findViewById(R.id.buttonIknow);
        buttonIknow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTip("请登录：http://www.xfyun.cn/ 下载aiui体验吧！");
            }
        });

        Button buttonIwake = rootview.findViewById(R.id.buttonWake);
        buttonIwake.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTip("请登录：http://www.xfyun.cn/ 下载aiui体验吧！");
            }
        });
        return rootview;
    }

/**


    @Override
    public void onClick(View view) {
        int tag = Integer.parseInt(view.getTag().toString());
        Intent intent = null;
        switch (tag) {
            case 0:
                // 语音评测
                intent = new Intent(getActivity(), IseDemo.class);
                break;
            case 1:
                // 语音转写
                intent = new Intent(getActivity(), IatDemo.class);
                break;
            case 2:
                // 语义理解
                showTip("请登录：http://www.xfyun.cn/ 下载aiui体验吧！");
                break;
            case 3:
                // 唤醒
                showTip("请登录：http://www.xfyun.cn/ 下载体验吧！");
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
*/
    // Menu 列表
    String items[] = { "立刻体验语音评测", "立刻体验语音听写", "立刻体验语义理解", "立刻体验语音唤醒" };

    private class SimpleAdapter extends BaseAdapter {
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                LayoutInflater factory = LayoutInflater.from(getContext());
                View mView = factory.inflate(R.layout.list_items, null);
                convertView = mView;
            }

            Button btn = (Button) convertView.findViewById(R.id.btn);
            btn.setOnClickListener((View.OnClickListener) getActivity());
            btn.setTag(position);
            btn.setText(items[position]);

            return convertView;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }

    private void showTip(final String str) {
        mToast.setText(str);
        mToast.show();
    }

    @Override
    public void onResume() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onResume(getActivity());
        FlowerCollector.onPageStart("asasas");
        super.onResume();
    }

    @Override
    public void onPause() {
        // 开放统计 移动数据统计分析
        FlowerCollector.onPageEnd("asasas");
        FlowerCollector.onPause(getActivity());
        super.onPause();
    }

    private void requestPermissions(){
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int permission = ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permission!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),new String[]
                            {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.LOCATION_HARDWARE,Manifest.permission.READ_PHONE_STATE,
                                    Manifest.permission.WRITE_SETTINGS,Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_CONTACTS},0x0010);
                }

                if(permission != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(),new String[] {
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},0x0010);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
