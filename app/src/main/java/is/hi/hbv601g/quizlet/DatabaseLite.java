package is.hi.hbv601g.quizlet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseLite extends SQLiteOpenHelper {


    public static final String QUIZ_TABLE = "QUIZ_TABLE";
    public static final String COLUMN_ID = "ID" ;
    public static final String COLUMN_NAME = "QUIZ_NAME" ;
    public static final String COLUMN_QUESTION = "QUIZ_QUESTION" ;
    public static final String COLUMN_RIGHT_ANSWER = "QUIZ_RIGHT_ANSWER" ;
    public static final String COLUMN_WRONG_ANSWER_ONE = "QUIZ_WRONG_ANSWER_ONE" ;
    public static final String COLUMN_WRONG_ANSWER_TWO = "QUIZ_WRONG_ANSWER_TWO" ;
    public static final String COLUMN_WRONG_ANSWER_THREE = "QUIZ_WRONG_ANSWER_THREE" ;

    public DatabaseLite(@Nullable Context context) {
        super(context, "Quiz.db", null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + QUIZ_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_QUESTION + " TEXT, " + COLUMN_RIGHT_ANSWER + " TEXT,  " + COLUMN_WRONG_ANSWER_ONE + " TEXT, " + COLUMN_WRONG_ANSWER_TWO + " TEXT, " + COLUMN_WRONG_ANSWER_THREE + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addQuiz (QuizModel quizModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, quizModel.getQuizName());
        cv.put(COLUMN_QUESTION, quizModel.getQuizQuestion());
        cv.put(COLUMN_RIGHT_ANSWER, quizModel.getQuizAnswer());
        cv.put(COLUMN_WRONG_ANSWER_ONE, quizModel.getQuizWrongAnswerOne());
        cv.put(COLUMN_WRONG_ANSWER_TWO, quizModel.getQuizWrongAnswerTwo());
        cv.put(COLUMN_WRONG_ANSWER_THREE, quizModel.getQuizWrongAnswerThree());

        long insert = db.insert(QUIZ_TABLE,null,cv);

        if(insert == -1) {
            return false;
        } else {
            return true;
        }

    }
    
    public  List<QuizModel> getQuizes() {
        List<QuizModel> returnQuizList = new ArrayList<>();
        
        String qs = "SELECT * FROM " + QUIZ_TABLE;
        
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(qs, null);

        if(cursor.moveToFirst()) {

            do {
                int quizID = cursor.getInt(0);
                String quizName = cursor.getString(1);
                String quizQuestion = cursor.getString(2);
                String QuizAnswer = cursor.getString(3);
                String QuizWrongOne = cursor.getString(4);
                String QuizWrongTwo = cursor.getString(5);
                String QuizWrongThree = cursor.getString(6);

                QuizModel newQuiz = new QuizModel(quizID,quizName,quizQuestion,QuizAnswer,QuizWrongOne,QuizWrongTwo,QuizWrongThree);
                returnQuizList.add(newQuiz);

            } while (cursor.moveToNext());

        }else {
            // no list
            String errorfiller = "error";
            QuizModel newQuiz = new QuizModel(1,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller);
            returnQuizList.add(newQuiz);

        }
        cursor.close();
        db.close();
        return returnQuizList;
    }
}