package com.theironyard;

import net.doughughes.testifier.exception.CannotFindMethodException;
import net.doughughes.testifier.matcher.RegexMatcher;
import net.doughughes.testifier.output.OutputStreamInterceptor;
import net.doughughes.testifier.test.TestifierTest;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MainTest extends TestifierTest{

    @Test
    public void testMainMethodInvokesVolumeCubeMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should invoke Volume's cube() method.",
                source, RegexMatcher.matches("^.*?MethodCallExpr.*?NameExpr\\[Volume\\].*?MethodName\\[cube\\].*?\\/MethodCallExpr.*?$"));
    }

    @Test
    public void testMainMethodInvokesVolumeConeMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should invoke Volume's cone() method.",
                source, RegexMatcher.matches("^.*?MethodCallExpr.*?NameExpr\\[Volume\\].*?MethodName\\[cone\\].*?\\/MethodCallExpr.*?$"));
    }

    @Test
    public void testMainMethodInvokesVolumeSphereMethod(){
        /* arrange */

        /* act */
        String source = null;
        try {
            source = codeWatcher.getMainSourceCodeService().getDescriptionOfMethod("main", String[].class);
        } catch (CannotFindMethodException e) {
            fail(e.getMessage());
        }

        /* assert */
        assertThat("The main() method should invoke Volume's sphere() method.",
                source, RegexMatcher.matches("^.*?MethodCallExpr.*?NameExpr\\[Volume\\].*?MethodName\\[sphere\\].*?\\/MethodCallExpr.*?$"));
    }
}