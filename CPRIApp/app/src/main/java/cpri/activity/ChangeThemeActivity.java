package cpri.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.example.dhara.cpriapp.R;

import cpri.other.UserPreferenceManager;

public class ChangeThemeActivity extends BaseActivity implements View.OnClickListener {

    protected View view;
    private LinearLayout layout_green, layout_purple, layout_brown, layout_red, layout_indigo, layout_pink, layout_cyan, layout_lime, layout_teal, layout_amber, layout_lightGreen;
    private SwitchCompat switch_dark;
    private boolean isDarkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

            //set the transition
            Transition ts = new Explode();
            ts.setDuration(5000);
            getWindow().setEnterTransition(ts);
            getWindow().setExitTransition(ts);
        }

        super.onCreate(savedInstanceState);

        setReference();

        setToolbarElevation(0);

        setToolbarSubTittle(this.getClass().getSimpleName());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void setReference() {
        view = LayoutInflater.from(this).inflate(R.layout.activity_change_theme,container);

        switch_dark = (SwitchCompat) view.findViewById(R.id.switch_darkTheme);
        layout_green = (LinearLayout) view.findViewById(R.id.layout_green);
        layout_purple = (LinearLayout) view.findViewById(R.id.layout_purple);
        layout_brown = (LinearLayout) view.findViewById(R.id.layout_brown);
        layout_red = (LinearLayout) view.findViewById(R.id.layout_red);
        layout_indigo = (LinearLayout) view.findViewById(R.id.layout_indigo);
        layout_pink = (LinearLayout) view.findViewById(R.id.layout_pink);
        layout_cyan = (LinearLayout) view.findViewById(R.id.layout_cyan);
        layout_lime = (LinearLayout) view.findViewById(R.id.layout_lime);
        layout_teal = (LinearLayout) view.findViewById(R.id.layout_teal);
        layout_amber = (LinearLayout) view.findViewById(R.id.layout_amber);
        layout_lightGreen = (LinearLayout) view.findViewById(R.id.layout_lightGreen);

        switch_dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    if (isChecked)
                    {
                        isDarkTheme = true;
                        UserPreferenceManager.preferencePutBoolean("DarkTheme", true);
                    }
                    else {
                        isDarkTheme = false;
                        UserPreferenceManager.preferencePutBoolean("DarkTheme", false);
                    }
            }
        });

        if (UserPreferenceManager.preferenceGetBoolean("DarkTheme", false))
        {
            switch_dark.setChecked(false);
        }

        layout_green.setOnClickListener(this);
        layout_purple.setOnClickListener(this);
        layout_brown.setOnClickListener(this);
        layout_red.setOnClickListener(this);
        layout_indigo.setOnClickListener(this);
        layout_pink.setOnClickListener(this);
        layout_cyan.setOnClickListener(this);
        layout_lime.setOnClickListener(this);
        layout_teal.setOnClickListener(this);
        layout_amber.setOnClickListener(this);
        layout_lightGreen.setOnClickListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.layout_green:
                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Green_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Green");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_purple:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Purple_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Purple");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_brown:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Brown_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Brown");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_red:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Red_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Red");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_indigo:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Indigo_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Indigo");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_pink:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Pink_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Pink");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_cyan:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Cyan_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Cyan");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_lime:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Lime_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Lime");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_teal:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Teal_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Teal");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_amber:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Amber_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "Amber");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;

            case R.id.layout_lightGreen:

                if (isDarkTheme)
                    UserPreferenceManager.preferencePutString("AppliedTheme", "LightGreen_Dark");
                else
                    UserPreferenceManager.preferencePutString("AppliedTheme", "LightGreen");

                TaskStackBuilder.create(this)
                        .addNextIntent(new Intent(getApplicationContext(), SiteListActivity.class))
                        .addNextIntent(getIntent())
                        .startActivities();
                break;
        }

    }
}

