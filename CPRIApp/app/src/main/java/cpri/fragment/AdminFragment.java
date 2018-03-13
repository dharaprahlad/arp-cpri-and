package cpri.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dhara.cpriapp.R;

import java.util.ArrayList;
import java.util.List;

import cpri.activity.Admin;
import cpri.other.AdminAdapter;
import cpri.other.RecyclerTouchListener;


public class AdminFragment extends Fragment {
    private List<Admin> adminList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdminAdapter mAdapter;

    public AdminFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_admin, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        mAdapter = new AdminAdapter(adminList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Admin admin = adminList.get(position);
                Toast.makeText(getContext(), admin.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();

        return v;
    }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareMovieData() {
        Admin movie = new Admin("Preety", "Admin", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Payal", "Account Manager", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Kunjan", "Manager", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Vipul", "Manager", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Rinkal", "Developer", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Shivali", "Developer", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Nilesh", "Developer", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Kelly", "Developer", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Arpan", "Developer", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Manisha", "Developer", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Priyank", "Developer", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Ravi", "Network Admin", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Mihir", "Network Admin", R.drawable.indian_flag);
        adminList.add(movie);

        movie = new Admin("Mustafa", "Network Admin", R.drawable.us_flag);
        adminList.add(movie);

        movie = new Admin("Milan", "Network Admin", R.drawable.us_flag);
        adminList.add(movie);



        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}

