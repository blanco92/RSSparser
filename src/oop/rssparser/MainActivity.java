package oop.rssparser;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
	
    private NewParser parser;
    private List<PostItem> messages;
    

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parser = new NewParser();
        messages = parser.parse();
        List<String> titles = new ArrayList<String>(messages.size());
    	for (PostItem msg : messages){
    		titles.add(msg.getTitle());
    	}
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,titles);
      setListAdapter(adapter);        
    }
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String lMessage = messages.get(position).toString();
		

	 	Intent intent = new Intent();
		intent.setClass(MainActivity.this, Novosti.class);
			Bundle b = new Bundle();
			b.putString("key", lMessage);  
			intent.putExtras(b);
		startActivity(intent);  
	}
}