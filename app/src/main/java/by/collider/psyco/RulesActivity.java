package by.collider.psyco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules);
    }

    public void goToChapters(View view) {
        Intent chapters = new Intent(this, ChaptersActivity.class);
        startActivity(chapters);
    }
}
