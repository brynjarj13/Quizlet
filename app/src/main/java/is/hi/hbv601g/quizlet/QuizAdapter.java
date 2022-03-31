package is.hi.hbv601g.quizlet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class QuizAdapter extends ArrayAdapter<Quiz> {

    public QuizAdapter(Context context, int resource, List<Quiz> quizList) {
        super(context, resource, quizList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Quiz quiz = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_quiz, parent, false);
        }
        TextView tvQuizName = (TextView) convertView.findViewById(R.id.quizName);
        TextView tvQuizSubcategory = (TextView) convertView.findViewById(R.id.quizSubcategory);
        RatingBar rbQuizRating = (RatingBar) convertView.findViewById(R.id.quizRatingBar);
        TextView tvQuizRating = (TextView) convertView.findViewById(R.id.quizRatingText);
        ImageView ivQuizIcon = (ImageView) convertView.findViewById(R.id.quizImage);


        tvQuizName.setText(quiz.getName());
        tvQuizSubcategory.setText(quiz.getsubcategory());
        rbQuizRating.setRating(quiz.getRating());
        tvQuizRating.setText(String.valueOf(quiz.getRating()));
        ivQuizIcon.setImageResource(quiz.getImage());

        return convertView;
    }
}