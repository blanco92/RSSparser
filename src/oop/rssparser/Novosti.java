package oop.rssparser;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class Novosti extends Activity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.novosti);
		
		Bundle bundle = getIntent().getExtras();
		String lMessage = bundle.getString("key"); //получаем строку и формируем имя ресурса
		
        WebView myWebView = (WebView) findViewById(R.id.webview);
          myWebView.loadDataWithBaseURL("",lMessage, "text/html","utf-8", null);
		
	}
	

}