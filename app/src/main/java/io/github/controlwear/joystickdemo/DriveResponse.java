package io.github.controlwear.joystickdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ivan on 2/2/18.
 */

public class DriveResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("request")
    @Expose
    private Drive request;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Drive getRequest() {
        return request;
    }

    public void setRequest(Drive request) {
        this.request = request;
    }
}
