package is.hi.hbv601g.quizlet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;


public class DbAdapter {
    myDbHelper myhelper;
    public DbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertQuizData(String quizID, String quizGenre, String quizName, String )
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.QNAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.QID,myDbHelper.QNAME,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.QID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.QNAME));
            String  password =cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid+ "   " + name + "   " + password +" \n");
        }
        return buffer.toString();
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.QNAME+" = ?",whereArgs);
        return  count;
    }

    public int updateQuiz(String quizName , String question, String answer )
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.QNAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.QNAME+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "localDatabase";    // Database Name
        private static final String TABLE_NAME = "QuizTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String QuizID="QuizID";     // Column 1 (Primary Key)
        private static final String QuizGenre= "QuizGenre";    // Column 2
        private static final String QuizNAME = "QuizName";    //Column 3
        private static final String QUESTION= "QuizQuestion";    // Column 4
        private static final String RightAnswer= "RightAnswer";    // Column 5
        private static final String WrongAnswer1= "WrongAnswer1";    // Column 6
        private static final String WrongAnswer2= "WrongAnswer2";    // Column 7
        private static final String WrongAnswer3= "WrongAnswer3";    // Column 8
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+QuizID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+QuizGenre+" VARCHAR(255) ,"+ QuizNAME+" VARCHAR(225),"
                + QUESTION+" VARCHAR(225),"+ RightAnswer+" VARCHAR(225),"+ WrongAnswer1+" VARCHAR(225),"+ WrongAnswer2+" VARCHAR(225),"
                + WrongAnswer3+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                //Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                //Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                //Message.message(context,""+e);
            }
        }
    }
}
