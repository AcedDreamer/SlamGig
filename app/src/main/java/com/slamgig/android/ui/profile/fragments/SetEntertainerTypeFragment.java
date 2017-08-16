package com.slamgig.android.ui.profile.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.slamgig.android.utilities.DataUtil;
import com.slamgig.android.views.EntertainerTypeCompletionView;
import com.tokenautocomplete.FilteredArrayAdapter;
import com.tokenautocomplete.TokenCompleteTextView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SetEntertainerTypeFragment extends Fragment
implements EntertainerTypeCompletionView.TokenListener{

    private OnEntertainerTypesSelectedListener mListener;

    ArrayList<EntertainerType> entertainerTypes = new ArrayList<>();
    ArrayList<EntertainerType> selectedEntertainerTypes = new ArrayList<>();

    @BindView(R.id.select_entertainer_view)
    EntertainerTypeCompletionView completionView;
    @BindView(R.id.tokens)
    TextView tokens;

    ArrayAdapter<EntertainerType> adapter;

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
        ButterKnife.bind(this,view);

        entertainerTypes =  getEntertainerTypes();

        adapter = new FilteredArrayAdapter<EntertainerType>(getActivity(), R.layout.entertainer_type_item_layout, entertainerTypes) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater l = (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                    convertView = l.inflate(R.layout.entertainer_type_item_layout, parent, false);
                }

                EntertainerType type = getItem(position);
                ((TextView)convertView.findViewById(R.id.name)).setText(type.getName());

                return convertView;
            }

            @Override
            protected boolean keepObject(EntertainerType entertainerType, String mask) {
                mask = mask.toUpperCase();
                return entertainerType.getName().toUpperCase().startsWith(mask);
            }
        };

        completionView.setAdapter(adapter);
        completionView.setTokenListener(this);
        completionView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.None);

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

    private void updateTokenConfirmation() {
        StringBuilder sb = new StringBuilder("Current tokens:\n");
        for (Object token: completionView.getObjects()) {
            sb.append(token.toString());
            sb.append("\n");
        }

        tokens.setText(sb);
    }

    @Override
    public void onTokenAdded(Object token) {
        updateTokenConfirmation();
    }

    @Override
    public void onTokenRemoved(Object token) {
        updateTokenConfirmation();
    }

    public interface OnEntertainerTypesSelectedListener {
        void onEntertainerTypesSelected(ArrayList<EntertainerType> entertainerTypeArrayList);
    }
}
