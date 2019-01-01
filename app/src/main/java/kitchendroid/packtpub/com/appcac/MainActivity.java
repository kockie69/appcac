package kitchendroid.packtpub.com.appcac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.util.Log;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends AppCompatActivity {
    public static boolean restartNetThread = false;
    public static boolean reloadPrefs = false;
    public static Context context;
    public static String version = "Unknown";
    public static String id = "Unknown";
    public NetThread netThread = null;
    public Context activity;
    public static Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10;
    public static ImageView led1,led2, led3, led4, led5, led6, led7, led8,led9,led10,led11;
    public static int SwitchesAudioL, ReceiverSelL;
    public static int ledNr;
    public static int[] intArray = new int[13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        led1 = (ImageView) findViewById(R.id.led1);
        led1.setBackgroundResource(R.drawable.ledoff);

        led2 = (ImageView) findViewById(R.id.led2);
        led2.setBackgroundResource(R.drawable.ledoff);

        led3 = (ImageView) findViewById(R.id.led3);
        led3.setBackgroundResource(R.drawable.ledoff);

        led4 = (ImageView) findViewById(R.id.led4);
        led4.setBackgroundResource(R.drawable.ledoff);

        led5 = (ImageView) findViewById(R.id.led5);
        led5.setBackgroundResource(R.drawable.ledoff);

        led6 = (ImageView) findViewById(R.id.led6);
        led6.setBackgroundResource(R.drawable.ledoff);

        led7 = (ImageView) findViewById(R.id.led7);
        led7.setBackgroundResource(R.drawable.ledoff);

        led8 = (ImageView) findViewById(R.id.led8);
        led8.setBackgroundResource(R.drawable.ledoff);

        led9 = (ImageView) findViewById(R.id.led9);
        led9.setBackgroundResource(R.drawable.ledoff);

        led10 = (ImageView) findViewById(R.id.led10);
        led10.setBackgroundResource(R.drawable.ledoff);

        led11 = (ImageView) findViewById(R.id.led11);
        led11.setBackgroundResource(R.drawable.ledoff);

        Button volumeBtn1 = (Button) findViewById(R.id.volumebtn1);
        volumeBtn1.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn1");
                sendPsxMessage("Qh410=10");
            }
        });

        Button volumeBtn2 = (Button) findViewById(R.id.volumebtn2);
        volumeBtn2.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn2");
                sendPsxMessage("Qh410=11");
            }
        });


        Button volumeBtn3 = (Button) findViewById(R.id.volumebtn3);
        volumeBtn3.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn3");
                sendPsxMessage("Qh410=12");
            }
        });


        Button volumeBtn4 = (Button) findViewById(R.id.volumebtn4);
        volumeBtn4.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn4");
                sendPsxMessage("Qh410=13");
            }
        });


        Button volumeBtn5 = (Button) findViewById(R.id.volumebtn5);
        volumeBtn5.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn5");
                sendPsxMessage("Qh410=14");
            }
        });


        Button volumeBtn6 = (Button) findViewById(R.id.volumebtn6);
        volumeBtn6.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn6");
                sendPsxMessage("Qh410=15");
            }
        });


        Button volumeBtn7 = (Button) findViewById(R.id.volumebtn7);
        volumeBtn7.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn7");
                sendPsxMessage("Qh410=16");
            }
        });


        Button volumeBtn8 = (Button) findViewById(R.id.volumebtn8);
        volumeBtn8.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn8");
                sendPsxMessage("Qh410=17");
            }
        });


        Button volumeBtn9 = (Button) findViewById(R.id.volumebtn9);
        volumeBtn9.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn9");
                sendPsxMessage("Qh410=20");
            }
        });


        Button volumeBtn10 = (Button) findViewById(R.id.volumebtn10);
        volumeBtn10.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn10");
                sendPsxMessage("Qh410=21");
            }
        });


        Button volumeBtn11 = (Button) findViewById(R.id.volumebtn11);
        volumeBtn11.setBackgroundResource(R.drawable.volumebtn);
        volumeBtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "volumebtn11");
                sendPsxMessage("Qh410=22");
            }
        });


        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button1");
                sendPsxMessage("Qh410=0");
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button2");
                sendPsxMessage("Qh410=1");
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button3");
                sendPsxMessage("Qh410=2");
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button4");
                sendPsxMessage("Qh410=3");
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button5");
                sendPsxMessage("Qh410=4");
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button6");
                sendPsxMessage("Qh410=5");
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button7");
                sendPsxMessage("Qh410=6");
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button8");
                sendPsxMessage("Qh410=7");
            }
        });

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button9");
                sendPsxMessage("Qh410=8");
            }
        });

        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("UI thread", "Button10");
                sendPsxMessage("Qh410=9");
            }
        });

        context = getApplicationContext();
        Settings settings = new Settings(context);
        settings.loadPref();

        activity = MainActivity.this;

        if (netThread == null) {
            netThread = new NetThread(settings.host, settings.port, activity);
            netThread.start();
        } else {
            System.out.println("NetThread not null");
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        String message;

        if (MotionEventCompat.getActionMasked(event) == ACTION_DOWN) {
            ImageView iv = (ImageView) findViewById(R.id.imagebg);
            message = Keyboard.getMessage(event, iv);
            Log.e("Message", message);
            if (message.contentEquals("Qh410=options")) showUserSettings();
            NetThread.sendToServer(message);
        }
        if (MotionEventCompat.getActionMasked(event) == ACTION_UP) {
            message="Qh410=-1";
            Log.e("Message", message);
            NetThread.sendToServer(message);
        }

        return super.onTouchEvent(event);
    }


     public void sendPsxMessage(String message) {

        Log.e("Message", message);
        NetThread.sendToServer(message);

    }

    private void showUserSettings() {
        Log.e("showUserSettings", "Start showUserSettings ");

        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

}


