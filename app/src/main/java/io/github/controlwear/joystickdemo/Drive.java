package io.github.controlwear.joystickdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ivan on 2/2/18.
 */

public class Drive {

    @SerializedName("speed")
    @Expose
    private Integer speed;
    @SerializedName("angle")
    @Expose
    private Integer angle;
    @SerializedName("forward")
    @Expose
    private Boolean forward;

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

    public Boolean getForward() {
        return forward;
    }

    public void setForward(Boolean forward) {
        this.forward = forward;
    }
}
