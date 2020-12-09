package com.example.sono;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    //DB version, table and database name
    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE = "quiztable";


    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";
    private static final String KEY_OPTD = "optD";
    private static final String KEY_EXP = "exp";
    private final Context mContext;

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.mContext = context;
        //  //3rd argument to be passed is CursorFactory instance
    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = " CREATE TABLE " + DB_TABLE+"("+KEY_ID  + " INTEGER PRIMARY KEY," + KEY_QUES +" TEXT," + KEY_OPTA +" TEXT," + KEY_OPTB+" TEXT," + KEY_OPTC +" TEXT," + KEY_OPTD +" TEXT," + KEY_EXP +" TEXT"+")";
        Log.d("TESTE","----> " + sqlQuery);
        Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
    }

    private void addQuestions() {
        Question q1 = new Question(mContext.getString(R.string.q1), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q1);
        Question q2 = new Question(mContext.getString(R.string.q2), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q2);
        Question q3 = new Question(mContext.getString(R.string.q3), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q3);
        Question q4 = new Question(mContext.getString(R.string.q4), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q4);
        Question q5 = new Question(mContext.getString(R.string.q5), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q5);
        Question q6 = new Question(mContext.getString(R.string.q6), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q6);
        Question q7 = new Question(mContext.getString(R.string.q7), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q7);
        Question q8 = new Question(mContext.getString(R.string.q8), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q8);
        Question q9 = new Question(mContext.getString(R.string.q9), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q9);
        Question q10 = new Question(mContext.getString(R.string.q10), mContext.getString(R.string.ansA), mContext.getString(R.string.ansB), mContext.getString(R.string.ansC), mContext.getString(R.string.ansD), "D");
        this.addQuestionToDB(q10);

    }

    //code to add new question
    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        values.put(KEY_OPTD,q.getOptD());
        values.put(KEY_EXP,q.getExplanation());
        //insert row
        dbase.insert(DB_TABLE, null, values);
    }
//get all question in listview
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setOptA(cursor.getString(2));
                q.setOptB(cursor.getString(3));
                q.setOptC(cursor.getString(4));
                q.setOptD(cursor.getString(5));
                q.setExplanation(cursor.getString(5));

                //add question in list
                questionList.add(q);

                //loop all rows
            }while (cursor.moveToNext());
        }
        return questionList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }


}
