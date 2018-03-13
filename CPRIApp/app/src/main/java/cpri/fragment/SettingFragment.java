package cpri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhara.cpriapp.R;

import cpri.activity.ChangePasswordActivity;
import cpri.activity.ChangeThemeActivity;
import cpri.activity.FeedbackActivity;
import cpri.other.MainController;


public class SettingFragment extends Fragment {

    TextView imgPswd, imgtheme, imgFeedback;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_setting, container, false);

        imgPswd = (TextView) v.findViewById(R.id.chngPswd);
        imgtheme = (TextView) v.findViewById(R.id.chngTheme);
        imgFeedback = (TextView) v.findViewById(R.id.chngfeedback);

        imgPswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(i);
            }
        });

        imgtheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTheme = new Intent(getContext(), ChangeThemeActivity.class);
                startActivity(iTheme);
            }
        });

        imgFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifeed = new Intent(getContext(), FeedbackActivity.class);
                startActivity(ifeed);
            }
        });
        return v;
    }
}
