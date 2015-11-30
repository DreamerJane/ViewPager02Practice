package com.example.viewpager02practice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, OnPageChangeListener {

	//定义ViewPager对象
	private ViewPager viewPager;
	//定义适配器对象
	private ViewPagerAdapter adapter;
	//显示fragment的view对象
	private View first, second, third;
	
	private Button tab1_Btn, tab2_Btn, tab3_Btn;
	
	private List<View> list = new ArrayList<View>();
	
	private int curViewIndex;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
        
        adapter = new ViewPagerAdapter(list);
        viewPager.setAdapter(adapter);
        curViewIndex = 0;
        viewPager.setCurrentItem(curViewIndex);
        viewPager.setOnPageChangeListener(this);
        
    }


    private void initViews() {
    	viewPager = (ViewPager) findViewById(R.id.view_pager);
    	
    	LayoutInflater inflater = getLayoutInflater();
    	first = inflater.inflate(R.layout.fragment_first, null);
    	second = inflater.inflate(R.layout.fragment_second, null);
    	third = inflater.inflate(R.layout.fragment_third, null);
    	
    	list.add(first);
    	list.add(second);
    	list.add(third);
    	
    	tab1_Btn = (Button) findViewById(R.id.btn_tab1);
    	tab2_Btn = (Button) findViewById(R.id.btn_tab2);
    	tab3_Btn = (Button) findViewById(R.id.btn_tab3);
    	tab1_Btn.setOnClickListener(this);
    	tab2_Btn.setOnClickListener(this);
    	tab3_Btn.setOnClickListener(this);
	}

    @Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_tab1:
			viewPager.setCurrentItem(0);
			break;
		case R.id.btn_tab2:
			viewPager.setCurrentItem(1);
			break;
		case R.id.btn_tab3:
			viewPager.setCurrentItem(2);
			break;

		default:
			break;
		}
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int position) {
		if(position < 0 || position > list.size() - 1){
			return;
		}
		viewPager.setCurrentItem(position);
		
	}

	
}

