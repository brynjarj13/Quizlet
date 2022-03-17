package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class LoginActivity extends AppCompatActivity {

    private Button loginB;
    private Button registerB;
    private EditText userT;
    private EditText passwordT;


    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public boolean Login(String textUserID, String textPasswordID) {

        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
