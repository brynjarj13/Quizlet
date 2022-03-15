package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginB;
    private Button registerB;
    private EditText userT;
    private EditText passwordT;


    public boolean Login(String textUserID, String textPasswordID) {

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userT = (EditText) findViewById(R.id.editTextTextPersonName);
        passwordT = (EditText) findViewById(R.id.editTextTextPassword2);

        loginB = (Button) findViewById(R.id.loginButton);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean loginFailed = false;
                if(loginFailed){
                    Toast.makeText(LoginActivity.this, R.string.error_login, Toast.LENGTH_SHORT).show();
                }else{
                    // go to main activity
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

        registerB = (Button) findViewById(R.id.registerButton);
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

}
