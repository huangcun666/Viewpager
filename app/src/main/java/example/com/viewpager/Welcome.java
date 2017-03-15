package example.com.viewpager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Adminstrator on 2017/2/4.
 */

public class Welcome extends AppCompatActivity {
    private boolean isfirstin=false;
    private static final int TIME=1000;
    private static final int GO_HOME=2000;
    private static final int GO_GUDIE=2001;
    private Handler myhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case GO_HOME:
                   gohome();
                   break;
               case GO_GUDIE:
                   goguide();
                   break;
           }
        };
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        init();
    }
    private void init(){
        SharedPreferences preferences=getSharedPreferences("bb",MODE_PRIVATE);
        /*isfirstin=preferences.getBoolean("isfirstin",true);*/
        if (!isfirstin){
            myhandler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }else {
            myhandler.sendEmptyMessageDelayed(GO_GUDIE,TIME);
        }
 /*       SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isfirstin",false);
        editor.commit();*/

    }
     private void gohome(){
         Intent intent=new Intent(Welcome.this,MainActivity.class);
         startActivity(intent);
         finish();
     }
    private void goguide(){
        Intent intent=new Intent(Welcome.this,Guide.class);
        startActivity(intent);
        finish();
    }
}
