package seedu.duke.model.item;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModuleTest {

    @Test
    void checkValidMcs_0mcs_returnsTrue() {
        boolean result = Module.checkValidMcs(0);
        assertTrue(result);
    }

    @Test
    void checkValidMcs_negativeMcs_returnsFalse() {
        boolean result = Module.checkValidMcs(-1);
        assertFalse(result);
    }

    @Test
    void checkValidMcs_40mcs_returnsTrue() {
        boolean result = Module.checkValidMcs(40);
        assertTrue(result);
    }

    @Test
    void checkValidMcs_41mcs_returnsFalse() {
        boolean result = Module.checkValidMcs(41);
        assertFalse(result);
    }

    @Test
    void checkValidMcs_4mcs_returnsTrue() {
        boolean result = Module.checkValidMcs(4);
        assertTrue(result);
    }

    @Test
    void checkValidAy_AY2021S1_returnsTrue() {
        boolean result = Module.checkValidAy("2021S1");
        assertTrue(result);
    }

    @Test
    void checkValidAy_AY2021S2_returnsTrue() {
        boolean result = Module.checkValidAy("2021S2");
        assertTrue(result);
    }

    @Test
    void checkValidAy_AY2021S3_returnsFalse() {
        boolean result = Module.checkValidAy("2021S3");
        assertFalse(result);
    }

    @Test
    void checkValidAy_AY2021S0_returnsFalse() {
        boolean result = Module.checkValidAy("2021S0");
        assertFalse(result);
    }

    @Test
    void checkValidAy_AY2011S1_returnsFalse() {
        boolean result = Module.checkValidAy("2011S1");
        assertFalse(result);
    }
}