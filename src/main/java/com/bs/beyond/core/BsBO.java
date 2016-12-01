package com.bs.beyond.core;

public class BsBO
{

    private String bsResult;
    private String bsMessage;

    
    public BsBO()
    {
    	this.setBsResult(BsConst.ResultCode.SUCCESS);
    	this.setBsMessage("");
    }
    
    public String getBsResult() {
        return bsResult;
    }
    public void setBsResult(String bsResult) {
        this.bsResult = bsResult;
    }

    public String getBsMessage() {
        return bsMessage;
    }
    public void setBsMessage(String bsMessage) {
        this.bsMessage = bsMessage;
    }

}
