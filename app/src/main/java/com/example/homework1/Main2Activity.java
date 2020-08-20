package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Main2Activity extends AppCompatActivity implements KeyListener{//implements KeyListener

    @Override
    public int getInputType(){
       return InputType.TYPE_CLASS_TEXT;
    }

    @Override
    public boolean onKeyDown(View view, Editable text, int keyCode, KeyEvent event) {
        //EditText tet = (EditText) findViewById(R.id.editText2);

        return true;
    }

    @Override
    public boolean onKeyUp(View view, Editable text, int keyCode, KeyEvent event) {

        return true;
    }

    @Override
    public boolean onKeyOther(View view, Editable text, KeyEvent event) {
        return false;
    }

    @Override
    public void clearMetaKeyState(View view, Editable content, int states) {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         EditText tet = (EditText) findViewById(R.id.editText2);

        tet.setKeyListener(this);
        tet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //String keyString;

                if(actionId == EditorInfo.IME_ACTION_DONE || event.KEYCODE_ENTER == actionId ){
                    //Log.d("done","hello");
                    String keystring = v.getText().toString();
                    String trimed = keystring.trim();
                    String[] splitstring = trimed.split(" ");

                    //Toast.makeText(Main2Activity.this, Arrays.toString(splitstring), Toast.LENGTH_SHORT).show();
                    //System.out.println(trimed);
                    if( splitstring.length >= 2 && trimed.matches("[a-zA-Z ]+")){
                        //Log.d("true","T");
                       Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        intent.putExtra("MESSAGE",trimed);
                        setResult(Activity.RESULT_OK,intent);
                        finish();

                    }
                    else{
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        setResult(Activity.RESULT_CANCELED, intent);
                        finish();
                        //Log.d("false","F");

                    }
                    //Log.d("To string:", keystring);
                    //finish();

                    //return true;
                }
                //finish();
                return false;

            }

        });



    }/*public void enterPersonName(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);




    } //adding to go back to first activity*/
}
