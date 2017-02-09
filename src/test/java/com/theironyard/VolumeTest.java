package com.theironyard;

import net.doughughes.testifier.exception.CannotAccessMethodException;
import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.exception.CannotInvokeMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.test.TestifierTest;
import net.doughughes.testifier.util.Invoker;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class VolumeTest extends TestifierTest {

    @Test
    public void testCubeOfEdgeLength1() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "cube", 1.0);

            /* assert */
            assertThat("Volume of a cube with sides of length 1 should be 1",
                    volume, closeTo(1, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCubeOfEdgeLength7Point123() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "cube", 7.123);

            /* assert */
            assertThat("Volume of a cube with sides of length 7.123 should be 361.40056986700006",
                    volume, closeTo(361.40056986700006, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCubeIsStatic(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("cube", double.class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("cube() method should be static",
                source, RegexMatcher.matches("^.*?StaticModifier.*?$"));
    }

    @Test
    public void testCubeDoesNotUseMultiplicationOperator(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("cube", double.class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("cube() method should not use * operator",
                source, not(RegexMatcher.matches("^.*?times.*?$")));
    }

    @Test
    public void testConeOfRadius1Height1() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "cone", 1.0, 1.0);

            /* assert */
            assertThat("Volume of a cone with radius of 1 and height of 1 should be 1.0471975511965976",
                    volume, closeTo(1.0471975511965976, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConeOfRadius3Point4Height5Point5() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "cone", 3.4, 5.5);

            /* assert */
            assertThat("Volume of a cone with radius of 3.4 and height of 5.5 should be 66.58082030507967",
                    volume, closeTo(66.58082030507967, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConeIsStatic(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("cone", double.class, double.class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("cone() method should be static",
                source, RegexMatcher.matches("^.*?StaticModifier.*?$"));
    }


    @Test
    public void testSphereOfRadius1() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "sphere", 1.0);

            /* assert */
            assertThat("Volume of a sphere with radius 1 should be 4.1887902047863905",
                    volume, closeTo(4.1887902047863905, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSphereOfRadius7Point123() {
        /* arrange */

        try {
            /* act */
            double volume = (double) Invoker.invokeStatic(Volume.class, "sphere", 7.123);

            /* assert */
            assertThat("Volume of a sphere with radius 7.123 should be 1513.8311670631094",
                    volume, closeTo(1513.8311670631094, 0.001));

        } catch (CannotInvokeMethodException | CannotFindMethodException | CannotAccessMethodException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSphereIsStatic(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("sphere", double.class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("cube() method should be static",
                source, RegexMatcher.matches("^.*?StaticModifier.*?$"));
    }


}