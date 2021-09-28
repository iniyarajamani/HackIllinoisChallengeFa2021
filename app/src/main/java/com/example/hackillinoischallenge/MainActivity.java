package com.example.hackillinoischallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Mentor> mentors;
    String JSON_URL = "https://api.hackillinois.org/upload/blobstore/mentors/";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mentors = new ArrayList<>();

        getMentors();
    }

    private void getMentors() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray mentorsArray = response.getJSONArray("data");

                    for (int i = 0; i < mentorsArray.length(); i++) {
                        JSONObject mentorObject = mentorsArray.getJSONObject(i);
                        Mentor mentor = new Mentor( mentorObject.getString("firstName"),
                                                    mentorObject.getString("lastName"),
                                                    mentorObject.getString("profile"),
                                                    mentorObject.getString("description"));
                        mentors.add(mentor);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(), mentors);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonObjectRequest);
    }
}
