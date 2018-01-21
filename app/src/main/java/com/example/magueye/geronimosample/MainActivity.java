package com.example.magueye.geronimosample;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.magueye.geronimosample.model.MovieDataModel;
import com.example.magueye.geronimosample.view.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieDataModel> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSavedData();

        this.myAdapter = new MyAdapter(this, movies);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//agencement verticale
        recyclerView.setAdapter(myAdapter);
    }

    //adding datas
    public void setSavedData() {
        movies.add(new MovieDataModel("Kirikou",
                R.string.detail_item,
                "kids",
                "https://static.fnac-static.com/multimedia/FR/Images_Produits/FR/fnac.com/Visual_Principal_340/2/0/3/5099950691302/tsp20120926061128/Kirikou-et-Karaba.jpg"));
        movies.add(new MovieDataModel("Django",
                R.string.detail_item,
                "fight",
                "http://braindamaged.fr/wp-content/uploads/2012/11/Django-Unchained-Wallpaper-Jamie-Foxx-631x250@2x.jpg"));
        movies.add(new MovieDataModel("Imitation Game",
                R.string.detail_item,
                "History and Crypto machine",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BOTgwMzFiMWYtZDhlNS00ODNkLWJiODAtZDVhNzgyNzJhYjQ4L2ltYWdlXkEyXkFqcGdeQXVyNzEzOTYxNTQ@._V1_UX182_CR0,0,182,268_AL_.jpg"));
        movies.add(new MovieDataModel("GOT",
                R.string.detail_item,
                "Game of thrones",
                "http://braindamaged.fr/wp-content/uploads/2016/05/game-of-thrones-saison-6-logo-une-631x250@2x.jpg"));
        setMovies(movies);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items_add_remove, menu);
        return true;
    }

    //menu button add/remove movie
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int positon = 0; //position of the item to add/remove
        //add a movie
        if (id == R.id.menu_add_item) {
            if(movies.size()>0) positon++;

            movies.add(positon, new MovieDataModel("GOT",
                    R.string.detail_item,
                    "Game of thrones",
                    "http://braindamaged.fr/wp-content/uploads/2016/05/game-of-thrones-saison-6-logo-une-631x250@2x.jpg"));
            myAdapter.notifyDataSetChanged();

            return true;

            //remove a movie
        }else if(id == R.id.menu_remove_item && movies.size()>0) {
            getMovies().remove(positon);
            recyclerView.removeViewAt(positon);
            myAdapter.notifyItemRemoved(positon);
            myAdapter.notifyItemRangeChanged(positon, movies.size());
            return true;
        }
        setMovies(getMovies());
        recyclerView.setAdapter(myAdapter);
        return super.onOptionsItemSelected(item);
    }

    public List<MovieDataModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDataModel> movies) {
        this.movies = movies;
    }
}
