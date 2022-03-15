package is.hi.hbv601g.quizlet;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginB;
    private Button registerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginB = (Button) findViewById(R.id.loginButton);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                private boolean loginFailed = false;
                if(!loginFailed){
                    Toast.makeText(LoginActivity.this, R.string.error_login, Toast.LENGTH_SHORT).show();
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
