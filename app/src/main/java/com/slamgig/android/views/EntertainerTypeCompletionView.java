package com.slamgig.android.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Created by adaobifrank on 8/16/17.
 */

public class EntertainerTypeCompletionView extends TokenCompleteTextView<EntertainerType> {

    public EntertainerTypeCompletionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View getViewForObject(EntertainerType entertainerType) {

        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TextView view = (TextView) l.inflate(R.layout.entertainer_type_token, (ViewGroup) getParent(), false);
        view.setText(entertainerType.getName());

        return view;
    }

    @Override
    protected EntertainerType defaultObject(String completionText) {
        return new EntertainerType(completionText);
    }
}