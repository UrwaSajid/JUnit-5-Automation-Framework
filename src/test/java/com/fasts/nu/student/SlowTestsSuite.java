package com.fasts.nu.student;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("com.fasts.nu.student")
@IncludeTags("slow")
public class SlowTestsSuite {
    // Runs only @Tag("slow") tests
}