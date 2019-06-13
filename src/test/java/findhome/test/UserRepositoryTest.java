package findhome.test;

import findhome.FindhomeApplicationTests;
import findhome.bean.User;
import findhome.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * 以动手实践为荣,以只看不练为耻.
 * 以打印日志为荣,以出错不报为耻.
 * 以局部变量为荣,以全局变量为耻.
 * 以单元测试为荣,以手工测试为耻.
 * 以代码重用为荣,以复制粘贴为耻.
 * 以多态应用为荣,以分支判断为耻.
 * 以定义常量为荣,以魔法数字为耻.
 * 以总结思考为荣,以不求甚解为耻.
 *
 * @author LvZheng
 * 创建时间：2019/6/10 下午7:07
 */
public class UserRepositoryTest extends FindhomeApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void getone(){

        User user = userRepository.findByName("admin");
        System.out.println(user);
        Assert.assertEquals("admin",user.getName());
    }
}
