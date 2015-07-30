package by.collider.psyco;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

public class MainActivity extends Activity {
    RelativeLayout treeContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TreeNode root = TreeNode.root();
        TreeNode parent = new TreeNode("MyParentNode");
        TreeNode child0 = new TreeNode("ChildNode0");
        TreeNode child00 = new TreeNode("ChildNode00");
        TreeNode child000 = new TreeNode("ChildNode000");
        TreeNode child001 = new TreeNode("ChildNode001");
        child00.addChildren(child000, child001);
        TreeNode child01 = new TreeNode("ChildNode01");
        child0.addChildren(child00, child01);
        TreeNode child1 = new TreeNode("ChildNode1");
        TreeNode child10 = new TreeNode("ChildNode10");
        TreeNode child11 = new TreeNode("ChildNode11");
        child1.addChildren(child10, child11);
        parent.addChildren(child0, child1);
        root.addChild(parent);
        AndroidTreeView tView = new AndroidTreeView(this, root);
        tView.setDefaultViewHolder(MyViewHolder.class);
        tView.setDefaultNodeClickListener(new TreeNode.TreeNodeClickListener() {
            @Override
            public void onClick(TreeNode treeNode, Object o) {
                treeNode.getParent();
            }
        });
        treeContainer = (RelativeLayout) findViewById(R.id.tree_container);
        treeContainer.addView(tView.getView());
        tView.expandLevel(1);
    }
}