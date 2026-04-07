package com.fasts.nu.student;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.api.Assertions.*;

class GradeDataDrivenTest {

    private Student student = new Student("S001", "Ali", "ali@nu.edu.pk", 20);
    private Course course = new Course("CS101", "Programming", 3, "Dr. Ahmed");

    // ============================================================
    // CSV BASED TEST
    // ============================================================

    @ParameterizedTest(name = "CSV Test: marks={0} should give grade={1}")
    @CsvFileSource(resources = "/grade_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Grade calculation from CSV file")
    void should_returnCorrectGrade_when_marksReadFromCSV(double marks, String expectedGrade) {
        Grade grade = new Grade(student, course, marks);
        assertEquals(expectedGrade, grade.getGradeLetter());
    }

    // ============================================================
    // EXCEL BASED TESTS — one method per sheet
    // ============================================================

    // --- Valid Sheet ---
    static Stream<Arguments> validDataFromExcel() throws Exception {
        List<Object[]> rows = ExcelDataProvider.readExcelSheet("grade_test_data.xlsx", "Valid");
        return rows.stream().map(r -> Arguments.of(r[0], r[1]));
    }

    @ParameterizedTest(name = "Excel Valid: marks={0} should give grade={1}")
    @MethodSource("validDataFromExcel")
    @DisplayName("Valid data from Excel")
    void should_returnCorrectGrade_when_validMarksFromExcel(double marks, String expectedGrade) {
        Grade grade = new Grade(student, course, marks);
        assertEquals(expectedGrade, grade.getGradeLetter());
    }

    // --- Invalid Sheet ---
    static Stream<Arguments> invalidDataFromExcel() throws Exception {
        List<Object[]> rows = ExcelDataProvider.readExcelSheet("grade_test_data.xlsx", "Invalid");
        return rows.stream().map(r -> Arguments.of(r[0], r[1]));
    }

    @ParameterizedTest(name = "Excel Invalid: marks={0} should give grade={1}")
    @MethodSource("invalidDataFromExcel")
    @DisplayName("Invalid data from Excel")
    void should_returnF_when_invalidNegativeMarksFromExcel(double marks, String expectedGrade) {
        Grade grade = new Grade(student, course, marks);
        assertEquals(expectedGrade, grade.getGradeLetter());
    }

    // --- Edge Sheet ---
    static Stream<Arguments> edgeDataFromExcel() throws Exception {
        List<Object[]> rows = ExcelDataProvider.readExcelSheet("grade_test_data.xlsx", "Edge");
        return rows.stream().map(r -> Arguments.of(r[0], r[1]));
    }

    @ParameterizedTest(name = "Excel Edge: marks={0} should give grade={1}")
    @MethodSource("edgeDataFromExcel")
    @DisplayName("Edge boundary data from Excel")
    void should_returnCorrectGrade_when_boundaryMarksFromExcel(double marks, String expectedGrade) {
        Grade grade = new Grade(student, course, marks);
        assertEquals(expectedGrade, grade.getGradeLetter());
    }

    // --- Stress Sheet ---
    static Stream<Arguments> stressDataFromExcel() throws Exception {
        List<Object[]> rows = ExcelDataProvider.readExcelSheet("grade_test_data.xlsx", "Stress");
        return rows.stream().map(r -> Arguments.of(r[0], r[1]));
    }

    @ParameterizedTest(name = "Excel Stress: marks={0} should give grade={1}")
    @MethodSource("stressDataFromExcel")
    @DisplayName("Stress data from Excel")
    void should_returnCorrectGrade_when_stressMarksFromExcel(double marks, String expectedGrade) {
        Grade grade = new Grade(student, course, marks);
        assertEquals(expectedGrade, grade.getGradeLetter());
    }
}
