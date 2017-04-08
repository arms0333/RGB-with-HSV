package com.algonquincollege.arms0333.hsvcolorpicker;

import android.os.Bundle;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;
import model.HSVModel;


public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener
{
    // INSTANCE VARIABLES/members
    private AboutDialogFragment mAboutDialog;
    private TextView mColorSwatch;
    private HSVModel mModel;
    private SeekBar mHueSB;
    private SeekBar mSatSB;
    private SeekBar mValSB;
    private TextView mHueTitle;
    private TextView mSatTitle;
    private TextView mValTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setting dialog
        mAboutDialog = new AboutDialogFragment();

        // Instantiate a new HSV model
        mModel = new HSVModel();
        mModel.setHue(HSVModel.MIN_HSV);
        mModel.setSaturation(HSVModel.MIN_HSV);
        mModel.setValue(HSVModel.MIN_HSV);
        // The Model is observing this Controller (class MainActivity implements Observer)
        mModel.addObserver(this);
        // reference each View
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.seekBarHue);
        mSatSB = (SeekBar) findViewById(R.id.seekBarSat);
        mValSB = (SeekBar) findViewById(R.id.seekBarVal);
        mHueTitle = (TextView) findViewById(R.id.hueTitle);
        mSatTitle = (TextView) findViewById(R.id.satTitle);
        mValTitle = (TextView) findViewById(R.id.valTitle);

        mHueSB.setMax(HSVModel.MAX_HUE);
        mSatSB.setMax(HSVModel.MAX_SAT);
        mValSB.setMax(HSVModel.MAX_VAL);

        mHueSB.setOnSeekBarChangeListener(this);// register the event handler for each <SeekBar
        mSatSB.setOnSeekBarChangeListener(this);// register the event handler for each <SeekBar
        mValSB.setOnSeekBarChangeListener(this);// register the event handler for each <SeekBar
        // initialize the View to the values of the Model
        this.updateView();
    }
    /**
     * Event handler for the <SeekBar>s
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if (fromUser == false)
        {
            return;
        }
        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId())
        {
            case R.id.seekBarHue:
                mModel.setHue( (float) progress );
                mHueTitle.setText(getResources().getString(R.string.hueProgress, progress).toUpperCase());
                break;

            case R.id.seekBarSat:
                mModel.setSaturation( (float) progress );
                mSatTitle.setText(getResources().getString(R.string.satProgress, progress).toUpperCase());
                break;

            case R.id.seekBarVal:
                mModel.setValue( (float) progress );
                mValTitle.setText(getResources().getString(R.string.valProgress, progress).toUpperCase());
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar)
    {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar)
    {

        // chnages the text back to small characters
        switch (seekBar.getId())
        {
            case R.id.seekBarHue:
                mHueTitle.setText("hue");
                break;

            case R.id.seekBarSat:

                mSatTitle.setText("saturation");
                break;

            case R.id.seekBarVal:
                mValTitle.setText("value");
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onButtonChangeBottom(View view)
    {

        //colour wheel
        switch (view.getId())
        {


            case R.id.blackButton:
                Toast.makeText(this,"Black", Toast.LENGTH_LONG).show();
                mModel.asBlack();
                break;

            case R.id.redButton:
                Toast.makeText(this,"Red", Toast.LENGTH_LONG).show();
                mModel.asRed();
                break;

            case R.id.limeButton:
                Toast.makeText(this,"Lime", Toast.LENGTH_LONG).show();
                mModel.asLime();
                break;

            case R.id.blueButton:
                Toast.makeText(this,"Blue", Toast.LENGTH_LONG).show();
                mModel.asBlue();
                break;

            case R.id.yellowButton:
                Toast.makeText(this,"Yellow", Toast.LENGTH_LONG).show();
                mModel.asYellow();
                break;

            case R.id.cyanButton:
                Toast.makeText(this,"Cyan", Toast.LENGTH_LONG).show();
                mModel.asCyan();
                break;

            case R.id.magentaButton:
                Toast.makeText(this,"Magenta", Toast.LENGTH_LONG).show();
                mModel.asMagenta();
                break;

            case R.id.silverButton:
                Toast.makeText(this,"Silver", Toast.LENGTH_LONG).show();
                mModel.asSilver();
                break;

            case R.id.grayButton:
                Toast.makeText(this,"Gray", Toast.LENGTH_LONG).show();
                mModel.asGray();
                break;

            case R.id.maroonButton:
                Toast.makeText(this,"Maroon", Toast.LENGTH_LONG).show();
                mModel.asMaroon();
                break;

            case R.id.oliveButton:
                Toast.makeText(this,"Olive", Toast.LENGTH_LONG).show();
                mModel.asOlive();
                break;

            case R.id.greenButton:
                Toast.makeText(this,"Green", Toast.LENGTH_LONG).show();
                mModel.asGreen();
                break;

            case R.id.purpleButton:
                Toast.makeText(this,"Purple", Toast.LENGTH_LONG).show();
                mModel.asPurple();
                break;

            case R.id.tealButton:
                Toast.makeText(this,"Teal", Toast.LENGTH_LONG).show();
                mModel.asTeal();
                break;

            case R.id.navyButton:
                Toast.makeText(this,"Navy", Toast.LENGTH_LONG).show();
                mModel.asNavy();
                break;
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_about:
                mAboutDialog.show(getFragmentManager(), "About_Dialog");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data)
    {
        this.updateView();
    }


    private void updateColorSwatch()
    {
        //update colours && set the textview swatch
        int theColor = Color.HSVToColor(new float[] { mModel.getHue(), mModel.getSaturation()/100, mModel.getValue()/100 });
        mColorSwatch.setBackgroundColor( theColor );
    }

    // synchronize each View component with the Model
    public void updateView()
    {
        this.updateColorSwatch();
    }
}

