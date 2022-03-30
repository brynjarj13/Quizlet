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
        TextView tv = (TextView) convertView.findViewById(R.id.quizName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.quizImage);

        tv.setText(quiz.getName());
        iv.setImageResource(quiz.getImage());

        return convertView;
    }
}