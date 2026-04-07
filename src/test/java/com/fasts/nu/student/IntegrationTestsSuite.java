package com.fasts.nu.student;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("com.fasts.nu.student")
@IncludeTags("integration")
public class IntegrationTestsSuite {
    // Runs only @Tag("integration") tests
}
