package cpri.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.example.dhara.cpriapp.R;

public class SplashScreenActivity extends AppCompatActivity {

    private VideoView mVideoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        mVideoview = (VideoView) findViewById(R.id.splash_video);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.splash_video;
        mVideoview.setVideoURI(Uri.parse(uri));
        mVideoview.start();


        /****** Create Thread that will sleep for 5 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5 * 1000);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();

    }

    /*@Override
    public void setReference() {

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
