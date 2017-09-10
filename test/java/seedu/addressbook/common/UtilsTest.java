package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() {
        //empty object
        assertNoNull();

        //No null objects
        assertNoNull("abc", 1, 'a');
        assertNoNull(2);
        assertNoNull("hello");
        assertNoNull("one", "two");

        //One or more null objects
        assertHasNull((Object) null);
        assertHasNull((Object) null, "one");
        assertHasNull((Object) null, 1, 2);
        assertHasNull((Object) null, (Object) null, "one");
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    public void assertNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    public void assertHasNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
