package cpri.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dhara.cpriapp.R;

import java.util.ArrayList;
import java.util.List;

import cpri.fragment.AwsFragment;
import cpri.fragment.LTEFragment;
import cpri.fragment.OtherFragment;
import cpri.fragment.PCSFragment;

public class TechnologyActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void setReference() {

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AwsFragment(), "AWS");
        adapter.addFragment(new LTEFragment(), "LTE");
        adapter.addFragment(new PCSFragment(), "PCS");
        adapter.addFragment(new OtherFragment(), "850");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {return mFragmentTitleList.get(position);}
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent iTech = new Intent(TechnologyActivity.this, AddSiteInfoActivity.class);
        iTech.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        iTech.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        iTech.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(iTech);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);*/

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit) {
            //Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
