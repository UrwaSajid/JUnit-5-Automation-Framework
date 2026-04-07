package com.fasts.nu.student;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("com.fasts.nu.student")
@IncludeTags("fast")
public class FastTestsSuite {
    // Runs only @Tag("fast") tests
}