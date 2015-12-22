package com.github.slmyldz.islib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

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



    Is getIs(){
       return  ((IsApplication)getApplication()).getIs();
    }


    public void startTest(){
        text.setText("");
        setText("isPackageInstalled : com.github.slmyldz.islib => " + getIs().getApplications().isPackageInstalled("com.github.slmyldz.islib"));
        setText("isValidCreditCard : 4521235486213215 => " + getIs().getBasics().isValidCreditCard("4521235486213215"));
        setText("isValidDomainName : www.google.com => " + getIs().getBasics().isValidDomainName("www.google.com"));
        setText("isValidEmail : slmyldz41@gmail.com => " + getIs().getBasics().isValidEmail("slmyldz41@gmail.com"));
        setText("isValidIPadress : 191.168.1.1 => " + getIs().getBasics().isValidIPadress("191.168.1.1"));
        setText("isValidPhone : +90 888 88 88 => "+getIs().getBasics().isValidPhone("+90 888 88 88"));
        setText("isValidURL : http://slmyldz.com => "+getIs().getBasics().isValidURL("http://slmyldz.com"));
        //setText("isKeyboardVisible : => "+getIs().getKeyboard().isKeyboardVisible());
        setText("isLocationEnabled : => "+getIs().getLocations().isLocationEnabled());
        setText("isMobileDataEnabled : => "+getIs().getNetwork().isMobileDataEnabled());
        setText("isNetworkEnabled : => "+getIs().getNetwork().isNetworkEnabled());
        setText("isBrand : LG => "+getIs().getPhones().isBrand("LG"));

        try {
            setText("isLockScreenDisabled : => "+getIs().getPhones().isLockScreenDisabled());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setText("isPlugged : => "+getIs().getPhones().isPlugged());
        setText("isTabletDevice : Activity => "+getIs().getPhones().isTabletDevice(this));
        setText("isRooted : => "+getIs().getRoot().isRooted());
        setText("isScreenLandscape : => "+getIs().getScreen().isScreenLandscape());
        setText("isScreenPortrait : => "+getIs().getScreen().isScreenPortrait());
        setText("isScreenSquare : => "+getIs().getScreen().isScreenSquare());
        setText("getScreenSizes : => "+"w:"+getIs().getScreen().getScreenSizes(this)[0]+" h:"+getIs().getScreen().getScreenSizes(this)[1]);
        setText("isServiceRunning : com.android.vending => "+getIs().getServices().isServiceRunning("com.android.vending"));
        setText("isMax : Sound => "+getIs().getSounds().isMax());
        setText("isMute : Sound => "+getIs().getSounds().isMute());
        setText("isAvailableSpace : 250 bytes => "+getIs().getSpace().isAvailableSpace(250));
        setText("isAvailableSpace : 16*1024*1024*1024 bytes => "+getIs().getSpace().isAvailableSpace(16*1024*1024*1024));
        setText("getAvailableSpaceInBytes : => "+getIs().getSpace().getAvailableSpaceInBytes());
        setText("getAvailableSpaceInGB : => "+getIs().getSpace().getAvailableSpaceInGB());
        setText("getAvailableSpaceInKB : => "+getIs().getSpace().getAvailableSpaceInKB());
        setText("isVisible : text => "+getIs().getViews().isVisible(text));
        setText("isGone : text => "+getIs().getViews().isGone(text));
        setText("getDeviceId : => "+getIs().getPhones().getDeviceId());
        setText("equalsViews : text,text => "+getIs().getViews().equalsViews(text, text));
        transformToHtml();
    }

    public void setText(String output){
        int b =output.indexOf(':');

        output = "<b>"+getBlankedString(output.substring(0,b))+"</b>"+output.substring(b)+"<br>";

        text.setText(text.getText() + output + "\n");

    }
    String getBlankedString(String a){
        return a.length()>= 20 ? a: a+getBlank(20-a.length()) ;
    }

    String getBlank(int a){
        String blank="";
        for(int i =0;i<a;i++){
            blank = blank + " ";
        }
        return blank;
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
