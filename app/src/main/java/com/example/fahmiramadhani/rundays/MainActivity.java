package com.example.fahmiramadhani.rundays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Race> raceList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RaceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new RaceAdapter(raceList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Race movie = raceList.get(position);
                Toast.makeText(getApplicationContext(), movie.getRaceTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareMovieData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorite) {
            Toast.makeText(MainActivity.this, "Favorited Events clicked", Toast.LENGTH_LONG).show();
        }
            return true;
        }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareMovieData() {
        Race race = new Race("Temple Run 2017", "Yogyakarta", "Marathon", "2 November 2017");
        raceList.add(race);

        race = new Race("Toba Lake Challenge 3", "Sumatera Utara", "Ultra Marathon", "28 Oktober 2017");
        raceList.add(race);

        race = new Race("Palembang Midnight Run", "Palembang", "5K", "24 Oktober 2017");
        raceList.add(race);

        race = new Race("Jakarta Running Festival 2017", "Jakarta", "Ultra Marathon", "19 Oktober 2017");
        raceList.add(race);

        race = new Race("Purwakarta Challenge Ultra Marathon 2017", "Purwakarta", "Ultra Marathon", "17 Oktober 2017");
        raceList.add(race);

        race = new Race("Dieng Hills Fun Run 2017", "Jawa Tengah", "10K", "10 Oktober 2017");
        raceList.add(race);

        race = new Race("Surabaya Superhero Run", "Surabaya", "Marathon", "3 Oktober 2017");
        raceList.add(race);

        race = new Race("Yogyakarta Ringroad Ultra Marathon Trail 2017", "Yogyakarta", "Ultra Marathon", "30 September 2017");
        raceList.add(race);

        race = new Race("Bali Holy Run 2017", "Bali", "Half Marathon", "28 September 2017");
        raceList.add(race);

        race = new Race("Komodo Marathon 2017", "Lombok", "Marathon", "26 September 2017");
        raceList.add(race);

        race = new Race("Adidas Marathon Trail 2017", "Jakarta", "Marathon", "20 September 2017");
        raceList.add(race);

        race = new Race("Nike Marathon 2017", "Jakarta", "Marathon", "17 September 2017");
        raceList.add(race);

        race = new Race("Kalimantan Ultra Marathon 2017", "Yogyakarta", "Ultra Marathon", "16 September 2017");
        raceList.add(race);

        race = new Race("Makassar Trail 2017", "Makassar", "10K", "12 September 2017");
        raceList.add(race);

        race = new Race("Cendrawasih Challenge Marathon", "Papua", "Marathon", "9 September 2017");
        raceList.add(race);

        race = new Race("Independence Run: Ultra Marathon 2017", "Jakarta", "Ultra Marathon", "17 Agustus 2017");
        raceList.add(race);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}
