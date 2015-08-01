package by.collider.psyco;

import android.content.Context;

import com.unnamed.b.atv.model.TreeNode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ContentMaker {
    TreeNode root;

    public ContentMaker(Context context) {
        root = TreeNode.root();
        try {
            createTree(createStructureFromContent(context), root);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public void createTree(JSONObject node, TreeNode treeNode) throws JSONException {
        TreeNode child = new TreeNode(node);
        treeNode.addChild(child);
        if (node.has("children")) {
            JSONArray children = node.getJSONArray("children");
            for (int i = 0; i < children.length(); i++) {
                JSONObject nodeChild = children.getJSONObject(i);
                createTree(nodeChild, child);
            }
        }
    }

    public JSONObject createStructureFromContent(Context context) throws IOException, JSONException {
        InputStream inputStream = context.getAssets().open("chapter3.json");
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        String chapter3content = new String(b);
        JSONObject chapter3 = new JSONObject(chapter3content);
        return chapter3;
    }
}
