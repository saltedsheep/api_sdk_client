package com.allby.api.client.contract.response;

/**
 * Description :
 * Created by Angus on 2024/4/7 11:34
 */
public class GetBehaviorInfoResponse extends BaseResponse{
    private static final long serialVersionUID = 111L;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
