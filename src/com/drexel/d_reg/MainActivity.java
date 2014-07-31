package com.drexel.d_reg;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
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
        list.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int pos, long arg3) {
				DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
				    @Override
				    public void onClick(DialogInterface dialog, int which) {
				        switch (which){
				        case DialogInterface.BUTTON_POSITIVE:
				        	classArray.remove(pos);
				        	a.setListData(classArray);
							a.notifyDataSetChanged();
				            break;

				        case DialogInterface.BUTTON_NEGATIVE:
				            
				            break;
				        }
				    }
				};

				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setMessage("Are you sure you want to remove this item?").setPositiveButton("Yes", dialogClickListener)
				    .setNegativeButton("No", dialogClickListener).show();
				return false;
			}
		});
        add.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("".equals(nameEditText.getText().toString())) {
					nameEditText.setError(getString(R.string.error_field_required));
				} else{
					nameEditText.setError(null);
				}
				if ("".equals(crnEditText.getText().toString())) {
					crnEditText.setError(getString(R.string.error_field_required));	
				} else {
					crnEditText.setError(null);
				}
				if (!("".equals(crnEditText.getText().toString()) || "".equals(nameEditText.getText().toString()))){
					classArray.add(new Class(crnEditText.getText().toString(), nameEditText.getText().toString()));
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
