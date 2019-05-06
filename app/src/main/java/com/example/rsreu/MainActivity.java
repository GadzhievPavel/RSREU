package com.example.rsreu;

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
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements RecycleViewAdapter.ItemClickListener {
    private static final String TAG ="MAIN" ;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    private MySQLquery mySQLquery;
    private ArrayList<Settings> settings = new ArrayList<>();
    private ArrayList<Times> times = new ArrayList<>();
    static final int PAGE_COUNT = 2;

    //private ArrayList<Denominator> denominators = new ArrayList<>();
    //private ArrayList<Numerator> numerators = new ArrayList<>();
    private ArrayList<ArrayList<Numerator>> listsNummerator;
    private ArrayList<ArrayList<Denominator>> listsDenominator;

    ViewPager pager;
    PagerAdapter pagerAdapter;
    AnswerMaker answerMaker;
    Map<Integer, ArrayList<ArrayList<Answer>>> answer = new HashMap<Integer, ArrayList<ArrayList<Answer>>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        mySQLquery = new MySQLquery(databaseHelper);
        settings = mySQLquery.getSettings();
        times = mySQLquery.getTimes();

        Log.e("times 8",times.get(8).getFrom());

        listsNummerator=mySQLquery.getNumeratorAll("540","20.02");
        listsDenominator=mySQLquery.getDenominatorAll("543","27.02");
        Log.e("f", String.valueOf(listsNummerator.get(1).get(0).getWeekDay()));

        answerMaker = new AnswerMaker(settings, times);
        answer = answerMaker.getAnswers(listsNummerator,listsDenominator);
        Log.e(TAG, String.valueOf(answer.get(1).get(1).get(0).getBuild()));

        pager=findViewById(R.id.pager);
        pagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String day;
            switch (position){
                case 0:
                    day="Числитель";
                    break;
                case 1:
                    day="Знаменатель";
                    break;
                default:
                    day="Неделя";
            }
            return day;
        }

        @Override
        public Fragment getItem(int position) {
            notifyDataSetChanged();
            PageFragment.week=answer.get(position);
            Log.e("POSITION", String.valueOf(position));
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            Log.e("GETCOUNT", String.valueOf(PAGE_COUNT));
            return PAGE_COUNT;
        }

    }
    @Override
    public void onItemClick(View view, int position) {

    }
}
