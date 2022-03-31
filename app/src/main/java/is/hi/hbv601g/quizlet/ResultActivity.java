package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    Button back_button;
    TextView name_quiz, results, results_sum, results_right;
    ImageView result_image;

    int questionCorrect;
    int questionLength;
    String chosenQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        back_button = (Button)findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        results_right = (TextView)findViewById(R.id.results_right);
        results_sum = (TextView)findViewById(R.id.results_sum);
        results = (TextView)findViewById(R.id.results);
        name_quiz = (TextView)findViewById(R.id.name_quiz);
        result_image = (ImageView)findViewById(R.id.result_image);

        questionCorrect = getIntent().getIntExtra("Question_correct", questionCorrect);
        questionLength = getIntent().getIntExtra("Question_length", questionLength);
        chosenQuiz = getIntent().getStringExtra("Chosen_quiz");

        getInfoQuiz();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_button:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
    }

    private void getInfoQuiz()
    {
        results_right.setText(Integer.toString(questionCorrect));
        results_sum.setText(Integer.toString(questionLength));
        name_quiz.setText(chosenQuiz);
        if(questionCorrect == questionLength){
            results.setText("Congratulations, You got every answer right!!");
            result_image.setImageResource(R.drawable.winner);
        }else if(questionCorrect >= (questionLength/2))
        {
            results.setText("Not bad.");
            result_image.setImageResource(R.drawable.notbad);
        }
        else
        {
            results.setText("Maybe next time...");
            result_image.setImageResource(R.drawable.nexttime);
        }
    }

}