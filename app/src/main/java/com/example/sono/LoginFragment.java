package com.example.sono;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflatedView = inflater.inflate(R.layout.fragment_login, container, false);


        final EditText editTextPassword, editTextUserName;
        Button buttonLogin;

        editTextUserName = (EditText) inflatedView.findViewById(R.id.et_email);
        editTextPassword = (EditText) inflatedView.findViewById(R.id.et_password);
        buttonLogin = (Button) inflatedView.findViewById(R.id.btn_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = editTextUserName.getText().toString();
                String Pwd = editTextPassword.getText().toString();

                if(UserName.equals("user")&&Pwd.equals("pass")){

                    Intent mainIntent = new Intent(getContext(),QuizActivity.class);
                    startActivity(mainIntent);
                }


            }
        });




        return inflatedView;
    }

}