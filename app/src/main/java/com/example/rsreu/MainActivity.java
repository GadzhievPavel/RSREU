package com.example.rsreu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.rsreu.data.Answer;
import com.example.rsreu.data.DatabaseHelper;
import com.example.rsreu.data.json_parser.api.source.subsource.Denominator;
import com.example.rsreu.data.json_parser.api.source.subsource.Numerator;
import com.example.rsreu.data.json_parser.api.source.subsource.Settings;
import com.example.rsreu.data.json_parser.api.source.subsource.Times;
import com.example.rsreu.util.AnswerMaker;
import com.example.rsreu.util.MySQLquery;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    TextView textView;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private MySQLquery mySQLquery;
    private ArrayList<Settings> settings= new ArrayList<>();
    private ArrayList<Times>times=new ArrayList<>();
    static final int PAGE_COUNT = 1;

    private ArrayList<Denominator>denominators=new ArrayList<>();
    private ArrayList<Numerator>numerators=new ArrayList<>();
    private TextView textView1;

    ViewPager pager;
    PagerAdapter pagerAdapter;
    AnswerMaker answerMaker;
    ArrayList<Answer> answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        mySQLquery = new MySQLquery(databaseHelper);
        settings=mySQLquery.getSettings();
        times=mySQLquery.getTimes();

        numerators=mySQLquery.getNumerators("540",1,"20.02");
        denominators=mySQLquery.getDenominators("633",3,"20.02");

        Log.e("Nun",numerators.get(0).getTitle());
        answerMaker=new AnswerMaker(settings,times);
        answer=answerMaker.getAnswersN(numerators);
        pager=findViewById(R.id.pager);
        pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),this,answer);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Answer> answers;
        private Context context;
        public MyFragmentPagerAdapter(FragmentManager fm, Context context, ArrayList<Answer> answers) {
            super(fm);
            this.answers=answers;
            this.context=context;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position,context,answers);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }

}
