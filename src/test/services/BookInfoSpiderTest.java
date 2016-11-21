package services;
import com.bookcompare.common.BzException;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.BookInfoSpiderBase;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Raymond on 20/11/2016.
 */
public class BookInfoSpiderTest {

    @Test
    public void testAllOnlineShop() {
//        String[] shops = new String[]{"JD", "AMAZON", "DANGDANG", "WINXUAN"};
//        for (String code : shops) {
//            try {
//                BookInfoSpiderBase spider = BookInfoSpiderBase.getSpider(ShopCode.getCodeByName(code), "");
//                Assert.notNull(spider);
//                Assert.isTrue(spider.getSellPrice() == 0.0);
//            } catch (BzException e) {
//                e.printStackTrace();
//            }
//
//        }
//        String url = "https://www.amazon.cn/数学之美-吴军/dp/B00P6OJ09C/ref=lp_658414051_1_2?s=books&ie=UTF8&qid=1479732151&sr=1-2";
        try {

            String name = "Java编程思想";

            
            BookInfoSpiderBase jdSpider = BookInfoSpiderBase.getSpider(ShopCode.JD, name);
            System.out.println(jdSpider.getBook());

            BookInfoSpiderBase amazonSpider = BookInfoSpiderBase.getSpider(ShopCode.WINXUAN, name);
            System.out.println(amazonSpider.getBook());

        } catch (BzException e) {
            e.printStackTrace();
        }
    }
}
