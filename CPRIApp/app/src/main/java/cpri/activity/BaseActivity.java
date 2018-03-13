package cpri.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anupcowkur.reservoir.Reservoir;
import com.example.dhara.cpriapp.R;

import cpri.other.UserPreferenceManager;

public abstract class BaseActivity extends AppCompatActivity {

    private View view_simpleToolbar;
    public FrameLayout container;
    public android.support.v7.widget.Toolbar toolbar;
    public CoordinatorLayout mainlayout;
    public AppBarLayout base_toolbarContainer;

    private static final String Theme_Current = "AppliedTheme";
    //public ExceptionHandler exceptionHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            setAppTheme();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_base);

            //exceptionHandler = new ExceptionHandler(this);

            //Thread.setDefaultUncaughtExceptionHandler(ExceptionHandler.getInstance(this));
            base_toolbarContainer = (AppBarLayout) findViewById(R.id.base_appbar);
            container = (FrameLayout) findViewById(R.id.container);
            mainlayout = (CoordinatorLayout) findViewById(R.id.fulllayout);

            Reservoir.init(this, 8192); //in bytes
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSimpleToolbar(boolean isSimpleToolbarRequire) {
        if (isSimpleToolbarRequire) {
            view_simpleToolbar = LayoutInflater.from(this).inflate(R.layout.simple_toolbar, base_toolbarContainer);
            toolbar = (android.support.v7.widget.Toolbar) view_simpleToolbar.findViewById(R.id.toolbar);

            //Set the custom toolbar
            if (toolbar != null) {
                setSupportActionBar(toolbar);
                toolbar.setTitle(R.string.app_name);
                toolbar.setTitleTextColor(Color.WHITE);
                //toolbar.setLogo(R.mipmap.ic_launcher);
            }
        }
    }

    public void setToolbarSubTittle(String header) {
        if (toolbar != null)
            toolbar.setSubtitle(header);
    }

    public void setToolbarElevation(float value) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (toolbar != null)
                toolbar.setElevation(value);
        }
    }

    // Method to set xml object reference.
    public abstract void setReference();

    private void setAppTheme() {
        if (!UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("")) {
            if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Green")) {
                setTheme(R.style.ThemeApp_Green);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Green_Dark")) {
                setTheme(R.style.ThemeApp_Green_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Purple_Dark")) {
                setTheme(R.style.ThemeApp_Purple_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Purple")) {
                setTheme(R.style.ThemeApp_Purple);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Brown_Dark")) {
                setTheme(R.style.ThemeApp_Brown_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Brown")) {
                setTheme(R.style.ThemeApp_Brown);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Red_Dark")) {
                setTheme(R.style.ThemeApp_Red_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Red")) {
                setTheme(R.style.ThemeApp_Red);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Indigo_Dark")) {
                setTheme(R.style.ThemeApp_Indigo_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Indigo")) {
                setTheme(R.style.ThemeApp_Indigo);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Pink_Dark")) {
                setTheme(R.style.ThemeApp_Pink_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Pink")) {
                setTheme(R.style.ThemeApp_Pink);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Cyan_Dark")) {
                setTheme(R.style.ThemeApp_Cyan_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Cyan")) {
                setTheme(R.style.ThemeApp_Cyan);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Lime_Dark")) {
                setTheme(R.style.ThemeApp_Lime_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Lime")) {
                setTheme(R.style.ThemeApp_Lime);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Teal_Dark")) {
                setTheme(R.style.ThemeApp_Teal_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Teal")) {
                setTheme(R.style.ThemeApp_Teal);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Amber_Dark")) {
                setTheme(R.style.ThemeApp_Amber_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("Amber")) {
                setTheme(R.style.ThemeApp_Amber);
            }else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("LightGreen_Dark")) {
                setTheme(R.style.ThemeApp_LightGreen_Dark);
            } else if (UserPreferenceManager.preferenceGetString(Theme_Current, "").equals("LightGreen")) {
                setTheme(R.style.ThemeApp_LightGreen);
            }
        } else {
            setTheme(R.style.ThemeApp_Green);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            Reservoir.clear();
        } catch (Exception e) {
            //failure
        }
    }
}