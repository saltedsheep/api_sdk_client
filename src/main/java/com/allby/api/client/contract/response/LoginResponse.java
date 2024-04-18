package com.allby.api.client.contract.response;

public class LoginResponse extends BaseResponse {
    private UserLoginData data;

    public UserLoginData getData() {
        return data;
    }

    public void setData(UserLoginData data) {
        this.data = data;
    }

    public class UserLoginData {
        private String nickName;
        private String accessToken;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }
}
