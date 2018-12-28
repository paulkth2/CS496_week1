package com.example.taehyungkim.listviewcontact;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyListAdapter myListAdapter;
    ArrayList<list_item> list_itemArrayList;

    private TextView testView;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.my_listview);

        list_itemArrayList = new ArrayList<list_item>();

        //testView = (TextView)findViewById(R.id.testView);

        String json_data = getString(R.string.json_data);

        //testView.setText(json_data);

        try {
            //testView.setText("parsing tried");
            JSONArray contact = new JSONArray(json_data);
            //testView.setText("Array loading succeed.");
            for (int i = 0; i < contact.length(); i++) {
                JSONObject jObject = contact.getJSONObject(i);
                String name = jObject.getString("name");
                String phonenum = jObject.getString("phone number");
                String email = jObject.getString("email");

                list_itemArrayList.add(
                        new list_item(R.mipmap.ic_launcher, name, phonenum, email));
            }
        } catch (JSONException e){
            //testView.setText("parsing error");
            e.printStackTrace();
        }


        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"김정상","010-1234-5678","kth@example.com"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"이미나","010-2345-1234","hello@kimchi.com"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"송순신","010-2341-2341","hungry@lunch.com"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"감자탕","010-1423-1422","breakfast@kirai.com"));
        list_itemArrayList.add(
                new list_item(R.mipmap.ic_launcher,"갈비탕","010-4514-1323","nap@ski.com"));

        myListAdapter = new MyListAdapter(MainActivity.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
