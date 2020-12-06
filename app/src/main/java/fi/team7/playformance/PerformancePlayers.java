package fi.team7.playformance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import fi.team7.playformance.data.AppDB;
import fi.team7.playformance.data.Player;
import fi.team7.playformance.teams.SelectionForPlayer;
import fi.team7.playformance.teams.SelectionOfPlayer;

public class PerformancePlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_players);


        AppDB db = Room.databaseBuilder(getApplicationContext(),
            AppDB.class, "playformance_db.db").allowMainThreadQueries().build();

    Bundle b = getIntent().getExtras();
    long i = b.getLong(Performance.EXTRA, 0);
        ((TextView) findViewById(R.id.txtPlayersTitle)).setText(db.teamDAO().getTeamByID(i).name);

                List<Player> lvp = db.playerDAO().getPlayersByTeamID(i);
        ListView listView = findViewById(R.id.listWithPlayers);
        listView.setAdapter(new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, lvp));

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Player pl = (Player) parent.getItemAtPosition(position);
            Log.d(SelectionOfPlayer.TAG, "onItemClick(" + pl + ")");
            Intent nextActivity = new Intent(this, PlayerResult.class);
            nextActivity.putExtra(SelectionOfPlayer.EXTRA, pl.pid);
            startActivity(nextActivity);
        });
    }
}