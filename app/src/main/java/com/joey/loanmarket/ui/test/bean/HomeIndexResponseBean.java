package com.joey.loanmarket.ui.test.bean;

import java.util.List;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */

public class HomeIndexResponseBean {

    /**
     * amount_days_list : {"amounts":["20000","30000","40000","50000","60000","70000","80000","90000","100000","110000","120000","130000","140000","150000","160000","170000","180000","190000","200000","210000","220000","230000","240000","250000","260000","270000","280000","290000","300000","310000","320000","330000","340000","350000","360000","370000","380000","390000","400000","410000","420000","430000","440000","450000","460000","470000","480000","490000","500000","510000","520000","530000","540000","550000","560000","570000","580000","590000","600000","610000","620000","630000","640000","650000","660000","670000","680000","690000","700000","710000","720000","730000","740000","750000","760000","770000","780000","790000","800000","810000","820000","830000","840000","850000","860000","870000","880000","890000","900000","910000","920000","930000","940000","950000","960000","970000","980000","990000","1000000","1000000"],"creditVet":["50000.0","110000.0"],"days":["7","14"],"accountManage":["43800.0","63000.0"],"accrual":["4200.0","7000.0"],"interests":["49000","75000"]}
     * item : {"card_title":"狒狒人品","verify_loan_nums":0,"card_amount":"1000000","card_verify_step":"认证0/4","verify_loan_pass":0,"all_auth_Count":5,"new_version_upgrade_url":"http://api.ffrpbank.com:80/getNewAppUpgrade","next_loan_day":"0","risk_status":"0","drainage_url":"http://mobile.souyijie.com/recommend"}
     * user_loan_log_list : []
     * today_last_amount : 123400
     * index_images : [{"reurl":"http://api.ffrpbank.com/gotoAboutIndex","sort":"1","title":"首页活动三","url":"http://api.ffrpbank.com/common/web/images/index_banner2.png"},{"reurl":"http://api.ffrpbank.com/gotoDrawAwardsIndex","sort":"2","title":"首页活动二","url":"http://api.ffrpbank.com/common/web/images/index_banner3.png"}]
     */

    private AmountDaysListBean amount_days_list;
    private ItemBean item;
    private String today_last_amount;
    private List<?> user_loan_log_list;
    private List<IndexImagesBean> index_images;

    public AmountDaysListBean getAmount_days_list() {
        return amount_days_list;
    }

    public void setAmount_days_list(AmountDaysListBean amount_days_list) {
        this.amount_days_list = amount_days_list;
    }

    public ItemBean getItem() {
        return item;
    }

    public void setItem(ItemBean item) {
        this.item = item;
    }

    public String getToday_last_amount() {
        return today_last_amount;
    }

    public void setToday_last_amount(String today_last_amount) {
        this.today_last_amount = today_last_amount;
    }

    public List<?> getUser_loan_log_list() {
        return user_loan_log_list;
    }

    public void setUser_loan_log_list(List<?> user_loan_log_list) {
        this.user_loan_log_list = user_loan_log_list;
    }

    public List<IndexImagesBean> getIndex_images() {
        return index_images;
    }

    public void setIndex_images(List<IndexImagesBean> index_images) {
        this.index_images = index_images;
    }

    public static class AmountDaysListBean {
        private List<String> amounts;
        private List<String> creditVet;
        private List<String> days;
        private List<String> accountManage;
        private List<String> accrual;
        private List<String> interests;

        public List<String> getAmounts() {
            return amounts;
        }

        public void setAmounts(List<String> amounts) {
            this.amounts = amounts;
        }

        public List<String> getCreditVet() {
            return creditVet;
        }

        public void setCreditVet(List<String> creditVet) {
            this.creditVet = creditVet;
        }

        public List<String> getDays() {
            return days;
        }

        public void setDays(List<String> days) {
            this.days = days;
        }

        public List<String> getAccountManage() {
            return accountManage;
        }

        public void setAccountManage(List<String> accountManage) {
            this.accountManage = accountManage;
        }

        public List<String> getAccrual() {
            return accrual;
        }

        public void setAccrual(List<String> accrual) {
            this.accrual = accrual;
        }

        public List<String> getInterests() {
            return interests;
        }

        public void setInterests(List<String> interests) {
            this.interests = interests;
        }

        @Override
        public String toString() {
            return "AmountDaysListBean{" +
                    "amounts=" + amounts +
                    ", creditVet=" + creditVet +
                    ", days=" + days +
                    ", accountManage=" + accountManage +
                    ", accrual=" + accrual +
                    ", interests=" + interests +
                    '}';
        }
    }

    public static class ItemBean {
        /**
         * card_title : 狒狒人品
         * verify_loan_nums : 0
         * card_amount : 1000000
         * card_verify_step : 认证0/4
         * verify_loan_pass : 0
         * all_auth_Count : 5
         * new_version_upgrade_url : http://api.ffrpbank.com:80/getNewAppUpgrade
         * next_loan_day : 0
         * risk_status : 0
         * drainage_url : http://mobile.souyijie.com/recommend
         */

        private String card_title;
        private int verify_loan_nums;
        private String card_amount;
        private String card_verify_step;
        private int verify_loan_pass;
        private int all_auth_Count;
        private String new_version_upgrade_url;
        private String next_loan_day;
        private String risk_status;
        private String drainage_url;

        public String getCard_title() {
            return card_title;
        }

        public void setCard_title(String card_title) {
            this.card_title = card_title;
        }

        public int getVerify_loan_nums() {
            return verify_loan_nums;
        }

        public void setVerify_loan_nums(int verify_loan_nums) {
            this.verify_loan_nums = verify_loan_nums;
        }

        public String getCard_amount() {
            return card_amount;
        }

        public void setCard_amount(String card_amount) {
            this.card_amount = card_amount;
        }

        public String getCard_verify_step() {
            return card_verify_step;
        }

        public void setCard_verify_step(String card_verify_step) {
            this.card_verify_step = card_verify_step;
        }

        public int getVerify_loan_pass() {
            return verify_loan_pass;
        }

        public void setVerify_loan_pass(int verify_loan_pass) {
            this.verify_loan_pass = verify_loan_pass;
        }

        public int getAll_auth_Count() {
            return all_auth_Count;
        }

        public void setAll_auth_Count(int all_auth_Count) {
            this.all_auth_Count = all_auth_Count;
        }

        public String getNew_version_upgrade_url() {
            return new_version_upgrade_url;
        }

        public void setNew_version_upgrade_url(String new_version_upgrade_url) {
            this.new_version_upgrade_url = new_version_upgrade_url;
        }

        public String getNext_loan_day() {
            return next_loan_day;
        }

        public void setNext_loan_day(String next_loan_day) {
            this.next_loan_day = next_loan_day;
        }

        public String getRisk_status() {
            return risk_status;
        }

        public void setRisk_status(String risk_status) {
            this.risk_status = risk_status;
        }

        public String getDrainage_url() {
            return drainage_url;
        }

        public void setDrainage_url(String drainage_url) {
            this.drainage_url = drainage_url;
        }

        @Override
        public String toString() {
            return "ItemBean{" +
                    "card_title='" + card_title + '\'' +
                    ", verify_loan_nums=" + verify_loan_nums +
                    ", card_amount='" + card_amount + '\'' +
                    ", card_verify_step='" + card_verify_step + '\'' +
                    ", verify_loan_pass=" + verify_loan_pass +
                    ", all_auth_Count=" + all_auth_Count +
                    ", new_version_upgrade_url='" + new_version_upgrade_url + '\'' +
                    ", next_loan_day='" + next_loan_day + '\'' +
                    ", risk_status='" + risk_status + '\'' +
                    ", drainage_url='" + drainage_url + '\'' +
                    '}';
        }
    }

    public static class IndexImagesBean {
        /**
         * reurl : http://api.ffrpbank.com/gotoAboutIndex
         * sort : 1
         * title : 首页活动三
         * url : http://api.ffrpbank.com/common/web/images/index_banner2.png
         */

        private String reurl;
        private String sort;
        private String title;
        private String url;

        public String getReurl() {
            return reurl;
        }

        public void setReurl(String reurl) {
            this.reurl = reurl;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "IndexImagesBean{" +
                    "reurl='" + reurl + '\'' +
                    ", sort='" + sort + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HomeIndexResponseBean{" +
                "amount_days_list=" + amount_days_list.toString() +
                ", item=" + item.toString() +
                ", today_last_amount='" + today_last_amount.toString() + '\'' +
                ", user_loan_log_list=" + user_loan_log_list.toString() +
                ", index_images=" + index_images.toString() +
                '}';
    }
}
