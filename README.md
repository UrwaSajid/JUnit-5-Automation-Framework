

##  Project Overview

A complete **Advanced JUnit 5 Automation Framework** built on top of a Student Management System. This project demonstrates scalable, maintainable, and data-driven unit testing using real-world practices including modular testing, test orchestration, parallel execution, and coverage reporting.

---

<img width="1013" height="249" alt="image" src="https://github.com/user-attachments/assets/36a61ed7-048d-4510-990c-2cae05413be1" />


##  Project Structure

```
student-management-system/
├── src/
│   ├── main/java/com/fasts/nu/student/
│   │   ├── Student.java
│   │   ├── Course.java
│   │   ├── Teacher.java
│   │   ├── Enrollment.java
│   │   ├── Grade.java
│   │   ├── StudentManagementSystem.java
│   │   └── Main.java
│   │
│   └── test/
│       ├── java/com/fasts/nu/student/
│       │   ├── StudentTest.java               # @Tag("fast")
│       │   ├── CourseTest.java                # @Tag("fast")
│       │   ├── GradeTest.java                 # @Tag("slow") + @TestMethodOrder
│       │   ├── EnrollmentTest.java            # @Tag("integration")
│       │   ├── TeacherTest.java               # @Tag("fast")
│       │   ├── StudentManagementSystemTest.java
│       │   ├── GradeDataDrivenTest.java       # CSV + Excel parameterized tests
│       │   ├── ExcelDataProvider.java         # Apache POI helper
│       │   ├── AllTestsSuite.java             # Full test suite
│       │   ├── FastTestsSuite.java            # Fast tests only
│       │   ├── SlowTestsSuite.java            # Slow tests only
│       │   └── IntegrationTestsSuite.java     # Integration tests only
│       │
│       └── resources/
│           ├── junit-platform.properties      # Parallel execution config
│           ├── grade_test_data.csv            # CSV data source
│           └── grade_test_data.xlsx           # Excel data source (4 sheets)
│
├── target/site/jacoco/                        # JaCoCo coverage reports
├── pom.xml
└── README.md
```

---

##  Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | SE 1.8+ | Programming language |
| JUnit 5 (Jupiter) | 5.10.2 | Unit testing framework |
| Apache POI | 5.2.3 | Excel file reading |
| JaCoCo | 0.8.11 | Code coverage |
| Maven | 3.x | Build & dependency management |
| Maven Surefire | 3.2.5 | JUnit 5 Maven runner |
| JUnit Platform Suite | 1.10.0 | Test suite management |
| Eclipse IDE | Latest | Development environment |

---

##  Getting Started

### Prerequisites
- Java JDK 8 or higher
- Maven installed
- Eclipse IDE (recommended) or IntelliJ

### Clone & Setup
```bash
git clone <your-repo-url>
cd student-management-system
```

### Run All Tests
```bash
mvn test
```

### Run Specific Tag Group
```bash
# Run only fast tests
mvn test -Dgroups="fast"

# Run only slow tests
mvn test -Dgroups="slow"

# Run only integration tests
mvn test -Dgroups="integration"
```

### Generate Coverage Report
```bash
mvn test
# Report available at: target/site/jacoco/index.html
```

---

##  Test Summary

| Test File | Tag | Tests | Type |
|-----------|-----|-------|------|
| StudentTest.java | `fast` | 12 | Unit |
| CourseTest.java | `fast` | 11 | Unit |
| GradeTest.java | `slow` | 12 | Unit + Boundary |
| EnrollmentTest.java | `integration` | 10 | Integration |
| TeacherTest.java | `fast` | 6 | Unit |
| StudentManagementSystemTest.java | `integration` | 12 | System |
| GradeDataDrivenTest.java | Parameterized | 32 | Data-Driven |
| **Total** | | **95+** | |

---

##  Data-Driven Testing

### CSV (`grade_test_data.csv`)
- 12 test cases covering all grade boundaries
- Uses `@CsvFileSource` annotation

### Excel (`grade_test_data.xlsx`)
| Sheet | Description | Cases |
|-------|-------------|-------|
| Valid | Correct expected inputs | 5 |
| Invalid | Negative/wrong inputs | 5 |
| Edge | Exact boundary values | 5 |
| Stress | Large/complex inputs | 5 |

---

##  Parallel Execution

Configured in `src/test/resources/junit-platform.properties`:

```properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent
junit.jupiter.execution.parallel.mode.classes.default=concurrent
junit.jupiter.execution.parallel.config.strategy=fixed
junit.jupiter.execution.parallel.config.fixed.parallelism=4
```

---

##  Test Suites

| Suite | Description |
|-------|-------------|
| `AllTestsSuite` | Runs every test in the package |
| `FastTestsSuite` | Runs only `@Tag("fast")` tests |
| `SlowTestsSuite` | Runs only `@Tag("slow")` tests |
| `IntegrationTestsSuite` | Runs only `@Tag("integration")` tests |

---

##  Code Coverage (JaCoCo)

| Metric | Result | Target |
|--------|--------|--------|
| Line Coverage | 70%+ | 70% ✅ |
| Branch Coverage | 100% | 70% ✅ |

> Coverage report: `target/site/jacoco/index.html`

---

##  Test Naming Convention

All tests follow the **AAA pattern** (Arrange, Act, Assert) with this naming standard:

```
should_<expectedBehavior>_when_<condition>
```

**Example:**
```java
@Test
void should_returnGradeA_when_marksAreExactly90() {
    // Arrange
    Grade grade = new Grade(student, course, 90);
    // Act & Assert
    assertEquals("A", grade.getGradeLetter());
}
```

