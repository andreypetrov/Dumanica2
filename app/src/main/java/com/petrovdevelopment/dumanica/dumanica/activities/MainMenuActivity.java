package com.petrovdevelopment.dumanica.dumanica.activities;

import java.util.Arrays;
import java.util.List;

import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.petrovdevelopment.dumanica.dumanica.R;
import com.petrovdevelopment.dumanica.dumanica.adapters.MainMenuAdapter;
import com.petrovdevelopment.dumanica.dumanica.util.U;

public class MainMenuActivity extends DrawerActivity {

	@InjectView(R.id.mainMenu) ListView mMainMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// getActionBar().hide();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_drawer);
		initDrawersHandlers();
		initMainMenu();
	}

	public void initMainMenu() {
		List<String> menuOptions = getMenuOptions();
		mMainMenu.setAdapter(getMainMenuAdapter(menuOptions));
		mMainMenu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				switch (position) {
				case 0:
					openGuessActivity();
					break;
				case 1:
					U.log(this, "second button");
					break;
				case 2:
					U.log(this, "third button");
					break;
				default: // do nothing
				}
			}
		});
	}

	protected void openGuessActivity() {
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
	}

	private List<String> getMenuOptions() {
		return Arrays.asList(getResources().getStringArray(R.array.main_menu));
	}

	private ListAdapter getMainMenuAdapter(List<String> menuOptions) {
		return new MainMenuAdapter(menuOptions, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.home_action_bar, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item); // ensures fragments can also handle the call
		}
	}

	private void openSettings() {
		// TODO Auto-generated method stub
		U.log(this, "OpenSettings");
	}
}
