package com.example.mygate;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
public class NoteDatabase extends SQLiteOpenHelper {
    public static final int DB_VERSION = 2;
    public static String DB_NAME = "NotesDB.db";
    public static String DB_TABLE = "NotesTAble";
    public static String Column_ID = "NotesId";
    public static String Column_TITLE = "NotesTitle";
    public static String Column_DETAILS = "NotesDetails";
    public static String Column_DATE = "NotesDate";
    public static String Column_TIME = "NotesTime";
    public NoteDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + DB_TABLE +
                "(" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Column_TITLE + " TEXT, " +
                Column_DETAILS + " TEXT, " +
                Column_DATE+ " TEXT, " +
                Column_TIME + " TEXT " +")";
        sqLiteDatabase.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion )
            return;
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(sqLiteDatabase);
    }
    public long AddNote(NoteModel noteModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Column_TITLE, noteModel.getNoteTitle());
        contentValues.put(Column_DETAILS, noteModel.getNoteDetails());
        contentValues.put(Column_DATE, noteModel.getNoteDate());
        contentValues.put(Column_TIME, noteModel.getNoteTime());

        long ID = db.insert(DB_TABLE, null, contentValues);
        Log.d("Inserted", "id-" + ID);
        return ID;
    }
    public List<NoteModel> getNote(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteModel> allNote = new ArrayList<>();
        String queryStatement = "SELECT * FROM " + DB_TABLE;
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(queryStatement, null);

        if (cursor.moveToFirst()){
            do {

                NoteModel noteModel = new NoteModel();
                noteModel.setId(cursor.getInt(0));
                noteModel.setNoteTitle(cursor.getString(1));
                noteModel.setNoteDetails(cursor.getString(2));
                noteModel.setNoteDate(cursor.getString(3));
                noteModel.setNoteTime(cursor.getString(4));

                allNote.add(noteModel);
            } while (cursor.moveToNext());
        }
        return allNote;
    }
    public NoteModel getNotes(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] query = new  String[] {Column_ID,Column_TITLE,Column_DETAILS,Column_DATE,Column_TIME};
        @SuppressLint("Recycle") Cursor cursor = db.query(DB_TABLE, query,Column_ID+"=?", new String[]{String.valueOf(id)}, null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();
        assert cursor != null;
        return new NoteModel(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4));
        }
        void deleteNote(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(DB_TABLE,Column_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
        }
}
