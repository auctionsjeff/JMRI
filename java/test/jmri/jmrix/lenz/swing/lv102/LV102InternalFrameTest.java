package jmri.jmrix.lenz.swing.lv102;

import java.awt.GraphicsEnvironment;
import jmri.jmrix.lenz.LenzCommandStation;
import jmri.jmrix.lenz.XNetInterfaceScaffold;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

/**
 * LV102InternalFrameTest.java
 *
 * Description:	tests for the jmri.jmrix.lenz.swing.lv102.LV102InternalFrame class
 *
 * @author	Paul Bender
 */
public class LV102InternalFrameTest {

    @Test
    public void testCtor() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        LV102InternalFrame f = new LV102InternalFrame();
        Assert.assertNotNull(f);
    }

    @Test
    public void testResetButton() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // we are building an LV102Frame here, which automatically contains 
        // an LV102 Internal Frame
        LV102Frame f = new LV102Frame(Bundle.getMessage("LV102Config"));
        f.setVisible(true);
        LV102FrameScaffold operator = new LV102FrameScaffold();
        operator.pushResetButton();
        Assert.assertEquals("Default Voltage","",operator.getSelectedVoltage());
        f.setVisible(false);
    }

    @Test
    public void testDefaultButton() {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        // we are building an LV102Frame here, which automatically contains 
        // an LV102 Internal Frame
        LV102Frame f = new LV102Frame(Bundle.getMessage("LV102Config"));
        f.setVisible(true);
        LV102FrameScaffold operator = new LV102FrameScaffold();
        operator.pushDefaultButton();
        Assert.assertEquals("Default Voltage","16V (factory default)",operator.getSelectedVoltage());
        f.setVisible(false);
    }


    // The minimal setup for log4J
    @Before
    public void setUp() {
        apps.tests.Log4JFixture.setUp();
    }

    @After
    public void tearDown() {
        apps.tests.Log4JFixture.tearDown();
    }

}
