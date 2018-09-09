package petrusproject.com.attendancesystem;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{



    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPageAdapter viewPageAdapter;

    private DrawerLayout theDrawer;
    private ActionBarDrawerToggle toggle;


    //Object of DatabaseHelper class
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        myDb = new DatabaseHelper(this);

        theDrawer = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, theDrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        theDrawer.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nav);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Handle the Drawer clicks
    public void selectItemDrawer(MenuItem theItem)
    {
        android.support.v4.app.Fragment frag = null;
        Class fragClass = null;

        //Open a fragment corresponding to a clicked item on a menu
        switch (theItem.getItemId())
        {
            case R.id.tk_attendanceItem:
               fragClass = Attendance.class;
               break;

            case R.id.v_attendanceItem:
                fragClass = AttendanceView.class;
                break;

            case R.id.tk_assessmentItem:
                fragClass = Assessment.class;
                break;

            case R.id.v_assessmentItem:
                fragClass = AssessmentView.class;
                break;

            case R.id.settingItem:
                fragClass = Settings.class;
                break;
             default:
        }

        try {
            frag = (android.support.v4.app.Fragment) fragClass.newInstance();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentFlow, frag).commit();
        theItem.setChecked(true);
        setTitle(theItem.getTitle());
        theDrawer.closeDrawers();
    }

    //Setup Drawer content
    public void setupDrawerContent(NavigationView navigationView)
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

}
