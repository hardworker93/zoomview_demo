package com.example.slidingTabBasic;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.example.bullet.R;


public class MainActivity extends ActionBarActivity {

	ViewPager mViewPager;
	SlidingTabLayout mSlidingTabLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);   
		mViewPager= (ViewPager) findViewById(R.id.pager);
		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new MyAdapter(fm));
		mSlidingTabLayout = (SlidingTabLayout)findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setSelectedIndicatorColors(Color.parseColor("#FFFFFF"));
		mSlidingTabLayout.setViewPager(mViewPager);
		mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
	}

	class MyAdapter extends FragmentStatePagerAdapter  
	{
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public Fragment getItem(int position) {			
			Fragment fragment= FragmentA.newInstance(getTitle(position));
			return fragment;
		}
		@Override
		public int getCount() {
			return 4;
		}
		@Override
		public CharSequence getPageTitle(int position) {
			return getTitle(position);
		}		
		String getTitle(int position){
			String title = "";
			switch (position) {
			case 0:
				title = "CATEGORIES";
				break;
			case 1:
				title = "HOME";
				break;
			case 2:
				title = "TOP PAID";
				break;
			case 3:
				title = "TOP FREE";
				break;
			default:
				break;
			}
			return title;
		}
	}

}
