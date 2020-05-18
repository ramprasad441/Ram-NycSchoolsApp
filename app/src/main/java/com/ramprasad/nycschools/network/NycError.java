package com.ramprasad.nycschools.network;

/**
 * Created by Ramprasad on 5/16/20.
 */
public class NycError {
    //required parameters
    private String errorMsg;

    //optional parameters
    private String errorDescription;
    private String errorCode;
    private String deviceType;
    private String serialNumber;
    private String errorResponse;

    public String getErrorResponse() {
        return errorResponse;
    }

    void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }


    private NycError(NycErrorBuilder builder) {
        this.errorMsg = builder.errorMsg;
        this.errorDescription = builder.errorDescription;
        this.errorCode = builder.errorCode;
    }

    //Builder Class
    static class NycErrorBuilder {

        // required parameters
        private String errorMsg;

        // optional parameters
        private String errorDescription;
        private String errorCode;

        NycErrorBuilder(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        NycErrorBuilder setErrorDescription(String errorDescription) {
            this.errorDescription = errorDescription;
            return this;
        }

        NycErrorBuilder setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        NycErrorBuilder setRequestMethod(String requestMethod) {
            return this;
        }

        NycError build() {
            return new NycError(this);
        }

    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceSerialNumber() {
        return serialNumber;
    }


}
