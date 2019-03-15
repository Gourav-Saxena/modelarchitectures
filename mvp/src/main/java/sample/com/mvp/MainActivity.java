package sample.com.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewImpl {

    ImageView iv_image;
    TextView txt_temp;
    Button btn_click;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_image = findViewById(R.id.iv_image);
        txt_temp = findViewById(R.id.txt_temp);
        btn_click = findViewById(R.id.btn_click);
        presenter = new Presenter(this);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendNetworkCall();
            }
        });
    }

    @Override
    public void updateTextView(final String textData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txt_temp.setText(textData);
            }
        });

    }
}
