package by.collider.psyco;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expListView = (ExpandableListView) findViewById(R.id.chapter);
        final Node objects = new Node();
        objects.title = "Root";
        Node child1 = new Node();
        child1.title = "child1";
        Node child1child1 = new Node();
        child1child1.title = "child1child1";
        Node child4 = new Node();
        child4.title = "child4";
        child1child1.children.add(child4);
        Node child5 = new Node();
        child5.title = "child5";
        child4.children.add(child5);
        Node child6 = new Node();
        child6.title = "child6";
        child5.children.add(child6);
        child1.children.add(child1child1);
        Node child2 = new Node();
        child2.title = "child2";
        Node child3 = new Node();
        child3.title = "child3";
        objects.children.add(child1);
        objects.children.add(child2);
        objects.children.add(child3);
        // First level items in the ExpandableListView
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView eListView, View view, int groupPosition, long id) {
                // TODO: whatever you need
                return false /* or true depending on what you need */;
            }
        });

        // Second level items in the ExpandableListView
        ExpandableListView.OnGroupClickListener grpLst = new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView eListView, View view, int groupPosition, long id) {
                // TODO: whatever you need
                return false /* or true depending on what you need */;
            }
        };

        // Third (and last) level items in the ExpandableListView
        ExpandableListView.OnChildClickListener childLst = new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView eListView, View view, int groupPosition, int childPosition, long id) {
                // TODO: whatever you need
                return false /* or true depending on what you need */;
            }
        };

        ExpandableListView.OnGroupExpandListener grpExpLst = new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            /* this one is not required of course, you can delete it from the RootAdapter Constructor
             * it is just an example as to how to implement Listeners on the second level items */
            }
        };

        final RootExpandableListAdapter adapter = new RootExpandableListAdapter(this, objects, grpLst, childLst, grpExpLst);
        expListView.setAdapter(adapter);
    }
}