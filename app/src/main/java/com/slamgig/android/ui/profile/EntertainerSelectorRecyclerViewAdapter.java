package com.slamgig.android.ui.profile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.slamgig.android.ui.profile.fragments.SetEntertainerTypeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by adaobifrank on 8/29/17.
 */

public class EntertainerSelectorRecyclerViewAdapter extends RecyclerView.Adapter<EntertainerSelectorRecyclerViewAdapter.ViewHolder> {

    ArrayList<EntertainerType> entertainerTypes;

    public EntertainerSelectorRecyclerViewAdapter(ArrayList<EntertainerType> entertainerTypeArrayList){
        entertainerTypes = entertainerTypeArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.entertainer_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = entertainerTypes.get(position);
        holder.radioButton.setText(entertainerTypes.get(position).getName());

        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                entertainerTypes.get(position).setChecked(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return entertainerTypes.size();
    }

    public ArrayList<EntertainerType> getAllChecked() {
        ArrayList<EntertainerType> checkedEntertainerTypes = new ArrayList<>();
        for (int i = 0; i < entertainerTypes.size(); i++) {
            EntertainerType entertainerType = entertainerTypes.get(i);
            if (entertainerType.isChecked()) {
                checkedEntertainerTypes.add(entertainerType);
            }
        }
        return checkedEntertainerTypes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        @BindView(R.id.radio_button)
        CheckBox radioButton;

        public EntertainerType mItem;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
            mView = view;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + radioButton.getText() + "'";
        }
    }
}
