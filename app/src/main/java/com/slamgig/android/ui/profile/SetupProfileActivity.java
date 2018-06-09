package com.slamgig.android.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.slamgig.android.R;
import com.slamgig.android.model.EntertainerType;
import com.slamgig.android.ui.profile.fragments.SetAvatarUsernameFragment;
import com.slamgig.android.ui.profile.fragments.SetEntertainerTypeFragment;
import com.slamgig.android.ui.profile.fragments.SetEntertainmentTypeFragment;
import com.slamgig.android.ui.profile.fragments.SetUserTypeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class SetupProfileActivity extends AppCompatActivity
    implements ViewPager.OnPageChangeListener, SetUserTypeFragment.OnUserTypeSelectedListener,
        SetEntertainerTypeFragment.OnEntertainerTypesSelectedListener, SetEntertainmentTypeFragment.OnFragmentInteractionListener,
    SetAvatarUsernameFragment.OnFragmentInteractionListener{

    MyFragmentPagerAdapter mPagerAdapter;
    final int FRAGMENTS_LENGTH = 4;
    private int ENTERTAINER_TYPE_FRAGMENT_INDEX = 1;

    @BindView(R.id.view_pager)
    ViewPager mPager;

    @BindView(R.id.btn_next)
    Button btnNext;
    @OnClick(R.id.btn_next)
    public void next(Button btnNext) {
        int current = getItem(+1);
        if (current < FRAGMENTS_LENGTH) {
            // move to next screen
            mPager.setCurrentItem(current);
        } else {
            launchProfilePage();
        }

        if(current == ++ENTERTAINER_TYPE_FRAGMENT_INDEX){
            validateEntertainerTypes();
        }
    }

    @BindView(R.id.btn_skip)
    Button btnSkip;
    @OnClick(R.id.btn_skip)
    public void skip(Button skipBtn) {
        launchProfilePage();
    }

    @BindView(R.id.indicator)
    CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_profile);
        ButterKnife.bind(this);

        mPager.setOffscreenPageLimit(3); // Helps to keep fragment alive, otherwise I will have to load again images
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),FRAGMENTS_LENGTH);
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(this);

        indicator.setViewPager(mPager);
        mPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
    }

    void launchProfilePage(){
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    private void validateEntertainerTypes(ArrayList<EntertainerType> entertainerTypeArrayList){
        if(entertainerTypeArrayList.size() == 0){
            mPager.get
         }
    }

    private int getItem(int i) {
        return mPager.getCurrentItem() + i;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        // changing the next button text 'NEXT' / 'GOT IT'
        if (position == FRAGMENTS_LENGTH - 1) {
            // last page. make button text to GOT IT
            btnNext.setText(getString(R.string.start));
            btnSkip.setVisibility(View.GONE);
        } else {
            // still pages are left
            btnNext.setText(getString(R.string.next));
            btnSkip.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onUserTypeSelected(String userType) {


    }

    @Override
    public void onEntertainerTypesSelected(ArrayList<EntertainerType> entertainerTypeArrayList) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
