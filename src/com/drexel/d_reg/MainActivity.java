package com.drexel.d_reg;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = (Button)findViewById(R.id.add);
        final EditText crnEditText = (EditText)findViewById(R.id.crn);
        final EditText nameEditText = (EditText)findViewById(R.id.courseName);
        final ArrayList<Class> classArray = new ArrayList<Class>();
        final ListView list = (ListView)findViewById(R.id.listView1);
        final CArrayAdapter a = new CArrayAdapter(this, classArray);
        list.setAdapter(a);
        add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("".equals(crnEditText.getText().toString()) || "".equals(nameEditText.getText().toString())){
					System.out.println("No.");
				}else{
					System.out.println("yes");
					Class c = new Class(crnEditText.getText().toString(), nameEditText.getText().toString());
					classArray.add(c);
					a.setListData(classArray);
					a.notifyDataSetChanged();
				}
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
