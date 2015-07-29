package by.collider.psyco;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    public Node child;

    private final LayoutInflater inflater;

    public ExpandableListAdapter(Node child, Context context) {
        this.child = child;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.children.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // third level
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        View layout = convertView;
        final Node Node = (Node) getChild(groupPosition, childPosition);

        ChildViewHolder holder;

        if (layout == null) {
            layout = inflater.inflate(R.layout.group_child, parent, false);

            holder = new ChildViewHolder();
            holder.title = (TextView) layout.findViewById(R.id.group_child_title);
            layout.setTag(holder);
        } else {
            holder = (ChildViewHolder) layout.getTag();
        }

        holder.title.setText(Node.title.trim());

        return layout;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.children.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return child.children.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return child.children.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // Second level
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        View layout = convertView;
        ViewHolder holder;

        final Node Node = (Node) getGroup(groupPosition);

        if (layout == null) {
            layout = inflater.inflate(R.layout.group, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) layout.findViewById(R.id.group_title);
            layout.setTag(holder);
        } else {
            holder = (ViewHolder) layout.getTag();
        }

        holder.title.setText(Node.title.trim());

        return layout;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        Log.d("SecondLevelAdapter", "Unregistering observer");
        if (observer != null) {
            super.unregisterDataSetObserver(observer);
        }
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolder {
        TextView title;
    }

    private static class ChildViewHolder {
        TextView title;
    }
}