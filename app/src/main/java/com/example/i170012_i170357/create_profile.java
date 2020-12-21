package com.example.i170012_i170357;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

public class create_profile extends AppCompatActivity {

    Button save;
    private  final String TAG = "CreateProfile";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    EditText phoneNumber,description,firstName,lastName;


    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        save = findViewById(R.id.save_button);
        mDisplayDate =(EditText) findViewById(R.id.profile_date_of_birth);
        phoneNumber = findViewById(R.id.phoneNumber);
        description = findViewById(R.id.profile_bio);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);

        auth = FirebaseAuth.getInstance();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Save data to firebase

                String txt_username = firstName.getText().toString() + " " +lastName.getText().toString();
                String txt_phoneNumber = phoneNumber.getText().toString();
                String txt_description = description.getText().toString();

                FirebaseUser firebaseUser = auth.getCurrentUser();

                String userid = firebaseUser.getUid();

                reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);

                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put("id",userid);
                hashMap.put("username",txt_username);
                hashMap.put("imageURL","default");
                hashMap.put("description",txt_description);
                hashMap.put("phoneNumber",txt_phoneNumber);

                reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(create_profile.this, "Profile Completed", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(create_profile.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });

                //
            }
        });
    }

    public void onClickDate(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(create_profile.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener,year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                String date = dayOfMonth + "/" + month +"/" + year;
                mDisplayDate.setText(date);
            }
        };
    }

}