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

    // it is easier to work with constants than loose strings.
    public static final String QUIZ_TABLE = "QUIZ_TABLE";
    public static final String COLUMN_ID = "ID" ;
    public static final String COLUMN_NAME = "QUIZ_NAME" ;
    public static final String COLUMN_QUESTION = "QUIZ_QUESTION" ;
    public static final String COLUMN_RIGHT_ANSWER = "QUIZ_RIGHT_ANSWER" ;
    public static final String COLUMN_WRONG_ANSWER_ONE = "QUIZ_WRONG_ANSWER_ONE" ;
    public static final String COLUMN_WRONG_ANSWER_TWO = "QUIZ_WRONG_ANSWER_TWO" ;
    public static final String COLUMN_WRONG_ANSWER_THREE = "QUIZ_WRONG_ANSWER_THREE" ;
    public static final String COLUMN_QUIZ_GENRE = "QUIZ_GENRE" ;
    public static final String COLUMN_QUIZ_IMAGE_URL = "QUIZ_IMAGE_URL" ;


    public DatabaseLite(@Nullable Context context) {
        super(context, "Quiz.db", null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + QUIZ_TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_QUESTION + " TEXT, "
                + COLUMN_RIGHT_ANSWER + " TEXT,  "
                + COLUMN_WRONG_ANSWER_ONE + " TEXT, "
                + COLUMN_WRONG_ANSWER_TWO + " TEXT, "
                + COLUMN_WRONG_ANSWER_THREE + " TEXT, "
                + COLUMN_QUIZ_GENRE + " TEXT, "
                + COLUMN_QUIZ_IMAGE_URL + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  boolean deleteQuestion(QuizModel quizModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        String qs = "DELETE FROM " + QUIZ_TABLE
                + " WHERE " + COLUMN_ID + " = " + quizModel.getId();

        Cursor cursor = db.rawQuery(qs,null);

        if(cursor.moveToFirst()) {
            return true;
        }else {
            return false;
        }
    }

    public boolean updateQuiz (QuizModel quizModel, String condition) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        // pair the columns with the updated values
        cv.put(COLUMN_NAME, quizModel.getQuizName());
        cv.put(COLUMN_QUESTION, quizModel.getQuizQuestion());
        cv.put(COLUMN_RIGHT_ANSWER, quizModel.getQuizAnswer());
        cv.put(COLUMN_WRONG_ANSWER_ONE, quizModel.getQuizWrongAnswerOne());
        cv.put(COLUMN_WRONG_ANSWER_TWO, quizModel.getQuizWrongAnswerTwo());
        cv.put(COLUMN_WRONG_ANSWER_THREE, quizModel.getQuizWrongAnswerThree());
        cv.put(COLUMN_QUIZ_GENRE, quizModel.getQuizGenre());
        cv.put(COLUMN_QUIZ_IMAGE_URL, quizModel.getQuizImageURL());

        // replaces values where the whereClause (text in quotation marks) matches
        long update = db.update(QUIZ_TABLE, cv, "QUIZ_QUESTION=?", new String[]{condition});
        db.close();

        if(update == -1) {
            return false;
        } else {
            return true;
        }

    }

    public boolean addQuiz (QuizModel quizModel) {
        // retrieves a sql database that is writeable
        SQLiteDatabase db = this.getWritableDatabase();
        // content values pairs intended values into the right table columns
        ContentValues cv = new ContentValues();
        // the id is auto increment so it does not need to be inserted manually
        cv.put(COLUMN_NAME, quizModel.getQuizName());
        cv.put(COLUMN_QUESTION, quizModel.getQuizQuestion());
        cv.put(COLUMN_RIGHT_ANSWER, quizModel.getQuizAnswer());
        cv.put(COLUMN_WRONG_ANSWER_ONE, quizModel.getQuizWrongAnswerOne());
        cv.put(COLUMN_WRONG_ANSWER_TWO, quizModel.getQuizWrongAnswerTwo());
        cv.put(COLUMN_WRONG_ANSWER_THREE, quizModel.getQuizWrongAnswerThree());
        cv.put(COLUMN_QUIZ_GENRE, quizModel.getQuizGenre());
        cv.put(COLUMN_QUIZ_IMAGE_URL, quizModel.getQuizImageURL());

        long insert = db.insert(QUIZ_TABLE,null,cv);
        db.close();
        // a check to see if the insert works
        if(insert == -1) {
            return false;
        } else {
            return true;
        }


    }
    // currently returns all items in quiz table
    public  List<QuizModel> getQuizes() {
        List<QuizModel> returnQuizList = new ArrayList<>();
        // query string that fetches certain items from the quiz table
        String qs = "SELECT * FROM " + QUIZ_TABLE;
        // retrieves a sql dabase that is readable
        SQLiteDatabase db = this.getReadableDatabase();
        // a raw query returns a cursor object that we can use to traverse the data
        Cursor cursor = db.rawQuery(qs, null);
        // if there is a 'first' item in the dataset, movefirst will point towards it.
        if(cursor.moveToFirst()) {

            do {
                int quizID = cursor.getInt(0);
                String quizName = cursor.getString(1);
                String quizQuestion = cursor.getString(2);
                String quizAnswer = cursor.getString(3);
                String quizWrongOne = cursor.getString(4);
                String quizWrongTwo = cursor.getString(5);
                String quizWrongThree = cursor.getString(6);
                String quizGenre = cursor.getString(7);
                String quizImageURL = cursor.getString(8);

                QuizModel newQuiz = new QuizModel(
                        quizID,quizName,quizQuestion,quizAnswer,quizWrongOne,quizWrongTwo,quizWrongThree,quizGenre,quizImageURL);

                returnQuizList.add(newQuiz);
            // has to be move to next to prevent it from looping endlessly
            } while (cursor.moveToNext());

        }else {
            // no list so created a error filler message that creates an obvious way to see something went wrong
            String errorfiller = "error";
            QuizModel newQuiz = new QuizModel(1,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller,errorfiller);
            returnQuizList.add(newQuiz);

        }
        cursor.close();
        db.close();
        return returnQuizList;
    }
}
