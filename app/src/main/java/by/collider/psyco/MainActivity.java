package by.collider.psyco;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.unnamed.b.atv.view.AndroidTreeView;

public class MainActivity extends Activity {
    RelativeLayout treeContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidTreeView tView = new AndroidTreeView(this, new ContentMaker(this).root);
        tView.setDefaultViewHolder(MyViewHolder.class);
        treeContainer = (RelativeLayout) findViewById(R.id.tree_container);
        treeContainer.addView(tView.getView());
        tView.expandLevel(1);
    }
}