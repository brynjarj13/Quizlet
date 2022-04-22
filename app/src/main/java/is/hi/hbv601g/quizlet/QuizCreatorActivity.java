package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.database.sqlite.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class QuizCreatorActivity extends AppCompatActivity{

    //list view to see quizes
    ListView lv_quizList;

    private Button newQuizB;
    private Button myQuizB;
    private Button addQuestionB;
    private Button publishQuizB;

    private EditText quizQuestion;
    private EditText quizName;
    private EditText quizAnswer;
    private EditText quizWrongAnswer1;
    private EditText quizWrongAnswer2;
    private EditText quizWrongAnswer3;
    // sql lite
    //MyDbAdapter sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcreator);

        //sqlHelper = new MyDbAdapter(this);

        //array adapter
        ArrayAdapter quizArrayAdapter;

        //list view and set to invis for now
        lv_quizList = (ListView) findViewById(R.id.myQuizListView);
        lv_quizList.setVisibility(View.INVISIBLE);
        lv_quizList.setFocusable(false);

        quizQuestion = (EditText) findViewById(R.id.newQuizQuestionEditText);
        quizAnswer = (EditText) findViewById(R.id.newQuizAnswerEditText);
        quizWrongAnswer1 = (EditText) findViewById(R.id.wrongAnswer1EditText);
        quizWrongAnswer2 = (EditText) findViewById(R.id.wrongAnswer2EditText);
        quizWrongAnswer3 = (EditText) findViewById(R.id.wrongAnswer3EditText);
        quizName = (EditText) findViewById(R.id.quizNameEditText);

        quizQuestion.setVisibility(View.INVISIBLE);
        quizAnswer.setVisibility(View.INVISIBLE);
        quizWrongAnswer1.setVisibility(View.INVISIBLE);
        quizWrongAnswer2.setVisibility(View.INVISIBLE);
        quizWrongAnswer3.setVisibility(View.INVISIBLE);
        quizName.setVisibility(View.INVISIBLE);


        newQuizB = (Button) findViewById(R.id.NewQuizButton);
        myQuizB = (Button) findViewById(R.id.myQuizsButton);
        addQuestionB = (Button) findViewById(R.id.addQuestionButton);
        publishQuizB = (Button) findViewById(R.id.publishQuizButton);


        newQuizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // interface for a new quiz
                // hide my quiz button and new quiz button
                // View.VISIBILE myndir gera þá aftur sýnilega
                //myQuizB.setVisibility(View.INVISIBLE);
                //newQuizB.setVisibility(View.INVISIBLE);
                quizName.setFocusable(true);

                quizName.getText().clear();
                quizQuestion.getText().clear();
                quizAnswer.getText().clear();
                quizWrongAnswer1.getText().clear();
                quizWrongAnswer2.getText().clear();
                quizWrongAnswer3.getText().clear();

                quizQuestion.setVisibility(View.VISIBLE);
                quizAnswer.setVisibility(View.VISIBLE);
                quizWrongAnswer1.setVisibility(View.VISIBLE);
                quizWrongAnswer2.setVisibility(View.VISIBLE);
                quizWrongAnswer3.setVisibility(View.VISIBLE);
                quizName.setVisibility(View.VISIBLE);

                lv_quizList.setFocusable(false);
                lv_quizList.setVisibility(View.INVISIBLE);

                /*
                Intent i = new Intent(QuizCreatorActivity.this, MainActivity.class);
                startActivity(i);
                */
            }
        });


        myQuizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get a list of user's quizses
                // hide new quiz button and new quiz button
                newQuizB.setVisibility(View.INVISIBLE);
                myQuizB.setVisibility(View.INVISIBLE);

            }
        });


        // add question to the quiz
        addQuestionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = quizName.getText().toString();
                String question = quizQuestion.getText().toString();
                String answer = quizAnswer.getText().toString();
                String wrongAnswer1 = quizWrongAnswer1.getText().toString();
                String wrongAnswer2 = quizWrongAnswer2.getText().toString();
                String wrongAnswer3 = quizWrongAnswer3.getText().toString();;

                // to get the database, send context to the constructor
                DatabaseLite dbl = new DatabaseLite(QuizCreatorActivity.this);

                if(name.isEmpty()){
                    Toast.makeText(QuizCreatorActivity.this, R.string.text_quizname_required, Toast.LENGTH_SHORT).show();
                } else {
                    // disables editing in quizname edittext
                    quizName.setFocusable(false);

                    if(question.isEmpty() ||
                            answer.isEmpty() ||
                            wrongAnswer1.isEmpty() ||
                            wrongAnswer2.isEmpty() ||
                            wrongAnswer3.isEmpty())  {
                        Toast.makeText(QuizCreatorActivity.this,
                                R.string.text_quizquestion_required,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        // update quiz

                        QuizModel qm;
                        try {
                            qm = new QuizModel(-1, name, question, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
                            Toast.makeText(QuizCreatorActivity.this, qm.toString(), Toast.LENGTH_LONG).show();
                            dbl.addQuiz(qm);

                        } catch (Exception e) {
                            Toast.makeText(QuizCreatorActivity.this, "error creating question", Toast.LENGTH_LONG).show();
                            // something went wrong
                            qm = new QuizModel(-1, "error", "error", "error", "error", "error", "error");
                            dbl.addQuiz(qm);
                        }


                        quizQuestion.getText().clear();
                        quizAnswer.getText().clear();
                        quizWrongAnswer1.getText().clear();
                        quizWrongAnswer2.getText().clear();
                        quizWrongAnswer3.getText().clear();




                    }
                }

            }
        });


        publishQuizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // publish quiz to server
                Toast.makeText(QuizCreatorActivity.this, "publishing", Toast.LENGTH_LONG).show();
            }
        });

        myQuizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizQuestion.setVisibility(View.INVISIBLE);
                quizAnswer.setVisibility(View.INVISIBLE);
                quizWrongAnswer1.setVisibility(View.INVISIBLE);
                quizWrongAnswer2.setVisibility(View.INVISIBLE);
                quizWrongAnswer3.setVisibility(View.INVISIBLE);
                quizName.setVisibility(View.INVISIBLE);


                // see my quiz
                lv_quizList.setFocusable(true);
                lv_quizList.setVisibility(View.VISIBLE);
                DatabaseLite dbs = new DatabaseLite(QuizCreatorActivity.this);
                List<QuizModel> allQuiz = dbs.getQuizes();


                ArrayAdapter quizArrayAdapter = new ArrayAdapter<QuizModel>(QuizCreatorActivity.this, android.R.layout.simple_list_item_1, allQuiz);
                lv_quizList.setAdapter(quizArrayAdapter);

                Toast.makeText(QuizCreatorActivity.this, allQuiz.toString(), Toast.LENGTH_SHORT).show();

            }
        });


        // can interact with the clicked item in the list, does nothing atm
        lv_quizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                QuizModel clickedQuiz = (QuizModel) adapterView.getItemAtPosition(i);


            }
        });


    }
}
