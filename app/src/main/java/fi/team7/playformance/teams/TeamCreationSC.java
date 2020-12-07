package fi.team7.playformance.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import fi.team7.playformance.R;
import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.data.Team;


public class TeamCreationSC extends AppCompatActivity {

    private final View.OnClickListener onClickListener = this::onClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creation_s_c);
        findViewById(R.id.btnSubmit).setOnClickListener(onClickListener);


//        AppDB db = Room.databaseBuilder(getApplicationContext(),
//                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
//        Team team = new Team(0, "Kiri");
//        long tid = db.teamDAO().createTeam(team);
//        Player p1 = new Player(0, "John", "Test", 4, tid);
//        db.playerDAO().createPlayer(p1);
//        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
//        for (TeamWithPlayers tw: twp) {
//        Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
//        }


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
    private void saveTeamPlayer(){

    }

    public void saveT() {

        EditText editText1 = findViewById(R.id.txtNewPfirstName);
        EditText editText2 = findViewById(R.id.txtNewPlaststName);
        EditText editText3 = findViewById(R.id.txtNewPlayerNumber);
        EditText editText4 = findViewById(R.id.txtTeamName);

        String fName = editText1.getText().toString();
        String lName = editText2.getText().toString();
        int number = Integer.valueOf(editText3.getText().toString());
        String teamName = editText4.getText().toString();

        AppDB db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class, "playformance_db.db").allowMainThreadQueries().build();
        Team team = new Team(0, teamName);
        long tid = db.teamDAO().createTeam(team);
        Player p = new Player(0, fName, lName, number, tid);
        db.playerDAO().createPlayer(p);
        editText1.setText(" ");
        editText2.setText(" ");
        editText3.setText(" ");
        editText4.setText(" ");

//        List<TeamWithPlayers> twp = db.teamDAO().getTeamWithPlayers();
//        for (TeamWithPlayers tw: twp) {
//            Log.d("PLAYDB", "Team with id: " + tw.team + " whith players: " + tw.players);
//        }

    }


    private void onClick(View view) {
        saveT();
        Intent intent = new Intent(this, SelectTeam.class);
        startActivity(intent);
    }
}
