package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question, count_of, count_left;
    ImageView image;
    Quiz selectedQuiz;

    private Question question = new Question();

    private String answer;
    private String chosenQuiz;
    private int questionLength;
    private int questionCounter;
    private int questionCorrect = 0;
    private int countCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);
        image = (ImageView)findViewById(R.id.image);
        count_of = (TextView)findViewById(R.id.count_of);
        count_left = (TextView)findViewById(R.id.count_left);
        getSelectedQuiz();
        setValues();
        questionsById();

        NextQuestion(questionCounter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Correct", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    questionCorrect += 1;
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }else{
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Incorrect", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Correct", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    questionCorrect += 1;
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }else{
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Incorrect", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Correct", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    questionCorrect += 1;
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }else{
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Incorrect", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Correct", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    questionCorrect += 1;
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }else{
                    Toast toast = Toast.makeText(DetailActivity.this, "You Are Incorrect", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    if(questionLength == 0){
                        GameOver();
                    }
                    else{
                        NextQuestion(questionCounter);
                    }
                }

                break;
        }
    }

    private void GameOver(){
        questionLength = selectedQuiz.getQuizlength();
        chosenQuiz = selectedQuiz.getName();
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
        intent.putExtra("Question_correct", questionCorrect);
        intent.putExtra("Question_length",  questionLength);
        intent.putExtra("Chosen_quiz", chosenQuiz);
        startActivity(intent);
    }

    private void NextQuestion(int num){
        tv_question.setText(question.getQuestion(num));
        image.setImageResource(question.images[num]);
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));
        count_of.setText(Integer.toString(countCounter));

        answer = question.getCorrectAnswer(num);
        questionCounter += 1;
        questionLength -= 1;
        countCounter += 1;
    }

    private void getSelectedQuiz()
    {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedQuiz = HomeFragment.quizList.get(Integer.valueOf(parsedStringID));
    }

    private void setValues()
    {
        TextView tv = (TextView) findViewById(R.id.quizName);
        tv.setText(selectedQuiz.getName());
        questionLength = selectedQuiz.getQuizlength();
        count_left.setText(Integer.toString(questionLength));

    }
    private void questionsById()
    {
        chosenQuiz = selectedQuiz.getId();
        if(chosenQuiz=="0"){
            questionCounter = 0;
        }
        if(chosenQuiz=="1"){
            questionCounter = 3;
        }
        if(chosenQuiz=="2"){
            questionCounter = 5;
        }
        if(chosenQuiz=="3"){
            questionCounter = 9;
        }
    }
}