package com.example.eman.jsonreader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eman.com.example.eman.pojo.Employee;
import com.example.eman.jsonparser.JsonParser;

public class JsonReader extends Activity  implements View.OnClickListener{

    EditText edtTxt;
    Button btnShowName;

    String json;

    JsonParser jsonParser;

    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_reader);

        //bind the component
        bindCoponent();

        btnShowName.setOnClickListener(this);

        jsonParser = new JsonParser();
    }

    private void showName() {
        Toast.makeText(this,"first name :"+employee.getFirstName()+" last name :"+employee.getLastName(),Toast.LENGTH_SHORT).show();
    }

    //get the json string from the
    private String readJson() {
        return edtTxt.getText().toString();
    }
    //bind the ui component
    private void bindCoponent() {
        edtTxt = (EditText)findViewById(R.id.edtTxt);
        btnShowName = (Button)findViewById(R.id.btnShowNam);
    }
    //listener hanlding method
    @Override
    public void onClick(View v) {
        int btnID = v.getId();
        if(btnID == R.id.btnShowNam){
            //get json from editText
            json = readJson();
            //pass json string to the parser and recieve the Employess object
            employee = jsonParser.parseJson(json);
            //show info from json
            showName();
        }
    }
}
