package com.example.slidingTabBasic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.bullet.R;
import com.example.slidingTabBasic.ZoomView.ZoomViewListener;
public class FragmentA extends Fragment {
	
	public static final String PACKAGE    = "com.example.slidingTabBasic";
	public static final String EXTRA_TEXT = PACKAGE + ".text";
	
	String mMessage;
	ZoomView mZoomView;
	TextView mMsgTextView;
	
	
	public static FragmentA newInstance(String text){
		
		Bundle args = new Bundle();
		args.putString(EXTRA_TEXT, text);
		FragmentA fragment = new FragmentA();
		fragment.setArguments(args);
		return fragment;
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mMessage = getArguments().getString(EXTRA_TEXT);
	}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       
    
    	View v = inflater.inflate(R.layout.fragment_a,container,false);
    	mMsgTextView = (TextView)v.findViewById(R.id.textView);
    	mZoomView    = (ZoomView)v.findViewById(R.id.zoomView);
    	mMsgTextView.setText(mMessage);	
    	mZoomView.smoothZoomTo(1,0,0);
    	return v;
    }
    
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    	super.setUserVisibleHint(isVisibleToUser);
    	if(!isVisibleToUser){
    		if(mZoomView != null)mZoomView.zoomTo(1,0,0);
    	}
    }
    
 
}
