
package edison.vidya.mood_setting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MoodSetting.db";
    public static final String TABLE_NAME = "MoodSetTable";
    public static final String COLUMN_NO = "no";
    public static final String HOUSE_NUM = "houseNum";
    public static final String HOUSE_NAME = "houseName";
    public static final String ROOM_NUM = "roomNum";
    public static final String SETTING_NUM = "settingNum";
    public static final String DEVICE_TYPE = "device_type";
    public static final String DEVICE_NUM = "deviceNum";
    public static final String STATUS = "status";
    public static final String DATA = "data";
    public static final String MOOD_TYPE= "MOOD_TYPE";
    public  SQLiteDatabase db = null;

    String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_NO + " INTEGER PRIMARY KEY AUTOINCREMENT  , " + HOUSE_NUM + " TEXT ,"+ HOUSE_NAME + " TEXT ,"+ ROOM_NUM + " TEXT ,"+
            SETTING_NUM + " TEXT ," +  DEVICE_TYPE + " TEXT ,"+ DEVICE_NUM + " TEXT ,"+ STATUS + " TEXT ,"+ DATA + " TEXT ," + MOOD_TYPE + " TEXT "+ ");";
    private Cursor res;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      /*  db.execSQL("create table" +TABLE_NAME+ "(_no integer primary key AUTOINCREMENT NOT NULL,"+ HOUSE_NUM+ "Int,"+HOUSE_NAME+ " Text,"+ROOM_NUM+ " Int,"+SETTING_NUM+ " Int,"+DEVICE_TYPE+ " Text,"+DEVICE_NUM+ " Int,"+STATUS+ " Text,"+DATA+ " Text)"
        );*/

       db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_NAME);
        onCreate(db);
    }


    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db,TABLE_NAME);
        return numRows;
    }




    public boolean insertPlate(String house_num, String house_name, String room_num,String setting_num, String device, String device_num,String status, String data, String mood_type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       
        Cursor c=db.rawQuery("SELECT * FROM MoodSetTable WHERE device_type='"+device+"'" , null);
        if(c.moveToFirst())
        {
            //showMessage("Error", "Record exist");

            Cursor c1=db.rawQuery("SELECT * FROM MoodSetTable WHERE deviceNum='"+device_num+"'" , null);
            if(c1.moveToFirst()) {

                Cursor c3=db.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if(c3.moveToFirst()) {
                    Toast.makeText(context,"data already exist",Toast.LENGTH_LONG).show();

                }
                else{

                    // Inserting record
                    contentValues.put("houseNum", house_num);
                    contentValues.put("houseName", house_name);
                    contentValues.put("roomNum", room_num);
                    contentValues.put("settingNum", setting_num);
                    contentValues.put("device_type", device);
                    contentValues.put("deviceNum", device_num);
                    contentValues.put("status", status);
                    contentValues.put("data", data);
                    contentValues.put("MOOD_TYPE", mood_type);

                    db.insert(TABLE_NAME, null, contentValues);
                    Toast.makeText(context,"Inserted successfully",Toast.LENGTH_LONG).show();

                }

            }
            else{

                    // Inserting record
                    contentValues.put("houseNum", house_num);
                    contentValues.put("houseName", house_name);
                    contentValues.put("roomNum", room_num);
                    contentValues.put("settingNum", setting_num);
                    contentValues.put("device_type", device);
                    contentValues.put("deviceNum", device_num);
                    contentValues.put("status", status);
                    contentValues.put("data", data);
                    contentValues.put("MOOD_TYPE", mood_type);

                    db.insert(TABLE_NAME, null, contentValues);
                Toast.makeText(context,"Inserted successfully",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            // Inserting record
            contentValues.put("houseNum", house_num);
            contentValues.put("houseName", house_name);
            contentValues.put("roomNum", room_num);
            contentValues.put("settingNum", setting_num);
            contentValues.put("device_type", device);
            contentValues.put("deviceNum", device_num);
            contentValues.put("status", status);
            contentValues.put("data", data);
            contentValues.put("MOOD_TYPE", mood_type);

            db.insert(TABLE_NAME, null, contentValues);
            Toast.makeText(context,"Inserted successfully",Toast.LENGTH_LONG).show();
        }







        /*Cursor resultSet=db.rawQuery("select * from " + TABLE_NAME + " where  device_type   = " + device,null);
       // String Query = "Select * from " + TABLE_NAME + " where " + DEVICE_TYPE + " = " + device;
        if (resultSet.getCount() == 0)  {
            //contentValues.put("no", no);
            contentValues.put("houseNum", house_num);
            contentValues.put("houseName", house_name);
            contentValues.put("roomNum", room_num);
            contentValues.put("settingNum", setting_num);
            contentValues.put("device_type", device);
            contentValues.put("deviceNum", device_num);
            contentValues.put("status", status);
            contentValues.put("data", data);
            contentValues.put("MOOD_TYPE", mood_type);

            db.insert(TABLE_NAME, null, contentValues);
        }*/
       // else
       // {
           // Toast.makeText(context,device+" already exists",Toast.LENGTH_SHORT).show();
      //  }
        return true;
    }

     boolean updateData(String aanum, String housenum, String housename, String roomnum, String settingnum, String devicetype, String devicenum, String status, String data, String aamood_type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       contentValues.put(COLUMN_NO,aanum);
         contentValues.put(HOUSE_NUM,housenum);
        contentValues.put(HOUSE_NAME, housename);
        contentValues.put(ROOM_NUM, roomnum);
        contentValues.put(SETTING_NUM, settingnum);
        contentValues.put(DEVICE_TYPE, devicetype);
         contentValues.put(DEVICE_NUM, devicenum);
        contentValues.put(DATA, data);
        contentValues.put(STATUS, status);
         contentValues.put(MOOD_TYPE, aamood_type);

         db.update(TABLE_NAME, contentValues,COLUMN_NO +" = '"+ aanum + "'", null);
         Toast.makeText(context,"Updated successfully",Toast.LENGTH_LONG).show();
        return true;
    }

    public void delete(String aanum)  {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, COLUMN_NO+"=?", new String[] {aanum});
        Toast.makeText(context,"Deleted successfully",Toast.LENGTH_LONG).show();
        database.close();
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
        db.execSQL("UPDATE SQLITE_SEQUENCE SET seq = 0 WHERE NAME = '"+TABLE_NAME+"'");
        Toast.makeText(context,"Deleted all data successfully",Toast.LENGTH_LONG).show();

    }

    //getting data based on logintype
    public Cursor getData1(String mobil) {
       // mobil="'"+mobil+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME+" where MOOD_TYPE="+mobil, null );
        if (res != null)
            res.moveToFirst();

        return res;
    }


}
