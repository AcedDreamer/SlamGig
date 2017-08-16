package com.slamgig.android.ui.profile.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycardboarddreams.autocompletebubbletext.MultiSelectEditText;
import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.slamgig.android.utilities.DataUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SetEntertainerTypeFragment extends Fragment{

    private static final String TAG = SetEntertainerTypeFragment.class.getSimpleName();
    private OnEntertainerTypesSelectedListener mListener;

    ArrayList<EntertainerType> entertainerTypes = new ArrayList<>();
    ArrayList<EntertainerType> selectedEntertainerTypes = new ArrayList<>();


//    @BindView(R.id.auto_text_complete)
    MultiSelectEditText autoCompleteEditText;

    public SetEntertainerTypeFragment() {
        // Required empty public constructor
    }

    public static SetEntertainerTypeFragment newInstance() {
        return new SetEntertainerTypeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_set_entertainer_type, container, false);
       // ButterKnife.bind(this,view);

        entertainerTypes =  getEntertainerTypes();

        autoCompleteEditText = (MultiSelectEditText)view.findViewById(R.id.auto_text_complete);
        autoCompleteEditText.addAllItems(entertainerTypes);

        //Pull out the ListView from the MultiSelectEditText
        ListView list = autoCompleteEditText.getListView();

        //Add it to a ViewGroup somewhere else in the layout
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        list.setLayoutParams(params);

        FrameLayout frame = (FrameLayout)view.findViewById(R.id.auto_list_container);
        frame.addView(list);

        //Set a listener on bubble clicks
        autoCompleteEditText.setBubbleClickListener(new MultiSelectEditText.BubbleClickListener<EntertainerType>() {

            @Override
            public void onClick(EntertainerType item) {
                Log.d(TAG, "Item: " + item.getReadableName());
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onEntertainerTypesSelected(selectedEntertainerTypes);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnEntertainerTypesSelectedListener) {
            mListener = (OnEntertainerTypesSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnUserTypeSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    ArrayList<EntertainerType> getEntertainerTypes(){

        ArrayList<EntertainerType> returnArray = new ArrayList<>();
        try {
            returnArray = DataUtil.readEntertainerTypeFromResources(getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return returnArray;
    }


    public interface OnEntertainerTypesSelectedListener {
        void onEntertainerTypesSelected(ArrayList<EntertainerType> entertainerTypeArrayList);
    }
}
