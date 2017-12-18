package edison.vidya.mood_setting;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import edison.vidya.mood_setting.dimmerExternalLibrary.ShaderSeekArc;
import static edison.vidya.mood_setting.DatabaseHelper.MOOD_TYPE;
import static edison.vidya.mood_setting.DatabaseHelper.TABLE_NAME;
import static edison.vidya.mood_setting.ListActivity.device_type;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG1 = "ShaderSeekArc";
    ShaderSeekArc seekArc;
    ImageView i;
    Button mood1,mood2,mood3,flash, fade, strobe, smooth,colorview,s1,s2,fan;
    TextView tvspeed;
    SeekBar brightness;
    View alertLayout;
    int color_bright;
    Object fsfs_speed, tvspeed1,color_fsfs;
    Integer rrr, ggg, bbb;
    private Button save,cancel,btopen,btstop,btclose,btopen_sheer,btclose_sheer,btopen_curtain,btclose_curtain;
    private String fsfs,rrrr,gggg,bbbb,data;
    private String aaanum,aaadevicenum,aaadevicename,aaaswitch1,aaamood_type;
    private Cursor mCursor;
    private int check2,check3;
    private String d4,cur_status,cur_type,aaadata,ac_data,pro_status,dimerval,two2;
    private Button ac_tb;
    private int dimer;
    DatabaseHelper db = null;
    static String mood_num,mood_type;
    Spinner  fan_speed;
    private String fanspeed;
    ArrayList<Object> bulbon;
    private String sone,stwo,num_switch,off_data,on_data,device_name,device_num,one,two;
    SQLiteDatabase dataBase;

    List ar_num_switch = new ArrayList();
    List ar_off_data = new ArrayList();
    List ar_on_data = new ArrayList();
    private ArrayList<String> anum = new ArrayList<String>();
    private ArrayList<String> ahousenum = new ArrayList<String>();
    private ArrayList<String> ahousename = new ArrayList<String>();
    private ArrayList<String> aroomnum = new ArrayList<String>();
    private ArrayList<String> adevicenum = new ArrayList<String>();
    private ArrayList<String> adevicename = new ArrayList<String>();
    private ArrayList<String> aswitch1 = new ArrayList<String>();
    private ArrayList<String> astatus = new ArrayList<String>();
    private ArrayList<String> adata = new ArrayList<String>();
    private ArrayList<String> amood_type = new ArrayList<String>();
    private String aaahousename,aaahousenum,aaaroomnum,aaastatus;
    private ArrayAdapter<String> adp2;
    private Button btn_hign,btn_medium,btn_low,mood_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(MainActivity.this);
        db.getWritableDatabase();

        mood1 = (Button) findViewById(R.id.mood1);
        mood2 = (Button) findViewById(R.id.mood2);
        mood3 = (Button) findViewById(R.id.mood3);

        if (device_type.equals("rgb")) {
            device_num="1";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "rmood1";
                    rgb();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "rmood2";
                    rgb();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "rmood3";
                    rgb();
                }
            });
        }
        else  if (device_type.equals("switch21")) {
            device_num="2";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "smood1";
                    switch21();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "smood2";
                    switch21();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "smood3";
                    switch21();
                }
            });
        }
        else  if (device_type.equals("switch51")) {
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "ssmood1";
                    switch51();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "ssmood2";
                    switch51();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "ssmood3";
                    switch51();
                }
            });
        }
        else  if (device_type.equals("dimmer")) {
            device_num="3";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dmood1";
                    dimmer();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dmood2";
                    dimmer();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dmood3";
                    dimmer();
                }
            });
        }

        else  if (device_type.equals("curtain")) {
            device_num="3";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "cmood1";
                    curtain();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "cmood2";
                    curtain();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "cmood3";
                    curtain();
                }
            });
        }
        else  if (device_type.equals("ac")) {
            device_num="4";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "acmood1";
                    ac();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "acmood2";
                    ac();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "acmood3";
                    ac();
                }
            });
        }
        else  if (device_type.equals("bell")) {
            device_num="5";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "bellmood1";
                    bell();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "bellmood2";
                    bell();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "bellmood3";
                    bell();
                }
            });
        }
        else  if (device_type.equals("dog")) {
            device_num="6";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dogmood1";
                    dog();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dogmood2";
                    dog();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dogmood3";
                    dog();
                }
            });
        }
        else  if (device_type.equals("geyser")) {
            device_num="7";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "geymood1";
                    geyser();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "geymood2";
                    geyser();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "geymood3";
                    geyser();
                }
            });
        }
        else  if (device_type.equals("sprinkler")) {
            device_num="8";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "sprimood1";
                    sprinkler();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "sprimood2";
                    sprinkler();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "sprimood3";
                    sprinkler();
                }
            });
        }
        else  if (device_type.equals("doorlock")) {
            device_num="9";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "dlckmood1";
                    doorlock();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "dlckmood2";
                    doorlock();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "dlckmood3";
                    doorlock();
                }
            });
        }
        else  if (device_type.equals("projector")) {
            device_num="10";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "promood1";
                    projector();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "promood2";
                    projector();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "promood3";
                    projector();
                }
            });
        }
        else  if (device_type.equals("pir")) {
            device_num="11";
            mood1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "1";
                    mood_type = "pirmood1";
                    pir();
                }
            });
            mood2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "2";
                    mood_type = "pirmood2";
                    pir();
                }
            });
            mood3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mood_num = "3";
                    mood_type = "pirmood3";
                    pir();
                }
            });
        }
    }
    private void pir() {
        device_name="PIR";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();

        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    switch (mood_num) {
                        case "1":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("pirmood1")) {
                                ac_status();
                            }
                            break;
                        case "2":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("pirmood2")) {
                                ac_status();
                            }
                            break;
                        case "3":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("pirmood3")) {
                                ac_status();
                            }
                            break;
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
        }
        else{

        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                Boolean rowExists;

                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void dimmer() {
        device_name="Dimmer";
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.dimmer_popup_moodlist, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

       // setings= (Button) findViewById(R.id.settings);
        seekArc= (ShaderSeekArc) alertLayout.findViewById(R.id.seek_arc);
        i= (ImageView) alertLayout.findViewById(R.id.image1);
        save = (Button) alertLayout.findViewById(R.id.save_dimmer);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
         btn_hign = (Button) alertLayout.findViewById(R.id.dimmer_high_brigtns);
         btn_low = (Button) alertLayout.findViewById(R.id.dimmer_low_brigtns);
         btn_medium = (Button) alertLayout.findViewById(R.id.dimmer_medium_brigtns);
         mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        i.setImageResource(R.drawable.b1);
        btn_hign.setOnClickListener(this);
        btn_low.setOnClickListener(this);
        btn_medium.setOnClickListener(this);
        mood_list.setOnClickListener(this);
        seekArc.setOnSeekArcChangeListener(new ShaderSeekArc.OnSeekArcChangeListener() {
            @Override
            public void onProgressChanged(ShaderSeekArc seekArc, float progress) {
                if (seekArc.getProgress() >= 1 && seekArc.getProgress() < 2) {
                    i.setImageResource(R.drawable.b1);
                    dimer = 3;
                }
                else if (seekArc.getProgress() >= 2 && seekArc.getProgress() < 3) {
                    i.setImageResource(R.drawable.b2);
                    dimer = 40;
                }
                else if (seekArc.getProgress() >= 3 && seekArc.getProgress() < 4) {
                    i.setImageResource(R.drawable.b3);
                    dimer = 75;
                }
                else  if (seekArc.getProgress() >= 4 && seekArc.getProgress() < 5) {
                    i.setImageResource(R.drawable.b4);
                    dimer = 103;
                }
                else  if (seekArc.getProgress() >= 5 && seekArc.getProgress() < 6) {
                    i.setImageResource(R.drawable.b5);
                    dimer = 140;
                }
                else if (seekArc.getProgress() >= 6 && seekArc.getProgress() < 7) {
                    i.setImageResource(R.drawable.b6);
                    dimer = 169;
                }
                else if (seekArc.getProgress() >= 7 && seekArc.getProgress() < 8) {
                    i.setImageResource(R.drawable.b7);
                    dimer = 180;
                }
                else if (seekArc.getProgress() >= 8 && seekArc.getProgress() <= 9) {
                    i.setImageResource(R.drawable.b8);
                    dimer = 200;
                }
                else if (seekArc.getProgress() >= 9 && seekArc.getProgress() <= 10) {
                    i.setImageResource(R.drawable.b9);
                    dimer = 255;
                }
                Log.d("TAG", "progress " + progress);
            }
            @Override
            public void onStartTrackingTouch(ShaderSeekArc seekArc) {
                Log.d("TAG", "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(ShaderSeekArc seekArc) {
                Log.d("TAG", "onStopTrackingTouch");
            }
        });
        ////////////
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    switch (mood_num) {
                        case "1":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood1")) {
                                dimmer_status();
                            }
                            break;
                        case "2":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood2")) {
                                dimmer_status();
                            }
                            break;
                        case "3":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dmood3")) {
                                dimmer_status();
                            }
                            break;
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{

        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                if (dimer > 0 && dimer < 9) {
                    dimerval = "00" + dimer;
                } else if (dimer > 9 && dimer < 99) {
                    dimerval = "0" + dimer;
                } else if (dimer > 99) {
                    dimerval = String.valueOf(dimer);
                }
                data = dimerval;
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
        }
        });
    }




    public void switch21() {

        device_name="Switch21";
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.mood_switch21, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.70);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        s1 = (Button) alertLayout.findViewById(R.id.s1);
        s2 = (Button) alertLayout.findViewById(R.id.s2);
        fan = (Button) alertLayout.findViewById(R.id.fan);
        fan_speed = (Spinner) alertLayout.findViewById(R.id.fan_speed);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        mood_list.setOnClickListener(this);
        s1.setTag(0);
        s2.setTag(0);
        fan.setTag(0);
        final String[] str = {"0", "1", "2", "3", "4", "5"};
         adp2 = new ArrayAdapter<>(alertLayout.getRootView().getContext(),android.R.layout.simple_spinner_item, str);
        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fan_speed.setAdapter(adp2);


        bulbon = new ArrayList<>();

///////////////////////////////////////////////////////////////
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       clear_arraylist();


        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    switch (mood_num) {
                        case "1":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood1")) {
                                switch21_status();
                            }
                            break;
                        case "2":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood2")) {
                                switch21_status();
                            }
                            break;
                        case "3":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("smood3")) {
                                switch21_status();
                            }
                            break;
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s1.getTag().equals(0)) {
                    s1.setBackgroundResource(R.drawable.bulb02);
                    s1.setTag(1);
                    sone="201";
                    bulbon.add(sone);
                } else {
                    s1.setBackgroundResource(R.drawable.bulb01);
                    s1.setTag(0);
                    bulbon.remove(sone);
                }
                Log.d("TAG", String.valueOf(bulbon));
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (s2.getTag().equals(0)) {
                    s2.setBackgroundResource(R.drawable.bulb02);
                    s2.setTag(1);
                    stwo="202";
                    bulbon.add(stwo);
                } else {
                    s2.setBackgroundResource(R.drawable.bulb01);
                    s2.setTag(0);
                    bulbon.remove(stwo);
                }
                Log.d("TAG", String.valueOf(bulbon));

            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fan.getTag().equals(0)) {
                    fan.setBackgroundResource(R.drawable.fan02);
                    fan.setTag(1);
                } else {
                    fan.setBackgroundResource(R.drawable.fan01);
                    fan.setTag(0);
                }
                Log.d("TAG", String.valueOf(bulbon));
            }
        });

        fan_speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                   fanspeed = String.valueOf(i);
                }
                else {
                    fanspeed = String.valueOf(i);
                    bulbon.add("71");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ar_num_switch.clear();
        ar_off_data.clear();
        ar_on_data.clear();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                if (bulbon != null && bulbon.size()>0) {
                    for (Object area : bulbon) {
                        if (area.equals("201")) {
                            off_data = "301";
                            ar_num_switch.add("1");
                            ar_off_data.add("001000000101" + off_data + "000000000000000");
                        } else if (area.equals("202")) {
                            off_data = "302";
                            ar_num_switch.add("2");
                            ar_off_data.add("001000000101" + off_data + "000000000000000");
                        } else if (area.equals("71")) {
                            if(ar_num_switch.contains("98")){
                                on_data = fanspeed;
                            }else {
                                off_data = "723";
                                on_data = fanspeed;
                                ar_num_switch.add("98");
                                ar_off_data.add("001000000101" + off_data + "000000000000000");
                            }
                        }
                    }
                    if (on_data != null) {
                        data = ar_num_switch + ";" + on_data;
                    } else {
                        on_data = "0";
                        data = ar_num_switch + ";" + on_data;
                    }
                    dataBase = db.getWritableDatabase();
                     mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                    mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                    Boolean rowExists;

                    if (mCursor.moveToFirst())
                    {
                        db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                    } else
                    {
                        if(data!=null) {
                            insert();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else {
                    Toast.makeText(view.getContext(), "Set operation", Toast.LENGTH_LONG).show();
                }
                dialog1.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();

            }
        });

    }

    private void switch21_status() {
         fetching_db_data();
        String ondat = String.valueOf(adata);
        String splitTime[] = ondat.split(";");
        one = splitTime[0];
        two = splitTime[1];
        String splitTime2[] = two.split("]");
        two2 = splitTime2[0];
        if ( one.contains("1"))
        {
            s1.setBackgroundResource(R.drawable.bulb02);
            s1.setTag(1);
            sone="201";
            bulbon.add(sone);
        }else{
            s1.setBackgroundResource(R.drawable.bulb01);
            s1.setTag(0);
        }
        if (one.contains("2"))
           {
            s2.setBackgroundResource(R.drawable.bulb02);
            s2.setTag(1);
            stwo="202";
            bulbon.add(stwo);
           }else
            {
                s2.setBackgroundResource(R.drawable.bulb01);
                s2.setTag(0);
            }
        if (one.contains("98"))
        {
            bulbon.add("71");
            fan_speed.setSelection(adp2.getPosition(String.valueOf(two2)));
            fan.setBackgroundResource(R.drawable.fan02);
        }
        else {
            fan.setBackgroundResource(R.drawable.fan01);
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void switch51() {
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.mood_switch51, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);

        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void rgb() {
                device_name="RGB";
                fsfs=null;rrrr=null;gggg=null;bbbb=null;fsfs_speed=null;
                final LayoutInflater inflater1 = getLayoutInflater();
                alertLayout = inflater1.inflate(R.layout.rgb_popup, null);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
                alert.setView(alertLayout);
                alert.setCancelable(true);
                final AlertDialog dialog1 = alert.create();
                dialog1.show();
                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.50);
                dialog1.getWindow().setLayout(width, height);
                dialog1.show();

                Button c1 = (Button) alertLayout.findViewById(R.id.c1);
                Button c2 = (Button) alertLayout.findViewById(R.id.c2);
                Button c3 = (Button) alertLayout.findViewById(R.id.c3);
                Button c4 = (Button) alertLayout.findViewById(R.id.c4);
                Button c5 = (Button) alertLayout.findViewById(R.id.c5);
                Button c6 = (Button) alertLayout.findViewById(R.id.c6);
                Button c7 = (Button) alertLayout.findViewById(R.id.c7);
                Button c8 = (Button) alertLayout.findViewById(R.id.c8);
                Button c9 = (Button) alertLayout.findViewById(R.id.c9);
                Button c10 = (Button) alertLayout.findViewById(R.id.c10);
                Button c11 = (Button) alertLayout.findViewById(R.id.c11);
                Button c12 = (Button) alertLayout.findViewById(R.id.c12);
                Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
                save = (Button) alertLayout.findViewById(R.id.save);
                cancel = (Button) alertLayout.findViewById(R.id.cancel);
                colorview = (Button) alertLayout.findViewById(R.id.colorview);
                final Button btup = (Button) alertLayout.findViewById(R.id.up);
                final Button btdown = (Button) alertLayout.findViewById(R.id.down);
                tvspeed = (TextView) alertLayout.findViewById(R.id.tvspeed);
                brightness = (SeekBar) alertLayout.findViewById(R.id.brightness);
                flash = (Button) alertLayout.findViewById(R.id.flash);
                strobe = (Button) alertLayout.findViewById(R.id.strobe);
                fade = (Button) alertLayout.findViewById(R.id.fade);
                smooth = (Button) alertLayout.findViewById(R.id.smooth);
                c1.setOnClickListener(this);
                c2.setOnClickListener(this);
                c3.setOnClickListener(this);
                c4.setOnClickListener(this);
                c5.setOnClickListener(this);
                c6.setOnClickListener(this);
                c7.setOnClickListener(this);
                c8.setOnClickListener(this);
                c9.setOnClickListener(this);
                c10.setOnClickListener(this);
                c11.setOnClickListener(this);
                c12.setOnClickListener(this);
                flash.setOnClickListener(this);
                strobe.setOnClickListener(this);
                fade.setOnClickListener(this);
                smooth.setOnClickListener(this);
                mood_list.setOnClickListener(this);


                brightness.setMax(10);

                brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        color_bright = 13+progress;
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });


                final int[] count = {0};
                btup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btup.setEnabled(true);
                        count[0]++;
                        if (count[0] == 0) {
                            tvspeed.setBackgroundResource(R.drawable.spzero);
                        } else if (count[0] == 1) {
                            tvspeed.setBackgroundResource(R.drawable.spone);

                            tvspeed.setTag(1);
                        } else if (count[0] == 2) {
                            tvspeed.setBackgroundResource(R.drawable.sptwo);
                            tvspeed.setTag(2);
                        } else if (count[0] == 3) {
                            tvspeed.setBackgroundResource(R.drawable.spthree);
                            tvspeed.setTag(3);
                        } else if (count[0] == 4) {
                            tvspeed.setBackgroundResource(R.drawable.spfour);
                            tvspeed.setTag(4);
                        } else if (count[0] == 5) {
                            tvspeed.setBackgroundResource(R.drawable.spfive);
                            tvspeed.setTag(5);
                        } else if (count[0] == 6) {
                            tvspeed.setBackgroundResource(R.drawable.spsix);
                            tvspeed.setTag(6);
                        } else if (count[0] == 7) {
                            tvspeed.setBackgroundResource(R.drawable.spseven);
                            tvspeed.setTag(7);
                        } else if (count[0] == 8) {
                            tvspeed.setBackgroundResource(R.drawable.speight);
                            tvspeed.setTag(8);
                        } else if (count[0] == 9) {
                            tvspeed.setBackgroundResource(R.drawable.spnine);
                            tvspeed.setTag(9);
                        } else if (count[0] == 10) {
                            tvspeed.setBackgroundResource(R.drawable.spten);
                            tvspeed.setTag(10);
                        } else if (count[0] == 11) {
                            btup.setEnabled(false);
                            count[0]--;
                        }
                        btup.setEnabled(true);
                    }
                });

                btdown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btdown.setEnabled(true);
                        count[0]--;
                        if (count[0] == -1) {
                            btdown.setEnabled(false);
                            count[0]++;
                        } else if (count[0] == 0) {
                            tvspeed.setBackgroundResource(R.drawable.spzero);
                            tvspeed.setTag(0);
                        } else if (count[0] == 1) {
                            tvspeed.setBackgroundResource(R.drawable.spone);
                            tvspeed.setTag(1);
                        } else if (count[0] == 2) {
                            tvspeed.setBackgroundResource(R.drawable.sptwo);
                            tvspeed.setTag(2);
                        } else if (count[0] == 3) {
                            tvspeed.setBackgroundResource(R.drawable.spthree);
                            tvspeed.setTag(3);
                        } else if (count[0] == 4) {
                            tvspeed.setBackgroundResource(R.drawable.spfour);
                            tvspeed.setTag(4);
                        } else if (count[0] == 5) {
                            tvspeed.setBackgroundResource(R.drawable.spfive);
                            tvspeed.setTag(5);
                        } else if (count[0] == 6) {
                            tvspeed.setBackgroundResource(R.drawable.spsix);
                            tvspeed.setTag(6);
                        } else if (count[0] == 7) {
                            tvspeed.setBackgroundResource(R.drawable.spseven);
                            tvspeed.setTag(7);
                        } else if (count[0] == 8) {
                            tvspeed.setBackgroundResource(R.drawable.speight);
                            tvspeed.setTag(8);
                        } else if (count[0] == 9) {
                            tvspeed.setBackgroundResource(R.drawable.spnine);
                            tvspeed.setTag(9);
                        } else if (count[0] == 10) {
                            tvspeed.setBackgroundResource(R.drawable.spten);
                            tvspeed.setTag(10);
                        }
                        btdown.setEnabled(true);
                    }

                });

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    switch (mood_num) {
                        case "1":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood1")) {
                                rgb_status();
                            }
                            break;
                        case "2":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood2")) {
                                rgb_status();
                            }
                            break;
                        case "3":
                            if (mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("rmood3")) {
                                rgb_status();
                            }
                            break;
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{

        }
               cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                        db2.getWritableDatabase();
                        CharSequence z = colorview.getText();
                        if (z.equals("")) {
                            fsfs_speed ="000";
                            int color ;
                            Drawable background = colorview.getBackground();
                            if (background instanceof ColorDrawable) {
                                color = ((ColorDrawable) background).getColor();
                                Integer intColor = color;
                                String hexColor = "#" + Integer.toHexString(intColor).substring(2);
                                rrr = Integer.valueOf(hexColor.substring(1, 3), 16);
                                ggg = Integer.valueOf(hexColor.substring(3, 5), 16);
                                bbb = Integer.valueOf(hexColor.substring(5, 7), 16);
                                if(rrr<=9) {
                                    rrrr = "00" + rrr;
                                }
                                else if(rrr>9 && rrr<=99)
                                {
                                    rrrr= "0"+rrr;
                                }
                                else {
                                    rrrr= String.valueOf(rrr);
                                }
                                if(ggg<=9)
                                {
                                    gggg= "00"+ggg;
                                }
                                else if(ggg>9 && ggg<=99)
                                {
                                    gggg="0"+ggg;
                                }
                                else {
                                    gggg= String.valueOf(ggg);
                                }
                                if(bbb<=9)
                                {
                                    bbbb= "00"+bbb;
                                }
                                else if(bbb>9 && bbb<=99)
                                {
                                    bbbb="0"+bbb;
                                }
                                else {
                                    bbbb= String.valueOf(bbb);
                                }
                                color_fsfs = "112";
                                int m = brightness.getProgress();
                                color_bright = Integer.parseInt("13"+m);
                            }
                            fsfs="0";
                            data= fsfs +","+ rrrr+","+ gggg+"," + bbbb+";"+fsfs_speed+";"+color_bright;
                            dataBase = db.getWritableDatabase();
                            mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                            mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                            if (mCursor.moveToFirst())
                            {
                                db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                            } else
                            {
                                if(data!=null&&fsfs!=null&&color_bright>0&&fsfs_speed!=null&&rrrr!=null&&gggg!=null&&bbbb!=null) {
                                insert();
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                            }
                            }
                        } else {
                            CharSequence fs = colorview.getText();
                            if (fs.equals("FLASH")) {
                                fsfs = "104";
                            } else if (fs.equals("STROBE")) {
                                fsfs = "105";
                            } else if (fs.equals("FADE")) {
                                fsfs = "106";
                            } else if (fs.equals("SMOOTH")) {
                                fsfs = "107";
                            }
                            else{
                                fsfs = "0";
                            }
                            color_fsfs = fsfs;
                            rrrr = "0";
                            gggg = "0";
                            bbbb = "0";
                            int m = brightness.getProgress();
                            color_bright = Integer.parseInt("13"+m);
                            tvspeed1 = tvspeed.getTag();
                            if(tvspeed1!=null)
                            {
                                fsfs_speed ="12"+tvspeed1;
                            }
                            else {
                                fsfs_speed = "000";
                            }
                            data= fsfs +","+ rrrr+","+ gggg+"," + bbbb+";"+fsfs_speed+";"+color_bright;
                            dataBase = db.getWritableDatabase();
                            mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                            mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                            Boolean rowExists;

                            if (mCursor.moveToFirst())
                            {
                                db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                            } else
                            {
                                if(data!=null&&fsfs!=null&&fsfs_speed!=null) {
                                    insert();
                                }
                                else{
                                    Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                        dialog1.dismiss();
                    }
                });

    }


    private void dimmer_status() {

        fetching_db_data();
        String ondat = String.valueOf(adata);
        String s = mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));
        int s11= Integer.parseInt(s);
        if(s11>0&&s11<=25){
            i.setImageResource(R.drawable.b1);
            seekArc.setProgress(1);

        }else   if(s11>25&&s11<=50){
            i.setImageResource(R.drawable.b2);
            seekArc.setProgress(2);
        }else   if(s11>50&&s11<=100){
            i.setImageResource(R.drawable.b3);
            seekArc.setProgress(3);
        }else   if(s11>100&&s11<=125){
            i.setImageResource(R.drawable.b4);
            seekArc.setProgress(4);
        }else   if(s11>125&&s11<=150){
            i.setImageResource(R.drawable.b5);
            seekArc.setProgress(5);
        }else   if(s11>150&&s11<=175){
            i.setImageResource(R.drawable.b6);
            seekArc.setProgress(6);
        }else   if(s11>175&&s11<=200){
            i.setImageResource(R.drawable.b7);
            seekArc.setProgress(7);
        }else   if(s11>200&&s11<=225){
            i.setImageResource(R.drawable.b8);
            seekArc.setProgress(8);
        }else   if(s11>225&&s11<=255){
            i.setImageResource(R.drawable.b9);
            seekArc.setProgress(9);
        }

    }
    private void rgb_status() {
     fetching_db_data();
        String ondat = String.valueOf(adata);
        String [] d = ondat.split("(\\[)|(\\])");
        one = d[1];
        String d2[] = one.split(";");
        two = d2[0];
        two2 = d2[1];
        String two3 = d2[2];
        String d3[] = two.split(",");
         d4=d3[0];
        String rr = d3[1];
        String gg = d3[2];
        String bb = d3[3];

        check2 = Integer.parseInt(two2);
        if (check2 >= 121 && check2 <= 130) {
            speed();
        }

        check3 = Integer.parseInt(two3);
        if (check3 >= 131 && check2 <= 130) {
            brightness();
        }

        if (d4.equals("0")) {
            int r = Integer.parseInt(rr);
            int g = Integer.parseInt(gg);
            int b = Integer.parseInt(bb);
            colorview.setBackgroundColor(Color.rgb(r, g, b));

        } else {
            flashfadesmooth();
        }

    }

    void brightness()
    {
        brightness.setMax(10);
        if(check3==131)
        {
            brightness.setProgress(1);

        }
        else if(check3==132)
        {
            brightness.setProgress(2);

        }
        else if(check3==133)
        {
            brightness.setProgress(3);
        }
        else if(check3==134)
        {
            brightness.setProgress(4);
        }
        else if(check3==135)
        {
            brightness.setProgress(5);
        }
        else if(check3==136)
        {
            brightness.setProgress(6);
        }
        else if(check3==137)
        {
            brightness.setProgress(7);
        }
        else if(check3==138)
        {
            brightness.setProgress(8);
        }
        else if(check3==139)
        {
            brightness.setProgress(9);
        }
        else if(check3==140)
        {
            brightness.setProgress(10);
        }
        else
        {
            brightness.setProgress(0);
        }

    }
    void speed()
    {
        if(check2==121)
        {
            tvspeed.setBackgroundResource(R.drawable.spone);
        }
        else if(check2==122)
        {
            tvspeed.setBackgroundResource(R.drawable.sptwo);
        }
        else if(check2==123)
        {
            tvspeed.setBackgroundResource(R.drawable.spthree);
        }
        else if(check2==124)
        {
            tvspeed.setBackgroundResource(R.drawable.spfour);
        }
        else if(check2==125)
        {
            tvspeed.setBackgroundResource(R.drawable.spfive);
        }
        else if(check2==126)
        {
            tvspeed.setBackgroundResource(R.drawable.spsix);
        }
        else if(check2==127)
        {
            tvspeed.setBackgroundResource(R.drawable.spseven);
        }
        else if(check2==128)
        {
            tvspeed.setBackgroundResource(R.drawable.speight);
        }
        else if(check2==129)
        {
            tvspeed.setBackgroundResource(R.drawable.spnine);
        }
        else if(check2==130)
        {
            tvspeed.setBackgroundResource(R.drawable.spten);
        }
        else
        {
            tvspeed.setBackgroundResource(R.drawable.spzero);
        }

    }

    void  flashfadesmooth() {
        switch (d4) {
            case "104": {
                colorview.setText("FLASH");
                break;
            }
            case "105":
                colorview.setText("STROBE");
                break;
            case "106":
                colorview.setText("FADE");
                break;
            case "107": {
                colorview.setText("SMOOTH");
                break;
            }
        }
    }
    private void insert() {
        db.insertPlate("1", "abcd","1",mood_num, device_name,device_num,"ON",data,mood_type);
    }
    private void curtain() {
        device_name="Curtain";
        cur_status=null;
        cur_type=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.curtain_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.80);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.45);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        btopen = (Button) alertLayout.findViewById(R.id.btopen);
        btclose = (Button) alertLayout.findViewById(R.id.btclose);
        btstop = (Button) alertLayout.findViewById(R.id.btstop);
        btopen_sheer = (Button) alertLayout.findViewById(R.id.btopen_sheer);
        btclose_sheer = (Button) alertLayout.findViewById(R.id.btclose_sheer);
        Button btstop_sheer = (Button) alertLayout.findViewById(R.id.btstop_sheer);

        btopen_curtain = (Button) alertLayout.findViewById(R.id.btopen_curtain);
        btclose_curtain = (Button) alertLayout.findViewById(R.id.btclose_curtain);
        Button btstop_curtain = (Button) alertLayout.findViewById(R.id.btstop_curtain);
        mood_list.setOnClickListener(this);
        btopen.setTag(0);
        btclose.setTag(0);
        btstop.setTag(0);

        btopen_sheer.setTag(0);
        btclose_sheer.setTag(0);
        btstop_sheer.setTag(0);

        btopen_curtain.setTag(0);
        btclose_curtain.setTag(0);
        btstop_curtain.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood1")) {
                            curtain_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood2")) {
                            curtain_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("cmood3")) {
                            curtain_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{

        }

        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="101";
                    cur_type="ALL";
                } else {
                    btopen.setBackgroundResource(R.drawable.open);
                    cur_status="";
                    cur_type="";
                }
            }
        });

        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose.setBackgroundResource(R.drawable.close01);
                    btopen.setBackgroundResource(R.drawable.open);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="102";
                    cur_type="ALL";
                } else {
                    btclose.setBackgroundResource(R.drawable.close);
                    cur_status="";
                    cur_type="";
                }
            }
        });

        btopen_sheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen_sheer.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="101";
                    cur_type="CLR";

                } else {
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    cur_status="";
                    cur_type="";
                }
            }
        });
        btclose_sheer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose_sheer.setBackgroundResource(R.drawable.close01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btopen.setBackgroundResource(R.drawable.open);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="102";
                    cur_type="CLR";

                } else {
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    cur_status="";
                    cur_type="";
                }
            }
        });

        btopen_curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen_curtain.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen.setBackgroundResource(R.drawable.open);
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="101";
                    cur_type="CC";
                } else {
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    cur_status="";
                    cur_type="";
                }
            }
        });
        btclose_curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose_curtain.setBackgroundResource(R.drawable.close01);
                    btclose.setBackgroundResource(R.drawable.close);
                    btopen_sheer.setBackgroundResource(R.drawable.open);
                    btclose_sheer.setBackgroundResource(R.drawable.close);
                    btopen_curtain.setBackgroundResource(R.drawable.open);
                    btopen.setBackgroundResource(R.drawable.open);
                    cur_status="102";
                    cur_type="CC";
                } else {
                    btclose_curtain.setBackgroundResource(R.drawable.close);
                    cur_status="";
                    cur_type="";
                }
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= cur_status +";"+ cur_type;
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                Boolean rowExists;

                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&cur_status!=null&&cur_type!=null ) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });


    }

    private void curtain_status() {
        fetching_db_data2();
        String ondat = aaadata;
        String splitTime[] = ondat.split(";");
        String curtain_status = splitTime[0];
        String curtain_type = splitTime[1];
        //int a = one.length();
        if(curtain_type.equals("ALL")&& curtain_status.equals("101"))
        {
            btopen.setBackgroundResource(R.drawable.open01);
            cur_status="101";
            cur_type="ALL";
        }
        else if(curtain_type.equals("ALL")&& curtain_status.equals("102"))
        {
            btclose.setBackgroundResource(R.drawable.close01);
            cur_status="102";
            cur_type="ALL";
        }
        else if(curtain_type.equals("CLR")&& curtain_status.equals("101"))
        {
            btopen_sheer.setBackgroundResource(R.drawable.open01);
            cur_status="101";
            cur_type="CLR";
        }
        else if(curtain_type.equals("CLR")&& curtain_status.equals("102"))
        {
            btclose_sheer.setBackgroundResource(R.drawable.close01);
            cur_status="102";
            cur_type="CLR";
        }
        else if(curtain_type.equals("CC")&& curtain_status.equals("101"))
        {
            btopen_curtain.setBackgroundResource(R.drawable.open01);
            cur_status="101";
            cur_type="CC";
        }
        else if(curtain_type.equals("CC")&& curtain_status.equals("102"))
        {
            btclose_curtain.setBackgroundResource(R.drawable.close01);
            cur_status="102";
            cur_type="CC";
        }
    }





    /////////////////////////////////////////////////////////////////////////////////////////////////////

    private void ac() {
        device_name="AC";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("acmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{

        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void ac_status() {
        fetching_db_data2();
        String ondat = aaadata;
        if(ondat.equals("201"))
        {ac_tb.setBackgroundResource(R.drawable.on);
            ac_data="201";
            ac_tb.setTag(1);
        }
        else if(ondat.equals("301"))
        {
            ac_tb.setBackgroundResource(R.drawable.off);
            ac_data="301";
            ac_tb.setTag(0);
        }
    }

    private void fetching_db_data2() {
        aaanum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        aaahousenum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        aaahousename=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        aaaroomnum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        aaadevicename=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        aaadevicenum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        aaaswitch1=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        aaastatus=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        aaadata=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA));
        aaamood_type=mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));

    }

    private void bell() {
        device_name="BELL";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("bellmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                dataBase = db.getWritableDatabase();
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });

    }
    private void dog() {
        device_name="DOG";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        mood_list.setOnClickListener(this);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        ac_tb.setTag(0);
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dogmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                dataBase = db.getWritableDatabase();
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void geyser() {
        device_name="GEYSER";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       clear_arraylist();

        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("geymood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                Boolean rowExists;

                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void sprinkler() {
        device_name="Sprinkler";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("sprimood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                dataBase = db.getWritableDatabase();
                  mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void doorlock() {
        device_name="Doorlock";
        ac_data=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.onoff_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        ac_tb = (Button) alertLayout.findViewById(R.id.ac_tb);
        mood_list.setOnClickListener(this);
        ac_tb.setTag(0);

        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
       clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                //mCursor.moveToFirst();
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood1")) {
                            ac_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood2")) {
                            ac_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("dlckmood3")) {
                            ac_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        ac_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ac_tb.getTag().equals(0)) {
                    ac_tb.setBackgroundResource(R.drawable.on);
                    ac_data="201";
                    ac_tb.setTag(1);
                } else {
                    ac_tb.setBackgroundResource(R.drawable.off);
                    ac_data="301";
                    ac_tb.setTag(0);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= ac_data;
                // insert();
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                Boolean rowExists;

                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null&&ac_data!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }

    private void projector() {
        device_name="Projector";
        pro_status=null;
        final LayoutInflater inflater1 = getLayoutInflater();
        alertLayout = inflater1.inflate(R.layout.projector_popup, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this, R.style.MyDialogTheme1);
        alert.setView(alertLayout);
        alert.setCancelable(true);
        final AlertDialog dialog1 = alert.create();
        dialog1.show();
        int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.60);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
        dialog1.getWindow().setLayout(width, height);
        dialog1.show();
        Button mood_list = (Button) alertLayout.findViewById(R.id.mood_list);
        save = (Button) alertLayout.findViewById(R.id.save);
        cancel = (Button) alertLayout.findViewById(R.id.cancel);
        btopen = (Button) alertLayout.findViewById(R.id.btopen);
        btclose = (Button) alertLayout.findViewById(R.id.btclose);
        btstop = (Button) alertLayout.findViewById(R.id.btstop);
        mood_list.setOnClickListener(this);
        btopen.setTag(0);
        btclose.setTag(0);
        btstop.setTag(0);
        dataBase = db.getWritableDatabase();
        //the SQL command to fetched all records from the table
        mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        clear_arraylist();
        if(mCursor.getCount() > 0) {
            //fetch each record
            if (mCursor.moveToFirst()) {
                do {
                    if (mood_num.equals("1")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood1")) {
                            proj_status();
                        }
                    }
                    else  if (mood_num.equals("2")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood2")) {
                            proj_status();
                        }
                    }
                    else if (mood_num.equals("3")) {
                        if(mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE)).equals("promood3")) {
                            proj_status();
                        }
                    }
                } while (mCursor.moveToNext());
                db.close();
            }
            //do above till data exhausted
            mCursor.close();
            //  }
        }
        else{
        }
        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btopen.setBackgroundResource(R.drawable.open01);
                    btclose.setBackgroundResource(R.drawable.close);
                    pro_status="101";
                } else {
                    btopen.setBackgroundResource(R.drawable.open);
                    pro_status="";
                }
            }
        });
        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(0)) {
                    btclose.setBackgroundResource(R.drawable.close01);

                    btopen.setBackgroundResource(R.drawable.open);
                    pro_status="102";

                } else {
                    btclose.setBackgroundResource(R.drawable.close);
                    pro_status="";

                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db2 = new DatabaseHelper(view.getContext());
                db2.getWritableDatabase();
                data= pro_status;
                dataBase = db.getWritableDatabase();
                mCursor = dataBase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
                mCursor=dataBase.rawQuery("SELECT * FROM MoodSetTable WHERE MOOD_TYPE='"+mood_type+"'" , null);
                if (mCursor.moveToFirst())
                {
                    db2.updateData(aaanum, "1", "abcd", "1", aaaswitch1, aaadevicename, aaadevicenum, "ON", data, aaamood_type);
                } else
                {
                    if(data!=null && pro_status!=null) {
                        insert();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Please set data",Toast.LENGTH_LONG).show();
                    }
                }
                dialog1.dismiss();
            }
        });
    }
    private void proj_status() {
        fetching_db_data2();
        String ondat = aaadata;
        if(ondat.equals("101"))
        {
            btopen.setBackgroundResource(R.drawable.open01);
            pro_status="101";
        }
        else if(ondat.equals("102"))
        {
            btclose.setBackgroundResource(R.drawable.close01);
            pro_status="102";
        }
    }
    private void clear_arraylist() {
        anum.clear();
        ahousenum.clear();
        ahousename.clear();
        aroomnum.clear();
        adevicename.clear();
        adevicenum.clear();
        aswitch1.clear();
        astatus.clear();
        adata.clear();
        amood_type.clear();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.c1:
                colorview.setBackgroundColor(Color.parseColor("#F9F600"));
                colorview.setText("");
                break;
            case R.id.c2:
                colorview.setBackgroundColor(Color.parseColor("#FEBE50"));
                colorview.setText("");
                break;
            case R.id.c3:
                colorview.setBackgroundColor(Color.parseColor("#F7913C"));
                colorview.setText("");
                break;
            case R.id.c4:
                colorview.setBackgroundColor(Color.parseColor("#F3703C"));
                colorview.setText("");
                break;
            case R.id.c5:
                colorview.setBackgroundColor(Color.parseColor("#EA1D24"));
                colorview.setText("");
                break;
            case R.id.c6:
                colorview.setBackgroundColor(Color.parseColor("#9F0064"));
                colorview.setText("");
                break;
            case R.id.c7:
                colorview.setBackgroundColor(Color.parseColor("#892891"));
                colorview.setText("");
                break;
            case R.id.c8:
                colorview.setBackgroundColor(Color.parseColor("#5F6EB3"));
                colorview.setText("");
                break;
            case R.id.c9:
                colorview.setBackgroundColor(Color.parseColor("#0293D4"));
                colorview.setText("");
                break;
            case R.id.c10:
                colorview.setBackgroundColor(Color.parseColor("#009F8B"));
                colorview.setText("");
                break;
            case R.id.c11:
                colorview.setBackgroundColor(Color.parseColor("#51B747"));
                colorview.setText("");
                break;
            case R.id.c12:
                colorview.setBackgroundColor(Color.parseColor("#FFFFFF"));
                colorview.setText("");
                break;
            case R.id.flash:
                colorview.setText("FLASH");
                colorview.setBackgroundResource(R.drawable.indicator_background);
                break;
            case R.id.strobe:
                colorview.setText("STROBE");
                colorview.setBackgroundResource(R.drawable.indicator_background);
                break;
            case R.id.fade:
                colorview.setText("FADE");
                colorview.setBackgroundResource(R.drawable.indicator_background);
                break;
            case R.id.smooth:
                colorview.setText("SMOOTH");
                colorview.setBackgroundResource(R.drawable.indicator_background);
                break;
            case R.id.mood_list:
                Intent i1 = new Intent(MainActivity.this, DisplayList.class);
                startActivity(i1);
                finish();
                break;
            case R.id.dimmer_high_brigtns:
                i.setImageResource(R.drawable.b9);
                dimer = 255;
                break;
            case R.id.dimmer_low_brigtns:
                i.setImageResource(R.drawable.b1);
                dimer = 3;
                break;
            case R.id.dimmer_medium_brigtns:
                i.setImageResource(R.drawable.b3);
                dimer = 40;
                break;
        }
    }
    private void fetching_db_data() {
        //get data from field
        aaanum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_NO));
        aaahousenum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NUM));
        aaahousename=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.HOUSE_NAME));
        aaaroomnum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.ROOM_NUM));
        aaadevicename=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_TYPE));
        aaadevicenum=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DEVICE_NUM));
        aaaswitch1=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.SETTING_NUM));
        aaastatus=mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.STATUS));
        adata.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.DATA)));
        aaamood_type=mCursor.getString(mCursor.getColumnIndex(MOOD_TYPE));
    }
}



