package services;
import com.bookcompare.common.BzException;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.BookInfoSpiderBase;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Created by Raymond on 20/11/2016.
 */
public class BookInfoSpiderTest {

    @Test
    public void testAllOnlineShop() {
        String[] shops = new String[]{"JD", "AMAZON", "DANGDANG", "WINXUAN"};
        for (String code : shops) {
            try {
                BookInfoSpiderBase spider = BookInfoSpiderBase.getSpider(ShopCode.getCodeByName(code), "");
                Assert.notNull(spider);
                Assert.isTrue(spider.getSellPrice() == 0.0);
            } catch (BzException e) {
                e.printStackTrace();
            }

        }
    }
}
