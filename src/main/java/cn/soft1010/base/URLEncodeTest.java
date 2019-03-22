package cn.soft1010.base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author bjzhangjifu
 * @date 2019/3/14
 */
public class URLEncodeTest {

    public static void main(String[] args) {
        try {
            System.out.println(URLEncoder.encode("https://emarketing.netease.com/contractreserve/queryContractListResult.do?id=&code=035958&type=&cpxType=&signDateBegin=&signDateEnd=&ownerUserId=&commitDateBegin=&commitDateEnd=&state=&approvalState=&area=&isBacked=&topic=&maintainUserId=0&agentCompanyName=&agentCompanyId=&directClientCompanyName=&directClientCompanyId=&queryContractByCondition=%B0%B4%CC%F5%BC%FE%B2%E9%D1%AF","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
