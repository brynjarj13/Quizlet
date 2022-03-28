package is.hi.hbv601g.quizlet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static ArrayList<Quiz> quizList = new ArrayList<Quiz>();

    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;
    private Button allFilter;
    private Button boardgameFilter;
    private Button geographyFilter;
    private Button videogamesFilter;
    private Button moviesFilter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        quizList.clear();

        searchView = (SearchView) v.findViewById(R.id.quizListSearchView);
        listView = (ListView) v.findViewById(R.id.quizzesListView);
        allFilter = (Button) v.findViewById(R.id.allFilter);
        geographyFilter = (Button) v.findViewById(R.id.geographyFilter);
        boardgameFilter = (Button) v.findViewById(R.id.boardgameFilter);
        videogamesFilter = (Button) v.findViewById(R.id.videogamesFilter);
        moviesFilter = (Button) v.findViewById(R.id.moviesFilter);

        setButtonListeners();
        initSearchWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();

        return v;
    }

    private void setButtonListeners(){
        allFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                allFilterTapped(v);
            }
        });
        geographyFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                geographyFilterTapped(v);
            }
        });
        boardgameFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boardgameFilterTapped(v);
            }
        });
        videogamesFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                videogamesFilterTapped(v);
            }
        });
        moviesFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                moviesFilterTapped(v);
            }
        });
    }
    private void initSearchWidgets()
    {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<Quiz> filteredQuizzes = new ArrayList<Quiz>();

                for(Quiz quiz: quizList)
                {
                    if(quiz.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        if(selectedFilter.equals("all"))
                        {
                            filteredQuizzes.add(quiz);
                        }
                        else
                        {
                            if(quiz.getGenre().toLowerCase().contains(selectedFilter))
                            {
                                filteredQuizzes.add(quiz);
                            }
                        }
                    }
                }
                QuizAdapter adapter = new QuizAdapter(getActivity(), 0, filteredQuizzes);
                listView.setAdapter(adapter);

                return false;
            }
        });
    }

    private void setupData()
    {
        Quiz lol = new Quiz("0", "League of Legends", "videogames", 3, R.drawable.videogames);
        quizList.add(lol);

        Quiz lotr = new Quiz("1","The Lord of the Rings", "movies", 2, R.drawable.movies);
        quizList.add(lotr);

        Quiz iceland = new Quiz("2","Iceland", "geography",4, R.drawable.geography);
        quizList.add(iceland);

        Quiz risk = new Quiz("3","Risk", "boardgame",2, R.drawable.boardgame);
        quizList.add(risk);

    }

    private void setUpList()
    {

        QuizAdapter adapter = new QuizAdapter(getActivity(), 0, quizList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Quiz selectQuiz = (Quiz) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getActivity(), DetailActivity.class);
                showDetail.putExtra("id",selectQuiz.getId());
                startActivity(showDetail);
            }
        });
    }

    private void filterList(String status)
    {
        selectedFilter = status;

        ArrayList<Quiz> filteredQuizzes = new ArrayList<Quiz>();

        for (Quiz quiz : quizList) {
            if (quiz.getGenre().toLowerCase().contains(status))
            {
                if(currentSearchText == "")
                {
                    filteredQuizzes.add(quiz);
                }
                else
                {
                    if(quiz.getName().toLowerCase().contains(currentSearchText.toLowerCase()))
                    {
                        filteredQuizzes.add(quiz);
                    }
                }

            }
        }
        QuizAdapter adapter = new QuizAdapter(getActivity(), 0, filteredQuizzes);
        listView.setAdapter(adapter);
    }


    public void allFilterTapped(View view)
    {
        selectedFilter = "all";
        searchView.setQuery("", false);
        searchView.clearFocus();

        QuizAdapter adapter = new QuizAdapter(getActivity(), 0, quizList);
        listView.setAdapter(adapter);
    }

    public void moviesFilterTapped(View view)
    {
        filterList("movies");
    }

    public void videogamesFilterTapped(View view)
    {
        filterList("videogames");
    }

    public void boardgameFilterTapped(View view)
    {
        filterList("boardgame");
    }

    public void geographyFilterTapped(View view)
    {
        filterList("geography");
    }

}
