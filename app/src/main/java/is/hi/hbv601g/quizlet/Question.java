package is.hi.hbv601g.quizlet;

public class Question {
    public String questions[] = {
            //Lol questions
            "Who is Jinx's sister?",
            "What class is Tristana?",
            "Who is the oldest?",
            //Lotr questions
            "Who acts the role of Gandalf the wizard?",
            "When was this movie released?",
            //Iceland questions
            "Where is this?",
            "Where is this?",
            "Where is this?",
            "Where is this?",
            //Risk questions
            "When was Risk first released?",
            "How much is Artillery worth?"
    };

    public String choices[][] = {
            //Lol choices
            {"Vi", "Caitlyn", "Karma", "Sona"},
            {"Tank", "Jungle", "Support", "ADC"},
            {"Kindred", "Graves", "Zoe", "Heimerdinger"},
            //Lotr choices
            {"Sean Connery", "Sir Ian Holm", "Christopher Lee", "Sir Ian McKellen"},
            {"1999", "2000", "2001", "2002"},
            //Iceland choices
            {"Þingvellir", "Þórsmörk", "Egilstaðir", "Mosfellsdalur"},
            {"Hveragerði", "Húsavík", "Akureyri", "Hella"},
            {"Laugavatn", "Apavatn", "Mývatn", "Rauðavatn"},
            {"Helgufoss", "Langifoss", "Gullfoss", "Dettifoss"},
            //Risk choices
            {"1950s", "1960s", "1970s", "1980s"},
            {"2 infantry", "5 infantry", "8 infantry", "10 infantry"}
    };

    public String correctAnswer[] = {
            //Lol answers
            "Vi",
            "ADC",
            "Kindred",
            //Lotr answers
            "Sir Ian McKellen",
            "2001",
            //Iceland answers
            "Þórsmörk",
            "Akureyri",
            "Laugavatn",
            "Dettifoss",
            //Risk answers
            "1950s",
            "10 infantry"
    };

    public int images[] = {
            //Lol images
            R.drawable.jinx,
            R.drawable.tristana,
            R.drawable.allchamps,
            //Lotr images
            R.drawable.gandalf,
            R.drawable.fellowship,
            //Iceland images
            R.drawable.thorsmork,
            R.drawable.akureyri,
            R.drawable.laugavatn,
            R.drawable.dettifoss,
            //Risk images
            R.drawable.riskboard,
            R.drawable.riskpieces
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}