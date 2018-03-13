package cpri.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.dhara.cpriapp.R;

import cpri.activity.CPRIActivity;
import cpri.activity.TimeSheetActivity;
import cpri.other.ImageAdapter;


public class HomeFragment extends Fragment {

    public HomeFragment() {
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
           View v = inflater.inflate(R.layout.fragment_home, container, false);

        GridView gridView = (GridView) v.findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(getContext()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
              //  Intent myIntent = null;
                switch (position) {
                    case 0:
                        Intent i = new Intent(v.getContext(), CPRIActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent it = new Intent(v.getContext(), TimeSheetActivity.class);
                        startActivity(it);
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Module 3 coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Module 4 coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(), "Module 5 coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(), "Module 6 coming soon", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return v;
    }
}
