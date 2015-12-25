package com.github.slmyldz.islib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

import is.Is;
import is.IsApplication;


public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.output);
        startTest();
    }



   


    public void startTest(){
        text.setText("");

        //application
        setText("isPackageInstalled : com.github.slmyldz.islib " + Is.application.isPackageInstalled("com.github.slmyldz.islib"));
        setText("getApplicationVersionNumber : =>" + Is.application.getApplicationVersionNumber());
        setText("getApplicationVersionCode : =>" + Is.application.getApplicationVersionCode());

        //basics
        setText("isValidCreditCard : 4521235486213215 " + Is.basic.isValidCreditCard("4521235486213215"));
        setText("isValidDomainName : www.google.com " + Is.basic.isValidDomainName("www.google.com"));
        setText("isValidEmail : slmyldz41@gmail.com " + Is.basic.isValidEmail("slmyldz41@gmail.com"));
        setText("isValidIPadress : 191.168.1.1 " + Is.basic.isValidIPadress("191.168.1.1"));
        setText("isValidPhone : +90 888 88 88 " + Is.basic.isValidPhone("+90 888 88 88"));
        setText("isValidURL : http://slmyldz.com " + Is.basic.isValidURL("http://slmyldz.com"));

        //location
        setText("isLocationEnabled : "+Is.location.isLocationEnabled());


        //network
        setText("isMobileDataEnabled : "+Is.network.isMobileDataEnabled());
        setText("isNetworkEnabled : " + Is.network.isNetworkEnabled());
        setText("getWifiState : "+ Is.network.getWifiState().name());

        //phone
        setText("isBrand : LG "+Is.phone.isBrand("LG"));
        try {
            setText("isLockScreenDisabled : "+Is.phone.isLockScreenDisabled());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setText("isPlugged : "+Is.phone.isPlugged());
        setText("checkBuildNumber : "+Is.phone.checkBuildNumber(15));
        setText("isTabletDevice : Activity " + Is.phone.isTabletDevice(this));
        setText("isAirplaneModeOpen : "+Is.phone.isAirplaneModeOpen());
        setText("getMaxMemory :  "+Is.phone.getMaxMemory());
        setText("getDeviceId : "+Is.phone.getDeviceId());

        //root
        setText("isRooted : "+Is.root.isRooted());

        //screen
        setText("isScreenLandscape : " + Is.screen.isScreenLandscape());
        setText("isScreenPortrait : " + Is.screen.isScreenPortrait());
        setText("isScreenSquare : " + Is.screen.isScreenSquare());
        setText("getScreenSizes : "+"w:"+Is.screen.getScreenSizes(this)[0]+" h:"+Is.screen.getScreenSizes(this)[1]);
        setText("getScreenBrightness : " + Is.screen.getScreenBrightness());
        setText("isScreenBrightnessModeAuto : " + Is.screen.isScreenBrightnessModeAuto());

        //service
        setText("isServiceRunning : com.android.vending " + Is.service.isServiceRunning("com.android.vending"));

        //sound
        setText("isMax : Sound "+Is.sound.isMax());
        setText("isMute : Sound "+Is.sound.isMute());
        setText("getMediaVolume : "+Is.sound.getMediaVolume());
        setText("getRingVolume : "+Is.sound.getRingVolume());

        //file
        setText("getAvailableSpaceInBytes : " + Is.file.getAvailableSpaceInBytes());
        setText("isSdCardMounted : " + Is.file.isSdCardMounted());
        setText("isFileExistsInSDCard : \"hello.txt\",\"/sdcard/\"" + Is.file.isFileExistsInSDCard("hello.txt", "/sdcard/"));

        //view
        setText("isVisible : text "+Is.view.isVisible(text));
        setText("isGone : text "+Is.view.isGone(text));

        //date
        setText("getCurrentDate : yyyy-MM-dd =>"+ Is.date.getCurrentDate("yyyy-MM-dd"));
        setText("isToday : yyyy-MM-dd =>"+ Is.date.isToday(new Date()));
        setText("isWeekday : yyyy-MM-dd =>"+ Is.date.isWeekday(new Date()));
        setText("isWeekend : yyyy-MM-dd =>"+ Is.date.isWeekend(new Date()));
        setText("getCurrentDateTimeStamp : yyyy-MM-dd =>"+ Is.date.getCurrentDateTimeStamp());
        setText("todayIsWeekday : yyyy-MM-dd =>"+ Is.date.todayIsWeekday());
        setText("todayIsWeekend : yyyy-MM-dd =>"+ Is.date.todayIsWeekend());



        transformToHtml();
    }

    public void setText(String output){
        int b =output.indexOf(':');
        output = "<b>"+output.substring(0,b)+"</b> => "+output.substring(b)+"<br>";
        text.setText(text.getText() + output + "\n");
    }

    public void transformToHtml(){
        text.setText(Html.fromHtml(text.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                startTest();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
