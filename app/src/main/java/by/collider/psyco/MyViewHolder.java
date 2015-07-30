package by.collider.psyco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.unnamed.b.atv.model.TreeNode;

public class MyViewHolder extends TreeNode.BaseNodeViewHolder {
    public MyViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode treeNode, Object o) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.group, ((MainActivity) context).treeContainer, false);
        TextView tvValue = (TextView) view.findViewById(R.id.group_title);
        tvValue.setText((CharSequence) o);
        return view;
    }
}
