package com.example.androidzk.myappportfolio;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new menuFragment())
                    .commit();
        }

    }

    public static class menuFragment extends Fragment {

        public menuFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String[] apps = {
                    "POPULAR MOVIES",
                    "STOCK HAWK",
                    "BUILD IT BIGGER",
                    "MAKE YOUR APP MATERIAL",
                    "GO UBIQUITOUS",
                    "CAPSTONE"
            };

            ArrayList<String> appNames = new ArrayList<String>(Arrays.asList(apps));
            ArrayAdapter<String> adapterAppNames = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.app_item,
                    R.id.app_item_buttonview,
                    appNames);
            ListView menuListView = (ListView)rootView.findViewById(R.id.appView);
            menuListView.setAdapter(adapterAppNames);
            menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView itemView = (TextView) view.findViewById(R.id.app_item_buttonview);
                    Toast.makeText(getActivity(), "This button will launch my \"" +
                                    itemView.getText().toString().toLowerCase()+"\" app!", Toast.LENGTH_SHORT).show();
                }
            });
            return rootView;
        }
    }
}
