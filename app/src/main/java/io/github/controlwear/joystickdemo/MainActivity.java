package io.github.controlwear.joystickdemo;

import java.io.IOException;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class MainActivity extends AppCompatActivity {

    private Integer previousStrength = 0;
    private Integer previousAngle = 0;
    private Integer steeringAngle;
    private Boolean forward;
    private TextView mTextViewAngle;
    private TextView mTextViewStrength;
    private TextView mTextViewDirection;
    private RCCarService service;
    private Drive drive;

    public void sendDrive(Drive drive) {
        service
            .getAPI()
            .drive(drive)
            .enqueue(new Callback<DriveResponse>() {
                @Override
                public void onResponse(Call<DriveResponse> call, Response<DriveResponse> response) {
                    DriveResponse result = response.body();
                    System.out.println("status: " + result.getStatus());
                    System.out.println("speed: " + result.getRequest().getSpeed());
                    System.out.println("angle: " + result.getRequest().getAngle());
                    System.out.println("forward: " + String.valueOf(result.getRequest().getForward()));
                }

                @Override
                public void onFailure(Call<DriveResponse> call, Throwable t) {
                    try {
                        throw new InterruptedException("Error sending request!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewAngle = (TextView) findViewById(R.id.textView_angle);
        mTextViewStrength = (TextView) findViewById(R.id.textView_strength);
        mTextViewDirection = (TextView) findViewById(R.id.textView_direction);

        service = new RCCarService();
        drive = new Drive();

        JoystickView joystick = (JoystickView) findViewById(R.id.joystickView);
        joystick.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                if ((previousAngle != angle) || (previousStrength != strength)) {
                    previousAngle = angle;
                    previousStrength = strength;
                    forward = angle < 180;
                    steeringAngle = forward ? 90 - angle : -(90 - angle % 180);
                    if (steeringAngle != 0) {
                        mTextViewAngle.setText((steeringAngle < 0 ? "Left " : "Right ") + steeringAngle + "°");
                    } else {
                        mTextViewAngle.setText("Straight");
                    }
                    mTextViewStrength.setText(strength == 0 ? "Stopped" : "Speed " + strength + "%");
                    mTextViewDirection.setText(forward ? "Forward" : "Backward");
                    drive.setAngle(steeringAngle);
                    drive.setSpeed(strength);
                    drive.setForward(forward);
                    sendDrive(drive);
                }
            }
        });
    }
}
