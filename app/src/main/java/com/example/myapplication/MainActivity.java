package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.party, R.drawable.camping, R.drawable.sports_day, R.drawable.zadar, R.drawable.istra, R.drawable.carneval, R.drawable.beer_pong};
        int[] locationList = {R.string.e1location, R.string.e2location,R.string.e3location,R.string.e4location,R.string.e5location, R.string.e6location, R.string.e7location};
        int[] descList = {R.string.e1Desc, R.string.e2Desc, R.string.e3Desc,R.string.e4Desc,R.string.e5Desc, R.string.e6Desc, R.string.e7Desc};
        String[] nameList = {"Party", "Camping", "Sports day", "Travel to Zadar", "Travel to Istra", "Carneval", "Beer pong"};
        String[] timeList = {"4 h", "2 days", "7 h","3 days", "4 days", "1 day", "3 h"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], timeList[i], locationList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("location", locationList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}