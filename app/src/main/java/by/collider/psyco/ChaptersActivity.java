package by.collider.psyco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChaptersActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapters);
    }

    public void chapterClicked(View view) {
        Intent chapters = new Intent(this, MainActivity.class);
        startActivity(chapters);
    }
}
