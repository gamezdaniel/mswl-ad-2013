package mswl.ad.layouts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Layouts extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layouts);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layouts, menu);
		return true;
	}

}
