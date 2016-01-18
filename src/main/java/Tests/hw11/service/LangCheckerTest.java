package hw11.service;

import hw11.service.utils.LangChecker;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin_Spring.
 * Date: 17.01.2016.
 * Time: 11:29.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class LangCheckerTest {

    private LangChecker langChecker;
    @Before
    public void setUp() throws Exception {
        langChecker = new LangChecker();
    }

    @Test
    public void testCheckLanguage() throws Exception {
     /*   Assert.assertEquals(langChecker.checkLanguage("ABC"),"eng");
        Assert.assertEquals(langChecker.checkLanguage("ABC1"),"1");
        Assert.assertEquals(langChecker.checkLanguage("фывыф"),"rus");
        Assert.assertEquals(langChecker.checkLanguage("фівфів"),"ukr");
        Assert.assertEquals(langChecker.checkLanguage("фівфівs"),"s");
        Assert.assertEquals(langChecker.checkLanguage("фівфівsыаё"),"s");*/
    }

    @Test
    public void testGetMax() throws Exception {
        /*ukr rus rusUkr eng*/
/*        Assert.assertEquals(langChecker.getMax(-12, -22, 0, -95),0);
        Assert.assertEquals(langChecker.getMax(0, 0, -1, -95),0);
        Assert.assertEquals(langChecker.getMax(12, 22, 54, -95),54);*/

    }
}