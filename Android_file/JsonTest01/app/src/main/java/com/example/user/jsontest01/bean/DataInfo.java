package com.example.user.jsontest01.bean;

import java.util.List;

public class DataInfo {


    @Override
    public String toString() {
        return "DataInfo{" +
                "data=" + data +
                ", rs_code='" + rs_code + '\'' +
                ", rs_msg='" + rs_msg + '\'' +
                '}';
    }

    /**
     * data : {"count":5,"item":[{"id":45,"title":"ha"},{"id":46,"title":"ah"},{"id":47,"title":"ma"}]}
     * rs_code : 1000
     * rs_msg : success
     */

    private DataBean data;
    private String rs_code;
    private String rs_msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getRs_code() {
        return rs_code;
    }

    public void setRs_code(String rs_code) {
        this.rs_code = rs_code;
    }

    public String getRs_msg() {
        return rs_msg;
    }

    public void setRs_msg(String rs_msg) {
        this.rs_msg = rs_msg;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", item=" + item +
                    '}';
        }

        /**
         * count : 5
         * item : [{"id":45,"title":"ha"},{"id":46,"title":"ah"},{"id":47,"title":"ma"}]
         */

        private int count;
        private List<ItemBean> item;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemBean> getItem() {
            return item;
        }

        public void setItem(List<ItemBean> item) {
            this.item = item;
        }

        public static class ItemBean {
            @Override
            public String toString() {
                return "ItemBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        '}';
            }

            /**
             * id : 45
             * title : ha
             */

            private int id;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
