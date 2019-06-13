package findhome.service.house;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import findhome.FindhomeApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by 瓦力.
 */
public class QiNiuServiceTests extends FindhomeApplicationTests {
    @Autowired
    private IQiNiuService qiNiuService;

    @Test
    public void testUploadFile() {
        String fileName = "/Users/a645661167/idea-work/findhome/images/吕_正.png";
        File file = new File(fileName);

        Assert.assertTrue(file.exists());

        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        String key = "FiA915a-JdItlOA3RAymipPldGWP";
        try {
            Response response = qiNiuService.delete(key);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
