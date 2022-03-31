package is.hi.hbv601g.quizlet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        TextView textViewName = (TextView) convertView.findViewById(R.id.quizName);
        TextView textViewSubcategory = (TextView) convertView.findViewById(R.id.quizSubcategory);
        ImageView iv = (ImageView) convertView.findViewById(R.id.quizImage);

        textViewName.setText(quiz.getName());
        textViewSubcategory.setText(quiz.getsubcategory());
        iv.setImageResource(quiz.getImage());

        return convertView;
    }
}