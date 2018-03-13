package com.example.saksh.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   private EditText Name;
   private EditText Password;
   private TextView Info;
   private Button Login;
   private int Counter=5;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= (EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);
        Info.setText("No of Attempts Remaining:5");

        Login.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View view)
                                 {

                                     validate(Name.getText().toString(), Password.getText().toString());
   }
}
        );
    }

    private void validate(String userName, String userPassword)
    {

        if((userName.equals("Admin")) && (userPassword.equals("1234")))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            finish();
            startActivity(intent);

        }

        else

        {
            Counter--;

            Info.setText("No of Attempts Remaining:"+String.valueOf(Counter));

            if(Counter==0)
            {
                Login.setEnabled(false);
            }

        }
    }
}
