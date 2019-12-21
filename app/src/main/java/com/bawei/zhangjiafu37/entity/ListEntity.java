package com.bawei.zhangjiafu37.entity;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class ListEntity {
    List<resule> result;

    public List<resule> getResult() {
        return result;
    }

    public void setResult(List<resule> result) {
        this.result = result;
    }

    public class resule{
        String commodityId;
        String commodityName;
        String masterPic;
        String price;
        String saleNum;

        @Override
        public String toString() {
            return "resule{" +
                    "commodityId='" + commodityId + '\'' +
                    ", commodityName='" + commodityName + '\'' +
                    ", masterPic='" + masterPic + '\'' +
                    ", price='" + price + '\'' +
                    ", saleNum='" + saleNum + '\'' +
                    '}';
        }

        public String getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(String commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(String saleNum) {
            this.saleNum = saleNum;
        }
    }
}
