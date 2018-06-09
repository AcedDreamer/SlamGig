package com.slamgig.android.ui.profile.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.slamgig.android.ui.profile.EntertainerSelectorRecyclerViewAdapter;
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

    @BindView(R.id.error_text)
    TextView errorMessage;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    EntertainerSelectorRecyclerViewAdapter adapter;

    public SetEntertainerTypeFragment() {

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
        ButterKnife.bind(this,view);

        entertainerTypes =  getEntertainerTypes();
        adapter = new EntertainerSelectorRecyclerViewAdapter(entertainerTypes);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(adapter);

//        if (mListener != null) {
//            mListener.onEntertainerTypesSelected(adapter.getAllChecked());
//        }

        return view;
    }

    public void showErrorMessage() {
        errorMessage.setVisibility(View.VISIBLE);
    }

    public void hideErrorMessage() {
        errorMessage.setVisibility(View.GONE);
    }

    public ArrayList<EntertainerType> getSelectedEntertainerTypes(){
        return adapter.getAllChecked();
    }

    @Override
    public void onHiddenChanged(boolean hidden){
        super.onHiddenChanged(hidden);
        if(hidden && mListener != null) {
            mListener.onEntertainerTypesSelected(adapter.getAllChecked());
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
