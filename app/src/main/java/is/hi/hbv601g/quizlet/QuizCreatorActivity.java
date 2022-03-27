package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizCreatorActivity extends AppCompatActivity{

    private Button newQuizB;
    private Button myQuizsb;
    private Button saveQuestion;
    private EditText quizQuestion;
    private EditText quizAnswer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcreator);

        quizQuestion = (EditText) findViewById(R.id.newQuizQuestionEditText);
        quizAnswer = (EditText) findViewById(R.id.newQuizAnswerEditText);

        newQuizB = (Button) findViewById(R.id.NewQuizButton);
        newQuizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // hide my quiz button and new quiz button
                myQuizsb.setVisibility(View.GONE);
                newQuizB.setVisibility(View.GONE);
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

        myQuizsb = (Button) findViewById(R.id.myQuizsButton);
        myQuizsb.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                // hide new quiz button and new quiz button
                newQuizB.setVisibility(View.GONE);
                myQuizsb.setVisibility(View.GONE);

            }
        });



    }
}
