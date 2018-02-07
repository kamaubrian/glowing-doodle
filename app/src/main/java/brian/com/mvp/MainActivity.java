package brian.com.mvp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements MainView {

    private TextView textView;
    private Button button;
    private ProgressBar progressBar;
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        presenter = new MainPresenterImpl(this,new GetQuoteInteractorImpl());

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                presenter.onButtonClick();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setQuote(String string) {
        textView.setText(string);
    }
}
