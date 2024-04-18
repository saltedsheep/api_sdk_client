package com.allby.api.client.contract.response;

import java.util.List;

/**
 * Description :
 * Created by Angus on 2024/4/6 21:17
 */
public class GetLibClientResponse extends BaseResponse {

    private static final long serialVersionUID = 10L;
    private LibClientData data;

    public LibClientData getData() {
        return data;
    }

    public void setData(LibClientData data) {
        this.data = data;
    }

    public static class LibClientData {

        private List<LibsData> libs;

        public List<LibsData> getLibs() {
            return libs;
        }

        public void setLibs(List<LibsData> libs) {
            this.libs = libs;
        }
    }

    public static class LibsData {
        private String code;
        private String name;
        private String descri;
        private String area;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescri(String descri) {
            this.descri = descri;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescri() {
            return descri;
        }

    }
}
