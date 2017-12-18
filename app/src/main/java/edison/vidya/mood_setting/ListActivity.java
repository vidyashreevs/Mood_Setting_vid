package edison.vidya.mood_setting;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;


public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox cb_rgb, cb_switch21,cb_switch51,cb_dimmer,cb_curtain,cb_projector,cb_pir,cb_bell,cb_dog,cb_geyser,cb_sprinkler,cb_ac,cb_doorlock;
    static String device_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_list);
        cb_rgb = (CheckBox) findViewById(R.id.cb_rgb);
        cb_switch21 = (CheckBox) findViewById(R.id.cb_switch21);
        cb_switch51 = (CheckBox) findViewById(R.id.cb_switch51);
        cb_dimmer = (CheckBox) findViewById(R.id.cb_dimmer);
        cb_curtain= (CheckBox) findViewById(R.id.cb_curtain);
        cb_projector= (CheckBox) findViewById(R.id.cb_projector);
        cb_pir= (CheckBox) findViewById(R.id.cb_pir);
        cb_bell= (CheckBox) findViewById(R.id.cb_bell);
        cb_dog= (CheckBox) findViewById(R.id.cb_dog);
        cb_geyser= (CheckBox) findViewById(R.id.cb_geyser);
        cb_sprinkler= (CheckBox) findViewById(R.id.cb_sprinkler);
        cb_ac= (CheckBox) findViewById(R.id.cb_ac);
        cb_doorlock= (CheckBox) findViewById(R.id.cb_doorlock);


        cb_switch21.setOnClickListener(this);
        cb_switch51.setOnClickListener(this);
        cb_rgb.setOnClickListener(this);
        cb_dimmer.setOnClickListener(this);
        cb_curtain.setOnClickListener(this);
        cb_ac.setOnClickListener(this);

        cb_bell.setOnClickListener(this);
        cb_dog.setOnClickListener(this);
        cb_geyser.setOnClickListener(this);
        cb_sprinkler.setOnClickListener(this);
        cb_doorlock.setOnClickListener(this);
        cb_projector.setOnClickListener(this);
        cb_pir.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view == cb_rgb) {
            if (cb_rgb.isChecked()) {
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                device_type = "rgb";
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);

            } else {
                cb_rgb.setChecked(false);
            }
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (view == cb_switch21) {

            if (cb_switch21.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "switch21";
            } else {
                cb_switch21.setChecked(false);
            }
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (view == cb_switch51) {
            if (cb_switch51.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "switch51";
            } else {
                cb_switch51.setChecked(false);
            }
        } else if (view == cb_dimmer) {
            if (cb_dimmer.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch21.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "dimmer";
            } else {
                cb_dimmer.setChecked(false);
            }
        } else if (view == cb_curtain) {
            if (cb_curtain.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "curtain";
            } else {
                cb_curtain.setChecked(false);
            }
        } else if (view == cb_ac) {
            if (cb_ac.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "ac";
            } else {
                cb_ac.setChecked(false);
            }
        } else if (view == cb_bell) {
            if (cb_bell.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "bell";
            } else {
                cb_bell.setChecked(false);
            }
        } else if (view == cb_dog) {
            if (cb_dog.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_bell.setChecked(false);
                cb_geyser.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "dog";
            } else {
                cb_dog.setChecked(false);
            }
        } else if (view == cb_geyser) {
            if (cb_geyser.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_bell.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "geyser";
            } else {
                cb_geyser.setChecked(false);
            }
        } else if (view == cb_sprinkler) {
            if (cb_sprinkler.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_bell.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "sprinkler";
            } else {
                cb_sprinkler.setChecked(false);
            }
        } else if (view == cb_doorlock) {
            if (cb_doorlock.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_bell.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_projector.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "doorlock";
            } else {
                cb_doorlock.setChecked(false);
            }
        } else if (view == cb_projector) {
            if (cb_projector.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_bell.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_pir.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "projector";
            } else {
                cb_projector.setChecked(false);
            }
        } else if (view == cb_pir) {
            if (cb_pir.isChecked()) {
                cb_rgb.setChecked(false);
                cb_switch21.setChecked(false);
                cb_switch51.setChecked(false);
                cb_dimmer.setChecked(false);
                cb_curtain.setChecked(false);
                cb_ac.setChecked(false);
                cb_dog.setChecked(false);
                cb_geyser.setChecked(false);
                cb_bell.setChecked(false);
                cb_sprinkler.setChecked(false);
                cb_doorlock.setChecked(false);
                cb_projector.setChecked(false);
                Intent i = new Intent(ListActivity.this, MainActivity.class);
                startActivity(i);
                device_type = "pir";
            } else {
                cb_pir.setChecked(false);
            }
        }
        }
    }




