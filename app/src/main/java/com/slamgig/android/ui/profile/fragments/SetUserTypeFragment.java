package com.slamgig.android.ui.profile.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.slamgig.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnUserTypeSelectedListener} interface
 * to handle interaction events.
 * Use the {@link SetUserTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetUserTypeFragment extends Fragment {

    private OnUserTypeSelectedListener mListener;

    @BindView(R.id.user_type_button_group)
    RadioGroup radioGroup;

    @BindView(R.id.entertainer_button)
    RadioButton entertainerButton;

    @BindView(R.id.slammer_button)
    RadioButton slammerButton;

    @BindView(R.id.error_text)
    public TextView errorText;

    public SetUserTypeFragment() {
        // Required empty public constructor
    }

    public static SetUserTypeFragment newInstance() {
        return new SetUserTypeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_set_user_type, container, false);
        ButterKnife.bind(this,view);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                RadioButton selectedButton = (RadioButton) view.findViewById(selectedId);
                if (mListener != null) {
                    mListener.onUserTypeSelected(selectedButton.getText().toString());
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUserTypeSelectedListener) {
            mListener = (OnUserTypeSelectedListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnUserTypeSelectedListener {
        // TODO: Update argument type and name
        void onUserTypeSelected(String userType);
    }
}
