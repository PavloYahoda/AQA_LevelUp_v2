package pyah.demoqa;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class FormsPageTest extends BaseTest{

    @Test
    @Order(1)
    @DisplayName("Work with form")
    void workWithForm() throws InterruptedException {
        getHomePage()
                .clickOnForms()
                .callForm()
                .fillForm();
        Thread.sleep(2000);
    }
}
