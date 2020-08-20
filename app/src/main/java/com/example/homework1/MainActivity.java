package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String message = null;
    boolean resultingCode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(resultingCode == true){
                    // Code here executes on main thread after user presses button
                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, message);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Incorrect Name", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    public void nameFunction(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, 1);
        //String mess = getIntent().getStringExtra("moved");
        //Log.d("hurray", mess);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       // super.onActivityResult(requestCode, resultCode, data);



        // check if the request code is same as what is passed  here it is 2
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            message = data.getStringExtra("MESSAGE");
            resultingCode = true;
        }
        else{
            resultingCode = false;
        }
    }

    public void contacts(View view) {
//        Intent intent =new Intent(Intent.ACTION_INSERT);
//        startActivity(intent);

        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        startActivity(intent);

    }

}
