package com.example.eman.jsonparser;

import com.example.eman.com.example.eman.pojo.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by EMAN on 10/04/2016.
 */
public class JsonParser {

    Gson gson ;

    public JsonParser(){
        gson = new GsonBuilder().create();
    }
    public Employee parseJson (String json){

        Employee employee = gson.fromJson(json,Employee.class);

        return employee;
    }
}
